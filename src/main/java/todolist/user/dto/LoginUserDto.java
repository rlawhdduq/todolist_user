package todolist.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private Long user_id;
    private String id;
    private String user_type;
    private Character scope_of_disclosure;
    private Long number_of_following;
    private Long number_of_follower;
}
