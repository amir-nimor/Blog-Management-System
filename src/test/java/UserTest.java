import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.service.post.PostServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {


    @Test
    public void saveTest(){

        PostServiceImpl postService = new PostServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        UserRequestDto userRequestDto = UserRequestDto.builder()
                .username("amir")
                .password("amirpass")
                .fullName("amir satari")
                .postId(new ArrayList<>())
                .build();

        UserResponseDto userResponseDto = userService.save(userRequestDto);




        assertEquals("amir",userResponseDto.getUsername());
    }
}
