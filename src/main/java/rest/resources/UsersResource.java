package rest.resources;

import com.google.gson.Gson;
import rest.models.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class UsersResource {
  Gson gson = new Gson();

  String user1ID, user1Password;
  User user1;
  public UsersResource () {
    user1ID = "soo";
    user1Password = "1234";
    user1 = new User(user1ID, user1Password, null);
  }
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String getMessage(){

    return gson.toJson(user1);
  }
}
