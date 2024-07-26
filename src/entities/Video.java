package entities;

import interfaces.HasBrightness;
import interfaces.Playble;

public class Video extends MultimediaElement implements Playble, HasBrightness {
    private int volume;
    private int length;
    private int brightness;

    public Video(String name, int length) {
        super(name);
        this.volume = 5;
        this.setLength(length);
        this.brightness = 5;
    }

    public int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        if (volume >= 0 && volume <= 10) {
            this.volume = volume;
        }
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Choose a value bigger than 0");
        }
    }

    public int getBrightness() {
        return brightness;
    }

    private void setBrightness(int brightness) {
        if (brightness > 0) {
            this.brightness = brightness;
        }
    }

    @Override
    public void volumeDown() {
        int currentVolume = this.getVolume();
        if (currentVolume > 0) {
            this.setVolume(currentVolume - 1);
        } else {
            throw new IllegalArgumentException("Volume is already at minimum value");
        }
    }

    @Override
    public void volumeUp() {
        int currentVolume = this.getVolume();
        if (currentVolume < 10) {
            this.setVolume(currentVolume + 1);
        } else {
            throw new IllegalArgumentException("Volume is already at maximum value");
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
    public void brightnessUp() {
        int currentBrightness = this.getBrightness();
        if (currentBrightness < 10) {
            this.setBrightness(currentBrightness + 1);
        } else {
            throw new IllegalArgumentException("Brightness is already at maximum value");
        }
    }

    @Override
    public String toString() {
        return "Video " + name + " {" +
                "volume=" + volume +
                ", length=" + length +
                ", brightness=" + brightness +
                ", name='" + name + '\'' +
                '}';
    }

    private String countVolume() {
        String exclamations = "";
        for (int i = 0; i < this.volume; i++) {
            exclamations = exclamations + "!";
        }
        return exclamations;
    }

    private String countBrightness() {
        String stars = "";
        for (int i = 0; i < this.brightness; i++) {
            stars = stars + "*";
        }
        return stars;
    }

    @Override
    public void play() {
        String exclamations = countVolume();
        String stars = countBrightness();
        for (int i = 0; i < this.length; i++) {
            String result;
            result = this.name + " " + exclamations + " " + stars;
            System.out.println(result);
        }
    }
}
