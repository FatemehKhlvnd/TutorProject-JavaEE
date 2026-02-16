package com.example.tutor.controller.api;

import com.example.tutor.model.entity.Lesson;
import com.example.tutor.service.Impl.LessonServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/lesson")
public class LessonApi {

    @Inject
    private LessonServiceImpl lessonService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            log.info("FindAllLesson");
            return Response
                    .ok()
                    .entity(lessonService.findAll())
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        try {
            log.info("FindByIdLesson");
            return Response
                    .ok()
                    .entity(lessonService.findById(id))
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Lesson attach) {
        try {
            log.info("Save Lesson");
            lessonService.save(attach);
            return Response
                    .ok()
                    .entity(attach)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Lesson attach) {
        try {
            log.info("Edit Lesson");
            lessonService.edit(attach);
            return Response
                    .ok()
                    .entity(attach)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Long id) {
        try {
            log.info("Remove Lesson");
            lessonService.removeById(id);
            return Response
                    .ok()
                    .entity(id)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }
    }
//@DELETE
//@Path("/{id}")
//public Response remove(@PathParam("id") String id) {
//    try {
//        log.info("Remove Lesson");
//        // Convert the String ID to Long before passing it to the service
//        Long lessonId = Long.parseLong(id);
//        lessonService.removeById(lessonId);
//        return Response
//                .ok()
//                .entity(id)
//                .build();
//    } catch (Exception e) {
//        log.error(e.getMessage());
//        return Response
//                .serverError()
//                .entity(e.getMessage())
//                .build();
//    }
//}

}


