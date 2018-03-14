package rest.controller;

import com.google.gson.Gson;
import rest.models.Comment;
import rest.models.Photo;
import rest.resources.PhotosResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;

@Path("photo/comments")
public class CommentController {
  Gson gson = new Gson();
  PhotosResource photos = new PhotosResource();


  public CommentController(){

  }
  @GET
  @Path("{photoID}")
  public LinkedList<Comment> getComment(@PathParam("photoID") String photoID){
    LinkedList<Comment> returnComments = new LinkedList<>();
    if(photos.getPhotos().contains(photoID)){
      switch (photoID) {
        case "1": returnComments = photos.getPhoto1Comment();
          break;
        case "2": returnComments = photos.getPhoto2Comment();
          break;
        default: System.out.println("Invalid comment Get request");
      }
    }
    return returnComments;
  }

  @POST
  @Path("{photoID}")
  public String postComment(@PathParam("photoID") String photoID){

  }



}
