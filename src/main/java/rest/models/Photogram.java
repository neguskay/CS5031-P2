package rest.models;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Random;

/**
 * Photogram Class.
 * Intended to be a stand alone app to be deployed.
 * Useful for debugging.
 * Still under construction.
 */
public class Photogram {
  private static LinkedList<User> users;
  private static LinkedList<Photo> userPhotos;
  private static LinkedList<Comment> photoComments;
  private static LinkedList<Reply> commentReplies;

  public static boolean isUserAuthentic;

  private String currentid;
  private String currentPass;

  private Timestamp ts = new Timestamp(System.currentTimeMillis());

  User currentUser;

  /**
   * Photogram Class Constructor.
   * @param currentid A users ID.
   * @param currentPass The above user's password.
   */
  public Photogram(String currentid,String currentPass) {
    initReplies();
    initComments();
    initPhotos();
    initUsers();

    this.currentid = currentid;
    this.currentPass = currentPass;
    this.currentUser = new User(currentid,currentPass, null);

  }

  /**
   * Initialises the comments list.
   */
  private void initComments() {
    photoComments = new LinkedList<Comment>();
    photoComments.add(new Comment(setPhotoComment(), commentReplies,
        new Timestamp(System.currentTimeMillis()), setUpVotes(), setDownVotes()));
  }

  /**
   * Initialises the replies list.
   */
  private void initReplies() {
    commentReplies = new LinkedList<Reply>();
    commentReplies.add(new Reply(setReply(),
        new Timestamp(System.currentTimeMillis()), setUpVotes(), setDownVotes()));
  }

  /**
   * Initialises the users list.
   */
  private void initUsers() {
    users = new LinkedList<User>();
    users.add(new User("user", "pw123", userPhotos));
  }

  /**
   * Initialises the users list.
   */
  private void initPhotos() {
    userPhotos = new LinkedList<Photo>();
    userPhotos.add(new Photo("1", photoComments));
  }

  private int setUpVotes() {
    return 10;
  }

  private int setDownVotes() {
    return 2;
  }

  private String setReply() {
    String sillyReply = "this is Comment Reply";
    return sillyReply;
  }

  private String setPhotoComment() {
    String sillyComment = "this is a Photo Comment";
    return sillyComment;
  }

  /**
   * Checks for valid user credentials before logging them in.
   * @param userid unique user identity
   * @param pass user's password
   */
  public void authenticateUser(String userid, String pass) {
    currentUser = new User(userid, pass, null);
    isUserAuthentic = false;
    System.out.println("Authenticating User ID and Password");
    if (users.contains(userid)) {
      System.out.println("User ID: Valid");
      /*if(currentUser.isPassAuthentic(pass)){

      }*/
    }
  }

  /**
   * Posts comments.
   * @param comment The comment message.
   */
  public void postComment(String comment) {
    //LinkedList<Comments> currentPhotoComments = new LinkedList<Comments>();
    photoComments.add(new Comment(setPhotoComment(), null,
        new Timestamp(System.currentTimeMillis()), setUpVotes(), setDownVotes()));
  }

  public void retreiveComments() {
    //get request will suffice
  }

  public void retreiveReplies() {
    //get request will suffice
  }

  public void incrementUpVote() {
      //increment vote
  }

  public void incrementDownVote() {
    //increment vote

  }
}
