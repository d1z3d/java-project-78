package hexlet.code.schemas;


public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected int minLength;
    public abstract boolean isValid(T object);
    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public BaseSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

}
