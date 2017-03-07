package io.taciturn.utility;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static io.taciturn.Utility.$;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractUtility<Item> {

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<Item> object;

    public AbstractUtility(Item object) {
        this.object = Optional.ofNullable(object);
    }
    
    public boolean isPresent() {
        return object.isPresent();
    }
    
    public void ifPresent(Consumer<? super Item> consumer) {
        object.ifPresent(consumer);
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractUtility<Item>> T filter(Predicate<? super Item> predicate) {
        object = object.filter(predicate);
        return (T) this;
    }
    
    @SuppressWarnings("unchecked")
    public <U> AbstractUtility<U> map(Function<? super Item, ? extends U> mapper) {
        return $(this.object.map(mapper).orElse(null));
    }

    public <U> AbstractUtility<U> flatMap(Function<? super Item, Optional<U>> mapper) {
        return $(this.object.flatMap(mapper).orElse(null));
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Item get() {
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

    @SuppressWarnings("unchecked")
    public <T extends AbstractUtility<Item>> T mustBe(Predicate<? super Item> predicate) {
        Objects.requireNonNull(predicate);
        if (!predicate.test(object.orElse(null))) {
            throw new InvalidContractException();
        }
        return (T) this;
    }

    public <T extends AbstractUtility<Item>> T mustBe(Predicate<? super Item> predicate, String message) {
        T filtered = filter(predicate);
        filtered.orElseThrow(() -> new InvalidContractException(message));
        return filtered;
    }

    public <T extends AbstractUtility<Item>> T mustNotBe(Predicate<? super Item> predicate) {
        return mustBe(predicate.negate());
    }

    public <T extends AbstractUtility<Item>> T mustNotBe(Predicate<? super Item> predicate, String message) {
        return mustBe(predicate.negate(), message);
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractUtility<Item>> T mustNotBeNull() {
        Objects.requireNonNull(object.orElse(null));
        return (T) this;
    }

    public Optional<Item> optional() {
        return object;
    }

}
