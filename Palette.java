public class Palette {
    
    private String name;
    private int pans;
    private String brandName;
    private int pansHit;
    private double panPercentage;

    public Palette (String name, String brandName, int pans, int pansHit) {
        this.name = name;
        this.brandName = brandName;
        this.pans = pans;
        this.pansHit = pansHit;
        setPanPercentage();
    }

    public int getPans() {
        return pans;
    }

    public void setPans(int pans) {
        this.pans = pans;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPansHit() {
        return pansHit;
    }

    public void setPansHit(int pansHit) {
        if (pansHit>0){
        this.pansHit = pansHit;
        setPanPercentage();
        }
    }

    private void setPanPercentage() {
        double ph = pansHit;
        double p = pans;
        panPercentage = (ph/p)*100;
    }

    public double getPanPercentage(){
        return panPercentage;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {

        String info = 
            "Palette:  " +getName() + " (" +getBrandName() +"), " + getPans() + " pans \n" +
            "          Pans hit: " + getPansHit() + "/" +getPans() + " pans, " + String.format("%.2f", panPercentage) + "%\n";

        return info;
    }

}
