import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        String trophy = new String("             ___________\n" + "            " +
                                                "'._==_==_=_.'\n" +
                                    "            .-\\:      /-.\n" +
                                    "           | (|:.     |) |\n" +
                                    "            '-|:.     |-'\n" +
                                    "              \\::.    /\n" +
                                    "               '::. .'\n" +
                                    "                 ) (\n" +
                                    "               _.' '._\n" +
                                    "              `\"\"\"\"\"\"\"`\n");

    //Kontrolki
        Label label = new Label(trophy);
        Label label1 = new Label("Tu bedzie sie osiągało ;P");
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
        layout.getChildren().addAll(label, label1, exitButton, returnButton);

        //rozmiar okna
        window = new Scene(layout, 300, 500);



        return window;
//        Table table = new Table(3);
//        Component[] row1 = new Component[3];
//        for (int i = 0; i < row1.length; i++){
//            row1[i] = new Label(trophy, Terminal.Color.YELLOW);
//        }
//        table.addRow(row1);
//        window.addComponent(table);
//
//        Panel p = new Panel();
//        p.addComponent(new Label("Zdobyte osiągnięcia. Gratuluję!", Terminal.Color.MAGENTA));
//        window.addComponent(p);
//
//        Panel achPanel = new Panel("Osiągnięcia");
//        achievments = GameWindow.user.getAchievmentsList();
//        if (achievments.size() < ((page + 1) * 3)){
//            for (int i = page * 3; i < achievments.size(); i++)
//                achPanel.addComponent(new Label(achievments.get(i)));
//        }
//        else {
//            for (int i = page * 3; i < ((page + 1) * 3); i++)
//                achPanel.addComponent(new Label(achievments.get(i)));
//        }
//        window.addComponent(achPanel);
//
//
//        Panel nextPrevPanel = new Panel("", Panel.Orientation.HORISONTAL);
//        if (page > 0){
//            nextPrevPanel.addComponent(new Button("previous", new Action() {
//                @Override
//                public void doAction() {
//                    page --;
//                    createAchievmentsWindow();
//                }
//            }));
//        }
//        if (achievments.size() > ((page + 1) * 3)) {
//            nextPrevPanel.addComponent(new Button("next", new Action() {
//                @Override
//                public void doAction() {
//                    page ++;
//                    createAchievmentsWindow();
//                }
//            }));
//        }
//        if (achievments!= null)
//            window.addComponent(nextPrevPanel);
//
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
//
    }

}
