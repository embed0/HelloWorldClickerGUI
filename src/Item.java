
public class Item {
    private String name;
    private long basicPrice;
    private long bugsGrowth;
    private String icon;
    private int howMuch;

    public Item(String _name, Long _basicPrice, Long _bugsGrowth, String _icon)
    {
        this.name = _name;
        this.basicPrice = _basicPrice;
        this.bugsGrowth = _bugsGrowth;
        this.icon = _icon;
        this.howMuch = 0;
    }

    public void addItem(){
        howMuch++;
    }
    public int getHowMuch(){
        return howMuch;
    }
    public void setName(String name) { this.name = name; }

    public void setBasicPrice(long basicPrice) {
        this.basicPrice = basicPrice;
    }

    public void setBugsGrowth(long bugsGrowth) {
        this.bugsGrowth = bugsGrowth;
    }

    public void setIcon(String icon) {this.icon = icon; }


    public String getName() {
        return name;
    }

    public long getBasicPrice() {
        return basicPrice;
    }

    public long getBugsGrowth() {
        return bugsGrowth;
    }

    public String getIcon() {
        return icon;
    }
}
