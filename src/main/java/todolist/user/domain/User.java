package todolist.user.domain;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, unique = true, length = 50, name="id")
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String addr;

    @Column(nullable = false, length = 70)
    private String addr_dt;

    @Column(nullable = false, length = 6)
    private String birth;

    @Column(nullable = false, unique = true, length = 15)
    private String ph;

    @Column
    private String social_login_platform;

    @Column(nullable = false, length = 1)
    private Character gender;

    @Builder.Default
    private String user_type = "NC";
    @Column
    private Long number_of_following;
    @Column
    private Long number_of_follower;
    @Builder.Default
    private String scope_of_disclosure = "A";
}
