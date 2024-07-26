package entities;

import interfaces.Playble;

public class Audio extends MultimediaElement implements Playble {
    private int volume;
    private int length;

    public Audio(String name, int length) {
        super(name);
        this.volume = 5;
        this.setLength(length);
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

    private String countVolume() {
        String exclamations = "";
        for (int i = 0; i < this.volume; i++) {
            exclamations = exclamations + "!";
        }
        return exclamations;
    }

    @Override
    public void play() {
        String exclamations = countVolume();
        for (int i = 0; i < this.length; i++) {
            String result;
            result = this.name + " " + exclamations;
            System.out.println(result);
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 10) {
            this.volume = volume;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Choose a value bigger than 0");
        }
    }

    @Override
    public String toString() {
        return "Audio " + name + " {" +
                "volume=" + volume +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }
}
