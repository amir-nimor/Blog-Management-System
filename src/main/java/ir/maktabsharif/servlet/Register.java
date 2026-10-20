package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.service.user.UserServiceImpl;
import ir.maktabsharif.util.PasswordUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;


@WebServlet(name = "Register",value = "/Register")
public class Register extends HttpServlet {

    private UserServiceImpl userService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
        this.objectMapper = (ObjectMapper) getServletContext().getAttribute("objectMapper");
    }



    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRequestDto userRequestDto = objectMapper.readValue(req.getReader(),UserRequestDto.class);

        HttpSession session = req.getSession();
        UserResponseDto userResponseDto = userService.findByUsername(userRequestDto.getUsername());

        String password = userRequestDto.getPassword();

        boolean ispasswordOk = PasswordUtil.checkingPassword(password,userResponseDto.getPassword());

        if (ispasswordOk){
            session.setAttribute("user",userResponseDto);
            session.setAttribute("userId",userResponseDto.getId());
            resp.setStatus(201);
            resp.setContentType("application/json");
            objectMapper.writeValue(resp.getWriter(),userResponseDto);
        }else {
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        UserRequestDto userRequestDto = objectMapper.readValue(req.getReader(), UserRequestDto.class);

        String passwordHash = PasswordUtil.generatePassword(userRequestDto.getPassword());

        userRequestDto.setPassword(passwordHash);

        UserResponseDto userResponseDto = userService.save(userRequestDto);

        session.setAttribute("user",userResponseDto);
        session.setAttribute("userId",userResponseDto.getId());

        Cookie cookie = new Cookie("username", userRequestDto.getUsername());


        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.addCookie(cookie);


        objectMapper.writeValue(resp.getWriter(),userResponseDto);
        req.getRequestDispatcher("./page/profile.jsp").forward(req,resp);
    }
}
