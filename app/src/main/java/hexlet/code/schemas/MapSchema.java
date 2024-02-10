package hexlet.code.schemas;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private int size;

    @Override
    public boolean isValid(Map<?, ?> object) {
        boolean isValid = true;

        for (var entry : object.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof BaseSchema) {
                Class<?> base = value.getClass();
                Class<?> parameter;
                if (base.toString().contains("String")) {
                    parameter = String.class;
                } else if (base.toString().contains("Number")) {
                    parameter = Number.class;
                } else {
                    parameter = Map.class;
                }

                Method method;
                try {
                    method = base.getMethod("isValid", parameter);
                    var t = method.invoke(value, "");
                    System.out.println(t.toString());
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            } else {
                if (((BaseSchema<?>) value).isRequired) {
                    if (object == null) {
                        return false;
                    }
                    if (size > 0) {
                        return object.size() == this.size;
                    }
                }
            }
        }
        return isValid;
    }

    public MapSchema sizeOf(int size) {
        this.size = size;
        return this;
    }
}
