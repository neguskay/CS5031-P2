package rest.resources;

import com.google.gson.Gson;
import java.util.LinkedList;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import rest.models.Comment;
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
  private User currentUser;

  private LinkedList<User> users;

  /**
   * UserResource Constructor.
   */
  public UsersResource() {
    this.gson = new Gson();
    this.photoResource = new PhotosResource();

    initUsers();
  }

  private void initUsers() {
    this.user1 = new User("soo", "1234", new LinkedList<Photo>());
    this.user2 = new User("see", "1111", photoResource.getUser2photos());

    users = new LinkedList<>();
    users.add(user1);
    users.add(user2);
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

  /**
   * Authenticates User's login details.
   * @param userId User name of admin
   * @param userPass Password of admin
   * @return boolean i.e. T/F is user's details are correct
   */
  @Path("{userId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public boolean isUserValid(@PathParam("userId") String userId,
                             @QueryParam("pw") String userPass) {
    boolean isValidUser = false;
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserid() == userId) {
        this.currentUser = users.get(i);
        System.out.println("Found User's Name");
        if (users.get(i).getUserPassword() == userPass) {
          System.out.println("User Login Verified: Welcome " + users.get(i).getUserid());
          //Log User In
          isValidUser = true;
        } else {
          System.out.println("User couldn't be verified at this time");
          isValidUser = false;
        }
      }
    }
    return isValidUser;
  }

  /**
   * Retrieves all comments of a given user.
   * @param userId user's ID/login
   * @return user's comments as  jSON object string
   */
  @GET
  @Path("{userId}/getusercomments")
  public String getUserComments(@PathParam("userId") String userId) {
    int userIndex = users.indexOf(userId);
    LinkedList<Comment> currentUserComments = new LinkedList<>();
    for (int i = 0; i < users.get(userIndex).getUserPhotos().size(); i++) {
      currentUserComments.add(
          users.get(userIndex).getUserPhotos().get(1).getPhotoComments().get(i));
    }
    return gson.toJson(currentUserComments);
  }
}
