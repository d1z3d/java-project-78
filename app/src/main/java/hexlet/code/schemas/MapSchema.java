package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private Map<?, ?> schemas = new HashMap<>();
    private boolean hasSize;
    private int size;

    @Override
    public boolean isValid(Map<?, ?> object) {
        if (!this.isRequired) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.hasSize && schemas.size() != this.size) {
            return false;
        }
        List<Boolean> isValid = new ArrayList<>();
        object.forEach((key, value) -> {
            if (schemas.containsKey(key)) {
                var schema = schemas.get(key);
                Class<?> base = schema.getClass();
                if (base.toString().contains("String")) {
                    isValid.add(((BaseSchema<String>) schema).isValid((String) value));
                } else if (base.toString().contains("Number")) {
                    isValid.add(((BaseSchema<Number>) schema).isValid((Number) value));
                } else {
                    isValid.add(false);
                }
            }
        });
        return !isValid.contains(false);
    }

    public void shape(Map<?, ? extends BaseSchema> schema) {
        this.schemas = new HashMap<>(schema);
    }
    public MapSchema sizeof(int length) {
        this.hasSize = true;
        this.size = length;
        return this;
    }
}
