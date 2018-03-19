package rest.models;

import java.util.ArrayList;

public class Notification {

  ArrayList<String> notications;

  public Notification(){

  }

  public String getNotication(int notificationIndex) {
    return this.notications.get(notificationIndex);
  }

/*  public void initNotifications() {
    String[] sampleNotes = {"nice photo","ugly light","rip", "dead ting"};
    for(int i=0; i<sampleNotes.length;i++){
      this.notications.add(sampleNotes[i]);
    }
  }*/


}
