package aip1;



import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import org.opencv.core.Core;
import javafx.embed.swing.SwingFXUtils;
/**
 *
 * @author mogue
 */
public class AIP1 extends Application{
    
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public AIP1(){
        
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view1.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public Image loadImage(){
        URL url_img = getClass().getResource("hw1_atrium.hdr");
        String ruta = url_img.getPath();
        Image imagenMostrar = null;
        Mat imagen;
         if (ruta.startsWith("/")) {
            ruta = ruta.substring(1);
        }
         System.out.println(ruta);
        imagen = Imgcodecs.imread(ruta,CV_LOAD_IMAGE_GRAYSCALE);
        System.out.println(imagen);
        if(!imagen.empty()){
            System.out.println("if");
            imagenMostrar = convertir(imagen);
        }else{
            System.out.println("fuck!");
        }
        return imagenMostrar;
    }
    

    private Image convertir(Mat imagen) {
        MatOfByte byteMat = new MatOfByte();
        Imgcodecs.imencode(".bmp", imagen, byteMat);
        return new Image(new ByteArrayInputStream(byteMat.toArray()));
    }
    
}
    

