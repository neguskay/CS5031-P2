package rest.resources;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import rest.models.Comment;
import rest.models.Photo;


/**
 * PhotoResource Class which contains all resources of Photos.
 */
@Path("/photos")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PhotosResource {
  private CommentsResource comments;
  private Gson gson;

  private Photo photo1;
  private Photo photo2;
  private Photo photo3;
  private Photo currentPhoto;

  private LinkedList<Comment> photo1Comment;
  private LinkedList<Comment> photo2Comment;
  private LinkedList<Comment> photo3Comment;
  private LinkedList<Comment> photo4Comment;

  private LinkedList<Photo> user1photos;
  private LinkedList<Photo> user2photos;

  private LinkedList<LinkedList> photoDatabase;

  /**
   * PhotoResource Constructor.
   */
  public PhotosResource() {
    gson = new Gson();
    initPhotos();
  }

  private void initPhotos() {
    this.comments = new CommentsResource();

    this.user1photos = new LinkedList<>();
    this.user2photos = new LinkedList<>();

    this.photo1Comment = new LinkedList<>();
    this.photo2Comment = new LinkedList<>();
    this.photo3Comment = new LinkedList<>();
    this.photo4Comment = new LinkedList<>();

    this.photo1Comment.add(comments.getComment1());
    this.photo2Comment.add(comments.getComment2());
    this.photo3Comment.add(comments.getComment3());
    this.photo4Comment.add(comments.getComment2());

    this.photo1 = new Photo("1", photo1Comment);
    this.photo2 = new Photo("2", photo2Comment);
    this.photo3 = new Photo("2", photo3Comment);

    this.user1photos.add(photo1);
    this.user1photos.add(photo2);
    this.user2photos.add(photo3);

    this.photoDatabase = new LinkedList();
    this.photoDatabase.add(user1photos);
    this.photoDatabase.add(user2photos);
  }

  public LinkedList<Photo> getUser1photos() {
    return user1photos;
  }

  public LinkedList<Photo> getUser2photos() {
    return user2photos;
  }

  @POST
  @Path("{photoid}/postcomment/")
  public String postComment(@PathParam("photoid") String photoid, @QueryParam("comment") String comment) {
    if(!(comment == null)) {
      for (int i = 0; i < photoDatabase.size(); i++) {
        LinkedList<Photo> currentPhotoList = photoDatabase.get(i);
        for (int j = 0; j < photoDatabase.get(i).size(); j++) {
          if (photoid.toLowerCase() == currentPhotoList.get(j).getPhotoId())
            currentPhoto = currentPhotoList.get(j);
          currentPhoto.getPhotoComments().add(new Comment(comment, null,
            new Timestamp(System.currentTimeMillis()), 0, 0));
          comments.commentNotifications+=1;
          System.out.println(currentPhoto.getPhotoComments().toString());
        }
      }
    }
    //return gson.toJson(currentPhoto.getPhotoComments());
    return currentPhoto.getPhotoComments().getLast().getComment();
  }

  public LinkedList<LinkedList> getPhotoDatabase() {
    return photoDatabase;
  }

  public void setComments(CommentsResource comments) {
    this.comments = comments;
  }

  @GET
  @Path("{photoid}/getusercomments")
  public String getUserComments(@PathParam("photoid") String photoid){
    String returnComments = "";
    //int photoIndex = photoDatabase.indexOf(photoid);
    LinkedList<Comment> currentPhotoComments  = new LinkedList<>();
    for (int i = 0; i <photoDatabase.size() ; i++) {
      for (int j = 0; j <photoDatabase.get(i).size() ; j++) {
        LinkedList<Photo> photoList = photoDatabase.get(i);
        if(photoList.get(j).getPhotoId() == photoid ){
          returnComments =  gson.toJson(photoList.element().getPhotoComments());
          if(comments.commentNotifications>0){
            comments.commentNotifications -=1;
          }
        }
        else{
          System.out.println("Couldn't find the Photo");
        }
      }
    }
    return returnComments;
  }

  public LinkedList<Comment> getPhoto1Comment() {
    return photo1Comment;
  }

  public LinkedList<Comment> getPhoto2Comment() {
    return photo2Comment;
  }
}
