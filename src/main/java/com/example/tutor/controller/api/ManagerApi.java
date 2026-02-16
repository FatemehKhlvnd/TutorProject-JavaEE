package com.example.tutor.controller.api;

import com.example.tutor.model.entity.Manager;
import com.example.tutor.service.Impl.ManagerServiceImpl;
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
@Path("/manager")
public class ManagerApi {

    @Inject
    private ManagerServiceImpl attachService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            log.info("FindAllCelass");
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
            log.info("FindByIdManager");
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
    public Response save(Manager attach) {
        try {
            log.info("Save Manager");
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
    public Response edit(Manager attach) {
        try {
            log.info("Edit Manager");
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
            log.info("Remove Manager");
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


