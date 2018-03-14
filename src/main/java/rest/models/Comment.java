package rest.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

public class Comment {

  ArrayList<String> commentID;
  ArrayList<String> comments;
  ArrayList<String> replyID;
  ArrayList<String> replies;

  private LinkedList<Reply>commentReplies = new LinkedList<>();

  private String comment;

  private int upVotes,downVotes;

  private Timestamp commentTimestamp;

  public Comment(String photoComment, LinkedList<Reply> commentReplies, Timestamp commentTimestamp, int upVotes, int downVotes){
    this.comment = photoComment;
    this.commentReplies = commentReplies;
    this.commentTimestamp = commentTimestamp;
    this.upVotes = upVotes;
    this.downVotes = downVotes;


  }

  private void initComments() {

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
