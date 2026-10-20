package ir.maktabsharif.dto.post;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostRequestDto{
    private Long id;
    private String title;
    private String description;
    private Integer userId;


}
