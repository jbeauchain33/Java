public class ItemOrder {
    //assigns variables for the item name and amount of each item
    public Item itemName;
    public int amount;

    //passes through the item name and amount of the item through the class
    public ItemOrder(Item item, int amount) {
         itemName = item;
         this.amount = amount;
    }
    //changes the amount of the item based on the boolean given
    public void changeAmount(boolean x) {
         if (x){
             amount += 1;
         }
         else{
             amount -= 1;
         }
    }
    //returns the amount of items
    public int getAmount(){

        return amount;
    }
    //returns and calculates the total price
    public int getTotalPrice(){

        return itemName.getItemPrice() * amount;
    }
    //returns the item name
    public Item getItem(){

        return itemName;
    }
}
