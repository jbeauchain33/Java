
public class Pizza{
    //creates an array
    public String[] array;
    // assigning variables
    public int dollars;
    int amount;
    String printing = " ";

    //passes through an array and an integer
    Pizza(String[] array, int amount) {
        //declares the array and integer in the class
        this.array = array;
        this.amount = amount;
        int x = 0;

        //prints the price and topping
        while (x != amount) {
            printing += " " + array[x] + ",";
            x++;
        }
        //calculates the amount based on the number of toppings
        dollars = 14 + (2 * amount);
    }
    //returns the type of toppings and the total price
    public String getString() {

        return "Pizza with toppings: " + printing + "\nTotal Price: $" + dollars;
    }
}