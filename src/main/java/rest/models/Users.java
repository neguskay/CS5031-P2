package rest.models;


public class Users {
  String userID,userPassword;

  public Users(){
    this.userID = getUserID();
    this.userPassword = getUserPassword();
  }

  public String getUserPassword() {
    String pass = "1234";
    return pass;
  }

  public String getUserID(){

    return "soo";
  }

}
