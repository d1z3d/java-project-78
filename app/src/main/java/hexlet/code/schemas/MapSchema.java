package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private Map<?, ?> schemas = new HashMap<>();

    @Override
    public boolean isValid(Map<?, ?> object) {
        boolean isValid = true;

        for (var entry : object.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            if (schemas.containsKey(key)) {
                var schema = schemas.get(key);
                Class<?> base = schema.getClass();
                if (base.toString().contains("String")) {
                    isValid = ((BaseSchema<String>) schema).isValid((String) value);
                } else if (base.toString().contains("Number")) {
                    isValid = ((BaseSchema<Number>) schema).isValid((Number) value);
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                return isValid;
            }
        }
        return isValid;
    }

    public void shape(Map<?, ? extends BaseSchema> schema) {
        this.schemas = new HashMap<>(schema);
    }
}
