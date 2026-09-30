package asaghir1_CMSC203_Lab1;

import java.util.Scanner;

public class MovieDriver {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Movie movie = new Movie();
        String response;

        do {
            System.out.println("Enter the title of a movie:");
            movie.setTitle(keyboard.nextLine());

            System.out.println("Enter the movie's rating:");
            movie.setRating(keyboard.nextLine());

            System.out.println("Enter the number of tickets sold:");
            movie.setSoldTickets(keyboard.nextInt());

            // Remove the newline left after reading the integer.
            keyboard.nextLine();

            System.out.println(movie.toString());

            System.out.println("Do you want to enter another movie? (y/n)");
            response = keyboard.nextLine();

        } while (response.equalsIgnoreCase("y"));

        System.out.println("Goodbye!");
        keyboard.close();
    }
}
