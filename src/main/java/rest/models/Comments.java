package rest.models;

import java.util.ArrayList;

public class Comments {

  ArrayList<String> commentID;
  ArrayList<String> comments;
  ArrayList<String> replyID;
  ArrayList<String> replies;

  public Comments(){
    this.comments = new ArrayList<>();

  }


  public ArrayList<String> getComments(String photoID) {
    return comments;
  }

  public ArrayList<String> getCommentID() {
    return commentID;
  }

  public ArrayList<String> getReplies(String commentID) {
    replies = new ArrayList<>();
    return replies;

  }
}
