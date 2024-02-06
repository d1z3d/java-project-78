package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private String pattern = "";
    @Override
    public boolean isValid(String value) {
        boolean result = true;
        if (this.isRequired) {
            if (value == null) {
                return false;
            }

            if (!value.isEmpty()) {
                result = this.minLength <= value.length();
            } else {
                result = false;
            }

            if (value.isEmpty() || !value.contains(this.pattern)) {
                result = false;
            }
        }
        return result;
    }


    public StringSchema contains(String value) {
        if (value != null) {
            this.pattern = value;
        }
        return this;
    }
}
