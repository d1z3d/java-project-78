package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired;
    protected Map<String, Predicate<T>> strategies = new LinkedHashMap<>();

    public boolean isValid(T object) {
        if (object == null) {
            return !isRequired;
        }

        for (var strategy : strategies.entrySet()) {
            if (!strategy.getValue().test(object)) {
                return false;
            }
        }

        return true;
    }

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }
    public final void addStrategy(String name, Predicate<T> strategy) {
        strategies.put(name, strategy);
    }
}
