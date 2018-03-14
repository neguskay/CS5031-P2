package rest.models;


import java.util.LinkedList;

public class Users {
  private String userID,userPassword;
  private LinkedList<Photos> userPhotos;

  public Users(String id, String pw, LinkedList<Photos> userPhotos){
    this.userID = id;
    this.userPassword = getUserPassword();
    this.userPhotos = userPhotos;
  }

  public String getUserPassword() {
    String pass = "1234";
    return pass;
  }

  public String getUserID(){
    return "soo";
  }

  public boolean isPassAuthentic(String userPassword){
    if (this.userPassword==userPassword ){
      return true;

    }else return false;
  }

}
