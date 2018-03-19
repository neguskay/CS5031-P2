package rest.resources;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.models.Reply;

/**
 * RepliesResource class which holds all replies resources.
 */
@Path("/replies")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepliesResource {

  Reply reply1;
  Reply reply2;
  Reply reply3;

  int replyNotifications = 0;

  /**
   * RepliesResource class constructor.
   */
  public RepliesResource() {
    this.reply1 = new Reply("trash photo", new Timestamp(System.currentTimeMillis()), 5, 1);
    replyNotifications += 1;
    this.reply2 = new Reply("great photo", new Timestamp(System.currentTimeMillis()), 3, 8);
    replyNotifications += 1;
    this.reply3 = new Reply("pretty photo", new Timestamp(System.currentTimeMillis()), 4, 2);
    replyNotifications += 1;
  }

  public Reply getReply1() {
    return reply1;
  }

  public Reply getReply2() {
    return reply2;
  }

  public Reply getReply3() {
    return reply3;
  }
}
