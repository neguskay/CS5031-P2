package rest.resources;

import com.google.gson.Gson;
import rest.models.Comment;
import rest.models.Reply;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.LinkedList;
@Path("/comments")
@Singleton
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource {
  Comment comment1, comment2,comment3, newcomment;
  Gson gson = new Gson();

  LinkedList<Reply> comment1Replies = new LinkedList<>();
  LinkedList<Reply> comment2Replies = new LinkedList<>();

  RepliesResource replies = new RepliesResource();
  public CommentsResource(){

    comment1Replies.add(replies.getReply1());
    comment1Replies.add(replies.getReply3());
    comment2Replies.add(replies.getReply2());

    comment1 = new Comment("comm 1", comment1Replies, new Timestamp(System.currentTimeMillis()), 4,1);
    comment2 = new Comment("comm 2", comment1Replies, new Timestamp(System.currentTimeMillis()), 10,13);
    comment3 = new Comment("comm 3", comment1Replies, new Timestamp(System.currentTimeMillis()), 5,17);
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

  @POST
  @Path("postnewcomment/")
  public String postNewComment(@QueryParam("comment") String comment, String x){
    System.out.println(x);
    gson.toJson("in post new comment");
    newcomment = new Comment(comment, null,new Timestamp(System.currentTimeMillis()),0, 0);
    System.out.println("New Comment Added: "+ newcomment.toString());
    return gson.toJson(newcomment);
  }
  @POST
  @Path("{commentid}/replytocomment/")
  public String replyToComment(@PathParam("commentid")String commentid){
    Object returnObject  = new Object();
    System.out.println(commentid);
    switch (commentid.toLowerCase()){
      case "1": comment1Replies.add(new Reply("new REply", new Timestamp(System.currentTimeMillis()), 0,0));
        return gson.toJson(comment1Replies);
      case "2": comment2Replies.add(new Reply("new REply", new Timestamp(System.currentTimeMillis()), 0,0));
        return gson.toJson(comment2Replies);
      default: returnObject = "NO Comment: "+ commentid+ "Reply=new Reply= was not posted";
        return gson.toJson(returnObject);
    }

  }
  @POST
  public void tryThis(){
    gson.toJson("Test Comments");
  }

}

