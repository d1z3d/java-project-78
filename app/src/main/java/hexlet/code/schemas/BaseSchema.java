package hexlet.code.schemas;


public abstract class BaseSchema<T> {
    protected String pattern;
    protected boolean checkContains;
    protected boolean isRequired = false;

    public abstract boolean isValid(T object);

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public BaseSchema contains(String value) {
        this.pattern = value;
        this.checkContains = true;
        return this;
    }
}
