package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Number> {
    private boolean isPositive = false;
    private long start = Long.MIN_VALUE;
    private long end = Long.MAX_VALUE;

    @Override
    public boolean isValid(Number number) {
        boolean result = true;
        if (this.isRequired) {
            if (number == null) {
                return false;
            }
            if (this.isPositive) {
                if (number instanceof Byte) {
                    result = number.byteValue() > 0 && (number.byteValue() >= start && number.byteValue() <= end);
                } else if (number instanceof Double) {
                    result = number.doubleValue() > 0 && (number.doubleValue() >= start && number.doubleValue() <= end);
                } else if (number instanceof Float) {
                    result = number.floatValue() > 0 && (number.floatValue() >= start && number.floatValue() <= end);
                } else if (number instanceof Long) {
                    result = number.longValue() > 0 && (number.longValue() >= start && number.longValue() <= end);
                } else {
                    result = number.intValue() > 0 && (number.intValue() >= start && number.intValue() <= end);
                }
            }
        }
        return result;
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
