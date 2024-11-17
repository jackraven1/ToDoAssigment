package se.lexicon.Dao;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    TodoItem persist (TodoItem todoItem);
    TodoItem findById (int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem>findAllByDoneStatus(boolean done);
    Collection<TodoItem>titleContains(String title);
    Collection<TodoItem>findByPersonId(int personId);
    Collection<TodoItem>findByDeadlineBefore(LocalDate date);
    Collection<TodoItem>findByDeadlineAfter(LocalDate after);
    void remove (int id);
}
