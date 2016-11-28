import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class GameWindow {
    static Scene window;
    static KeyStrokeListener keyStrokeListener;
    static User user;
    static ArrayList <String> code;
    static ArrayList <String> rootMsg;
    public static String lastLine;
    static int C = 1;
    public GameWindow() {

        lastLine = new String("");
        user = new User();
        keyStrokeListener = new KeyStrokeListener();


        createGameWindow();
    }

    public static Scene createGameWindow(){

        //Kontrolki
        Label label = new Label("Tu bedzie sie gralo");
        TextArea konsolaTextField = new TextArea( );
        Button sklepButton = new Button("SKLEP");
        Button achievementsButton = new Button("OSIĄGNIĘCIA");
        Button exitButton = new Button("WYJŚCIE");

        //Ustawienia parametów kontrolek
        konsolaTextField.setPrefWidth(300);
        konsolaTextField.setPrefHeight(500);
        konsolaTextField.setEditable(false);
        //Akcje przycisków
        //zamykanie okna gry
        exitButton.setOnAction(e -> View.exitGame());

        //wejscie do sklepu
        sklepButton.setOnAction(e -> View.shopView());

        //wejście do achievementów
        achievementsButton.setOnAction(e -> View.achievmentsView());



        //Layout
        //tworzenie layoutu
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        //dodanie kontrolek do layoutu
        layout.getChildren().addAll(konsolaTextField, label, sklepButton, achievementsButton, exitButton);

        //rozmiar okna
        window = new Scene(layout, 500, 300);

        //Nasluchiwanie klikania
        konsolaTextField.setText("dupa");

        window.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                konsolaTextField.appendText(Integer.toString(C) + "\n");
                C++;
            }
        });


        return window;


//        stage.removeAllComponents();
//        stage = null;
//        stage = new Window("");
//        stage.setSoloWindow(true);
//        stage.setWindowSizeOverride(new TerminalSize(100,100));
//        stage.addWindowListener(keyStrokeListener);

//        Panel statsPanel = new Panel("", Panel.Orientation.HORISONTAL);
//        Panel bugsPanel = new Panel("bugs");
//        bugsPanel.addComponent(new Label(Float.toString(user.getBugs()), Terminal.Color.MAGENTA));
//        statsPanel.addComponent(bugsPanel);
//        Panel perSecondPanel = new Panel("modyfikator bugów");
//        perSecondPanel.addComponent(new Label("+ " + Double.toString(user.getBugsPerSecond()), Terminal.Color.MAGENTA));
//        statsPanel.addComponent(perSecondPanel);
//        stage.addComponent(statsPanel);
//
//        code = user.getUserCode();
//
//        Panel userConsolePanel = new Panel("konsola", Panel.Orientation.VERTICAL);
//        userConsolePanel.addComponent(new Label("THE BEST IDE EVER", Terminal.Color.BLUE));
//        userConsolePanel.addComponent(new Label("--------------------------------------------------------------------------------", Terminal.Color.BLUE));
//
//        //czytanie kodu z pliku i aktualizowanie przy kliknieciu
//
//        for(int i = 0; i < code.size(); i++)
//            userConsolePanel.addComponent(new Label(code.get(i)));
//        userConsolePanel.addComponent(new Label(lastLine));
//        stage.addComponent(userConsolePanel);
//
//        Panel rootConsolePanel = new Panel("System output", Panel.Orientation.VERTICAL);
//        rootMsg = user.getRootMessages();
//        for (int i = 0; i < rootMsg.size(); i++)
//            rootConsolePanel.addComponent(new Label(rootMsg.get(i), Terminal.Color.RED));
//        stage.addComponent(rootConsolePanel);
//
//        Panel optionsPanel = new Panel("opcje", Panel.Orientation.HORISONTAL);
//
//        optionsPanel.addComponent(new Button("sklep", new Action() {
//            @Override
//            public void doAction() {
//                View.shopView();
//            }
//        }));
//        optionsPanel.addComponent(new Button("osiągnięcia", new Action() {
//            @Override
//            public void doAction() {
//                View.achievmentsView();
//            }
//        }));
//        optionsPanel.addComponent(new Button("zakończ", new Action() {
//            @Override
//            public void doAction() {
//                stage.close();
//                View.startWindow.closeWindow();
//                View.exitGame();
//            }
//        }));
//        stage.addComponent(optionsPanel);
    }
}
