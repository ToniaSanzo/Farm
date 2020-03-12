import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class YourFarm {

    public Chicken chicken = new Chicken();
    public Cow cow = new Cow();
    public int numberOfCows;
    public int numberOfChickens;
    private int money = 30;
    /**
     * Default constructor
     */
    public YourFarm (){
        numberOfCows = 0;
        numberOfChickens = 0;
    }

    /**
     * Add an Animal to YourFarm
     * @param animal
     */
    public <E> void addAnimal(Animal animal){
        if(animal instanceof Cow){
            if(money < 70){
                JOptionPane.showMessageDialog(null,"You broke");
            }
            else{
            numberOfCows++;
            money -= 70;}
        }

        if(animal instanceof Chicken) {
            if(money < 15){
                JOptionPane.showMessageDialog(null,"You broke");
            }
            else{
            numberOfChickens++;
            money -=15;}
        }


    }



    /**
     * Method to milk all the cows and return the money made
     */
    public void milkAllCows(){
        int temp = numberOfCows * cow.action();

        money += temp;
    }



    /**
     * Method to collect all the eggs and return the money made
     */
    public void collectAllEggs(){

        int temp = numberOfChickens * chicken.action();

        money += temp;
    }

    /**
     * @return the amount of money you have
     */
    public int getMoney(){
        return money;
    }

    /**
     * Buy the maximum amount of cows
     */
    public void buyMaxCows()
    {
        if(money <70){
            JOptionPane.showMessageDialog(null, "You broke af");
        }
        else{
            int number = money/ 70;
            numberOfCows += number;
            money -= 70 *number;
        }
    }


    /**
     * Buy the maximum amount of chickens
     */
    public void buyMaxChickens()
    {
        if(money <15){
            JOptionPane.showMessageDialog(null, "You broke af");
        }
        else{
            int number = money/ 15;
            numberOfChickens += number;
            money -= 15 *number;
        }
    }




}
