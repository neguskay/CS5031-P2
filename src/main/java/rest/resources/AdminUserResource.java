package rest.resources;

import java.util.LinkedList;
import javax.ws.rs.Path;
import rest.models.Admin;
import rest.models.Photo;


/**
 * Admin User Resources Class.
 * Holds all Admin user type resources.
 */
@Path("/adminlogin")
public class AdminUserResource {

  private Admin admin1;
  private Admin admin2;

  private LinkedList adminPhotoDatabase;
  private PhotosResource photosResource = new PhotosResource();

  /**
   * Admin User Constructor.
   */
  public AdminUserResource() {
    initAdminPhotosDatabase();
    initAdmin1();
    initAdmin2();


  }

  /**
   * Initiates Admin 1.
   */
  private void initAdmin1() {
    this.admin1 = new Admin("ad1", "pw1", null, 6,adminPhotoDatabase);
  }

  /**
   * Initiates Admin 1.
   */
  private void initAdmin2() {
    this.admin2 = new Admin("ad2", "pw2", photosResource.getUser1photos(), 2,adminPhotoDatabase);
  }

  /**
   * Initiates Admin Photos Database.
   */
  private void initAdminPhotosDatabase() {
    adminPhotoDatabase = new LinkedList<>();
    adminPhotoDatabase.add(photosResource.getUser1photos());
    adminPhotoDatabase.add(photosResource.getUser2photos());
  }
}
