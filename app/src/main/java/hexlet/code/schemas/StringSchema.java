package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private String pattern = "";

    @Override
    public boolean isValid(String object) {
        boolean isValid = true;
        if (this.isRequired) {
            if (object == null || !object.isEmpty()) {
                return !isValid;
            }
            isValid = this.minLength <= object.length();
            isValid = !object.contains(this.pattern);
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
