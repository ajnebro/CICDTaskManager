package org.iips.actions.exception;

/**
 * Exception thrown when a task is invalid.
 */
public class InvalidTaskException extends RuntimeException {
    /**
     * Creates a new InvalidTaskException with a message.
     * @param message Description of the validation error
     */
    public InvalidTaskException(String message) {
        super("Invalid task: " + message);
    }
}
