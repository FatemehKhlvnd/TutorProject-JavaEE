package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Celass;
import com.example.tutor.model.entity.Lesson;
import com.example.tutor.service.Impl.CelassServiceImpl;
import com.example.tutor.service.Impl.LessonServiceImpl;
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
@WebServlet(name = "ManagerCelassTable", urlPatterns = "/Manager-celass-table.do")

public class ManagerCelassTableServlet extends HttpServlet {
    @Inject
    private CelassServiceImpl celassService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("ManagerCelassTable - GET");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            log.info("ManagerCelassTable - find all");
            List<Celass> celassList = celassService.findAll();
            log.info("ManagerCelassTable - print");
            log.info("ManagerCelassTable - setattribute");
            request.getSession().setAttribute("lessonList", celassList);
            log.info("ManagerCelassTable - setattribute succes");

            response.getWriter().write(celassList.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("CelassServlet - Post");
        try {
            String date = request.getParameter("celassDate");
            String time = request.getParameter("celassTime");


           Celass celass = Celass
                    .builder()
                    .Date_c(date)
                    .time(time)
                    //.title(request.getParameter("title"))
                    .build();
            celassService.save(celass);
            log.info("CelassServlet - Celass Saved");
            response.sendRedirect("/Manager-celass.do");
        } catch (Exception e) {
            log.info("CelassServlet - Error Save Celass");
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/jsp/manager/Manager-celass.jsp").forward(request, response);
        }
    }
}
