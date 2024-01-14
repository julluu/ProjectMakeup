import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class MakeupCollection implements Comparator<Palette>{
    
    List<Palette> collection;

    public MakeupCollection(){
        collection= new ArrayList<Palette>();
    }

    //reading palettes from the file and adding them to the collection
    public void readProductsFromFile(MakeupCollection collection, String fileName){
        try{
            Scanner input = new Scanner(new File(fileName));

            while(input.hasNextLine()){
                String line = input.nextLine();

                String[] parts = line.split(",");

                if(parts.length==4){
                    String paletteName = parts[0];
                    String brandName = parts[1];
                    int numberOfPans = Integer.parseInt(parts[2]);
                    int pansHit = Integer.parseInt(parts[3]);

                    Palette palette = new Palette(paletteName, brandName, numberOfPans, pansHit);
                    collection.addProduct(palette);
                }
                else{
                    System.out.println("Error on line " +line);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Palette palette){
        if(palette != null){
            collection.add(palette);
        }
    }

    public String toString(){
        String info="";
        for(Palette products : collection){
            info += "Palette:  " +products.getName() + " (" 
                                 +products.getBrandName() +"), " 
                                 + products.getPans() + " pans \n" +
          "          Pans hit: " + products.getPansHit() + "/" 
                                 +products.getPans() + " pans, " 
                                 + String.format("%.2f", products.getPanPercentage()) + "%\n";
        }
        return info;
    }

    public void getAllPans(){
        double pans = 0;
        double pansHit = 0;
        for(Palette product : collection){
            pans += product.getPans();
            pansHit += product.getPansHit();
        }
        double percentage = (pansHit/pans)*100;
        System.out.println("Total pans in collection: " + (int)pans);
        System.out.println("Total pans hit: " + (int)pansHit + ", " + String.format("%.2f",percentage) +" %");
    }

    public void sortByPanPercentage(){
        List<Palette> sortedList = new ArrayList<>(collection);
        Collections.sort(sortedList, new Comparator<Palette>() {
            @Override
            public int compare(Palette one, Palette two) {
                return Double.compare(two.getPanPercentage(), one.getPanPercentage());
            }
         });

        System.out.println("Most used palettes: ");
        for(Palette product : sortedList){
            System.out.println("   "+product.getName() + ", " + product.getPansHit() + "/" 
                                    +product.getPans() +", " + String.format("%.2f", product.getPanPercentage())+" %");
        }
    }

    public void randomPalette(){
        Random rndm = new Random();
        Palette randomPalette = collection.get(rndm.nextInt(collection.size()));
        System.out.println("   "+randomPalette.getName() + " (" 
                                + randomPalette.getBrandName()+"), pans: "
                                + randomPalette.getPansHit() + "/" 
                                + randomPalette.getPans()
                                +", "+String.format("%.2f", randomPalette.getPanPercentage()) +" %");
    }

    public void randomShades(int numberOfShades){
        for(int i = 0; i<numberOfShades; i++){
            Random rndm = new Random();
            Palette randomPalette = collection.get(rndm.nextInt(collection.size()));
            int randomShades = ThreadLocalRandom.current().nextInt(1,randomPalette.getPans()+1);
            System.out.println("   Shade number " +randomShades + " from " + randomPalette.getName() + ", "+randomPalette.getBrandName());
        }
    }

    @Override
    public int compare(Palette one, Palette two) {
        return Double.compare(two.getPanPercentage(), one.getPanPercentage());
    }
}
