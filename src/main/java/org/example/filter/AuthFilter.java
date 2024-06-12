package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.entity.Users;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
           HttpServletRequest request = (HttpServletRequest) servletRequest;
           HttpServletResponse response = (HttpServletResponse) servletResponse;
        List<String> lines = Files.readAllLines(Path.of("/home/qudratilla/IdeaProjects/WEB_PROJECT/src/WhiteList"));

        String uri = request.getRequestURI();
        long count = lines.stream().filter(uri::equals).count();
        if (count == 0) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                Users user = (Users)session.getAttribute("user");
                if (user != null) {
                    filterChain.doFilter(request, response);
                }else{
                    response.sendRedirect("/login");
                }
            }
            else{
                response.sendRedirect("/login");
            }
        }
        else{
            filterChain.doFilter(request, response);
        }
    }
}
