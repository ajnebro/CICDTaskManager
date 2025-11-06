package org.iips.actions.repository;

import org.iips.actions.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Sealed interface for task repository operations. */
public sealed interface TaskRepository permits InMemoryTaskRepository {
  /**
   * Saves a new task.
   *
   * @param task Task to save
   * @return Saved task
   */
  Task save(Task task);

  /**
   * Finds a task by its id.
   *
   * @param id Task id
   * @return Optional containing the task if found
   */
  Optional<Task> findById(UUID id);

  /**
   * Returns all tasks.
   *
   * @return List of tasks
   */
  List<Task> findAll();

  /**
   * Deletes a task by its id.
   *
   * @param id Task id
   * @return true if deleted, false if not found
   */
  boolean deleteById(UUID id);
}
