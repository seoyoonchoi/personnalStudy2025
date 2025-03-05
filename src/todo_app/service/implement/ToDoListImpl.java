package todo_app.service.implement;



import todo_app.dto.request.ToDoListRegisterRequestDto;
import todo_app.dto.request.ToDoListRequestDto;
import todo_app.dto.response.ToDoListResponseDto;
import todo_app.entity.ToDoList;
import todo_app.entity.User;
import todo_app.repository.ToDoListRepository;
import todo_app.repository.UserRepository;
import todo_app.service.ToDoListService;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ToDoListImpl implements ToDoListService {
    private final UserRepository userRepository;
    private final ToDoListRepository toDoListRepository;

    private static long currentId = 1;
    public ToDoListImpl(){
        this.userRepository = UserRepository.getInstance();
        this.toDoListRepository = ToDoListRepository.getInstance();
    }

    private Long generateToDoListId(){
        return currentId++;
    }
    //유저아이디랑 일치하는 할일만 반환해주어야 함 -> 이거 일치여부 테스트
    private void validateUserId(String userId){
        Optional<User> foundUser = userRepository.findById(userId);

        if(!foundUser.isPresent()){
            throw new IllegalArgumentException("못찾아요 ;;;");
        }
    }




    @Override
    public void createList(ToDoListRegisterRequestDto dto) {
        try{
            validateUserId(dto.getUserId());
            ToDoList task = new ToDoList(generateToDoListId(),dto.getUserId(),new Date(),dto.getDueDate(), dto.getTypeOfList(), dto.getContext());
            toDoListRepository.save(task);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<ToDoListResponseDto> filterTaskByid(String id) {
        List<ToDoListResponseDto> responseDtos = null;
        try{
            List<ToDoList> tasks = toDoListRepository.findAll();
            responseDtos = tasks.stream().filter(k->k.getUserId().contains(id))
                    .map(filtered->new ToDoListResponseDto(filtered.getDueDate(), filtered.getTypeOfList(),filtered.getContext()))
                    .collect(Collectors.toList());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return responseDtos;
    }

    @Override
    public List<ToDoListResponseDto> filterTaskByType(String userId, String type) {
        List<ToDoListResponseDto> responseDtos = null;
        try{
            List<ToDoList> tasks = toDoListRepository.findAll();
            responseDtos = tasks.stream().filter(k->k.getUserId().contains(userId)).filter(o->o.getTypeOfList().contains(type))
                    .map(filtered->new ToDoListResponseDto(filtered.getDueDate(), filtered.getTypeOfList(),filtered.getContext()))
                    .collect(Collectors.toList());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return responseDtos;
    }


    @Override
    public void deleteList(Long id) {
        try{ ToDoList toDoList = toDoListRepository.findbynumId(id).orElseThrow(()
        ->new IllegalArgumentException("할일없다고!!"));
            toDoListRepository.delete(toDoList);


        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
