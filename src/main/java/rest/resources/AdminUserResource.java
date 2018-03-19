package rest.resources;

import java.util.LinkedList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
  private Admin currentAdmin;

  private LinkedList adminPhotoDatabase;
  private LinkedList<Admin> adminUsers;
  private PhotosResource photosResource = new PhotosResource();

  /**
   * Admin User Constructor.
   */
  public AdminUserResource() {
    initAdminPhotosDatabase();

    initAdminUsers();


  }

  private void initAdminUsers() {
    initAdmin1();
    initAdmin2();
    this.adminUsers=  new LinkedList<>();
    this.adminUsers.add(admin1);
    this.adminUsers.add(admin2);
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

  /**
   * Authenticates Administrator's login details.
   * @param adminId User name of admin
   * @param adminPass Password of admin
   * @return boolean i.e. T/F is admin's details are correct
   */
  @Path("{adminId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public boolean isAdminValid(@PathParam("adminId") String adminId, @QueryParam("pw") String adminPass) {
    boolean isValidAdmin = false;
    for(int i = 0; i<adminUsers.size(); i++){
      if (adminUsers.get(i).getUserid()==adminId){
        this.currentAdmin = adminUsers.get(i);
        System.out.println("Found Admin Name");
        if (adminUsers.get(i).getUserPassword()==adminPass){
          System.out.println("Admin Login Verified: Welcome " + adminUsers.get(i).getUserid());
          //Log User In
          isValidAdmin = true;
        }
        else {
          System.out.println("User couldn't be verified at this time");
          isValidAdmin = false;
        }
      }
    }
    return isValidAdmin;
  }

}
