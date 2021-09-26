package assignment7_000846481;

/**
 * author Yagna Parekh
 */
public class Main{


    public static void main(String[] args) {
        Village village = Village.create();

        village.draw();
        System.out.println("The population of village is: " + village.getPopulation());

    }
}
