package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.LinkedList;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import rest.models.Photo;
import rest.models.Photogram;
import rest.models.User;
import rest.resources.PhotosResource;

/**
 * PhotogramApp class.
 * Intended to be the web application entry path that directs to other resources.
 * Under Construction.
 * Extended the Web Application class
 */
@ApplicationPath("/photogram")
public class PhotogramApp extends Application {
  Photo photo;

  Gson gson = new Gson();
  GsonBuilder gsonBuilder = new GsonBuilder();

  Photogram model = new Photogram("sam", "1122");

  User currentUser;

  LinkedList<Photo> userPhotos;

  /**
   * PhotogramApp Constructor.
   * Under Construction
   */
  public PhotogramApp() {

  }

  /*@GET
  @Path("/{userID}")
  @Produces(MediaType.APPLICATION_JSON)
  public  void retrieveUser(@PathParam("userID") String userID) throws IOException {
    if(userID.toLowerCase() == "soo"){
      currentUser = new User(userID, "1234", null);
      //userPhotos = currentUser.getUserPhotos();
      if(userPhotos == null){
        String photoID = "1";
        userPhotos.add(new Photo(photoID, null));
        gson.toJson("Getting Photo");
        gson.toJson(userPhotos, new FileWriter("/cs/home/soo3/"+
        "IdeaProjects/CS5031/P2/restful/src/main/java/rest/resources/photos/1.jpeg"));
      }

    }
  }*/

}
