package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ShopWindowController implements Initializable {
    @FXML
    Button powrot;

    @FXML
    Label bugsLabel;
    @FXML
    Label nazwaItemu;
    @FXML
    Label posiadanaIlosc;
    @FXML
    Label przyrostBugow;
    @FXML
    Label cena;

    @FXML
    ImageView ikonaItemu;

    @FXML
    Button kupButton;
    @FXML
    Button prevPageButton;
    @FXML
    Button nextPageButton;

    private Scene window;
    private List<Item> items;
    private int actualPage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        powrot.setOnAction(actionEvent -> backToGame());
        //klikniecie w przycisku KUP
        kupButton.setOnAction(e -> {
            items.get(actualPage).addItem();
            Controller.user.setItemCount(1);
            Controller.user.minusBugs(items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch()-1));
            Controller.user.setBugsPerSecond(items.get(actualPage).getBugsGrowth());
            currentItemUpdate();
        });

        //następna i porzednia strona
        prevPageButton.setOnAction(e -> {
            actualPage--;
            currentItemUpdate();
        });

        nextPageButton.setOnAction(e -> {
            actualPage++;
            currentItemUpdate();
        });


        Items i = new Items();
        items = i.getItems();
        actualPage = 0;

        currentItemUpdate();
    }

    public void backToGame() {
        Main.stage.setScene(Controller.gameScene);
        Main.stage.show();
    }

    public float cenaUpdate(int color) {

        cena.setText("cena: " + (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch())));
        // 1 to zielona , 0 to czerwona
        if (color == 1) cena.setTextFill(Color.GREEN);
        if (color == 0) cena.setTextFill(Color.RED);

        return (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch()));
    }


    public void currentItemUpdate() {
        bugsLabelUpdate();
        nazwaItemu.setText(items.get(actualPage).getName());
        //System.out.println(items.get(actualPage).getIcon());
        File imageFile = new File("1.png");
        System.out.println(imageFile.getAbsolutePath());
        if (imageFile.exists()) {
            Image image = new Image("file:" + imageFile.getAbsolutePath());
            ikonaItemu.setImage(image);
        }
        //ikonaItemu.setImage("file:/home/ag/Pobrane/HelloWorldClickerProba/src/sample/1.png");
        posiadanaIlosc.setText("posiadana ilość: " + items.get(actualPage).getHowMuch());
        przyrostBugow.setText("przyrost bugów: " + items.get(actualPage).getBugsGrowth());

        if (Controller.user.getBugs() < cenaUpdate(3)) {
            cenaUpdate(0);
            kupButton.setDisable(true);
        } else {
            cenaUpdate(1);
            kupButton.setDisable(false);
        }

        if (actualPage == 0) prevPageButton.setDisable(true);
        else  prevPageButton.setDisable(false);

        if(actualPage < 5) nextPageButton.setDisable(false);
        else  nextPageButton.setDisable(true);

    }

    public void bugsLabelUpdate()
    {
        bugsLabel.setText("Bugs:" + Controller.user.getBugs() + " | Modyfikator Bugów: " + Controller.user.getBugsPerSecond());
    }

}
