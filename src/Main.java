import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    @Override
    public void start (Stage stage)
    {
        VBox vbox = new VBox();

        Label cels_Label = new Label("Grad Celsius");
        TextField cels_Text = new TextField();
        TextField Fahr_Text = new TextField();
        Button cels_Button = new Button("Convert C -> F");

        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                 try
                 {
                    double cels = Double.parseDouble(cels_Text.getText());
                    double fahr = cels * 1.8 + 32;
                    Fahr_Text.setText("" + fahr);
                 }
                 catch (Exception ignored)
                 {

                 }
            }
        };

       cels_Button.setOnMouseClicked(handler);
       vbox.getChildren().addAll(cels_Label, cels_Text, Fahr_Text, cels_Button);
       Scene scene = new Scene(vbox);
       stage.setTitle("UE-5");
       stage.setScene(scene);
       stage.show();
    }
}
