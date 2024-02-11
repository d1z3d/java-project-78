package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private boolean hasMinLength;
    private int minLength;

    @Override
    public boolean isValid(String object) {
        boolean isValid = true;
        if (!this.isRequired) {
            return isValid;
        }
        if (object == null || object.isEmpty()) {
            return false;
        }
        if (this.hasMinLength) {
            isValid = this.minLength <= object.length();
        }
        if (this.checkContains) {
            isValid = object.contains(this.pattern);
        }

        return isValid;
    }

    public StringSchema minLength(int length) {
        this.hasMinLength = true;
        this.minLength = length;
        return this;
    }
}
