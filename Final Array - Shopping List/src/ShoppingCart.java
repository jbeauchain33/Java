import java.util.ArrayList;
public class ShoppingCart {
    //creates a variable for total price
    public int totalprice = 0;
    //creates an array for the items in the order
    private ArrayList<ItemOrder> items;
    //passes the shopping cart array through the class
    public ShoppingCart(ArrayList<ItemOrder> arr) {
        this.items = arr;

    }
    //adds the items to the array
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    //adds the items from the item order
    public void addItem(ItemOrder itemOrder) {

        items.add(itemOrder);
    }
    //removes the items from the item order
    public void removeItem(ItemOrder itemOrder) {

        items.remove(itemOrder);
    }
    //prints the total shopping cart
    public String getItems() {
        String ret = "Your items are ";
        for (ItemOrder x : items){
            ret += x.getAmount() + " ";
            ret += x.getItem().getItemName() + " which will cost ";
            ret += x.getTotalPrice() + " dollars, ";
            ret += "\r";
        }

        return ret ;
    }
    //returns the total price
    public int getTotalPrice() {
        for (ItemOrder x : items){
            totalprice += (x.getTotalPrice());
        }
        return totalprice;

    }
    //allows for the item to be searched from the array
    public ArrayList<ItemOrder> searchItemByName(String itemName) {
        ArrayList<ItemOrder> foundItems = new ArrayList<>();
        for (ItemOrder itemOrder : items) {
            if (itemOrder.itemName.getItemName().equalsIgnoreCase(itemName)) {
                foundItems.add(itemOrder);
            }
        }
        return foundItems;
    }
}
