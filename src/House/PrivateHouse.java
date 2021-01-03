package House;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrivateHouse extends  House{


    public PrivateHouse(int id, double apartArea, int floor, int countOfRooms, String street) {
        setId(id);
        setApartArea(apartArea);
        setFloor(floor);
        setCountOfRooms(countOfRooms);
        setStreet(street);
    }
    public  PrivateHouse()
    {

    }

    @Override
    public  String toString()
    {
        return "Private House{"+"id="+getId()
                +", Appartament area="+getApartArea()
                +", Floor count="+getFloor()
                +", Count of rooms="+getCountOfRooms()
                +", Street="+getStreet()+"}\n";
    }

}
