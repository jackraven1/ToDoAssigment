package se.lexicon.Dao;

import se.lexicon.TodoItemTask;
import se.lexicon.sequanser.TodoItemIdSequencer;

import java.util.ArrayList;
import java.util.Collection;

public class TodoItemTaskDaoImpl implements TodoItemTaskDAO{
    private ArrayList<TodoItemTask> tasks = new ArrayList<>();

    @Override
    public TodoItemTask persist(TodoItemTask todoItem) {
        int id = TodoItemIdSequencer.nextId();
        todoItem = new TodoItemTask(id,todoItem.getTodoItem(),todoItem.getAssignee());
        tasks.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItemTask findById(int id) {
        for(TodoItemTask task : tasks){
            if(task.getId()==id)
                return task;
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return tasks;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        ArrayList<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : tasks){
            if(task.isAssigned())
                result.add(task);
        }
        return result;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        ArrayList<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : tasks){
            if(task.getAssignee().getId()==personId)
                result.add(task);
        }
        return result;
    }

    @Override
    public void remove(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
