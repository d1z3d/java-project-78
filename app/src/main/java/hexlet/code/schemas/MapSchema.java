package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, ?>> {
    private Map<String, BaseSchema<?>> schemas = new HashMap<>();
    private boolean hasSize;
    private int size;

    @Override
    public boolean isValid(Map<String, ?> object) {
        for (var schema : schemas.entrySet()) {
            if (!schema.getValue().isRequired) {
                return true;
            }
        }
        return validateSchema(object);
    }

    @Override
    public boolean validateSchema(Map<String, ?> data) {
        if (data == null) {
            return false;
        }
        if (this.hasSize && schemas.size() != this.size) {
            return false;
        }
        boolean isValid = true;
        for (var entry: data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                return false;
            }
            if (schemas.containsKey(key)) {
                var schema = schemas.get(key);
                Class<?> base = schema.getClass();
                if (base.toString().contains("String")) {
                    isValid = ((BaseSchema<String>) schema).isValid((String) value);
                } else if (base.toString().contains("Number")) {
                    isValid = ((BaseSchema<Number>) schema).isValid((Number) value);
                } else {
                    return false;
                }
            }
        }
        return isValid;
    }

    public <T> void shape(Map<String, BaseSchema<T>> schema) {
        this.schemas = new HashMap<>(schema);
    }

    public MapSchema sizeof(int length) {
        this.hasSize = true;
        this.size = length;
        return this;
    }
}
