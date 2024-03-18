public class Item {
    //adds a string and integer for the item name and price of the item
    public String itemName;
    public int itemPrice;
    //passes through the name and price to create an item class
    public Item(String name, int price) {
        itemName = name;
        itemPrice = price;
    }
    //creates a function that can be called to get the name of the item
    public String getItemName() {
        return itemName;
    }
    //creates a function that can be called to get the name of the price
    public int getItemPrice() {
        return itemPrice;
    }
    //sets the price of the item
    public void setItemPrice(int x){
        itemPrice -= x;
    }
}

