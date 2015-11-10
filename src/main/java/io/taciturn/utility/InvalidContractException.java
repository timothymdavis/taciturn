package io.taciturn.utility;

public class InvalidContractException extends RuntimeException {
    
    private final String message;

    public InvalidContractException() {
        this.message = "Invalid contract value provided";
    }

    public InvalidContractException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
