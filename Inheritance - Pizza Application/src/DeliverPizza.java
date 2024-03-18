public class DeliverPizza  extends Pizza{
    //assigns variables
    int newPrice;
    String address;

    //passes through the address, number of toppings, and array into the deliver pizza class
    DeliverPizza( String Address, int numOfToppings, String [] arr){
        //calls the Pizza class
        super(arr, numOfToppings);
        //declares address variable in the class
        this.address = Address;
        //adds the delivery fee to the total price, based on the total cost with the toppings chosen
        if (numOfToppings > 4){
            newPrice = dollars + 3;
        }
        else{newPrice = dollars + 5;}
        printing = printing + " will be delivered to " + Address;
    }


}
