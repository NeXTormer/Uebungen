package motor.rad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 23/11/2016.
 */
public class Bike {

    public static List<Bike> bikes = new ArrayList<>();

    private String type;

    private double power, weight, price;


    public Bike(String type_, double power_, double weight_, double price_) {
        power = power_;
        type = type_;
        weight = weight_;
        price = price_;

    }

    public double getNormalizedPower() {
        return power / weight;
    }

    public double getPower() { return power ; }

    public static void readFromCSV(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            String[] tokens = null;
            while((line = br.readLine()) != null){
                tokens = line.split(":");
                bikes.add(new Bike(tokens[0], Double.valueOf(tokens[1]), Double.valueOf(tokens[2]), Double.valueOf(tokens[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please check the file location!");
        } catch (IOException e) {
            System.out.println("Troubles reading data!");
        }
    }

    public static void getBest(int n) {
        List<Bike> backupCopy = new ArrayList<>(bikes);
        List<Bike> best = new ArrayList<>();
        for(int ni = 0; ni < n; ni++) {
            int bestindex = getBest(backupCopy);
            best.add(bikes.get(bestindex));
            backupCopy.remove(bestindex);
        }

        System.out.println(best.toString());

    }

    public static int getBest(List<Bike> bikeList) {
        int best = 0;
        double bestPower = 0;

        for (int i = 0; i < bikeList.size(); i++) {
            if(bikeList.get(i).getPower() > bestPower) {
                bestPower = bikeList.get(i).getPower();
                best = i;
            }
        }
        return best;
    }

    public static void getBestNormalized(int n) {
        List<Bike> backupCopy = new ArrayList<>(bikes);
        List<Bike> best = new ArrayList<>();
        for(int ni = 0; ni < n; ni++) {
            int bestindex = getBestNormalized(backupCopy);
            best.add(bikes.get(bestindex));
            backupCopy.remove(bestindex);
        }
        System.out.println(best.toString());

    }

    public static int getBestNormalized(List<Bike> bikeList) {
        int best = 0;
        double bestPower = 0;

        for (int i = 0; i < bikeList.size(); i++) {
            if(bikeList.get(i).getNormalizedPower() > bestPower) {
                bestPower = bikeList.get(i).getPower();
                best = i;
            }
        }
        return best;
    }

    public String toString() {
        return "Bike [type = " + type + "]";
    }

}
