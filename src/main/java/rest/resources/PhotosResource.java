package rest.resources;

import rest.models.Comment;
import rest.models.Photo;

import java.util.LinkedList;

public class PhotosResource {
  CommentsResource comments = new CommentsResource();
  Photo photo1, photo2;
  LinkedList<Comment> photo1Comment, photo2Comment;
  LinkedList<Photo> photos = new LinkedList<>();
  public PhotosResource(){
    photo1Comment = new LinkedList<>();
    photo2Comment = new LinkedList<>();

    photo1Comment.add(comments.getComment1());
    photo2Comment.add(comments.getComment2());

    photo1 = new Photo("1", photo1Comment);
    photo2 = new Photo("2", photo2Comment);

    photos.add(photo1);
    photos.add(photo2);

  }

  public Photo getPhoto2() {
    return photo2;
  }

  public Photo getPhoto1() {
    return photo1;
  }

  public Photo addPhoto(String photoID){
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
  }

  public LinkedList<Photo> getPhotos() {
    return photos;
  }

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
