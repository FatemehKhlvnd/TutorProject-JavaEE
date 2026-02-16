package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Lesson;
import com.example.tutor.model.entity.Teacher;
import com.example.tutor.service.Impl.LessonServiceImpl;
import com.example.tutor.service.Impl.TeacherServiceImpl;
import jakarta.inject.Inject;
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
@WebServlet(name = "FindTeacherServlet", urlPatterns = "/Find-Teacher.do")
public class FindTeacherServlet extends HttpServlet {

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
                // Handle empty teacher list case if needed
                resp.getWriter().write("[]");
            }
        } catch (Exception e) {
            log.error("Error in FindTeacherServlet", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("FindTeacherServlet - Post");

        try {
            String idString = req.getParameter("lessonId");
            System.out.println(idString);

            Long id = null;
            if (idString != null && !idString.isEmpty()) {
                id = Long.parseLong(idString);
                req.getSession().setAttribute("lessonId", id);
            }

            System.out.println(id);
            log.info("FindTeacherServlet - findTeacherByLesson");
            Optional<Teacher> teacherList = teacherService.findTeacherByLesson(id);
            log.info("FindTeacherServlet - print");
            System.out.println(teacherList);
            log.info("FindTeacherServlet - setattribute");
            req.getSession().setAttribute("teacherList", teacherList);
            log.info("FindTeacherServlet - setattribute success");
            resp.sendRedirect("/Find-Teacher.do");

        } catch (NumberFormatException e) {
            log.error("Error parsing lessonId to Long", e);

            req.getSession().setAttribute("error", "Invalid lessonId format.");
            req.getRequestDispatcher("/jsp/student/Student-index.jsp").forward(req, resp);

        } catch (Exception e) {
            log.error("FindTeacherServlet - Error Save Lesson", e);

            req.getSession().setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/jsp/student/Student-index.jsp").forward(req, resp);
        }
    }



}
