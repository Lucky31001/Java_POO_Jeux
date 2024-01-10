package Models.Objects;

public abstract class Objects {

    private String name;
    private int weight;

    public Objects(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
