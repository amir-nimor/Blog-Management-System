package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.service.post.PostServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userPost",value = "/userPost")
public class UserPostServlet extends HttpServlet {

    private PostServiceImpl postService;
    private UserServiceImpl userService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
        this.objectMapper = (ObjectMapper) getServletContext().getAttribute("objectMapper");
        this.postService = (PostServiceImpl) getServletContext().getAttribute("postService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserResponseDto userResponseDto = (UserResponseDto) session.getAttribute("user");

        List<PostResponseDto> postResponseDtoList = postService.userPosts(userResponseDto.getId());

        resp.setContentType("application/json");
        resp.setStatus(200);

        objectMapper.writeValue(resp.getWriter(),postResponseDtoList);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserResponseDto userResponseDto = (UserResponseDto) session.getAttribute("user");

        PostRequestDto postRequestDto = objectMapper.readValue(req.getReader(), PostRequestDto.class);



        PostResponseDto postResponseDto = postService.update(postRequestDto);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(),postResponseDto);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostRequestDto postRequestDto = objectMapper.readValue(req.getReader(),PostRequestDto.class);

        PostResponseDto postResponseDto = postService.save(postRequestDto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(),postResponseDto);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
