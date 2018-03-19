package rest.resources;

import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.LinkedList;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import rest.models.Admin;
import rest.models.Comment;
import rest.models.Photo;


/**
 * Admin User Resources Class.
 * Holds all Admin user type resources.
 */
@Path("/adminlogin")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

  Gson gson = new Gson();

  private Admin admin1;
  private Admin admin2;
  private Admin currentAdmin;

  private LinkedList adminPhotoDatabase;
  private LinkedList<Admin> adminUsers;
  private PhotosResource photosResource;

  CommentsResource commentsResource;

  /**
   * Admin User Constructor.
   */
  public AdminResource() {
    this.photosResource = new PhotosResource();
    this.commentsResource = new CommentsResource();
    initAdminPhotosDatabase();
    initAdminUsers();
  }

  private void initAdminUsers() {
    initAdmin1();
    initAdmin2();
    this.adminUsers =  new LinkedList<>();
    this.adminUsers.add(admin1);
    this.adminUsers.add(admin2);
  }

  /**
   * Initiates Admin 1.
   */
  private void initAdmin1() {
    this.admin1 =
      new Admin("ad1", "pw1", null, 6,adminPhotoDatabase);
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
   * Admin control: deletes a comments.
   * @param comment comment
   * @return replacement string
   */
  @Path("/delete/{comment}")
  public String deleteComment(@PathParam("comment") String comment) {
    Comment deleteComment = null;
    for (int i = 0; i < commentsResource.commentDatabase.size(); i++) {
      if (commentsResource.commentDatabase.get(i).getComment() == comment) {
        deleteComment = commentsResource.commentDatabase.get(i);
        deleteComment.getComment().replaceAll(deleteComment.getComment(), "Deleted Comment");
      }
    }
    return gson.toJson(deleteComment);
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
  public boolean isAdminValid(@PathParam("adminId") String adminId,
                              @QueryParam("pw") String adminPass) {
    boolean isValidAdmin = false;
    for (int i = 0; i < adminUsers.size(); i++) {
      if (adminUsers.get(i).getUserid() == adminId) {
        this.currentAdmin = adminUsers.get(i);
        System.out.println("Found Admin Name");
        if (adminUsers.get(i).getUserPassword() == adminPass) {
          System.out.println("Admin Login Verified: Welcome " + adminUsers.get(i).getUserid());
          //Log User In
          isValidAdmin = true;
        } else {
          System.out.println("User couldn't be verified at this time");
          isValidAdmin = false;
        }
      }
    }
    return isValidAdmin;
  }



}
