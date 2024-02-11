package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private String pattern;
    private boolean checkContains;
    protected boolean hasMinLength;
    protected int minLength;

    @Override
    public boolean isValid(String object) {
        boolean isValid = true;
        if (!this.isRequired) {
            return isValid;
        }
        if (object == null || object.isEmpty()) {
            return !isValid;
        }
        if (this.hasMinLength) {
            isValid = this.minLength <= object.length();
        }
        if (this.checkContains) {
            isValid = object.contains(this.pattern);
        }

        return isValid;
    }


    public StringSchema contains(String value) {
        this.pattern = value;
        this.checkContains = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.hasMinLength = true;
        this.minLength = length;
        return this;
    }
}
