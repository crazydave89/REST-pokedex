package pl.home.pokedex.model;


public class Prev_Evolution {
    private String name;
    private String num;

    public Prev_Evolution() {
    }

    public Prev_Evolution(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
