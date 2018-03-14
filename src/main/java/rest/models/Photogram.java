package rest.models;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Random;

public class Photogram {
  private static LinkedList<Users> users;
  private static LinkedList<Photos> userPhotos;
  private static LinkedList<Comments> photoComments;
  private static LinkedList<Replies> commentReplies;

  public static boolean isUserAuthentic;

  String currentID, currentPass;

  private Timestamp ts = new Timestamp(System.currentTimeMillis());

  Users currentUser;

  public Photogram(String currentID,String currentPass){
    initReplies();
    initComments();
    initPhotos();
    initUsers();

    this.currentID = currentID;
    this.currentPass = currentPass;
    this.currentUser = new Users(currentID,currentPass, null);

  }

  private void initComments() {
    photoComments = new LinkedList<Comments>();
    photoComments.add(new Comments(setPhotoComment(), commentReplies, new Timestamp(System.currentTimeMillis()), setUpVotes(), setDownVotes()));
  }

  private void initReplies() {
    commentReplies = new LinkedList<Replies>();
    commentReplies.add(new Replies(setReply(), new Timestamp(System.currentTimeMillis()), setUpVotes(), setDownVotes()));
  }

  private void initUsers() {
    users = new LinkedList<Users>();
    users.add(new Users("user", "pw123", userPhotos));
  }

  private void initPhotos(){
    userPhotos = new LinkedList<Photos>();
    userPhotos.add(new Photos("1", photoComments));
  }

  private int setUpVotes(){
    return 10;
  }

  private int setDownVotes(){
    return 2;
  }

  private String setReply(){
    String sillyReply = "this is Comment Reply";
    return sillyReply;
  }
  private String setPhotoComment(){
    String sillyComment = "this is a Photo Comment";
    return sillyComment;
  }

  public void authenticateUser(String userID, String pass){
    currentUser = new Users(userID, pass, null);
    isUserAuthentic = false;
    System.out.println("Authenticating User ID and Password");
    if(users.contains(userID)){
      System.out.println("User ID: Valid");
      if(currentUser.isPassAuthentic(pass)){

      }
    }
  }

  public void postComment(){
    //LinkedList<Comments> currentPhotoComments = new LinkedList<Comments>();
    photoComments.add(new Comments(setPhotoComment(), null, new Timestamp(System.currentTimeMillis()), setUpVotes(), setDownVotes()));
  }
  public void retreiveComments(){
    //get request will suffice
  }
  public void retreiveReplies(){
    //get request will suffice
  }

  public void incrementUpVote(){
      //increment vote
  }

  public void incrementDownVote(){
    //increment vote

  }
}
