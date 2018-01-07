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
import org.opencv.core.Core;
import org.opencv.imgproc.Imgproc;
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
    
    public Image loadImage(String pName){
        URL url_img = getClass().getResource(pName);
        String ruta = url_img.getPath();
        Image imagenMostrar = null;
        Mat imagen, imagen2;
         if (ruta.startsWith("/")) {
            ruta = ruta.substring(1);
        }
        ///System.out.println(ruta);
        imagen = Imgcodecs.imread(ruta);
        imagen2 = Imgcodecs.imread(ruta);
        Imgproc.cvtColor(imagen2,  imagen, Imgproc.COLOR_RGB2GRAY);
        //System.out.println(imagen);
        if(!imagen.empty()){
            imagenMostrar = convertir(imagen);
        }else{
            System.out.println("error al cargar la imagen");
        }
        return imagenMostrar;
    }
    

    private Image convertir(Mat imagen) {
        MatOfByte byteMat = new MatOfByte();
        Imgcodecs.imencode(".bmp", imagen, byteMat);
        return new Image(new ByteArrayInputStream(byteMat.toArray()));
    }
    
}
    

