package rest.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Comment Class.
 *
 */
public class Comment {

  ArrayList<String> commentid;
  ArrayList<String> comments;
  ArrayList<String> replyid;
  ArrayList<String> replies;

  private LinkedList<Reply> commentReplies = new LinkedList<>();

  private String comment;

  private int upVotes;
  private int downVotes;

  private Timestamp commentTimestamp;

  /**
   * Comment Class constructor.
   * @param photoComment Comment being posted
   * @param commentReplies Replies associated with the above comments
   * @param commentTimestamp Time at which comment was posted
   * @param upVotes Likes count for comment
   * @param downVotes Dislikes count for comment
   */
  public Comment(String photoComment, LinkedList<Reply> commentReplies,
                 Timestamp commentTimestamp, int upVotes, int downVotes) {
    this.comment = photoComment;
    this.commentReplies = commentReplies;
    this.commentTimestamp = commentTimestamp;
    this.upVotes = upVotes;
    this.downVotes = downVotes;


  }

  /**
   * Method which returns an Array List of type String containing all comments.
   * @param photoid Name of photo
   * @return List of comments
   */
  public ArrayList<String> getComments(String photoid) {
    return comments;
  }

  /**
   * Parses comment ID returns List of replies.
   * @return List of replies with associated comment
   */
  public LinkedList<Reply> getReplies() {
    return this.commentReplies;
  }

  public Reply addReplies(String reply, Timestamp timestamp,int upvotes, int downVotes) {
    return new Reply(reply, timestamp, upVotes, downVotes);
  }

  public String getComment() {
    return comment;
  }
}
