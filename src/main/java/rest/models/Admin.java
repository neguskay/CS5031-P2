package rest.models;

import java.util.LinkedList;

public class Admin extends User{
  String adminID, adminPass;
  LinkedList photoDatabase;
  LinkedList<Photo> adminPhotos;
  int level;

  public Admin(String id, String pw, LinkedList<Photo> userPhotos, int clearancelevel, LinkedList photoDatabase) {
    super(id, pw, userPhotos);
    this.adminID = id;
    this.adminID = pw;

    this.adminPhotos = userPhotos;
    this.photoDatabase =photoDatabase;
    this.level = clearancelevel;
  }




}
