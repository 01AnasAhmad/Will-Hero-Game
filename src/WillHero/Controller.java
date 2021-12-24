package WillHero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    private Button startGame ;
    @FXML
    private Label labelText;
    @FXML
    private Button nameSubmit;
    @FXML
    private TextField userName;
    @FXML
    private Button exitButton;

    public void ButtonHandler(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page2.fxml")));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public void NameButtonSubmitted(ActionEvent e) throws IOException{
        labelText.setText("     Hello ! "+userName.getText()+"\n\n"+"... STARTING A NEW GAME ...");
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game1.fxml")));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    @FXML
    public void ExitApplication(ActionEvent e) throws IOException{
        System.out.println("Exiting the Application");
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

}
// #FFC0CB for pink
