package ir.maktabsharif.servlet.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.service.post.PostServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.ArrayList;

@WebListener
public class Start implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        UserServiceImpl userService = new UserServiceImpl();
        PostServiceImpl postService = new PostServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();

        sce.getServletContext().setAttribute("userService",userService);
        sce.getServletContext().setAttribute("postService",postService);
        sce.getServletContext().setAttribute("objectMapper",objectMapper);

//        UserRequestDto userRequestDto = UserRequestDto.builder()
//                .username("amirsatari")
//                .password("gyukfg")
//                .phonNumber("7527852")
//                .fullName("amir satari ")
//                .postId(new ArrayList<>())
//                .build();
//
//        UserResponseDto userResponseDto = userService.save(userRequestDto);
//
//
//        PostRequestDto postRequestDto1 = PostRequestDto.builder()
//                .title("post1")
//                .description("shgseghsghsdtgh")
//                .userId(userResponseDto.id())
//                .build();
//
//
//        PostRequestDto postRequestDto2 = PostRequestDto.builder()
//                .title("post2")
//                .description("shgseghsgghjcyt45257hsdtgh")
//                .userId(userResponseDto.id())
//                .build();
//
//        postService.save(postRequestDto1);
//        postService.save(postRequestDto2);



    }
}
