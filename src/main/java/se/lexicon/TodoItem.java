package se.lexicon;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(int id, String title, String description, LocalDate deadLine, Person creator) {
        if (title == null || title.isEmpty() || deadLine == null || creator == null) {
            throw new IllegalArgumentException("Title, deadline, and creator cannot be null or empty.");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.creator = creator;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, title='%s', description='%s', deadline=%s, done=%b}",
                id, title, description, deadLine, done);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id &&
                done == todoItem.done &&
                title.equals(todoItem.title) &&
                Objects.equals(description, todoItem.description) &&
                deadLine.equals(todoItem.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadLine, done);
    }
}
