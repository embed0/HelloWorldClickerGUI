import java.util.ArrayList;

public class User {
    private float bugs;
    private int bugThreshold; //zmienna do osiągnięć, aby nie sprawdzać kilku warunków, tylko jeden
    private ArrayList<String> rootMessages;
    private ArrayList<String> userCode;
    private float countMode;
    private double bugsPerSecond;
    private Achievments achievments;
    public ArrayList<String> achievmentsList;
    private int itemCount, itemThreshold;
    //achievments, items

    public User(){
        bugs = 0;
        itemThreshold = 5;
        countMode = 1;
        bugThreshold = 100;
        itemCount = 0;

        bugsPerSecond = 1;
        achievments = new Achievments();
        achievmentsList = new ArrayList<>();
        rootMessages = new ArrayList<String>();
        rootMessages.add("system@root: Witaj! A więc chcesz zostać programistą?");
        rootMessages.add("system@root: Pomogę Ci... Ale pamiętaj... z tego świata nie ma ucieczki...");
        rootMessages.add("system@root: Poprostu zacznij pisać... Pomogę Ci");
        rootMessages.add("<czujesz jak zawartość dokumenacji Twojego systemu importuje się do Twojej głowy>");
        userCode = new ArrayList<String>();
        userCode.add("public class HelloWorld {");
        userCode.add("    public static void main(String[] args) {");
        userCode.add("        System.out.println(\"Hello, World\");");
        userCode.add("    }");
        userCode.add("}\n");
    }

    public void minusBugs(float a) {
        bugs-=a;
    }

    public void setBugsPerSecond(double a){
        bugsPerSecond+=a;
    }
    public float getBugs(){
        return bugs;
    }

    public ArrayList<String> getRootMessages (){
        return rootMessages;
    }

    public ArrayList<String> getUserCode(){
        return userCode;
    }

    public void addCode(String code){
        if (userCode.size() > 8)
            userCode.remove(0);
        userCode.add(code);
    }

    public void addBug() {
        bugs += bugsPerSecond;
        if (bugs >= bugThreshold) {
            //addMessage("system@root: Brawo! Stworzyles " + bugThreshold + " bugów" + achievments.getAchievments().get("Stworzyles"));
            addMessage("system@root: Brawo! Stworzyles " + bugThreshold + " bugów.");
            achievmentsList.add(bugThreshold + " zrobionych bugow");
            bugThreshold *= 2;
        }
    }

    public void addMessage(String msg){
        rootMessages.add(msg);
    }
    public double getBugsPerSecond () {
        return bugsPerSecond;
    }
    public ArrayList<String> getAchievmentsList(){
        return achievmentsList;
    }

    public void secretWord (String word) {
        achievmentsList.add("Sekretne słowo: " + word);
    }

    public void setItemCount(int a){
        itemCount+=a;
        if (itemCount == itemThreshold){
            addMessage("system@root: Brawo! Kupiłeś " + itemThreshold + " " + achievments.getAchievments().get("Kupiłeś "));
            achievmentsList.add(itemThreshold + " kupinoych przemiotów");
            itemThreshold *= 2;
        }
    }
}
