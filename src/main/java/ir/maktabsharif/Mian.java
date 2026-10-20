package ir.maktabsharif;

import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.service.post.PostServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;

import java.util.ArrayList;

public class Mian {
    static void main() {

        PostServiceImpl postService = new PostServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        UserRequestDto userRequestDto = UserRequestDto.builder()
                .username("amir")
                .password("amirpass")
                .fullName("amir satari")
                .postId(new ArrayList<>())
                .build();

        userService.save(userRequestDto);

    }
}
