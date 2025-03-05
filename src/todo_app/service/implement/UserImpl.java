package todo_app.service.implement;

import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserImpl implements UserService {
    private final UserRepository repository;
    private static Long currentId = 1L;

    public UserImpl(){
        this.repository = UserRepository.getInstance();
    }

    private Long generateId(){
        return currentId++;
    }


    @Override
    public void registerUser(UserSignUpRequestDto dto) {
        User user = new User(generateId(),dto.getUserId(), dto.getUsername(), dto.getNickname(),
                dto.getPassword(), dto.getEmail(), dto.getPhone(),new Date());
        repository.save(user);

    }

    @Override
    public List<UserResponseDto> listAllUsers() {

        List<User> users = repository.findAll();
        List<UserResponseDto> responseDtos = users.stream()
                .map(user ->new UserResponseDto(user.getNickname())).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public UserResponseDto getUserById(String userId,String password) {
        UserResponseDto responseDto = null;
        try{
            User user = repository.findById(userId).orElseThrow(()->new IllegalArgumentException("해당 아이디를 조회할 수 없습니다."));

            Optional<User> optionalUser = repository.findById(userId);

            if(optionalUser.isEmpty()){
                new IllegalArgumentException("없어요 아무것도..;;");
            }

            User userValue = optionalUser.get();
            responseDto = new UserResponseDto(user.getNickname());



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseDto;
    }


































    @Override
    public void updateUser(Long id, UserSignUpRequestDto dto) {

    }

    @Override
    public void signInUser(Long id, UserSignInRequestDto dto) {

    }
}
