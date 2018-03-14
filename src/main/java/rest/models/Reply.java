package rest.models;

import java.sql.Time;
import java.sql.Timestamp;

public class Reply {
  String reply;

  Timestamp replyTime;

  int upVotes, downVotes;

  public Reply(String reply, Timestamp replyTime, int upVotes, int downVotes){
    this.reply = reply;
    this.replyTime = replyTime;
    this.upVotes = upVotes;
    this.downVotes = downVotes;
  }
}
