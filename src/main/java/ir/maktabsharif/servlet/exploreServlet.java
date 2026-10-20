package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.service.post.PostServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "explore", value = "/explore")
public class exploreServlet extends HttpServlet {

    private PostServiceImpl postService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.postService = (PostServiceImpl) getServletContext().getAttribute("postService");
        this.objectMapper = (ObjectMapper) getServletContext().getAttribute("objectMapper");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostResponseDto> postResponseDtoList = postService.findAll();

        objectMapper.writeValue(resp.getWriter(),postResponseDtoList);

    }
}
