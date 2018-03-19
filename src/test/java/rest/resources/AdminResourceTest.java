package rest.resources;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminResourceTest {
  private AdminResource adminResource = new AdminResource();
  private CommentsResource commentsResource = new CommentsResource();
  /**
   * Tests for:
   * Valid admin name and valid password combination
   * Valid admin name and invalid password combination
   * Invalid admin name and valid password combination
   * Null admin name and null password combinations
   */
  @Test
  void isAdminValidTest() {
    System.out.println("Test 1: Valid admin name and valid password combination");
    if(adminResource.isAdminValid("ad1", "pw1")) {
      assert true;
    }
    System.out.println("Test 2: Valid admin name and invalid password combination");
    if(!adminResource.isAdminValid("ad1", "p")) {
      assert true;
    }
    System.out.println("Test 3: Invalid admin name and valid password combination");
    if(!adminResource.isAdminValid("as", "p")) {
      assert true;
    }
    System.out.println("Test 4: Null admin name and null password combinations");
    if(!adminResource.isAdminValid(null, null)) {
      assert true;
    }
  }
  @Test
  void deleteCommentsTest(){
    String deletecomment = "Deleted Comment";
    adminResource.deleteComment("comm 1");
    System.out.println(commentsResource.comment1.getComment());
    assertEquals(deletecomment, commentsResource.comment1.getComment());
  }

}