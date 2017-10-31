package com.company;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    static ArrayList<Long> results = new ArrayList<>();
    static List<Rectangle> rectangles = new ArrayList<>();
    static List<Point> points = new ArrayList<>();
    static List<Integer> values = new ArrayList<>();

    public static Random r = new Random();

    static Rectangle rect;

    public static void rendl(long n)
    {
            removeAndCheck(n, n);
    }

    public static void main(String[] args) {
        //readInput("level1-4.in");
        for(int i = 0; i < 400; i++)
        {
            rendl(337424981);
        }
        for(long s : results)
        {
            System.out.println(s);
        }
    }
    static long temp = 1;
    public static void removeAndCheck(long number, long start)
    {
        if(number < 10)
        {
            if (isPrime(number)) {
                if(results.contains(temp))
                {
                    removeAndCheck(number, start);
                }
                else
                {
                    results.add(temp);
                    finish(number);
                    return;
                }


            }
        }
        String sn;
        int index;
        long n2 = 1;
        try {
    sn = String.valueOf(number);
    index = r.nextInt(sn.length());
    StringBuilder sb = new StringBuilder(sn);
    sb.deleteCharAt(index);
    n2 = Long.parseLong(sb.toString());
} catch (StackOverflowError e)
{

}
        if(isPrime(n2))
        {
            temp = n2;
            removeAndCheck(n2, start);
        }
        else
        {
            removeAndCheck(number, start);
        }
        return;
    }

    static void finish(long nu)
    {
        System.out.println("FERTIG: " + nu + " C: " + results.size());
    }

    public static boolean isPrime(int n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=(int)n/2;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static boolean isPrime(long n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=(int)n/2;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }






    public static void readInput(String path)
    {
        StringBuilder text = new StringBuilder();

        try {
            FileReader reader = new FileReader(path);
            BufferedReader breader = new BufferedReader(reader);

            String temp;

            while((temp = breader.readLine()) != null)
            {
                text.append(temp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] lines = text.toString().split("\n");
        {
            String[] values = lines[0].split("\\,");
            String[] xvalues = values[0].split("\\.");
            String[] yvalues = values[1].split("\\.");
            String[] x2values = values[2].split("\\.");
            String[] y2values = values[3].split("\\.");

            if(xvalues[1].length() == 3)
            {
                xvalues[1] += "0";
            }
            if(yvalues[1].length() == 3)
            {
                yvalues[1] += "0";
            }
            if(x2values[1].length() == 3)
            {
                x2values[1] += "0";
            }
            if(y2values[1].length() == 3)
            {
                y2values[1] += "0";
            }

            int x2 = Integer.parseInt(xvalues[0] + xvalues[1]);
            int y2 = Integer.parseInt(yvalues[0] + yvalues[1]);
            int x = Integer.parseInt(x2values[0] + x2values[1]);
            int y = Integer.parseInt(y2values[0] + y2values[1]);

            System.out.println(x + ", " + y + ", " + x2 + ", " + y2 + ", ");
            rect = new Rectangle(x, y, Math.abs(x - x2), Math.abs(y - y2));
        }

        {
            int numberpoints = Integer.parseInt(lines[1]);



            for(int i = 0; i < numberpoints; i++)
            {
                values.add(0);
                String[] values = lines[2 + i].split("\\,");
                String[] xvalues = values[0].split("\\.");
                String[] yvalues = values[1].split("\\.");

                if(xvalues[1].length() == 3)
                {
                    xvalues[1] += "0";
                }
                if(yvalues[1].length() == 3)
                {
                    yvalues[1] += "0";
                }

                int x = Integer.parseInt(xvalues[0] + xvalues[1]);
                int y = Integer.parseInt(yvalues[0] + yvalues[1]);

                points.add(new Point(x, y));
            }
        }

        int pointsInRect = 0;

        for(int i = 0; i < points.size(); i++)
        {
            System.out.println("=================");
            System.out.println("Rect: x: " + rect.getX() + ", y: " + rect.getY() + ", width: " + rect.getWidth() + ", height: " + rect.getHeight());
            System.out.println("Point: x: " + points.get(i).getX() + ", y: " + points.get(i).getY());

            if(rect.contains(points.get(i)))
            {
                System.out.println("True");
                pointsInRect++;
            }
            else
            {
                System.out.println("False");
            }
        }
        System.out.println(pointsInRect);

    }
}