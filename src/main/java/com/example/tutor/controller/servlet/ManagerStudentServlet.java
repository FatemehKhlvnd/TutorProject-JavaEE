package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Role;
import com.example.tutor.model.entity.Student;
import com.example.tutor.service.Impl.RoleServiceImpl;
import com.example.tutor.service.Impl.StudentServiceImpl;
import com.google.gson.Gson;
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
import java.util.Optional;

@Slf4j
@WebServlet(name = "studentServlet", urlPatterns = "/Manager-student.do")
public class ManagerStudentServlet extends HttpServlet {

    @Inject
    private StudentServiceImpl studentService;

    @Inject
    private RoleServiceImpl roleService;
    @Inject
    private Student student;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("StudentServlet - GET");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            List<Student> studentList = studentService.findAll();
            System.out.println(studentList);
            request.getSession().setAttribute("studentList", studentList);
            request.getRequestDispatcher("/jsp/manager/Manager-student.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("StudentServlet - Post");
        try {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Role studentRole = roleService.findByName("student");

            student =
                    Student
                            .builder()
                            .name(firstName)
                            .family(lastName)
                            .username(username)
                            .password(password)
                            .role(studentRole)
                            .build();
            studentService.save(student);
            log.info("StudentServlet - Student Saved");
            response.sendRedirect("Manager-student.do");
        } catch (Exception e) {
            log.info("StudentServlet - Error Save Student");
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/jsp/manager/Manager-student.jsp").forward(request, response);
        }
    }
}

