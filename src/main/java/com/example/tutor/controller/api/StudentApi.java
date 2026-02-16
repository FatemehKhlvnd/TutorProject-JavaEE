package com.example.tutor.controller.api;

import com.example.tutor.model.entity.Student;
import com.example.tutor.service.Impl.StudentServiceImpl;
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
@Path("/student")
public class StudentApi {

    @Inject
    private StudentServiceImpl attachService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            log.info("FindAllStudent");
            return Response
                    .ok()
                    .entity(attachService.findAll())
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
            log.info("FindByIdStudent");
            return Response
                    .ok()
                    .entity(attachService.findById(id))
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
    public Response save(Student attach) {
        try {
            log.info("Save Student");
            attachService.save(attach);
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
    public Response edit(Student attach) {
        try {
            log.info("Edit Student");
            attachService.edit(attach);
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
            log.info("Remove Student");
            attachService.removeById(id);
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
}


