import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {

    static Stage stage;
    static GameWindow gameWindow;
    static StartWindow startWindow;
    static AchievmentsWindow achievmentsWindow;
    static ShopWindow shopWindow;
    Button startButton, exitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {}

    public View(Stage primaryStage){
        stage = primaryStage;
        primaryStage.setTitle("HelloWorldClicker");

    //Tworzenie okien
        gameWindow = new GameWindow();
        shopWindow = new ShopWindow();
        achievmentsWindow = new AchievmentsWindow();


    //Kontrolki
        Label label = new Label("Tu będzie logo");
        startButton = new Button("START");
        exitButton = new Button("EXIT");

    //Akcje przycisków
        //wyswietlenie okna gry
            startButton.setOnAction( e ->  startGame());

        //zamykanie okna gry
            exitButton.setOnAction(e -> exitGame());


    //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(label, startButton, exitButton);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();


//
//        gameWindow = new GameWindow();
//        achievmentsWindow = new AchievmentsWindow();
//        shopWindow = new ShopWindow();
//        guiScreen.getScreen().startScreen();
//        guiScreen.showWindow(startWindow.getWindow(), GUIScreen.Position.FULL_SCREEN);
    }

    public static void startGame(){
        stage.setScene( gameWindow.createGameWindow());
//        guiScreen.getScreen().clear();
//        guiScreen.getScreen().completeRefresh();
//        guiScreen.getScreen().refresh();
//        guiScreen.getActiveWindow().removeAllComponents();
//        guiScreen.getActiveWindow().close();
//        guiScreen.showWindow(gameWindow.createGameWindow(), GUIScreen.Position.FULL_SCREEN);
    }
    public static void exitGame(){
        stage.close();
//        gameWindow.closeWindow();
//        startWindow.closeWindow();
//        achievmentsWindow.closeWindow();
//        guiScreen.getScreen().stopScreen();
    }

    public static void achievmentsView(){
        stage.setScene( achievmentsWindow.createAchievmentsWindow());
//        guiScreen.showWindow(achievmentsWindow.createAchievmentsWindow(), GUIScreen.Position.FULL_SCREEN);
    }

    public static void shopView(){
        stage.setScene( shopWindow.createShopWindow());
//        guiScreen.showWindow(shopWindow.createShopWindow(), GUIScreen.Position.FULL_SCREEN);
    }
}
