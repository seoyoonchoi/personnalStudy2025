package todo_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class ToDoList {
    private Long id;//할일 고유 번호
    private String userId;//해당 기록에서의 유저
    private Date registerDate;//해당 할일을 등록한 일자
    private String dueDate;//완료기한
    private String typeOfList;//할일이 어떤 타입인지에 대해서 (운동/ 독서/업무 등--나중에 enum으로 설정도 가능할지도?)
    private String context;//할일에 관한 구체적인 내용


}
