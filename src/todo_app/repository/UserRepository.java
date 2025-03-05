package todo_app.repository;

import todo_app.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> users = new ArrayList<User>();
    private static final UserRepository instace = new UserRepository();
    private UserRepository(){}

    public static UserRepository getInstance(){
        return instace;
    }

    //User 사용자 등록
    public void save(User newUser){
        users.add(newUser);
    }

    //User 조회하기
    public Optional<User> findById (String userId){
        return users.stream()
                .filter(user ->user.getUserId().equals(userId))
                .findFirst();
    }

    public List<User> findAll(){
        return users;
    }

    public void delete (User user){
        users.remove(user);
    }

}
