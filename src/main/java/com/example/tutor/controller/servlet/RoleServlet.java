package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Role;
import com.example.tutor.service.Impl.RoleServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "roleServlet", urlPatterns = "/role.do")
public class RoleServlet extends HttpServlet {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;

    @Inject
    private RoleServiceImpl roleService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("RoleServlet - GET");
        request.getRequestDispatcher("/jsp/role.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("RoleServlet - Post");
        try {
            Role role =
                    Role
                            .builder()
                            //.title(request.getParameter("title"))
                            .build();
            roleService.save(role);
            log.info("RoleServlet - Role Saved");
            request.getRequestDispatcher("/jsp/role.jsp").forward(request, response);
        } catch (Exception e) {
            log.info("RoleServlet - Error Save Role");
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/jsp/role.jsp").forward(request, response);
        }
    }
}

