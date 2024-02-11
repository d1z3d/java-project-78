package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private String pattern = "";
    @Override
    public boolean isValid(String object) {
        boolean isValid = true;
        if (this.isRequired) {
            if (object == null) {
                return !isValid;
            }

            if (!object.isEmpty()) {
                isValid = this.minLength <= object.length();
            } else {
                isValid = !isValid;
            }

            if (object.isEmpty() || !object.contains(this.pattern)) {
                isValid = !isValid;
            }
        }
        return isValid;
    }


    public StringSchema contains(String value) {
        if (value != null) {
            this.pattern = value;
        }
        return this;
    }
}
