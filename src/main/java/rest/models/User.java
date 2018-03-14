package rest.models;

import java.util.LinkedList;

public class User {

  private String userID,userPassword;
  private LinkedList<Photo> userPhotos;

  public User(String id, String pw, LinkedList<Photo> userPhotos){
      this.userID = id;
      this.userPassword = pw;
      this.userPhotos = userPhotos;
  }

}
