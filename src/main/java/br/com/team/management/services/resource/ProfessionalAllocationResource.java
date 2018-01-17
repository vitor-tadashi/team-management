package br.com.team.management.services.resource;

import br.com.team.management.services.bo.ProfessionalAllocationBO;
import br.com.team.management.services.exceptions.BusinessException;
import br.com.team.management.services.model.ProfessionalAllocation;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Rest service for the allocated professional domain.
 */
@Api
@Component
@Path("/professional-allocation")
public class ProfessionalAllocationResource {

    private final static Logger LOG = LoggerFactory.getLogger(ProfessionalAllocationResource.class);

    @Inject
    private ProfessionalAllocationBO professionalAllocationBO;

    @GET
    @ApiOperation(value = "Operation that gets all the data of professional allocation.", notes = "Search without parameters all the professional allocations.", produces = MediaType.APPLICATION_JSON, response = Response.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Search done successfully.") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        final Iterable<ProfessionalAllocation> iterable = professionalAllocationBO.findAll();
        return Response.ok().entity(iterable).build();
    }

    @GET
    @Path("/{idProfessionalAllocation}")
    @ApiOperation(value = "Search for a professional allocation by ID.", notes = "This operation seeks a professional allocation from the informed ID.", produces = MediaType.APPLICATION_JSON, response = Response.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Allocation of professional found."),
            @ApiResponse(code = 404, message = "Allocation of professional not found.") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(
            @PathParam("idProfessionalAllocation") @ApiParam(name = "idProfessionalAllocation", example = "001", required = true, value = "Id do evento") Integer idProfessionalAllocation) {
        ProfessionalAllocation professionalAllocation = professionalAllocationBO.findOne(idProfessionalAllocation);

        if (professionalAllocation != null) {
            return Response.ok().entity(professionalAllocation).build();
        } else {
            return Response.status(404).entity(new ProfessionalAllocation()).build();
        }
    }

    @POST
    @ApiOperation(value = "Saves a new professional allocationo.", notes = "Operation responsible for generating a new professional allocation.", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, response = Response.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Professional Allocation was created successfully."),
            @ApiResponse(code = 500, message = "Problems occurred while creating a new professional allocation.") })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProfessionalAllocation(@ApiParam(name = "professionalAllocation", required = true, value = "professionalAllocation") ProfessionalAllocation professionalAllocation) {
        try {
            professionalAllocation = professionalAllocationBO.save(professionalAllocation);
        } catch (Exception e) {
            return Response.status(500).entity(professionalAllocation).build();
        }
        return Response.ok().entity(professionalAllocation).build();
    }

    @PUT
    @ApiOperation(value = "Updates a professional allocation.", notes = "Operation is responsible for changing an existing professional allocation in the database.", consumes = MediaType.APPLICATION_JSON, response = Response.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Professional Allocation was changed successfully."),
            @ApiResponse(code = 500, message = "Problems occurred while changing a professional allocation.") })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProfessionalAllocation(@ApiParam(name = "professionalAllocation", required = true, value = "professionalAllocation") ProfessionalAllocation professionalAllocation) {
        try {
            professionalAllocationBO.update(professionalAllocation);
            return Response.ok().build();
        } catch (BusinessException e) {
            return Response.status(HttpStatus.NOT_FOUND.value()).entity("Non-localized professional allocation for upgrade").build();
        }
    }
}
