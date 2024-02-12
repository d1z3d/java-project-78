package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Number> {
    public NumberSchema() {
        addStrategy("isNumberClass", isNumberClass());
    }

    public NumberSchema range(int from, int includeTo) {
        addStrategy("isBetweenRange", isBetweenRange(from, includeTo));
        return this;
    }

    public NumberSchema positive() {
        addStrategy("isPositive", isPositive());
        return this;
    }

    private Predicate<Number> isNumberClass() {
        return p -> true;
    }

    private Predicate<Number> isPositive() {
        return p -> p.intValue() > 0;
    }
    private Predicate<Number> isBetweenRange(int from, int includeTo) {
        return p -> (p.intValue() >= from && p.intValue() <= includeTo);
    }
}
