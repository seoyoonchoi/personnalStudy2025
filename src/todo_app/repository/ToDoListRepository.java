package todo_app.repository;

import todo_app.entity.ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ToDoListRepository {
    private List<ToDoList> tasks = new ArrayList<ToDoList>();
    private static final ToDoListRepository instance = new ToDoListRepository();

    private ToDoListRepository(){}

    public static ToDoListRepository getInstance(){
        return instance;
    }

    public void save(ToDoList task){
        tasks.add(task);
    }

    public Optional<ToDoList> findbyId(String id){
        return tasks.stream()
                .filter(task -> task.getUserId().equals(id))
                .findFirst();
    }

    public Optional<ToDoList> findbynumId(Long id){
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    public Optional<ToDoList> findbyType(String id,String type){
        return tasks.stream()
                .filter(task->task.getId().equals(id))
                .filter(tasks -> tasks.getTypeOfList().equals(type))
                .findFirst();
    }

    public List<ToDoList> findAll(){
        return tasks;
    }

    public void delete(ToDoList toDoList){
        tasks.remove(toDoList);
    }




}
