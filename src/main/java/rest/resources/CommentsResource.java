package rest.resources;

import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.LinkedList;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import rest.models.Comment;
import rest.models.Reply;

/**
 * Comments Resource Class.
 */
@Path("/comments")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource {
  Comment comment1;
  Comment comment2;
  Comment comment3;
  Comment newcomment;

  int commentNotifications = 0;

  Gson gson = new Gson();

  LinkedList<Reply> comment1Replies = new LinkedList<>();
  LinkedList<Reply> comment2Replies = new LinkedList<>();
  LinkedList<Comment> commentDatabase;

  RepliesResource replies = new RepliesResource();

  /**
   * Comments Resource Class Constructor.
   */
  public CommentsResource() {
    initComments();
  }

  private void initComments() {

    comment1Replies.add(replies.getReply1());
    comment1Replies.add(replies.getReply3());
    comment2Replies.add(replies.getReply2());

    comment1 = new Comment("comm 1", comment1Replies,
      new Timestamp(System.currentTimeMillis()), 4,1);
    comment2 = new Comment("comm 2", comment1Replies,
      new Timestamp(System.currentTimeMillis()), 10,13);
    comment3 = new Comment("comm 3", comment1Replies,
      new Timestamp(System.currentTimeMillis()), 5,17);

    this.commentDatabase = new LinkedList<>();
    this.commentDatabase.add(comment1);
    commentNotifications += 1;
    this.commentDatabase.add(comment2);
    commentNotifications += 1;
    this.commentDatabase.add(comment3);
    commentNotifications += 1;

  }

  public Comment getComment1() {
    return comment1;
  }

  public Comment getComment2() {
    return comment2;
  }

  public Comment getComment3() {
    return comment3;
  }

  /**
   * Posts and adds new comments.
   * @param comment a comment
   * @return newly posted comment 'as test'
   */
  @POST
  @Path("postnewcomment/")
  public String postNewComment(@QueryParam("comment") String comment) {
    System.out.println(comment);
    gson.toJson("in post new comment");
    newcomment = new Comment(comment, null,new Timestamp(System.currentTimeMillis()),0, 0);
    System.out.println("New Comment Added: " + newcomment.toString());
    return gson.toJson(newcomment);
  }

  /**
   * Posts a reply to a comment.
   * @param commentindex Comment being replied to.
   * @return
   */
  @POST
  @Path("/replytocomment")
  public String replyToComment(@HeaderParam("{commentindex},{reply}")
                                   int commentindex, String reply) {
    Object returnObject  = new Object();
    //System.out.println(commentindex + "lol" + reply);
    if ((0 <= commentindex) && (commentindex < commentDatabase.size())) {
      commentDatabase.get(commentindex).getReplies().add(new Reply(reply,
          new Timestamp(System.currentTimeMillis()), 0, 0));
      replies.replyNotifications += 1;
    } else {
      System.out.println("Comment " + commentindex + " does not exits");
    }
    System.out.println(commentDatabase.get(commentindex).getReplies().getLast().getReply());
    //return gson.toJson(commentDatabase.get(commentindex).getReplies());
    return commentDatabase.get(commentindex).getReplies().getLast().getReply();
  }

  /**
   * Retrieves all the replies of a given comment.
   * @param comment comment being looked up
   * @return list of replies in String form
   */
  @GET
  @Path("{comment}/getreplies")
  public String getCommentReplies(@PathParam("comment") String comment) {
    Comment searchComment;
    LinkedList<Reply> returnReplies = new LinkedList<>();
    for (int i = 0; i < commentDatabase.size(); i++) {
      if (commentDatabase.get(i).getComment() == comment) {
        searchComment = commentDatabase.element();
        returnReplies = searchComment.getReplies();
        if (replies.replyNotifications > 0) {
          replies.replyNotifications -= 1; //Notifications implemention
        }
      } else {
        System.out.println("Could not find replies");
      }
    }
    return gson.toJson(returnReplies);
  }
}

