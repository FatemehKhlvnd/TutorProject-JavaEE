package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Role;
import com.example.tutor.model.entity.Student;
import com.example.tutor.model.entity.Teacher;
import com.example.tutor.service.Impl.RoleServiceImpl;
import com.example.tutor.service.Impl.StudentServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;


@Slf4j
@WebServlet(name = "ManagerStudentTable", urlPatterns = "/Manager-student-table.do")

public class ManagerStudentTableServlet extends HttpServlet {

    @Inject
    private StudentServiceImpl studentService;
    @Inject
    private Student student;
    @Inject
    private RoleServiceImpl roleService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ManagerStudentTable - GET");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {

            List<Student> studentList = studentService.findAll();
            System.out.println(studentList);
            request.getSession().setAttribute("studentList", studentList);
            response.getWriter().write(studentList.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ManagerStudentTable - Post");
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