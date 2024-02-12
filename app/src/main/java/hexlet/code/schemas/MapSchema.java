package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, ?>> {
    public MapSchema() {
        addStrategy("isMapClass", isMapClass());
    }

    @Override
    public MapSchema required() {
        super.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addStrategy("isSameSize", isSameSize(size));
        return this;
    }

    private Predicate<Map<String, ?>> isMapClass() {
        return Objects::nonNull;
    }


    private Predicate<Map<String, ?>> isSameSize(int size) {
        return p -> p.size() == size;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schema) {
        addStrategy("isShape", isShape(schema));
        return this;
    }

    private <T> Predicate<Map<String, ?>> isShape(Map<String, BaseSchema<T>> schemas) {
        return p -> {
            for (var schema : schemas.entrySet()) {
                String key = schema.getKey();
                Object value = p.get(key);

                if (!schema.getValue().isValid((T) value)) {
                    return false;
                }
            }
            return true;
        };
    }
}
