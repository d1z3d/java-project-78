package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Number> {
    @Override
    public NumberSchema required() {
        super.isRequired = true;
        return this;
    }

    public NumberSchema range(int from, int includeTo) {
        addStrategy("isBetweenRange", p -> (p.intValue() >= from && p.intValue() <= includeTo));
        return this;
    }

    public NumberSchema positive() {
        addStrategy("isPositive", p -> p.intValue() > 0);
        return this;
    }
}
