import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.service.post.PostServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {


    @Test
    public void PostTest() {

        PostServiceImpl postService = new PostServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        UserRequestDto userRequestDto = UserRequestDto.builder()
                .username("amir")
                .password("amirpass")
                .fullName("amir satari")
                .postId(new ArrayList<>())
                .build();


        UserResponseDto userResponseDto = userService.save(userRequestDto);

        PostRequestDto postRequestDto = PostRequestDto.builder()
                .title("hello")
                .description("eragesarg")
                .userId(userResponseDto.getId())
                .build();
        PostResponseDto postResponseDto = postService.save(postRequestDto);
        assertEquals(1,postResponseDto.getId());




    }
}
