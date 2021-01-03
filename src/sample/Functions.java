package sample;

import House.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Functions {

    int index;
    public House[] objects;

    public  House FindById(House[] house,int id)
    {

        for (int i=0;i<objects.length;i++)
        {
            if (objects[i].getId()==id) {
                return objects[i];
            }
        }
        return null;
    }

    public  House[] StringToFieldsMethod(House[] house,String string)
    {
        String[] strings;
        strings=string.split("\\r?\\n");

        objects= Arrays.copyOf(house,strings.length);

        for (int i=0;i<strings.length;i++)
        {

           if (strings[i].charAt(0)=='A')
           {
               objects[i]=new ApartmentHouse();
               objects[i].stringToFields(strings[i]);
           }
           else
           {
               objects[i]=new PrivateHouse();
               objects[i].stringToFields(strings[i]);
           }
        }
        for (int i=0;i<objects.length;i++)
        {
           house[i]=objects[i];
        }
        return  house;
    }
   public String ReadFile()
    {
        StringBuilder sb=new StringBuilder();
        try(BufferedReader reader= Files.newBufferedReader(Paths.get("a.txt")))
        {
            String line=reader.readLine();

            while (line!=null)
            {

               sb.append(line+"\n");
                line= reader.readLine();

            }
        }
        catch (IOException e)
        {
          sb.append("File don`t exist "+e.getMessage());

        }
        return sb.toString();
    }



    public void WriteFile(Object[] obj)
    {
        try(BufferedWriter writer= Files.newBufferedWriter(Paths.get("a.txt")))
        {
            for (int i=0;i<obj.length;i++)
            {
                if(obj[i]!=null)
                writer.write(obj[i].toString());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error!!! "+e.getMessage());
        }
    }

    public String printA(House[] house, int countOfRooms)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<house.length;i++)
        {
            if (house[i].getCountOfRooms()==countOfRooms)
            {
                stringBuilder.append(house[i]);
            }

        }
        return  stringBuilder.toString();
    }
    public String printB(House[] house,int countOfRooms,int firstPoint,int secondPoint)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<house.length;i++)
        {
            if (house[i].getCountOfRooms()==countOfRooms &&
                    house[i].getFloor()<= secondPoint&&
                    house[i].getFloor()>=firstPoint)
            {
                stringBuilder.append(house[i]);
            }

        }
        return  stringBuilder.toString();
    }
    public String printC(House[]house,double apartArea)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<house.length;i++)
        {
            if (house[i].getApartArea()>apartArea)
            {
                stringBuilder.append(house[i]);

            }
        }
        return  stringBuilder.toString();
    }
    public   House[] fillHouseArray()
    {
        House[] toReturn=new  House[100];
        for (int i=0;i<100;i++)
        {
            toReturn[i]=null;
        }
        return  toReturn;
    }
}
