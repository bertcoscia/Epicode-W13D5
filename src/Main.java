import entities.Audio;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("Never gonna give you up", 3);
        /*System.out.println(audio1);
        audio1.volumeDown();
        System.out.println(audio1);
        audio1.volumeUp();
        System.out.println(audio1);*/
        audio1.play();
    }
}