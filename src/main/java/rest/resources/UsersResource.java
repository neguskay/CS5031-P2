package rest.resources;

import com.google.gson.Gson;
import rest.models.Photo;
import rest.models.User;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;

@Path("/users")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
public class UsersResource {
  Gson gson = new Gson();
  PhotosResource photos = new PhotosResource();
  private String newUserName, newUserPassword;

  String user1ID, user1Password;
  User user1,user2;
  public UsersResource () {
    user1ID = "soo";
    user1Password = "1234";
    user1 = new User(user1ID, user1Password, new LinkedList<Photo>());
    user2 = new User("see", "1111", photos.getUser2photos());
  }
  @GET
  @Path("{id}")
  public String getMessage(@PathParam("id") String id){
    Object object = new Object();
    switch (id.toLowerCase()) {
      case "1": object = user1;
      break;
      case "2": object = user2;
      break;
      default: object =  "ID: "+id+" not supported.";
      break;
    }
    return gson.toJson(object);
  }

  /*@POST
  @Path("{username}", "{password}")*/

}
