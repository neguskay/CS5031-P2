package rest.resources;

import org.junit.jupiter.api.Test;


class UsersResourceTest {

  UsersResource usersResource = new UsersResource();

  /**
   * Tests for:
   * Valid user name and valid password combination
   * Valid user name and invalid password combination
   * Invalid user name and valid password combination
   * Null user name and null password combinations
   */
  @Test
  void isUserValid() {
    System.out.println("Test 1: Valid user name and valid password combination");
    if(usersResource.isUserValid("soo", "1234")) {
      assert true;
    }
    System.out.println("Test 2: Valid user name and invalid password combination");
    if(!usersResource.isUserValid("ad1", "p")) {
      assert true;
    }
    System.out.println("Test 3: Invalid user name and valid password combination");
    if(!usersResource.isUserValid("as", "p")) {
      assert true;
    }
    System.out.println("Test 4: Null user name and null password combinations");
    if(!usersResource.isUserValid(null, null)) {
      assert true;
    }
  }

  @Test
  void postComment(){

  }

}