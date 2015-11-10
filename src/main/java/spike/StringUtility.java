package spike;

import java.util.Optional;

public class StringUtility extends ComparableUtility<String> {

    public StringUtility(String object) {
        super(object);
    }

    public boolean isBlank() {
        return object.map(String::trim).map(String::isEmpty).orElse(false);
    }
    
    public boolean isEmpty() {
        return object.map(String::isEmpty).orElse(false);
    }

    public Optional<Boolean> toBoolean() {
        return object.map(Boolean::parseBoolean);
    }

    public Optional<Double> toDouble() {
        return object.map(Double::parseDouble);
    }

    public Optional<Float> toFloat() {
        return object.map(Float::parseFloat);
    }

    public Optional<Integer> toInteger() {
        return object.map(Integer::parseInt);
    }

    public Optional<Integer> toInteger(int radix) {
        return object.map(o -> Integer.parseInt(o, radix));
    }

    public Optional<Long> toLong() {
        return object.map(Long::parseLong);
    }

    public Optional<Long> toLong(int radix) {
        return object.map(o -> Long.parseLong(o, radix));
    }

    public Optional<Short> toShort() {
        return object.map(Short::parseShort);
    }

    public Optional<Short> toShort(int radix) {
        return object.map(o -> Short.parseShort(o, radix));
    }

}
