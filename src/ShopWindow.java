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


    public ShopWindow() {
        Items i = new Items();
        items = i.getItems();
        actualPage = 0;
    }

    public Scene createShopWindow() {


    //Kontrolki
        Label bugsLabel = GameWindow.bugsLabel;
        Label label = new Label("W sklepie możesz zatrudnić osoby, które pomogą Ci produkować bugi");
        Label nazwaItemu = new Label(items.get(actualPage).getName());
        Label ikonaItemu = new Label(items.get(actualPage).getIcon());
        Label posiadanaIlosc = new Label("posiadana ilość: " + items.get(actualPage).getHowMuch());
        Label przyrostBugow = new Label("przyrost bugów: " + items.get(actualPage).getBugsGrowth());
        Label cena = new Label("cena: " + (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch())));
        Button kupButton = new Button("KUP");


        if (GameWindow.user.getBugs() < (items.get(actualPage).getBasicPrice() * (items.get(actualPage).getHowMuch()+1) +1))
        {
            cena.setTextFill(Color.RED);
            kupButton.setDisable(true);
        }
        else
        {
            cena.setTextFill(Color.GREEN);
            kupButton.setDisable(false);
            kupButton.setOnAction(e -> {
                        items.get(actualPage).addItem();
                        GameWindow.user.setItemCount(1);
                        GameWindow.user.minusBugs(items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch()-1));
                        GameWindow.user.setBugsPerSecond(items.get(actualPage).getBugsGrowth());
                        View.gameWindow.bugsLabelUpdate();
            });
        }



        Button returnButton = new Button("POWRÓT");
        Button exitButton = new Button("WYJŚCIE");

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
        layout.getChildren().addAll(
                bugsLabel,
                label,
                nazwaItemu,
                ikonaItemu,
                posiadanaIlosc,
                przyrostBugow,
                cena,
                kupButton,
                returnButton,
                exitButton
        );

        //rozmiar okna
        window = new Scene(layout, 500, 500);


        return window;

//

//     //
//        else{
//            row1.addComponent(new Label("cena: " + (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch())), Terminal.Color.GREEN));
//            row1.addComponent(new Button("KUP!", new Action() {
//                    @Override
//                    public void doAction() {
//                        items.get(actualPage).addItem();
//                        GameWindow.user.setItemCount(1);
//                        GameWindow.user.minusBugs(items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch()-1));
//                        GameWindow.user.setBugsPerSecond(items.get(actualPage).getBugsGrowth());
//                        createShopWindow();
//                    }
//                }));}
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

    }

}
