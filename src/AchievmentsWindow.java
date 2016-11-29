import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AchievmentsWindow {
    private Scene window;
    ArrayList<String> achievments;
    int page;
    public AchievmentsWindow() {
        page = 0;
    }

    public Scene createAchievmentsWindow() {
        ImageView puchar = new ImageView();
        puchar.setImage(new Image("puchar.png"));


    //Kontrolki
        Label label = new Label("Zdobyte osiągnięcia. Gratuluję!");
        Button returnButton = new Button("POWRÓT");
        Button exitButton = new Button("WYJŚCIE");

        achievments = GameWindow.user.getAchievmentsList();
        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> osiagnieciaList = new ListView<>(items);
        for (int i = 0; i < achievments.size(); i++)
        {
            osiagnieciaList.getItems().add(i, achievments.get(i));
        }

        osiagnieciaList.setItems(items);

    //Akcje przycisków
        //zamykanie okna gry
        exitButton.setOnAction(e -> View.exitGame());

        //powrot do okna gry
        returnButton.setOnAction(e -> View.startGame());

    //Layout
        //tworzenie layoutu
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        //dodanie kontrolek do layoutu
        layout.getChildren().addAll(puchar, label, osiagnieciaList, exitButton, returnButton);

        //rozmiar okna
        window = new Scene(layout, 300, 500);



        return window;
    }

}
