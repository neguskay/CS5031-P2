package rest.models;

import java.util.LinkedList;

/**
 * Admin Class definition.
 * Model package of the RESTful API.
 */
public class Admin extends User {
  private String adminId;
  private String adminPass;
  private LinkedList photoDatabase;
  private LinkedList<Photo> adminPhotos;
  private int clearanceLevel;

  /**
   * Admin class constructed.
   * @param id user ID of an Admin instance.
   * @param pw user password of the Admin instance.
   * @param userPhotos photos of the Admin
   * @param clearanceLevel indicates clearance or privilege level of that admin.
   * @param photoDatabase entire photos of all users combined.
   */
  public Admin(String id, String pw, LinkedList<Photo> userPhotos,
               int clearanceLevel, LinkedList photoDatabase) {
    super(id, pw, userPhotos);
    this.adminId = id;
    this.adminPass = pw;

    this.adminPhotos = userPhotos;
    this.photoDatabase = photoDatabase;
    this.clearanceLevel = clearanceLevel;
  }
}
