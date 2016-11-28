import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class ShopWindow {
    private Scene window;
    private List<Item> items;
    private int actualPage;


    public ShopWindow() {
//        window = new Window("Sklep");
//        window.setSoloWindow(true);
        Items i = new Items();
        items = i.getItems();
        actualPage = 0;
    }

    public Scene createShopWindow() {


    //Kontrolki
        Label label = new Label("Tu bedzie sie kupowało");
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
        layout.getChildren().addAll(label, exitButton, returnButton);

        //rozmiar okna
        window = new Scene(layout, 300, 200);


        return window;
//        window.removeAllComponents();
//        Panel statsPanel = new Panel("", Panel.Orientation.HORISONTAL);
//        Panel bugsPanel = new Panel("bugs");
//        bugsPanel.addComponent(new Label(Float.toString(GameWindow.user.getBugs()), Terminal.Color.MAGENTA));
//        statsPanel.addComponent(bugsPanel);
//        Panel perSecondPanel = new Panel("modyfikator bugów");
//        perSecondPanel.addComponent(new Label("+ " + Double.toString(GameWindow.user.getBugsPerSecond()), Terminal.Color.MAGENTA));
//        statsPanel.addComponent(perSecondPanel);
//        window.addComponent(statsPanel);
//        Panel p = new Panel();
//        p.addComponent(new Label("W sklepie możesz zatrudnić osoby, które pomogą Ci produkować bugi"));
//        window.addComponent(p);
//        Panel row1 = new Panel(items.get(actualPage).getName(), Panel.Orientation.VERTICAL);
//        row1.addComponent(new Label(items.get(actualPage).getIcon(), Terminal.Color.BLUE));
//        row1.addComponent(new Label("posiadana ilość: " + items.get(actualPage).getHowMuch()));
//        row1.addComponent(new Label("przyrost bugów: " + items.get(actualPage).getBugsGrowth()));
//        if (GameWindow.user.getBugs() < (items.get(actualPage).getBasicPrice() * (items.get(actualPage).getHowMuch()+1) +1)){
//            row1.addComponent(new Label("cena: " + (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch())), Terminal.Color.RED));
//            row1.addComponent(new Button("KUP!"));
//        }
//
//        else{
//            row1.addComponent(new Label("cena: " + (items.get(actualPage).getBasicPrice() + (items.get(actualPage).getHowMuch())), Terminal.Color.GREEN));
//        row1.addComponent(new Button("KUP!", new Action() {
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
