import entities.Audio;
import entities.MultimediaElement;
import entities.Picture;
import entities.Video;
import interfaces.Playble;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MultimediaElement[] arr = new MultimediaElement[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Type what kind of multimedia element you want to create: audio, video, picture");
            String chosenMedia = scanner.nextLine().toLowerCase();
            if (!chosenMedia.equals("audio") && !chosenMedia.equals("video") && !chosenMedia.equals("picture")) {
                System.out.println("You must chose one between audio, video, picture");
                i--; // se l'utente scrive qualcosa che non sia uno dei tre tipi decremento i in modo tale che non si salti un giro nella costruzione dell'array
            } else {
                System.out.println("Type the name of your file");
                String name = scanner.nextLine();
                switch (chosenMedia) {
                    case "audio":
                        System.out.println("Type the length of your audio file, it must be a number greater than 0");
                        int lengthAudio = Integer.parseInt(scanner.nextLine());
                        Audio audio = new Audio(name, lengthAudio);
                        arr[i] = audio;
                        break;
                    case "video":
                        System.out.println("Type the length of your video file, it must be a number greater than 0");
                        int lengthVideo = Integer.parseInt(scanner.nextLine());
                        Video video = new Video(name, lengthVideo);
                        arr[i] = video;
                        break;
                    case "picture":
                        Picture picture = new Picture(name);
                        arr[i] = picture;
                        break;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        int input;
        do {
            System.out.println("Which element do you want to run? 1, 2, 3, 4, 5? Enter 0 to exit");
            input = Integer.parseInt(scanner.nextLine());
            if (input >= 1 && input <= 5) {
                MultimediaElement chosenElement = arr[input - 1];
                if (chosenElement instanceof Audio || chosenElement instanceof Video) {
                    ((Playble) chosenElement).play();
                } else {
                    ((Picture) chosenElement).show();
                }
            } else if (input != 0) {
                System.out.println("Choice not valid. Insert a number between 1, 2, 3, 4, 5. Enter 0 to exit");
            }
        }
        while (input != 0);
    }
}

/*Ho deciso di mettere i setter privati in modo tale che l'unica possibilità di modificare brightness e volume sia quella
 * di utilizzare i vari metodi Up e Down*/