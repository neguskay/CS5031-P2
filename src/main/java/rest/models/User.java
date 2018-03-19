package rest.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;

@XmlRootElement
public class User {

  private String userID,userPassword;
  private LinkedList<Photo> userPhotos;

  public User(String id, String pw, LinkedList<Photo> userPhotos){
      this.userID = id;
      this.userPassword = pw;
      this.userPhotos = userPhotos;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public LinkedList<Photo> getUserPhotos() {
    return userPhotos;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public void setUserPhotos(LinkedList<Photo> userPhotos) {
    this.userPhotos = userPhotos;
  }

}
