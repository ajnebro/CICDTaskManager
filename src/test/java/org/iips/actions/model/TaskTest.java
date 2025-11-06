package org.iips.actions.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Task Model Unit Tests")
class TaskTest {
  @Test
  @DisplayName("Should create valid Task")
  void shouldCreateValidTask() {
    UUID id = UUID.randomUUID();
    Task task = new Task(id, "Description", false, LocalDate.now());
    assertEquals(id, task.id());
    assertEquals("Description", task.description());
    assertFalse(task.completed());
  }

  @Test
  @DisplayName("Should throw for null id")
  void shouldThrowForNullId() {
    assertThrows(
        IllegalArgumentException.class, () -> new Task(null, "desc", false, LocalDate.now()));
  }

  @Test
  @DisplayName("Should throw for blank description")
  void shouldThrowForBlankDescription() {
    UUID id = UUID.randomUUID();
    assertThrows(IllegalArgumentException.class, () -> new Task(id, " ", false, LocalDate.now()));
  }
}
