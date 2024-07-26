package entities;

public abstract class MultimediaElement {
    String name;

    public MultimediaElement(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MultimediaElement{" +
                "name='" + name + '\'' +
                '}';
    }
}
