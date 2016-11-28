package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api(value = "Api for querying cars")
public class UserResource {

	@GET
	@ApiOperation(value = "get all cars")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getCars(@QueryParam("page") int page, 
			@QueryParam("perPage") int perPage, @QueryParam("with-name") String withName) {
	
		UserService userService = UserService.getInstance();
		PagedResponse usersInPages = userService.getCarsInPagesFiltered(page, perPage, withName);
		
		return usersInPages;
	}

	
	@Path("/models")
	@GET
	@ApiOperation("get all distinct user names")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctUserNames(){
		return UserService.getInstance().getAllDistinctCarModels();
	}

	@POST
	@ApiOperation(value = "create new user", response = Cars.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Cars newCar) {
		UserService.getInstance().addCar(newCar);

		return Response.ok(newCar).build();
	}
}
