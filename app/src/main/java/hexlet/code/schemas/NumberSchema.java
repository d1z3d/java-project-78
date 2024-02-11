package hexlet.code.schemas;

import org.apache.commons.lang3.Range;

public class NumberSchema extends BaseSchema<Number> {
    private boolean isPositive;
    private Range<Long> range;
    private boolean hasRange;

    @Override
    public boolean validateSchema(Number data) {
        boolean isValid = true;
        if (this.isPositive) {
            isValid = (data.longValue() <= 0) != isValid;
        }
        if (this.hasRange) {
            isValid = range.contains(data.longValue());
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
