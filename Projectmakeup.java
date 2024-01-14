import java.util.Scanner;

public class Projectmakeup {
    public static void main(String[]args) {

    MakeupCollection palettes = new MakeupCollection();
    //reading palettes from the file and adding them to the collection
    palettes.readProductsFromFile(palettes, "palettes.txt");

    System.out.println("Welcome!");
    System.out.println("What do you want to do today?");

    Scanner scanner = new Scanner(System.in);

    while(true){
    System.out.println();
    System.out.println("1: Check the list of palettes");
    System.out.println("2: Sort palettes by panning percentage");
    System.out.println("3: Get random palette");
    System.out.println("4: Get random shades");
    System.out.println("5: Exit");
    String option =scanner.next();

    switch (option) {
        case "1":
            System.out.println(palettes);
            break;
        case "2":
            palettes.sortByPanPercentage();
            System.out.println();
            palettes.getAllPans();
            System.out.println();
            break;
        case "3":
            System.out.println("Random palette of the day: ");
            palettes.randomPalette();
            System.out.println();
            break;
        case "4":
            System.out.println("How many shades do you want to pick? (max 10)");
            int shades = scanner.nextInt();
            if(shades<=10){
            System.out.println("Random eyeshadow shades of the day: ");
            palettes.randomShades(shades);
            System.out.println();
            }
            else{
                System.out.println("Please choose maximum of 10 shades");
            }
            break;
        case "5":
            System.out.println("See you again soon!");
            scanner.close();
            System.exit(0);
        default:
            System.out.println("Invalid input, please try again");
            break;
        }
    }
    }
}