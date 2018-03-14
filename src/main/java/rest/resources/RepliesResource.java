package rest.resources;

import rest.models.Reply;

import java.sql.Timestamp;

public class RepliesResource {

  Reply reply1, reply2,reply3;
  public RepliesResource(){
    this.reply1 = new Reply("trash photo", new Timestamp(System.currentTimeMillis()), 5, 1);
    this.reply2 = new Reply("great photo", new Timestamp(System.currentTimeMillis()), 3, 8);
    this.reply3 = new Reply("pretty photo", new Timestamp(System.currentTimeMillis()), 4, 2);
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
