package spike;

import java.util.Optional;
import java.util.function.Predicate;

public class ObjectUtility<Item> {

    protected final Optional<Item> object;

    public ObjectUtility(Item object) {
        this.object = Optional.ofNullable(object);
    }
    
    public boolean is(Predicate<Item> predicate) {
        return object.map(predicate::test).orElse(false);
    }

    public boolean isNull() {
        return object.isPresent();
    }

    public boolean isNotPresent() {
        return !isNull();
    }

    public Item mustBe(Predicate<Item> predicate) {
        return object.filter(predicate).orElseThrow(InvalidContractException::new);
    }

    public Item mustBe(Predicate<Item> predicate, String message) {
        return object.filter(predicate).orElseThrow(() -> new InvalidContractException(message));
    }

    public Item mustBeNull() {
        return mustBe(isNullPredicate(), createExpectedMessage("null"));
    }

    public Item mustNotBe(Predicate<Item> predicate, String message) {
        return mustBe(predicate.negate(), message);
    }

    public Item mustNotBeNull() {
        return mustNotBe(isNullPredicate(), createExpectedMessage("non-null"));
    }

    public Item get() {
        return object.get();
    }

    protected String createExpectedMessage(Object expected) {
        return String.format("Expected: %s\n  actual: %s\n", expected, object);
    }

    public static <T> Predicate<T> isNullPredicate() {
        return o -> o == null;
    }

}
