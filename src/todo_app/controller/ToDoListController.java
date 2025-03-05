package todo_app.controller;

import todo_app.dto.request.ToDoListRegisterRequestDto;
import todo_app.dto.response.ToDoListResponseDto;
import todo_app.service.ToDoListService;
import todo_app.service.implement.ToDoListImpl;

import java.util.List;

public class ToDoListController {
    private ToDoListService service;

    public ToDoListController(){
        this.service = new ToDoListImpl();
    }

    public void createTask(ToDoListRegisterRequestDto dto){
        service.createList(dto);
    }

    public List<ToDoListResponseDto> myTask(String userId){
        return service.filterTaskByid(userId);
    }

    public List<ToDoListResponseDto> myTaskTypes(String userid, String type){
        return service.filterTaskByType(userid,type);
    }

    public void deletetask(long id){
        service.deleteList(id);
    }


}
