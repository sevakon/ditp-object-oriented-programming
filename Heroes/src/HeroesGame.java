import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class HeroesGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main/ui/main.fxml"));
        Scene scene = new Scene(root, 800, 600);
//        System.out.println(this.getClass().getResource("main/ui/res/style.css"));
        scene.getStylesheets().addAll(this.getClass().getResource("main/ui/res/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}