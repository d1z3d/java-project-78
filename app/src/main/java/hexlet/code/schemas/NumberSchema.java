package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Number> {
    private boolean isPositive = false;
    protected long start = Long.MIN_VALUE;
    protected long end = Long.MAX_VALUE;

    @Override
    public boolean isValid(Number object) {
        boolean isValid = true;
        if (this.isRequired) {
            if (object == null) {
                return !isValid;
            }
            if (this.isPositive) {
                if (object instanceof Byte) {
                    isValid = object.byteValue() > 0
                            && (object.byteValue() >= start && object.byteValue() <= end);
                } else if (object instanceof Double) {
                    isValid = object.doubleValue() > 0
                            && (object.doubleValue() >= start && object.doubleValue() <= end);
                } else if (object instanceof Float) {
                    isValid = object.floatValue() > 0 && (object.floatValue() >= start
                            && object.floatValue() <= end);
                } else if (object instanceof Long) {
                    isValid = object.longValue() > 0
                            && (object.longValue() >= start && object.longValue() <= end);
                } else {
                    isValid = object.intValue() > 0
                            && (object.intValue() >= start && object.intValue() <= end);
                }
            }
        }
        return isValid;
    }

    public NumberSchema range(long from, long includeTo) {
        this.start = from;
        this.end = includeTo;
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }
}
