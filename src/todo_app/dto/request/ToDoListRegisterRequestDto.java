package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDoListRegisterRequestDto {
    private String userId;
    private String typeOfList;
    private String dueDate;
    private String context;
}
