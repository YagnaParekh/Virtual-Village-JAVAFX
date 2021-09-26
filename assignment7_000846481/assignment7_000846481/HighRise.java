package assignment7_000846481;

import assignment7_000846481.Building;

public class HighRise extends Building
// inherits from buildings
{
    public  int numberOfFloors;

    public HighRise(String name, double xPosition,int numberOfFloors) {
        super(name, xPosition); // inherit from name xposition
        this.numberOfFloors = numberOfFloors;
    }

    /**
     *
     * @return will get number of floors
     */
    public  int getNumberOfFloors() {
        return numberOfFloors;
    }

    public String toString() {
        return null;
    }
}
