package rest.resources;

import com.google.gson.Gson;
import java.util.LinkedList;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import rest.models.Photo;
import rest.models.User;

/**
 * UserResource class holds all users resources.
 */
@Path("/users")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
public class UsersResource {
  private Gson gson = new Gson();
  private PhotosResource photoResource;

  private String newUserName;
  private String newUserPassword;
  private String user1id;
  private String user1password;

  private User user1;
  private User user2;

  /**
   * UserResource Constructor.
   */
  public UsersResource() {
    this.gson = new Gson();
    this.photoResource = new PhotosResource();
    user1id = "soo";
    user1password = "1234";
    user1 = new User(user1id, user1password, new LinkedList<Photo>());
    user2 = new User("see", "1111", photoResource.getUser2photos());
  }

  /**
   * Test method to debug and tests return users while under construction.
   * @param id User Login ID
   * @return Json user object as a String of text
   */
  @GET
  @Path("{id}")
  public String getMessage(@PathParam("id") String id) {
    Object object = new Object();
    switch (id.toLowerCase()) {
      case "1": object = user1;
      break;
      case "2": object = user2;
      break;
      default: object =  "ID: " + id + " not supported.";
      break;
    }
    return gson.toJson(object);
  }

  /*@POST
  @Path("{username}", "{password}")*/

}
