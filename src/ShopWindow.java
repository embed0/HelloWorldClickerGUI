import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class ShopWindow {
    private Scene window;
    private List<Item> items;
    private int actualPage;
    Label bugsLabel;
    Label label;
    Label nazwaItemu;
    ImageView ikonaItemu;
    Label posiadanaIlosc;
    Label przyrostBugow;
    Label cena;
    Button kupButton;
    Button prevPageButton;
    Button nextPageButton;

    public ShopWindow() {
        Items i = new Items();
        items = i.getItems();
        actualPage = 0;
        cena = new Label();
        kupButton = new Button("KUP");
        nazwaItemu = new Label();
        ikonaItemu = new ImageView();
        posiadanaIlosc = new Label();
        przyrostBugow = new Label();
        prevPageButton = new Button ("POPRZEDNIE");
        nextPageButton = new Button ("NASTĘPNE");
    }

    public float cenaUpdate(int color) {
        float nowaCena = (items.get(actualPage).getBasicPrice() + items.get(actualPage).getBasicPrice()*(items.get(actualPage).getHowMuch()));
        cena.setText("cena: " + nowaCena);
        // 1 to zielona , 0 to czerwona
        if (color == 1) cena.setTextFill(Color.GREEN);
        if (color == 0) cena.setTextFill(Color.RED);

        return nowaCena;
    }

    public void currentItemUpdate() {
        View.gameWindow.bugsLabelUpdate();
        bugsLabel = GameWindow.bugsLabel;
        label = new Label("W sklepie możesz zatrudnić osoby, które pomogą Ci produkować bugi");
        nazwaItemu.setText(items.get(actualPage).getName());
        ikonaItemu.setImage(new Image(items.get(actualPage).getIcon()));
        posiadanaIlosc.setText("posiadana ilość: " + items.get(actualPage).getHowMuch());
        przyrostBugow.setText("przyrost bugów: " + items.get(actualPage).getBugsGrowth());

        if (GameWindow.user.getBugs() < cenaUpdate(3)) {
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

    public Scene createShopWindow() {

        //Wczytanie obecnego przedmiotu + kontrolki
        currentItemUpdate();

        Button returnButton = new Button("POWRÓT");
        Button exitButton = new Button("WYJŚCIE");

        //Akcje przycisków

            //klikniecie w przycisku KUP
        kupButton.setOnAction(e -> {
            items.get(actualPage).addItem();
            GameWindow.user.setItemCount(1);
            GameWindow.user.minusBugs(items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch()-1));
            GameWindow.user.setBugsPerSecond(items.get(actualPage).getBugsGrowth());
            currentItemUpdate();
            items.get(actualPage).setBasicPrice(items.get(actualPage).getBasicPrice()*2);
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


            //zamykanie okna gry
        exitButton.setOnAction(e -> View.exitGame());

            //powrot do okna gry
        returnButton.setOnAction(e -> View.startGame());

        //Layout
            //tworzenie layoutu
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

            //dodanie kontrolek do layoutu
        layout.getChildren().addAll(
                bugsLabel,
                label,
                nazwaItemu,
                ikonaItemu,
                posiadanaIlosc,
                przyrostBugow,
                cena,
                kupButton,
                prevPageButton,
                nextPageButton,
                returnButton,
                exitButton
        );

            //rozmiar okna
        window = new Scene(layout, 500, 700);


        return window;
    }
}
