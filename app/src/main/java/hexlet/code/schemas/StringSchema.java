package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private String pattern = "";
    @Override
    public boolean isValid(String object) {
        boolean result = true;
        if (this.isRequired) {
            if (object == null) {
                return false;
            }

            if (!object.isEmpty()) {
                result = this.minLength <= object.length();
            } else {
                result = false;
            }

            if (object.isEmpty() || !object.contains(this.pattern)) {
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
