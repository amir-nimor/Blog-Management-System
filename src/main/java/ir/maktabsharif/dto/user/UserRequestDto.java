package ir.maktabsharif.dto.user;


import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequestDto {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String phonNumber;
    private List<Long> postId ;

}
