package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private boolean hasMinLength;
    private int minLength;

    @Override
    public boolean validateSchema(String data) {
        boolean isValid = true;
        if (data.isEmpty()) {
            return false;
        }
        if (this.hasMinLength) {
            isValid = this.minLength <= data.length();
        }
        if (this.checkContains) {
            isValid = data.contains(this.pattern);
        }
        return isValid;
    }

    public StringSchema minLength(int length) {
        this.hasMinLength = true;
        this.minLength = length;
        return this;
    }
}
