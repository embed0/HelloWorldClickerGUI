import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class GameWindow {
    static Scene window;
    static KeyStrokeListener keyStrokeListener;
    static User user;
    static ArrayList <String> code;
    static ArrayList <String> rootMsg;
    public static String lastLine;
    static int tmp;
    static FileInputStream file;




    public GameWindow() {

        lastLine = new String("");
        user = new User();
        keyStrokeListener = new KeyStrokeListener();

        try {
            file = new FileInputStream("crapCode.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        createGameWindow();
    }

    public static Scene createGameWindow(){

        //Kontrolki
        Label label = new Label("Tu bedzie sie gralo");
        TextArea konsolaTextArea = new TextArea();
        TextArea rootTextArea = new TextArea();
        Button sklepButton = new Button("SKLEP");
        Button achievementsButton = new Button("OSIĄGNIĘCIA");
        Button exitButton = new Button("WYJŚCIE");



        //Ustawienia parametów kontrolek
            konsolaTextArea.setPrefWidth(300);
            konsolaTextArea.setPrefHeight(300);
            konsolaTextArea.setEditable(false);

            rootTextArea.setPrefWidth(300);
            rootTextArea.setPrefHeight(200);
            rootTextArea.setEditable(false);

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
        layout.getChildren().addAll(konsolaTextArea, rootTextArea, label, sklepButton, achievementsButton, exitButton);

        //rozmiar okna
        window = new Scene(layout, 600, 500);


        //Nasluchiwanie klikania
        //  Wczytanie kodu juz napisanego do konsoli
        code = user.getUserCode();

        for (String line : code)
        {
            konsolaTextArea.appendText("\n" + line);
        }
        konsolaTextArea.appendText("\n" + lastLine);

        rootMsg = user.getRootMessages();
        for( String line : rootMsg)
        {
            rootTextArea.appendText("\n" + line);
        }



        //  Czytanie i dodawanie nowego kodu

        StringBuilder s = new StringBuilder(GameWindow.lastLine);
        konsolaTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    tmp = file.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (tmp != -1) {
                    if (tmp == 10) {
                        GameWindow.user.addCode(GameWindow.lastLine);
                        lastLine = "";
                        s.setLength(0);
                    } else {
                        GameWindow.lastLine = s.append((char) tmp).toString();
                        GameWindow.user.addBug();
                    }
                    konsolaTextArea.appendText(((char) tmp) + "");

                }
                else {
                    try {
                        file.reset();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
