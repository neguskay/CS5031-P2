package rest.resources;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentsResourceTest {
  CommentsResource commentsResource = new CommentsResource();
  @Test
  void postNewComment() {

  }

  @Test
  void replyToComment() {
    String reply = "reply test";
    //Test valid commentindex and valid reply
    assertEquals(commentsResource.replyToComment(1, "reply test"), reply);
    //Test valid commentindex and null reply
    assertNotEquals(commentsResource.replyToComment(8, null), reply);
    //Test out of bounds index and valid reply
    assertNotEquals(commentsResource.replyToComment(8, "reply test"), reply);
    //Test out of bounds negative index and valid reply
    assertNotEquals(commentsResource.replyToComment(-1, "reply test"), reply);
  }

}