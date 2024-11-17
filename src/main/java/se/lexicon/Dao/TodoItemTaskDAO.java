package se.lexicon.Dao;

import se.lexicon.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO {
    TodoItemTask persist(TodoItemTask todoItem);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove (int id);
}
