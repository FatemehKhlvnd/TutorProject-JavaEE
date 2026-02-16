package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Manager;
import com.example.tutor.model.entity.Role;
import com.example.tutor.model.entity.Student;
import com.example.tutor.service.Impl.ManagerServiceImpl;
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
import java.util.List;

@Slf4j
@WebServlet(name = "managerServlet", urlPatterns = "/manager.do")
public class ManagerServlet extends HttpServlet {

    @Inject
    private ManagerServiceImpl managerService;
    @Inject
    private RoleServiceImpl roleService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ManagerServlet - GET");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            List<Manager> managerList = managerService.findAll();
            System.out.println(managerList);
            request.getSession().setAttribute("managerList", managerList);

//            String jsonLessonList = new Gson().toJson(studentList);
//            System.out.println(jsonLessonList);
//            response.getWriter().write(jsonLessonList);
            request.getRequestDispatcher("/jsp/manager/manager.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ManagerServlet - Post");
        try {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Role managerRole = roleService.findByName("manager");


            Manager manager =
                    Manager
                            .builder()
                            .name(firstName)
                            .family(lastName)
                            .username(username)
                            .password(password)
                            .role(managerRole)
                            .build();

            managerService.save(manager);
            log.info("ManagerServlet - Manager Saved");
            response.sendRedirect("/manager.do");
        } catch (Exception e) {
            log.info("ManagerServlet - Error Save Manager");
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/jsp/manager/manager.jsp").forward(request, response);
        }
    }
}

