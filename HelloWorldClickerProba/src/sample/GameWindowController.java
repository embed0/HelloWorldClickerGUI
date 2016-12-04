package sample;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameWindowController implements Initializable {



    public static Scene achievmentsScene, shopScene;

    @FXML
    private Button sklepButton;
    @FXML
    private Button achievementsButton;
    @FXML
    private Button exitButton;

    @FXML
    private TextArea rootTextArea;
    @FXML
    private TextArea konsolaTextArea;

    @FXML
    public Label bugsLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShopWindow.fxml"));
            shopScene = new Scene(fxmlLoader.load());
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AchievmentsWindow.fxml"));
            achievmentsScene = new Scene(fxmlLoader.load());
        } catch(Exception e) {
            e.printStackTrace();
        }


        bugsLabelUpdate();

        //Akcje przycisków
        //zamykanie okna gry
        exitButton.setOnAction(e -> Main.stage.close());

        //wejscie do sklepu
        sklepButton.setOnAction(e -> showShop());

        //wejście do achievementów
        achievementsButton.setOnAction(e -> showAchievments());

        for (String line : Controller.code)
        {
            konsolaTextArea.appendText("\n" + line);
        }
        konsolaTextArea.appendText("\n" + Controller.lastLine);

        Controller.rootMsg = Controller.user.getRootMessages();
        for( String line : Controller.rootMsg)
        {
            rootTextArea.appendText("\n" + line);
        }

        Controller.rootmsgsize = Controller.rootMsg.size();

        StringBuilder s = new StringBuilder(Controller.lastLine);
        konsolaTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    Controller.tmp = Controller.file.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Controller.tmp != -1) {
                    if (Controller.tmp == 10) {
                        Controller.user.addCode(Controller.lastLine);
                        Controller.lastLine = "";
                        konsolaTextArea.clear();
                        for (String line : Controller.user.getUserCode())
                        {
                            konsolaTextArea.appendText("\n" + line);
                        }
                        s.setLength(0);
                    } else {
                        Controller.lastLine = s.append((char) Controller.tmp).toString();
                        Controller.user.addBug();
                    }
                    konsolaTextArea.appendText(((char) Controller.tmp) + "");
                }
                else {
                    try {
                        Controller.file.reset();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // dodawanie nowych powiadomien
                if( User.newMessage)
                {
                    rootTextArea.clear();
                    Controller.rootmsgsize = Controller.user.getRootMessages().size();
                    for(String line : Controller.user.getRootMessages()){
                        rootTextArea.appendText("\n" + line);
                    }
                    User.newMessage = false;
                    //rootTextArea.appendText("\n" + Controller.user.getRootMessages().get(Controller.rootmsgsize - 1));
                }

                // zmiana ilosci bugow
                bugsLabelUpdate();

            }
        });

    }

    public void bugsLabelUpdate()
    {
        bugsLabel.setText("Bugs:" + Controller.user.getBugs() + " | Modyfikator Bugów: " + Controller.user.getBugsPerSecond());
    }

    public void showShop() {
        Main.stage.setScene(shopScene);
        Main.stage.show();
    }

    public void showAchievments () {

        Main.stage.setScene(achievmentsScene);
        Main.stage.show();
        AchievmentsWindowController.setTextAchievments();
    }
}
