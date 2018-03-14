package rest.resources;

import rest.models.Comment;
import rest.models.Reply;

import java.sql.Timestamp;
import java.util.LinkedList;

public class CommentsResource {
  Comment comment1, comment2;

  RepliesResource replies = new RepliesResource();
  public CommentsResource(){
    LinkedList<Reply> comment1Replies = new LinkedList<>();
    LinkedList<Reply> comment2Replies = new LinkedList<>();
    comment1Replies.add(replies.getReply1());
    comment1Replies.add(replies.getReply3());
    comment2Replies.add(replies.getReply2());

    comment1 = new Comment("comm 1", comment1Replies, new Timestamp(System.currentTimeMillis()), 4,1);
    comment2 = new Comment("comm 2", comment1Replies, new Timestamp(System.currentTimeMillis()), 10,13);
  }

  public Comment getComment1() {
    return comment1;
  }

  public Comment getComment2() {
    return comment2;
  }
}
