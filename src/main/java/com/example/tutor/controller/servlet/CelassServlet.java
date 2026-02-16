package com.example.tutor.controller.servlet;

import com.example.tutor.model.entity.Celass;
import com.example.tutor.service.Impl.CelassServiceImpl;
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
@WebServlet(name = "CelassServlet", urlPatterns = "/Manager-celass.do")
public class CelassServlet extends HttpServlet {

    @Inject
    private CelassServiceImpl celassService;

    @Inject
    private Celass celass;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("CelassServlet - GET");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            log.info("CelassServlet - find all");
            List<Celass> celassList = celassService.findAll();
            log.info("CelassServlet - print");
            log.info("CelassServlet - setattribute");
            request.getSession().setAttribute("celassList", celassList);
            log.info("CelassServlet - setattribute succes");

            response.getWriter().write(celassList.toString());
            request.getRequestDispatcher("/jsp/manager/Manager-celass.jsp").forward(request, response);

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


            celass = Celass
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
