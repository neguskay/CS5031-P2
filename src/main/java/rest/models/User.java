package rest.models;

import java.util.LinkedList;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * User Class.
 */
@XmlRootElement
public class User {

  private String userid;
  private String userPassword;
  private LinkedList<Photo> userPhotos;

  /**
   * User Class Constructor.
   * @param id User ID
   * @param pw User's password
   * @param userPhotos User's photos on account
   */
  public User(String id, String pw, LinkedList<Photo> userPhotos) {
    this.userid = id;
    this.userPassword = pw;
    this.userPhotos = userPhotos;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public LinkedList<Photo> getUserPhotos() {
    return userPhotos;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public void setUserPhotos(LinkedList<Photo> userPhotos) {
    this.userPhotos = userPhotos;
  }

}
