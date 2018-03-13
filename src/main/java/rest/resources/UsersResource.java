package rest.resources;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class UsersResource {


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String getMessage(){

    Gson gson = new Gson();

    return gson.toJson("Hello");
  }
}
