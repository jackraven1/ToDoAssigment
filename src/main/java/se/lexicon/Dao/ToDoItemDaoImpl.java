package se.lexicon.Dao;

import se.lexicon.TodoItem;
import se.lexicon.sequanser.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


public class ToDoItemDaoImpl implements TodoItemDAO{

    private ArrayList<TodoItem> items = new ArrayList<>();

    public ToDoItemDaoImpl() {
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        int id = TodoItemIdSequencer.nextId();
        todoItem= new TodoItem(id,todoItem.getTitle(),todoItem.getDescription(),todoItem.getDeadLine(),todoItem.getCreator());
        items.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for(TodoItem item:items){
            if(item.getId()==id)
                return item;
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return items;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        ArrayList<TodoItem> tempList = new ArrayList<>();
        for(TodoItem item : items){
            if(item.isDone())
                tempList.add(item);
        }
        return tempList;
    }

    @Override
    public Collection<TodoItem> titleContains(String title) {
        ArrayList<TodoItem> tempList = new ArrayList<>();
        for(TodoItem item : items){
            if(item.getTitle().equals(title)){
                tempList.add(item);
            }
        }
        return tempList;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        ArrayList<TodoItem> tempList = new ArrayList<>();
        for(TodoItem item : items){
            if(item.getCreator().getId()==personId)
                tempList.add(item);
        }
        return tempList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        ArrayList<TodoItem> tempList = new ArrayList<>();
        for(TodoItem item : items){
            if(item.getDeadLine().isBefore(date))
                tempList.add(item);
        }
        return tempList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate after) {
        ArrayList<TodoItem> tempList = new ArrayList<>();
        for(TodoItem item : items){
            if(item.getDeadLine().isBefore(after))
                tempList.add(item);
        }
        return tempList;
    }

    @Override
    public void remove(int id) {
        items.removeIf(item -> item.getId() == id);

    }
}
