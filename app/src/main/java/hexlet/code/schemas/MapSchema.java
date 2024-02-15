package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, ?>> {
    @Override
    public MapSchema required() {
        super.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addStrategy("isSameSize", p -> p.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addStrategy("isShape", p -> {
            for (var schema : schemas.entrySet()) {
                String key = schema.getKey();
                Object value = p.get(key);

                if (!schema.getValue().isValid((T) value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
