package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button start, koniec;

    static Scene gameScene;
    static User user;
    static ArrayList<String> code;
    static ArrayList <String> rootMsg;
    public static String lastLine;
    static int tmp, rootmsgsize;
    static FileInputStream file;
    static ArrayList<String> achievments;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lastLine = new String("");
        user = new User();
        try {
            file = new FileInputStream("crapCode.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        code = user.getUserCode();
        achievments = user.getAchievmentsList();

        start.setOnAction(actionEvent -> startGame());
        koniec.setOnAction(actionEvent -> Main.stage.close());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameWindow.fxml"));
            gameScene = new Scene(fxmlLoader.load());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        Main.stage.setScene(gameScene);
        Main.stage.show();
    }
}

