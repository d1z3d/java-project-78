package hexlet.code.schemas;


public abstract class BaseSchema<T> {
    protected String pattern;
    protected boolean checkContains;
    protected boolean isRequired;

    public boolean isValid(T object) {
        if (!this.isRequired) {
            return true;
        }
        if (object == null) {
            return false;
        }
        return validateSchema(object);
    };

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public BaseSchema contains(String value) {
        this.pattern = value;
        this.checkContains = true;
        return this;
    }
    public abstract boolean validateSchema(T data);
}
