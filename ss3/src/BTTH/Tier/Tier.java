package BTTH.Tier;

public class Tier {

    protected String name;

    public Tier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}