import java.util.HashMap;

/**
 * Created by ag on 24.10.16.
 */
public class Achievments {
    private HashMap<String, String> achievments = new HashMap<String, String>();

    public Achievments() {
        achievments.put("Stworzyles ", "bugów w swoim kodzie");
        achievments.put("Odkryłeś sekretne słowo: ", " ");
        achievments.put("Kupiłeś ", "przemiotów");
    }

    public HashMap<String, String> getAchievments() {
        return achievments;
    }
}
