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

        Label Fahr_Label = new Label("Grad Fahrenheit");
        TextField cels_Text = new TextField();
        TextField Fahr_Text = new TextField();
        Button Fahr_Button = new Button("Convert F -> C");
        Label cels_Label = new Label("Grad Celsius");
        Button cels_Button = new Button("Convert C -> F");

        EventHandler<MouseEvent> handler2 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle (MouseEvent mouseEvent)
            {
                try
                {
                    double fahr = Double.parseDouble(Fahr_Text.getText());
                    double cels = (fahr - 32) / 1.8;
                    cels_Text.setText(""+cels);
                }
                catch (Exception ignored)
                {

                }
            }
        };
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
       Fahr_Button.setOnMouseClicked(handler2);
       cels_Button.setOnMouseClicked(handler);
       vbox.getChildren().addAll(cels_Label, cels_Text, Fahr_Label, Fahr_Text, cels_Button, Fahr_Button);
       Scene scene = new Scene(vbox);
       stage.setTitle("UE-5");
       stage.setScene(scene);
       stage.show();
    }
}
