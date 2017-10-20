package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Felix on 15-Mar-17.
 */
public class ReadInput
{
    String[] split;


    public ReadInput(String path)
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

        split = text.toString().split("\n");
    }


    public String getValue(int line, int index)
    {
        String[] values = split[line].split("\\s");
        return values[index];
    }

    public String getValue(int line, String value)
    {
        String[] values = split[line].split("\\s");
        for(int i = 0; i < values.length; i++)
        {
            String[] o = values[i].split("=");
            for(int j = 0; j < o.length; j++)
            {
                if(o[j].equals(value))
                {
                    return o[j + 1];
                }
            }
        }
        return "rendl";
    }





}
