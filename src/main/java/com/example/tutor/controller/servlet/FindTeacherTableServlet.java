package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Teacher;
import com.example.tutor.service.Impl.TeacherServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@WebServlet(name = "FindTeacherTableServlet", urlPatterns = "/find-teacher-table.do")

public class FindTeacherTableServlet extends HttpServlet {

    @Inject
    private TeacherServiceImpl teacherService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("FindTeacherServlet - GET");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            Long id = (Long) req.getSession().getAttribute("lessonId");
            log.info("Lesson ID: " + id);

            Optional<Teacher> teacherList = teacherService.findTeacherByLesson(id);
            log.info("Teacher List: " + teacherList);

            if (teacherList.isPresent()) {
                req.getSession().setAttribute("teacherList", teacherList.get());
                log.info("Teacher List set in session.");
                resp.getWriter().write(teacherList.toString());
            } else {
                log.warn("Teacher List is empty.");
                resp.getWriter().write("[]");
            }
        } catch (Exception e) {
            log.error("Error in FindTeacherServlet", e);
            throw new RuntimeException(e);
        }

    }

}
