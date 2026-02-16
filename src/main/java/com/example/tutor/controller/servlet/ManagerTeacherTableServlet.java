package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Role;
import com.example.tutor.model.entity.Teacher;
import com.example.tutor.service.Impl.LessonServiceImpl;
import com.example.tutor.service.Impl.RoleServiceImpl;
import com.example.tutor.service.Impl.TeacherServiceImpl;
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
@WebServlet(name = "teacherServletTable", urlPatterns = "/Manager-teacher-table.do")
public class ManagerTeacherTableServlet extends HttpServlet {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;

    @Inject
    private LessonServiceImpl lessonService;
    @Inject
    private RoleServiceImpl roleService;
    @Inject
    private TeacherServiceImpl teacherService;
    @Inject
    private Teacher teacher;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("TeacherServletTable - GET");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {

            List<Teacher> teacherList = teacherService.findAll();
            System.out.println(teacherList);
            request.getSession().setAttribute("teacherList", teacherList);
            response.getWriter().write(teacherList.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("TeacherServlet - Post");
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String education = request.getParameter("education");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
//            Lesson lessons = request.getParameter("lessons");

            Role teacherRole = roleService.findByName("teacher");


            teacher =
                    Teacher
                            .builder()
                            .name(firstName)
                            .family(lastName)
                            .education(education)
                            .username(username)
                            .password(password)
                            .role(teacherRole)
                            .build();
            teacherService.save(teacher);
            log.info("TeacherServlet - Teacher Saved");
            response.sendRedirect("Manager-teacher.do");
        } catch (Exception e) {
            log.info("TeacherServlet - Error Save Teacher");
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/jsp/manager/Manager-teacher.jsp").forward(request, response);
        }
    }
}

