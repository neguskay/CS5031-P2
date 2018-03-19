package rest.resources;

import org.junit.jupiter.api.Test;
import rest.models.Comment;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

class PhotosResourceTest {
  PhotosResource photosResource = new PhotosResource();

  @Test
  void postCommentTest() {
    System.out.println(photosResource.getPhotoDatabase().toString());
    //Test for valid comments and valid photo
    photosResource.postComment("1", "not too shabby");
    assertEquals(photosResource.getPhoto1Comment().get(1).getComment(),"not too shabby");
    //Test for valid photo and null comment
    photosResource.postComment("1", null);
    assertEquals(photosResource.getPhoto1Comment().get(1).getComment(),"not too shabby");
    //Test for null photo and null comment
    photosResource.postComment(null, null);
    assertEquals(photosResource.getPhoto1Comment().get(1).getComment(),"not too shabby");
    //Test of invalid(non-existent photoid)
    photosResource.postComment("20", "lol");
    assertEquals(photosResource.getPhoto1Comment().get(1).getComment(),"not too shabby");

  }

}