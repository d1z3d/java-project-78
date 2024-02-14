package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    @Override
    public StringSchema required() {
        super.isRequired = true;
        addStrategy("isRequired", isRequired());
        return this;
    }

    public StringSchema minLength(int length) {
        addStrategy("hasMinLength", hasMinLength(length));
        return this;
    }
    public StringSchema contains(String pattern) {
        addStrategy("isContains", isContains(pattern));
        return this;
    }

    private Predicate<String> isRequired() {
        return p -> !p.isEmpty();
    }

    private Predicate<String> isStringClass() {
        return p -> true;
    }

    private Predicate<String> hasMinLength(int length) {
        return p -> (p.length() >= length);
    }

    private Predicate<String> isContains(String pattern) {
        return p -> (p.contains(pattern));
    }
}
