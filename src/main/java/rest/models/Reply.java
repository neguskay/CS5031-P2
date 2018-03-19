package rest.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Time;
import java.sql.Timestamp;

@XmlRootElement
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
