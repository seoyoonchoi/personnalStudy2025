package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDoListRequestDto {
    private String userId;
    private String typeOfList;
}
