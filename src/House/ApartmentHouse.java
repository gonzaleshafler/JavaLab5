package House;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApartmentHouse extends House {

    public  ApartmentHouse()
    {

    }

    public ApartmentHouse(int id,double apartArea, int floor, int countOfRooms, String street) {
        setId(id);
        setApartArea(apartArea);
        setFloor(floor);
        setCountOfRooms(countOfRooms);
        setStreet(street);
    }
    @Override
    public  String toString()
    {
        return "Apartment House{"+"id="+getId()
                + ", Appartament area="+getApartArea()
                +", Floor number="+getFloor()
                +", Count of rooms="+getCountOfRooms()
                +", Street="+getStreet()+"}\n";
    }

}
