package hexlet.code.schemas;


public abstract class BaseSchema<T> {
    protected boolean isRequired = false;

    public abstract boolean isValid(T object);

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }
}
