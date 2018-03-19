package rest.models;

import java.sql.Time;
import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Reply Class.
 */
@XmlRootElement
public class Reply {

  private String reply;

  private Timestamp replyTime;

  int upVotes;
  int downVotes;

  /**
   * Reply class constructor.
   * @param reply reply String of word(s)
   * @param replyTime Time of reply
   * @param upVotes Likes count
   * @param downVotes Dislikes count
   */
  public Reply(String reply, Timestamp replyTime, int upVotes, int downVotes) {
    this.reply = reply;
    this.replyTime = replyTime;
    this.upVotes = upVotes;
    this.downVotes = downVotes;
  }

  public void setReply(String reply) {
    this.reply = reply;
  }

  public String getReply() {
    return reply;
  }
}
