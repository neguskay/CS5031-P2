package rest.controller;

import com.google.gson.Gson;
import rest.resources.PhotosResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("photo")
public class PhotoController {
  Gson gson = new Gson();
  PhotosResource photos = new PhotosResource();

  public PhotoController(){

  }

  @GET
  @Path("{photoID}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getPhoto(@PathParam("photoID") String photoID){
    return gson.toJson(photos.getPhoto(photoID));

  }
  @POST
  @Path("{photoID}")
  public void postPhoto(String photoID){
    photos.addPhoto(photoID);
  }
}
