package rest.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;

/**
 * Photo Class.
 */
public class Photo {

  BufferedImage photo;

  String photoid;

  LinkedList<Comment> photoComments;

  /**
   * Constructor of the Photo Class.
   * @param photoid Unique photo identity
   * @param photoComments list of comments posted on this photo.
   */
  public Photo(String photoid, LinkedList<Comment> photoComments) {
    this.photoid = photoid;
    this.photo = getImage(photoid);
    this.photoComments = photoComments;

  }

  public String getPhotoId() {
    return photoid;
  }

  /**
   * Gets a particular image.
   * @param photoid Unique id of the photo
   * @return a Buffered Image
   */
  public BufferedImage getImage(String photoid) {
    //Add code to choose particular image
    int width = 963;    //width of the image
    int height = 640;   //height of the image
    BufferedImage image = null;
    File f = null;

    //read image - Change path name
    try {
      //Create file Object with the given file path string
      f = new File("/cs/home/soo3/IdeaProjects/CS5031/P2/restful/src/"
        + "main/java/rest/resources/photos/1.jpeg");
      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image = ImageIO.read(f);

      System.out.println("Reading complete.");
      return image;
    } catch (IOException e) {
      System.out.println("Error: " + e);
      return null;
    }
  }

}
