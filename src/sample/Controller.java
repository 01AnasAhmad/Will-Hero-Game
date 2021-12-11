package sample;

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
    public void ButtonHandler(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page2.fxml")));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private Label labelText;
    @FXML
    private Button nameSubmit;
    @FXML
    private TextField userName;
    public void NameButtonSubmitted(ActionEvent e) throws IOException{
        labelText.setText("     Hello ! "+userName.getText()+"\n\n"+"... STARTING A NEW GAME ...");
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page3.fxml")));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    @FXML
    private Button exitButton;
    public void ExitApplication(ActionEvent e) throws IOException{

    }

}
