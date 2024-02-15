package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    @Override
    public StringSchema required() {
        super.isRequired = true;
        addStrategy("isRequired", p -> !p.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addStrategy("hasMinLength", p -> (p.length() >= length));
        return this;
    }
    public StringSchema contains(String pattern) {
        addStrategy("isContains", p -> (p.contains(pattern)));
        return this;
    }
}
