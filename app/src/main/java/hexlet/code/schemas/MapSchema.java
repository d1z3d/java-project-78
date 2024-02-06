package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private int size;
    @Override
    public boolean isValid(Map<?, ?> value) {
        if (this.isRequired) {
            if (value == null) {
                return false;
            }
            if (size > 0) {
                return value.size() == this.size;
            }
        }
        return true;
    }

    public MapSchema sizeOf(int size) {
        this.size = size;
        return this;
    }
}
