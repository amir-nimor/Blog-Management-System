package ir.maktabsharif.servlet.filter;

import ir.maktabsharif.dto.user.UserResponseDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/page/profile.jsp","/page/UserPost.jsp"})
public class Authorization implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        if (session == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND,"your section is not founded");
            return;
        }

        UserResponseDto userResponseDto = (UserResponseDto) session.getAttribute("user");

        if (userResponseDto == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND,"your user is not founded");
            return;
        }

        filterChain.doFilter(request,response);
    }
}
