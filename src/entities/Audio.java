package entities;

public class Audio extends MultimediaElement {
    private int volume;
    private int duration;

    public Audio(String name, int duration) {
        super(name);
        this.volume = 5;
        this.setDuration(duration);
    }

    public void volumeDown() {
        int currentVolume = this.getVolume();
        if (currentVolume > 0) {
            this.setVolume(currentVolume - 1);
        } else {
            throw new IllegalArgumentException("Volume is already 0");
        }
    }

    public void volumeUp() {
        int currentVolume = this.getVolume();
        if (currentVolume < 10) {
            this.setVolume(currentVolume + 1);
        } else {
            throw new IllegalArgumentException("Volume is already 10");
        }
    }

    private String countVolume() {
        String exclamations = "";
        for (int i = 0; i < this.volume; i++) {
            exclamations = exclamations + "!";
        }
        return exclamations;
    }

    public void play() {
        String exclamations = countVolume();
        for (int i = 0; i < this.duration; i++) {
            String result;
            result = this.name + exclamations;
            System.out.println(result);
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 10) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException("Choose a value between 0 and 10");
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("Choose a value bigger than 0");
        }
    }

    @Override
    public String toString() {
        return "Audio " + name + " {" +
                "volume=" + volume +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }
}
