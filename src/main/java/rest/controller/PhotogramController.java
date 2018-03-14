package rest.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rest.models.Photo;
import rest.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.LinkedList;


@Path("/login")
public class PhotogramController {
  Gson gson = new Gson();
  GsonBuilder gsonBuilder = new GsonBuilder();

  User currentUser;
  LinkedList<Photo> userPhotos;
  public PhotogramController(){

  }

  @GET
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
        //gson.toJson(userPhotos, new FileWriter("/cs/home/soo3/IdeaProjects/CS5031/P2/restful/src/main/java/rest/resources/photos/1.jpeg"));
      }

    }
  }



}
