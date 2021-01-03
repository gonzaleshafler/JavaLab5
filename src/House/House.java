package House;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class House {

    private  int id;

    private  double apartArea;
    private  int floor;
    private  int countOfRooms;
    private  String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getApartArea() {
        return apartArea;
    }

    public void setApartArea(double apartArea) {
        this.apartArea = apartArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }



    House()
    {

    }
    public House(int id, /*int apartNumber,*/ double apartArea, int floor, int countOfRooms, String street) {
        this.id = id;
//        this.apartNumber = apartNumber;
        this.apartArea = apartArea;
        this.floor = floor;
        this.countOfRooms = countOfRooms;
        this.street = street;
    }


@Override
    public abstract   String toString();
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        House house = (House) object;

        return id == house.id &&
//                apartNumber == house.apartNumber &&
                apartArea == house.apartArea &&
                floor == house.floor &&
                countOfRooms==house.countOfRooms &&
                Objects.equals(street,house.street);

    }

    public void stringToFields(String s)
    {
        Pattern pattern=Pattern.compile("[0-9]+(.[0-9]+)?");
        Matcher matcher= pattern.matcher(s);

        matcher.find();
        setId(Integer.parseInt(matcher.group()));

        matcher.find();
        setApartArea(Double.parseDouble(matcher.group()));

        matcher.find();
        setFloor(Integer.parseInt(matcher.group()));


        matcher.find();
        setCountOfRooms(Integer.parseInt(matcher.group()));

        setStreet(s.substring(s.indexOf("Street=")+7,s.length()-1));
    }

}


