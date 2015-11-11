package io.taciturn.utility;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ObjectUtility<Item> {

    private final Optional<Item> object;

    public ObjectUtility(Item object) {
        this.object = Optional.ofNullable(object);
    }
    
    public boolean isPresent() {
        return object.isPresent();
    }
    
    public void ifPresent(Consumer<? super Item> consumer) {
        object.ifPresent(consumer);
    }

    public Optional<Item> filter(Predicate<? super Item> predicate) {
        return object.filter(predicate);
    }
    
    public<U> Optional<U> map(Function<? super Item, ? extends U> mapper) {
        return object.map(mapper);
    }

    public<U> Item get() {
        return object.get();
    }
    
    public Item orElse(Item other) {
        return object.orElse(other);
    }

    public Item orElseGet(Supplier<? extends Item> other) {
        return object.orElseGet(other);
    }

    public <X extends Throwable> Item orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        return object.orElseThrow(exceptionSupplier);
    }

    public Item mustBe(Predicate<Item> predicate) {
        return object.filter(predicate).orElseThrow(InvalidContractException::new);
    }

    public Item mustBe(Predicate<Item> predicate, String message) {
        return object.filter(predicate).orElseThrow(() -> new InvalidContractException(message));
    }

    public Item mustNotBe(Predicate<Item> predicate, String message) {
        return mustBe(predicate.negate(), message);
    }

    public Item mustNotBeNull() {
        return mustNotBe(isNullPredicate(), createExpectedMessage("non-null"));
    }

    public Optional<Item> optional() {
        return object;
    }

    protected String createExpectedMessage(Object expected) {
        return String.format("Expected: %s\n  actual: %s\n", expected, object);
    }

    public static <T> Predicate<T> isNullPredicate() {
        return o -> o == null;
    }

}
