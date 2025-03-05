package todo_app.service;

import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    void registerUser(UserSignUpRequestDto dto);
    List<UserResponseDto> listAllUsers();
    UserResponseDto getUserById(String userId,String password);
    void updateUser(Long id, UserSignUpRequestDto dto);
    void signInUser(Long id, UserSignInRequestDto dto);
}
