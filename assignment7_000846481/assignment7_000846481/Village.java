package assignment7_000846481;
import javafx.application.Application;

import java.util.Scanner;

public class Village {
    private double Y_FLOOR = 300;
    public  int size;
    public  String name;
    public  Building[] buildings;

    /**
     * some required parameters for village.
     * @param name
     * @param size
     */
    public Village(String name, int size) {

        this.name = name;
        this.size = size;
        buildings = new Building[size];
    }


    public static Village create() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Write the name of Village:");
        String villageName = userInput.nextLine();
        System.out.println("Write the size of Village:");
        int villageSize = userInput.nextInt();
        Village village = new Village(villageName,villageSize);
        for (int i = 0; i < village.buildings.length; i++) {
            village.buildings[i] = village.getBuilding();
        }
        village.toString();
        return village;
    }

    public  int getPopulation() {
        int population = 0;
        for(int i=0; i< buildings.length; i++){
            if (buildings[i] instanceof House) {
                population += ((House) buildings[i]).getNumberOfOccupants();
            }
            else {
                population += ((ApartmentBuilding) buildings[i]).getNumberOfOccupants();
            }
        }

        return population;
    }

    public double getY_FLOOR() {
        return Y_FLOOR;
    }

    public  void draw() {

       StarterOfProgram.setBuildings(buildings);
        StarterOfProgram.nameOfVillage = name;
        Application.launch(StarterOfProgram.class);
    }

    /**
     *
     * @return
     */
    public String toString() {
        System.out.println("Village of "+this.name + "\n");

        for(int j=0; j< buildings.length; j++){
            buildings[j].toString();
        }
        return this.name;
    }

    /**
     *
     * @return
     */
    public Building getBuilding() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Select the type of building:(house/apartment)");
        String type = userInput.nextLine();
        if (type == null) {
            return null;
        }
        if (type.equals("house")) // if type is house then house method will be called
        {
            return House.create();
        }
        if (type.equals("apartment")) // if type is apartment then apartment will be called
        {
            return ApartmentBuilding.create();
        }
        return null;

    }
}
