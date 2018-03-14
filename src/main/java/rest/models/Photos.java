package rest.models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Photos {

  BufferedImage photo;
  String photoID;

  LinkedList<Comments> photoComments;

  public Photos(String photoID, LinkedList<Comments> photoComments){
    this.photoID = photoID;
    this.photo = getImage(photoID);
    this.photoComments = photoComments;

  }


  public String getPhotoID() {
    return photoID;
  }

  public BufferedImage getImage(String photoID){

    int width = 963;    //width of the image
    int height = 640;   //height of the image
    BufferedImage image = null;
    File f = null;

    //read image - Change path name
    try{
      f = new File("D:\\Image\\Taj.jpg"); //image file path
      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image = ImageIO.read(f);

      System.out.println("Reading complete.");
      return image;
    }catch(IOException e){
      System.out.println("Error: "+e);
      return null;
    }
  }

}
