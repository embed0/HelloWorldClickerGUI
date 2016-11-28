import com.googlecode.lanterna.gui.Interactable;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.input.Key;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class KeyStrokeListener implements WindowListener {
    FileInputStream file;
    StringBuilder buffAdmin, buffDupa, buffKck;
    String admin, dupa, kck;
    Boolean adm, du, k;
    int tmp;
    public KeyStrokeListener(){

        try {
            file = new FileInputStream("crapCode.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        buffKck = new StringBuilder();
        buffDupa = new StringBuilder();
        buffAdmin = new StringBuilder();
        admin="admin";
        dupa="dupa";
        kck="kckrzadzi";
        adm= false; du=false; k=false;
    }
    @Override
    public void onWindowInvalidated(Window window) {

    }

    @Override
    public void onWindowShown(Window window) {

    }

    @Override
    public void onWindowClosed(Window window) {
    }

    @Override
    public void onUnhandledKeyboardInteraction(Window window, Key key) {
        StringBuilder s = new StringBuilder(GameWindow.lastLine);

        //TODO porównać bufor z listą sekretnych słów
        if(key.getKind().equals(Key.Kind.NormalKey)) {
            try {
                tmp = file.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tmp != -1) {
                if (tmp == 10) {
                    GameWindow.user.addCode(GameWindow.lastLine);
                    GameWindow.lastLine = new String("");
                } else {
                    GameWindow.lastLine = s.append((char) tmp).toString();
                    GameWindow.user.addBug();
                }
                //View.guiScreen.showWindow(GameWindow.createGameWindow(), GUIScreen.Position.FULL_SCREEN);
            }
            else {
                try {
                    file.reset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onFocusChanged(Window window, Interactable interactable, Interactable interactable1) {

    }
}
