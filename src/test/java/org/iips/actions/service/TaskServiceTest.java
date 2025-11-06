package org.iips.actions.service;

import org.iips.actions.exception.InvalidTaskException;
import org.iips.actions.exception.TaskNotFoundException;
import org.iips.actions.model.Task;
import org.iips.actions.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TaskService Unit Tests")
class TaskServiceTest {
  private final TaskService service = new TaskService(new InMemoryTaskRepository());

  @Nested
  @DisplayName("Create Task")
  class CreateTask {
    @Test
    @DisplayName("Should create a valid task")
    void shouldCreateValidTask() {
      Task task = service.createTask("Test task", LocalDate.now());
      assertNotNull(task);
      assertEquals("Test task", task.description());
      assertFalse(task.completed());
    }

    @Test
    @DisplayName("Should throw InvalidTaskException for blank description")
    void shouldThrowForBlankDescription() {
      assertThrows(InvalidTaskException.class, () -> service.createTask(" ", LocalDate.now()));
    }
  }

  @Nested
  @DisplayName("Complete Task")
  class CompleteTask {
    @Test
    @DisplayName("Should mark task as completed")
    void shouldMarkTaskCompleted() {
      Task task = service.createTask("Complete me", null);
      Task completed = service.completeTask(task.id());
      assertTrue(completed.completed());
    }

    @Test
    @DisplayName("Should throw TaskNotFoundException for invalid id")
    void shouldThrowForInvalidId() {
      UUID fakeId = UUID.randomUUID();
      assertThrows(TaskNotFoundException.class, () -> service.completeTask(fakeId));
    }
  }

  @Nested
  @DisplayName("Delete Task")
  class DeleteTask {
    @Test
    @DisplayName("Should delete existing task")
    void shouldDeleteTask() {
      Task task = service.createTask("Delete me", null);
      assertDoesNotThrow(() -> service.deleteTask(task.id()));
    }

    @Test
    @DisplayName("Should throw TaskNotFoundException for non-existent task")
    void shouldThrowForNonExistentTask() {
      UUID fakeId = UUID.randomUUID();
      assertThrows(TaskNotFoundException.class, () -> service.deleteTask(fakeId));
    }
  }

  @Nested
  @DisplayName("Get Task")
  class GetTask {
    @Test
    @DisplayName("Should get existing task by id")
    void shouldGetTaskById() {
      Task task = service.createTask("Find me", null);
      Task found = service.getTaskById(task.id());
      assertEquals(task.id(), found.id());
    }

    @Test
    @DisplayName("Should throw TaskNotFoundException for missing task")
    void shouldThrowForMissingTask() {
      UUID fakeId = UUID.randomUUID();
      assertThrows(TaskNotFoundException.class, () -> service.getTaskById(fakeId));
    }
  }
}
