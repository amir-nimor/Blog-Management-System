package ir.maktabsharif.dto.post;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private Integer userId;

}
