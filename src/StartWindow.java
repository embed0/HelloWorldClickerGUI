import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class StartWindow {
    private Window window;

    public StartWindow (){
        window = new Window("");
        window.setSoloWindow(true);
        window.setWindowSizeOverride(new TerminalSize(100,50));
        String[] hello = new String[20];
        hello[0] = "*****************************************************************************************************************";
        hello[1] = " __   __  _______  ___      ___      _______    _     _  _______  ______    ___      ______  \n";
        hello[2] = "|  | |  ||       ||   |    |   |    |       |  | | _ | ||       ||    _ |  |   |    |      | \n\n";
        hello[3] = "|  |_|  ||    ___||   |    |   |    |   _   |  | || || ||   _   ||   | ||  |   |    |  _    |\n\n";
        hello[4] = "|       ||   |___ |   |    |   |    |  | |  |  |       ||  | |  ||   |_||_ |   |    | | |   |\n\n";
        hello[5] = "|       ||    ___||   |___ |   |___ |  |_|  |  |       ||  |_|  ||    __  ||   |___ | |_|   |\n\n";
        hello[6] = "|   _   ||   |___ |       ||       ||       |  |   _   ||       ||   |  | ||       ||       |\n\n";
        hello[7] = "|__| |__||_______||_______||_______||_______|  |__| |__||_______||___|  |_||_______||______| \n";
        hello[8] = "                           ____ ____ ____ ____ ____ ____ ____ \n\n";
        hello[9] = "                          ||c |||l |||i |||c |||k |||e |||r ||\n\n";
        hello[10] = "                          ||__|||__|||__|||__|||__|||__|||__||\n\n";
        hello[11] = "                          |/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|\n";
        hello[12] = "";
        hello[13] = "*****************************************************************************************************************";
        hello[14] = "";
        hello[15] = "";
        hello[18] = "";
        hello[19] = "";
        hello[16] = "                      Graj, aby zostać królem internetu i zdobyć";
        hello[17] = "                       więcej punktów niż Twoi koledzy z forum!";
        for (int i = 0; i < hello.length; i++)
            window.addComponent(new Label(hello[i], Terminal.Color.BLUE, true));
       window.addComponent(new Button("start", new Action() {
            @Override
            public void doAction() {
                // nowa gra
                View.startGame();
            }
        }));

        window.addComponent(new Button("exit", new Action() {
            @Override
            public void doAction() {
                //koniec gry
                //View.exitGame();
            }
        }));
    }
    public Window getWindow (){
        return window;
    }
    public void closeWindow() {
        window.close();
    }

}
