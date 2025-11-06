package org.iips.actions.repository;

import org.iips.actions.model.Task;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** In-memory implementation of TaskRepository. */
public final class InMemoryTaskRepository implements TaskRepository {
  private final Map<UUID, Task> tasks = new ConcurrentHashMap<>();

  @Override
  public Task save(Task task) {
    tasks.put(task.id(), task);
    return task;
  }

  @Override
  public Optional<Task> findById(UUID id) {
    return Optional.ofNullable(tasks.get(id));
  }

  @Override
  public List<Task> findAll() {
    return tasks.values().stream().toList();
  }

  @Override
  public boolean deleteById(UUID id) {
    return tasks.remove(id) != null;
  }
}
