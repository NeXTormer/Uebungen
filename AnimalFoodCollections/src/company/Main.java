package company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    static HashMap<String, List<String>> animals = new HashMap<>();

    public static void main(String[] args) {
        read();
        Scanner sc = new Scanner(System.in);

        String animal;
        String food;

        System.out.println("Enter animal with their respective foods, exit with '!'");


        inputloop:
        while(true)
        {
            System.out.println("1. Animal: ");
            animal = sc.nextLine();

            if(animal.equals("!")) break inputloop;

            System.out.println("2. Foods (Seperated using comma ','): ");
            food = sc.nextLine();
            ArrayList<String> foods = new ArrayList<String>(Arrays.asList(food.split(",")));
            if(animals.containsKey(animal))
            {
                for(String singlefood : foods)
                {
                    if(!animals.get(animal).contains(singlefood))
                    {
                        animals.get(animal).add(singlefood);
                    }
                }
            }
            else
            {
                animals.put(animal, foods);
            }
        }

        System.out.println(animals.toString());
        write();

        sc.close();
    }



    public static void write()
    {
        try {
            FileWriter fw = new FileWriter("animals.txt");
            BufferedWriter bw = new BufferedWriter(fw);



            Iterator it = animals.entrySet().iterator();
            while (it.hasNext()) {
                String finalstring = "";
                Map.Entry pair = (Map.Entry)it.next();
                finalstring += pair.getKey();
                for(String s : (ArrayList<String>) pair.getValue())
                {
                    finalstring += ";" + s;
                }

                bw.write(finalstring + "\n");
            }

            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read()
    {
        try {
            String read = new String(Files.readAllBytes(Paths.get("animals.txt")));
            writeToHashMap(read);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToHashMap(String read)
    {
        String[] lines = read.split("\n");

        for(String s : lines)
        {
            String[] values = s.split(";");

            ArrayList<String> temp = new ArrayList<>();

            int c = 0;
            for(String v : values)
            {
                if(c != 0)
                {
                    temp.add(v);
                }
                c = 1;
            }
            animals.put(values[0], temp);
        }
    }
}
