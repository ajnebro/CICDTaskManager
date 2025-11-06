package org.iips.actions.exception;

/**
 * Exception thrown when a task is not found.
 */
public class TaskNotFoundException extends RuntimeException {
    /**
     * Creates a new TaskNotFoundException with a message.
     * @param id Task id
     */
    public TaskNotFoundException(Object id) {
        super("Task not found with id: " + id);
    }
}
