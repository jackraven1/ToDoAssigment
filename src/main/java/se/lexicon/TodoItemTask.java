package se.lexicon;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        if (todoItem == null) {
            throw new IllegalArgumentException("TodoItem cannot be null.");
        }
        this.id = id;
        this.todoItem = todoItem;
        setAssignee(assignee);
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = assignee != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    @Override
    public String toString() {
        return String.format("TodoItemTask{id=%d, assigned=%b, todoItem=%s}", id, assigned, todoItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask)) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id &&
                assigned == that.assigned &&
                todoItem.equals(that.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }
}
