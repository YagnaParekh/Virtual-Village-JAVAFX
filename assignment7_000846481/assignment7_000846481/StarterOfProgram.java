package assignment7_000846481;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class StarterOfProgram extends Application {
    public static String nameOfVillage;
    public static  Building[] buildings;

    /**
     * This is the starter file of the program which will have the name
     * of the village and number of the buildings by creating an array.
     * @return
     */

    public static Building[] getBuildings() {
        return buildings;
    }

    public static void setBuildings(Building[] buildings) {
        StarterOfProgram.buildings = buildings;
    }

    public String getNameOfVillage() {
        return nameOfVillage;
    }

    public void setNameOfVillage(String nameOfVillage) {
        this.nameOfVillage = nameOfVillage;
    }

    /**
     * Implementing basic required Graphical Context.
     * @param stage
     */
    private void painting(Stage stage) {
        Village village = new Village("someVillage", 5);
        Label label = new Label(getNameOfVillage()); // getnameofvillage will give the name of the village
        label.setTranslateX(30);
        label.setTranslateY(50);
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BLUEVIOLET);
        final Canvas canvas = new Canvas(500,500);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        int xPositionOfBuilding = 30; //this will have the position of the building
        ArrayList<Label> labels = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            buildings[i].setxPosition(xPositionOfBuilding);
            buildings[i].draw(graphicsContext);
            labels.add(new Label(buildings[i].name)); // a swe add the number of buildings this will crete an
                                                     // appropriate number of buildings
            labels.get(i).setTranslateY(village.getY_FLOOR()+10); // position of village will be 10+ than building
            labels.get(i).setTranslateX(xPositionOfBuilding);
            root.getChildren().add(labels.get(i));
            xPositionOfBuilding +=120;

        }

        root.getChildren().addAll(canvas,label);
        stage.setTitle("Small Village");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        painting(stage);
    }
}
