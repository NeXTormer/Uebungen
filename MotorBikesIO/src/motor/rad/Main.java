package motor.rad;

public class Main {

    public static void main(String[] args) {
        Bike.readFromCSV("tuned_bikes.txt");
        Bike.getBest(2);
        for (Bike bike : Bike.bikes) {
//            System.out.print(bike);
//            System.out.println(" : " + bike.getNormalizedPower());
        }
    }

}
