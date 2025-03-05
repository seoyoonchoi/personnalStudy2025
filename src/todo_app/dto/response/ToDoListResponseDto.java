package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ToDoListResponseDto {
    private String dueDate;
    private String typeOfList;
    private String context;
}
