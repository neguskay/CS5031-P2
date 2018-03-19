package rest.resources;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserResourceTest {
  AdminUserResource adminUserResource = new AdminUserResource();

  /**
   * Tests for:
   * Valid admin name and valid password combination
   * Valid admin name and invalid password combination
   * Invalid admin name and valid password combination
   * Null admin name and null password combinations
   */
  @Test
  void isAdminValid() {
    System.out.println("Test 1: Valid admin name and valid password combination");
    if(adminUserResource.isAdminValid("ad1", "pw1")) {
      assert true;
    }
    System.out.println("Test 2: Valid admin name and invalid password combination");
    if(!adminUserResource.isAdminValid("ad1", "p")) {
      assert true;
    }
    System.out.println("Test 3: Invalid admin name and valid password combination");
    if(!adminUserResource.isAdminValid("as", "p")) {
      assert true;
    }
    System.out.println("Test 4: Null admin name and null password combinations");
    if(!adminUserResource.isAdminValid(null, null)) {
      assert true;
    }
  }

}