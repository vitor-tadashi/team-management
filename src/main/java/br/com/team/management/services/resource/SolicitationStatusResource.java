package br.com.team.management.services.resource;

import br.com.team.management.services.bo.SolicitationStatusBO;
import br.com.team.management.services.bo.TypeAllocationBO;
import br.com.team.management.services.model.SolicitationStatus;
import br.com.team.management.services.model.TypeAllocation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Rest service for the solicitaton status domain.
 */
@Api
@Component
@Path(value = "/solicitation-status")
public class SolicitationStatusResource {

    private final static Logger LOG = LoggerFactory.getLogger(SolicitationStatusResource.class);

    @Inject
    private SolicitationStatusBO solicitationStatusBO;

    @GET
    @ApiOperation(value = "Operation that gets all the data of solicitation status.", notes = "Search without parameters all the solicitation status.", produces = MediaType.APPLICATION_JSON, response = Response.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Search done successfully.") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        final Iterable<SolicitationStatus> iterable = solicitationStatusBO.findAll();
        return Response.ok().entity(iterable).build();
    }
}