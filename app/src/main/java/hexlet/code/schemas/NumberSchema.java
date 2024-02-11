package hexlet.code.schemas;

import org.apache.commons.lang3.Range;

public class NumberSchema extends BaseSchema<Number> {
    private boolean isPositive;
    private Range<Long> range;
    private boolean hasRange;

    @Override
    public boolean isValid(Number object) {
        boolean isValid = true;
        if (!this.isRequired) {
            return isValid;
        }
        if (object == null) {
            return !isValid;
        }
        if (this.isPositive) {
            int temp = Long.compare(object.longValue(), 0);
            isValid = temp <= 0 ? !isValid : isValid;
        }
        if (this.hasRange) {
            isValid = range.contains(object.longValue());
        }
        return isValid;
    }

    public NumberSchema range(long from, long includeTo) {
        this.hasRange = true;
        this.range = Range.between(from, includeTo);
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }
}
