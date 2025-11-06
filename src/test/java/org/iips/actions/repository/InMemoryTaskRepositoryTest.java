package org.iips.actions.repository;

import org.iips.actions.model.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InMemoryTaskRepository Unit Tests")
class InMemoryTaskRepositoryTest {
  private final InMemoryTaskRepository repository = new InMemoryTaskRepository();

  @Test
  @DisplayName("Should save and find a task")
  void shouldSaveAndFindTask() {
    Task task = new Task(UUID.randomUUID(), "Repo test", false, LocalDate.now());
    repository.save(task);
    Optional<Task> found = repository.findById(task.id());
    assertTrue(found.isPresent());
    assertEquals(task, found.get());
  }

  @Test
  @DisplayName("Should return all tasks")
  void shouldReturnAllTasks() {
    repository.save(new Task(UUID.randomUUID(), "Task 1", false, null));
    repository.save(new Task(UUID.randomUUID(), "Task 2", true, null));
    List<Task> tasks = repository.findAll();
    assertTrue(tasks.size() >= 2);
  }

  @Test
  @DisplayName("Should delete a task by id")
  void shouldDeleteTaskById() {
    Task task = new Task(UUID.randomUUID(), "Delete me", false, null);
    repository.save(task);
    boolean deleted = repository.deleteById(task.id());
    assertTrue(deleted);
    assertTrue(repository.findById(task.id()).isEmpty());
  }

  @Test
  @DisplayName("Should not delete non-existent task")
  void shouldNotDeleteNonExistentTask() {
    UUID fakeId = UUID.randomUUID();
    assertFalse(repository.deleteById(fakeId));
  }
}
