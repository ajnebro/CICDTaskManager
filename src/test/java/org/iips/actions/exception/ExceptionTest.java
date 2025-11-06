package org.iips.actions.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Custom Exceptions Unit Tests")
class ExceptionTest {
  @Test
  @DisplayName("TaskNotFoundException should contain id in message")
  void taskNotFoundExceptionMessage() {
    TaskNotFoundException ex = new TaskNotFoundException("1234");
    assertTrue(ex.getMessage().contains("1234"));
  }

  @Test
  @DisplayName("InvalidTaskException should contain message")
  void invalidTaskExceptionMessage() {
    InvalidTaskException ex = new InvalidTaskException("desc error");
    assertTrue(ex.getMessage().contains("desc error"));
  }
}
