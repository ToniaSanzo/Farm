import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.awt.Toolkit;
public class FarmDriver extends Application {


    // Creates a YourFarm object that contains all your money, and all your animals
    private YourFarm yourFarm = new YourFarm();

    // Buttons used to interact with your farm
    private Button milkButton = new Button("Milk ur cows");
    private Button collectEggs = new Button("Collect ur eggs");
    private Button buyCow = new Button("Buy cow $70");
    private Button buyChicken = new Button("Buy Chicken $15");
    private Button buyMaxCows = new Button("Cash Out on Cows");
    private Button buyMaxChicken = new Button("Cash Out on Chickens");

    private BorderPane borderPane = new BorderPane();

    // Text fields that contain the number of animals and money you have
    TextField yourCash =  new TextField("Your Cash $" + yourFarm.getMoney());
    TextField numChicks = new TextField("You have " + yourFarm.numberOfChickens + " chickens");
    TextField numCows = new TextField("You have " + yourFarm.numberOfCows + " cows");

    @Override
    public void start(Stage primaryStage) {


        StackPane sPane = new StackPane();

        Image image = new Image("https://static.goodgamestudios.com/wp-content/uploads/2014/11/big_farm_tablet_1024x550.jpg");
        ImageView imageV = new ImageView(image);
        sPane.getChildren().add(imageV);


        borderPane = getMainMenu();
        sPane.getChildren().add(borderPane);


        milkButton.setOnAction(e -> {
            yourFarm.milkAllCows();
            yourCash = new TextField("Your Cash $" + yourFarm.getMoney());

            sPane.getChildren().remove(borderPane);
            borderPane = getMainMenu();
            sPane.getChildren().add(borderPane);

        });

        collectEggs.setOnAction(e -> {
            yourFarm.collectAllEggs();
            yourCash = new TextField("Your Cash $" + yourFarm.getMoney());

            sPane.getChildren().remove(borderPane);
            borderPane = getMainMenu();
            sPane.getChildren().add(borderPane);

        } );

        buyCow.setOnAction( e ->{
            Cow tempCow = new Cow();
            yourFarm.addAnimal(tempCow);
            yourCash = new TextField("Your Cash $" + yourFarm.getMoney());
            numCows = new TextField("# of cows:" + yourFarm.numberOfCows);

            sPane.getChildren().remove(borderPane);
            borderPane = getMainMenu();
            sPane.getChildren().add(borderPane);

        });

        buyChicken.setOnAction(e ->{
            Chicken tempChick = new Chicken();
            yourFarm.addAnimal(tempChick);
            yourCash = new TextField("Your Cash $" + yourFarm.getMoney());
            numChicks = new TextField("# of chickens:" + yourFarm.numberOfChickens);

            sPane.getChildren().remove(borderPane);
            borderPane = getMainMenu();
            sPane.getChildren().add(borderPane);

        });

        buyMaxCows.setOnAction(e ->{
            yourFarm.buyMaxCows();
            yourCash = new TextField("Your Cash $" + yourFarm.getMoney());
            numCows = new TextField("# of cows:" + yourFarm.numberOfCows);

            sPane.getChildren().remove(borderPane);
            borderPane = getMainMenu();
            sPane.getChildren().add(borderPane);

        });

        buyMaxChicken.setOnAction(e ->{
            yourFarm.buyMaxChickens();
            yourCash = new TextField("Your Cash $" + yourFarm.getMoney());
            numChicks = new TextField("# of Chickens:" + yourFarm.numberOfChickens);

            sPane.getChildren().remove(borderPane);
            borderPane = getMainMenu();
            sPane.getChildren().add(borderPane);

        });


        Scene scene = new Scene(sPane,1240,550);
        sPane.setAlignment(Pos.CENTER);
        primaryStage.getIcons().add(new Image("https://cdn0.iconfinder.com/data/icons/activities-flat-colorful/2048/2136_-_Farmer-512.png"));
        primaryStage.setTitle("Farm Tycoon");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public GridPane getButtonMenu(){

        numChicks.setEditable(false);
        numCows.setEditable(false);
        yourCash.setEditable(false);


        GridPane gPane = new GridPane();

        gPane.setPadding(new Insets(120,60,30,60));

        gPane.add(milkButton, 0,0);
        gPane.add(collectEggs, 1,0);
        gPane.add(buyCow, 0,1);
        gPane.add(buyChicken,1,1);
        gPane.add(buyMaxCows, 2,1);
        gPane.add(buyMaxChicken, 3,1);

        gPane.setHgap(40);
        gPane.setVgap(40);


        return gPane;


    }

    /**
     * Create a horizontal pane that contains the textfields, that have the amount of money, and the number of animals
     * you have.
     *
     * @return, returns a Horizontal box that contains the text fields
     */
    public HBox getTextFields(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20,130,50,130));

        hbox.setSpacing(20);

        hbox.getChildren().addAll(yourCash,numChicks,numCows);

        return hbox;
    }

    public BorderPane getMainMenu(){
        BorderPane bPane = new BorderPane();

        bPane.setTop(getButtonMenu());
        bPane.setBottom(getButtonMenu());

        return bPane;
    }
}