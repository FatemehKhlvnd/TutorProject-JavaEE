package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Lesson;
import com.example.tutor.service.Impl.LessonServiceImpl;
import com.google.gson.Gson;
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
@WebServlet(name = "StudentLessonServlet", urlPatterns = "/Student-lesson.do")
public class StudentLessonServlet extends HttpServlet {

    @Inject
    private LessonServiceImpl lessonService;
    @Inject
    private Lesson lesson;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.info("SLessonServlet - GET");
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    try {
        log.info("SLessonServlet - find all");
        List<Lesson> lessonList = lessonService.findAll();
        log.info("SLessonServlet - print");
        System.out.println(lessonList);
        log.info("SLessonServlet - setattribute");
        request.getSession().setAttribute("lessonList", lessonList);
        log.info("SLessonServlet - setattribute success");

        // No need to manually convert to JSON, let the toString method handle it
        // Write the JSON data to the response
        response.getWriter().write(lessonList.toString());

        // No need to forward to JSP in this case, as the data is fetched using AJAX

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LessonServlet - Post");

        try {
            String name = request.getParameter("lessonName");

            lesson =
                    Lesson
                            .builder()
                            .name(name)
                            .build();
            lessonService.save(lesson);
            log.info("LessonServlet - Lesson Saved");
            response.sendRedirect("/Manager-lesson.do");
//            request.getRequestDispatcher("/jsp/lesson.jsp").forward(request, response);
        } catch (Exception e) {
            log.info("LessonServlet - Error Save Lesson");
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/jsp/manager/Manager-lesson.jsp").forward(request, response);
        }
    }
}