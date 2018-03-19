package rest.resources;

import java.util.LinkedList;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

  private Photo photo1;
  private Photo photo2;
  private Photo photo3;
  private Photo photo4;

  private LinkedList<Comment> photo1Comment;
  private LinkedList<Comment> photo2Comment;
  private LinkedList<Comment> photo3Comment;
  private LinkedList<Comment> photo4Comment;

  private LinkedList<Photo> user1photos;
  private LinkedList<Photo> user2photos;

  /**
   * PhotoResource Constructor.
   */
  public PhotosResource() {
    comments = new CommentsResource();

    user1photos = new LinkedList<>();
    user2photos = new LinkedList<>();

    photo1Comment = new LinkedList<>();
    photo2Comment = new LinkedList<>();
    photo3Comment = new LinkedList<>();
    photo4Comment = new LinkedList<>();

    photo1Comment.add(comments.getComment1());
    photo2Comment.add(comments.getComment2());
    photo3Comment.add(comments.getComment3());
    photo4Comment.add(comments.getComment2());

    photo1 = new Photo("1", photo1Comment);
    photo2 = new Photo("2", photo2Comment);
    photo3 = new Photo("2", photo3Comment);

    user1photos.add(photo1);
    user1photos.add(photo2);
    user2photos.add(photo3);

  }

  public LinkedList<Photo> getUser1photos() {
    return user1photos;
  }

  public LinkedList<Photo> getUser2photos() {
    return user2photos;
  }

  /*public Photo addPhoto(String photoID){
    Photo currentPhoto = new Photo(photoID, null);
    photos.add(currentPhoto);
    return currentPhoto;
  }

  public Photo getPhoto(String photoID) {
    Photo retPhoto = null;
    if(photos.contains(photoID)){
      int retPhotoIndex = photos.indexOf(photoID);
      retPhoto = photos.get(retPhotoIndex);
    }
    return retPhoto;
  }*/

  public CommentsResource getComments() {
    return comments;
  }

  public LinkedList<Comment> getPhoto1Comment() {
    return photo1Comment;
  }

  public LinkedList<Comment> getPhoto2Comment() {
    return photo2Comment;
  }
}
