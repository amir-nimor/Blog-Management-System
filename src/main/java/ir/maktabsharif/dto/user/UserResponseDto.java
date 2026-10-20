package ir.maktabsharif.dto.user;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserResponseDto {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String phonNumber;
    private List<Long> postId ;
}
