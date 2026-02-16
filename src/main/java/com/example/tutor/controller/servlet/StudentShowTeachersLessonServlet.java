package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Lesson;
import com.example.tutor.service.Impl.LessonServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "StudentLessonServlet", urlPatterns = "/Student-Show-Teacher-Lesson.do")
public class StudentShowTeachersLessonServlet extends HttpServlet {

    @Inject
    private LessonServiceImpl lessonService;
    @Inject
    private Lesson lesson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
