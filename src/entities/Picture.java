package entities;

import interfaces.HasBrightness;

public class Picture extends MultimediaElement implements HasBrightness {
    private int brightness;

    public Picture(String name) {
        super(name);
        this.brightness = 5;
    }

    public int getBrightness() {
        return brightness;
    }

    private void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public void brightnessUp() {
        int currentBrightness = this.getBrightness();
        if (currentBrightness < 10) {
            this.setBrightness(currentBrightness + 1);
        } else {
            throw new IllegalArgumentException("Brightness is already at maximum value");
        }
    }

    @Override
    public void brightnessDown() {
        int currentBrightness = this.getBrightness();
        if (currentBrightness > 0) {
            this.setBrightness(currentBrightness - 1);
        } else {
            throw new IllegalArgumentException("Brightness is already at minimum value");
        }
    }

    @Override
    public String toString() {
        return "Picture " + name + " {" +
                "brightness=" + brightness +
                ", name='" + name + '\'' +
                '}';
    }

    private String countBrightness() {
        String stars = "";
        for (int i = 0; i < this.brightness; i++) {
            stars = stars + "*";
        }
        return stars;
    }

    public void show() {
        String stars = countBrightness();
        String result = this.name + " " + stars;
        System.out.println(result);
    }
}
