import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Label ikonaItemu;
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
        ikonaItemu = new Label();
        posiadanaIlosc = new Label();
        przyrostBugow = new Label();
        prevPageButton = new Button ("POPRZEDNIE");
        nextPageButton = new Button ("NASTĘPNE");
    }

    public void cenaUpdate(int color) {
        cena.setText("cena: " + (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch())));
        // 1 to zielona , 0 to czerwona
        if (color == 1)
            cena.setTextFill(Color.GREEN);
        else cena.setTextFill(Color.RED);
    }

    public void currentItemUpdate() {
        View.gameWindow.bugsLabelUpdate();
        bugsLabel = GameWindow.bugsLabel;
        label = new Label("W sklepie możesz zatrudnić osoby, które pomogą Ci produkować bugi");
        nazwaItemu.setText(items.get(actualPage).getName());
        ikonaItemu.setText(items.get(actualPage).getIcon());
        posiadanaIlosc.setText("posiadana ilość: " + items.get(actualPage).getHowMuch());
        przyrostBugow.setText("przyrost bugów: " + items.get(actualPage).getBugsGrowth());
        if (GameWindow.user.getBugs() < (items.get(actualPage).getBasicPrice() * (items.get(actualPage).getHowMuch() + 1) )) {
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
        window = new Scene(layout, 500, 500);


        return window;
    }
}

//        window.addComponent(row1);
//        Panel nxtPrvPanel = new Panel("", Panel.Orientation.HORISONTAL);
//        if (actualPage > 0){
//            nxtPrvPanel.addComponent(new Button("poprzednie", new Action() {
//                @Override
//                public void doAction() {
//                    actualPage--;
//                    createShopWindow();
//                }
//            }));
//        }
//        if(actualPage < 5) {
//            nxtPrvPanel.addComponent(new Button("następne", new Action() {
//                @Override
//                public void doAction() {
//                    actualPage++;
//                    createShopWindow();
//                }
//            }));
//        }
//        window.addComponent(nxtPrvPanel);
//        Panel panel = new Panel("", Panel.Orientation.HORISONTAL);
//        panel.addComponent(new Button("powrót", new Action() {
//            @Override
//            public void doAction() {
//                View.startGame();
//            }
//        }));
//        panel.addComponent(new Button("zakończ grę", new Action() {
//            @Override
//            public void doAction() {
//                //View.exitGame();
//            }
//        }));
//        window.addComponent(panel);

