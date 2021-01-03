package sample;
import House.*;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import java.rmi.server.ExportException;


public class Controller {


    @FXML private TextArea textArea;
    @FXML private TextField idTextField;
    @FXML private TextField areaTextField;
    @FXML private TextField floorTextField;
    @FXML private TextField countOfRoomsTextField;
    @FXML private TextField streetTextField;


    @FXML private TextField infCountOfRooms;
    @FXML private TextField infFirstPoint;
    @FXML private TextField infLastPoint;
    @FXML private TextField infArea;

    Functions prog=new Functions();
    House[] houses=new House[100];
    Alert a=new Alert(Alert.AlertType.ERROR);


    public void refreshClick(ActionEvent event)
    {
        try
        {
            textArea.setText(prog.ReadFile());
            String temp=prog.ReadFile();
            houses=prog.fillHouseArray();
            houses=prog.StringToFieldsMethod(houses,temp);
            prog.index=prog.objects.length;
        }
        catch (IllegalStateException exception)
        {
            a.setContentText("Error\n"+exception.getMessage());
            a.show();
        }
    }

    public  void createButton(ActionEvent event)
    {


        houses=prog.fillHouseArray();
        prog.WriteFile(houses);
        textArea.setText(prog.ReadFile());

    }

    public void privateHouseButton(ActionEvent event)
    {


        try {

            int id=Integer.parseInt(idTextField.getText());

                double area=Double.parseDouble(areaTextField.getText());
                int floor=Integer.parseInt(floorTextField.getText());
                int countOfRooms=Integer.parseInt(countOfRoomsTextField.getText());
                houses[prog.index]=new PrivateHouse(id,area,floor,countOfRooms,streetTextField.getText());
                prog.WriteFile(houses);
                prog.index++;
                refreshClick(event);
        }
        catch (NumberFormatException exception)
        {

            a.setContentText("Input Error\nValues entered incorrectly! Try to enter only numbers.");
            a.show();
            return;
        }

        textArea.setText(prog.ReadFile());
    }
    public void appartHouseButton(ActionEvent event)
    {
        Alert a=new Alert(Alert.AlertType.ERROR);

        try {
            int id=Integer.parseInt(idTextField.getText());
                double area=Double.parseDouble(areaTextField.getText());
                int floor=Integer.parseInt(floorTextField.getText());
                int countOfRooms=Integer.parseInt(countOfRoomsTextField.getText());
                houses[prog.index]=new ApartmentHouse(id,area,floor,countOfRooms,streetTextField.getText());
                prog.index++;
                prog.WriteFile(houses);
            refreshClick(event);

        }
        catch (NumberFormatException exception)
        {

            a.setContentText("Error!\n"+exception.getMessage());
            a.show();
            return;
        }
        textArea.setText(prog.ReadFile());
    }

    public  void getInfoById(ActionEvent event)
    {
        try {
            int id=Integer.parseInt(idTextField.getText());
            House temp= prog.FindById(houses,id);
            double apartArea=temp.getApartArea();
            areaTextField.setText(""+apartArea);
            int floor=temp.getFloor();
            floorTextField.setText(""+floor);
            int countOfRooms=temp.getCountOfRooms();
            countOfRoomsTextField.setText(""+countOfRooms);
            streetTextField.setText(temp.getStreet());
            textArea.setText(temp.toString());
            }
        catch (Exception exception)
        {

            a.setContentText("Error! This object dost`nt exist.\n"+exception.getMessage());
            a.show();
            return;
        }
        textArea.setText(prog.ReadFile());
    }


    public void onAInfoClick(ActionEvent event)
    {
        try {

            int countOfRooms=Integer.parseInt(infCountOfRooms.getText());

            textArea.setText(prog.printA(prog.objects,countOfRooms));
        }
        catch (Exception exception)
        {

            a.setContentText("Input Error\nValues entered incorrectly! Try to enter only numbers.");
            a.show();
            return;
        }

    }

    public void onBInfoClick(ActionEvent event)
    {
        try {

            int countOfRooms=Integer.parseInt(infCountOfRooms.getText());
            int fp=Integer.parseInt(infFirstPoint.getText());
            int lp=Integer.parseInt(infLastPoint.getText());
            textArea.setText(prog.printB(prog.objects,countOfRooms,fp,lp));
        }
        catch (NumberFormatException exception)
        {

            a.setContentText("Input Error\nValues entered incorrectly! Try to enter only numbers.");
            a.show();
            return;
        }
    }

    public void onCInfoClick(ActionEvent event)
    {
        try {

            Double area=Double.parseDouble(infArea.getText());

            textArea.setText(prog.printC(prog.objects,area));
        }
        catch (NumberFormatException exception)
        {

            a.setContentText("Input Error\nValues entered incorrectly! Try to enter only numbers.");
            a.show();
            return;
        }

    }

}
