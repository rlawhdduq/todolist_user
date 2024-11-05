package todolist.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {
    private Long user_id;
    private String id;
    private String user_type;
    private String scope_of_disclosure;
    private Long number_of_following;
    private Long number_of_follower;
}
