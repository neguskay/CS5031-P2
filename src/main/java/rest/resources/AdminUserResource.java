package rest.resources;

import rest.models.Admin;
import rest.models.Photo;

import java.util.LinkedList;

public class AdminUserResource{

  Admin admin1, admin2;

  LinkedList adminPhotoDatabase;
  PhotosResource photosResource = new PhotosResource();

  public AdminUserResource(){
    initAdminPhotosDatabase();
    initAdmin1();
    initAdmin2();


  }

  public void initAdmin1(){
    this.admin1 = new Admin("ad1", "pw1", null, 6,adminPhotoDatabase);
  }
  public void initAdmin2(){
    this.admin2 = new Admin("ad2", "pw2", photosResource.getUser1photos(), 2,adminPhotoDatabase);
  }
  public void initAdminPhotosDatabase(){
    adminPhotoDatabase = new LinkedList<>();
    adminPhotoDatabase.add(photosResource.getUser1photos());
    adminPhotoDatabase.add(photosResource.getUser2photos());
  }
}
