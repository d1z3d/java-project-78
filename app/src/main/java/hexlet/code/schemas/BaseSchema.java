package hexlet.code.schemas;

import lombok.Setter;

@Setter
public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected int minLength;
    public abstract boolean isValid(T object);
    public BaseSchema required() {
        this.setRequired(true);
        return this;
    }

    public BaseSchema minLength(int minLength) {
        this.setMinLength(minLength);
        return this;
    }
}
