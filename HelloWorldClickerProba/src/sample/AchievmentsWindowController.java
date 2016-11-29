package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ag on 29.11.16.
 */
public class AchievmentsWindowController implements Initializable {

    @FXML
    private Button powrot;
    @FXML
    private Button exitButton;

    @FXML
    private ImageView puchar;

    int page;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        powrot.setOnAction(actionEvent -> backToGame());
        exitButton.setOnAction(actionEvent -> Main.stage.close());
        page = 0;
//        puchar.setImage(new Image("puchar.png"));


        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> osiagnieciaList = new ListView<>(items);
        for (int i = 0; i < Controller.achievments.size(); i++)
        {
            osiagnieciaList.getItems().add(i, Controller.achievments.get(i));
        }

        osiagnieciaList.setItems(items);
    }

    public void backToGame() {
        Main.stage.setScene(Controller.gameScene);
        Main.stage.show();
    }
}
