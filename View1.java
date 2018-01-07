package aip1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class View1 implements Initializable {

    @FXML private ImageView imagen1 = new ImageView();
    @FXML private ImageView imagen2;
    public static ImageView img2CImg1 = new ImageView();
    public static ImageView img2CImg2 = new ImageView();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        AIP1 a = new AIP1();
        Image image = a.loadImage("hw1_atrium.hdr");
        img2CImg1 = imagen1;
        View1.img2CImg1.setImage(image);
        image = a.loadImage("hw1_memorial.hdr");
        img2CImg2 = imagen2;
        View1.img2CImg2.setImage(image);
        
    } 
    
    public static void setItlol(Image image){
        View1.img2CImg1.setImage(image);
        System.out.println("mmmm");
    }
}
