package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Number> {
    private boolean isPositive = false;
    private long start = Long.MIN_VALUE;
    private long end = Long.MAX_VALUE;

    @Override
    public boolean isValid(Number number) {
        if (this.isRequired) {
            if (number == null) {
                return false;
            }
            if (this.isPositive) {
                if (number instanceof Byte) {
                    return number.byteValue() > 0 && (number.byteValue() >= start && number.byteValue() <= end);
                } else if (number instanceof Double) {
                    return number.doubleValue() > 0 && (number.doubleValue() >= start && number.doubleValue() <= end);
                } else if (number instanceof Float) {
                    return number.floatValue() > 0 && (number.floatValue() >= start && number.floatValue() <= end);
                } else if (number instanceof Long) {
                    return number.longValue() > 0 && (number.longValue() >= start && number.longValue() <= end);
                } else {
                    return number.intValue() > 0 && (number.intValue() >= start && number.intValue() <= end);
                }
            }
        }
        return true;
    }

    public NumberSchema range(long start, long end) {
        this.start = start;
        this.end = end;
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }
}
