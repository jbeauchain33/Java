import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Intro extends JFrame implements ActionListener {
    //declares the labels and buttons for the JFrame
    JLabel j1 = new JLabel ("Welcome to Jenna's Online Grocery Store");
    JLabel j2 = new JLabel ("We make shopping easier just order online today!");
    JButton continueButton = new JButton ("Click here to start!");
    JLabel deal1 = new JLabel("Deals Today:");
    JLabel deal2 = new JLabel ("Buy 4 tissues for $10!");
    JLabel deal3 = new JLabel ("Buy 3 apples for $5!");
    //declares the width and height of the JFrame
    final int WIDTH = 500;
    final int HEIGHT = 500;
    public Intro() {
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        //adds the label to the frame and sets the font type and size
        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 18));
        add(j1);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 18));
        add(j2);

        //adds the continue button and sets the size
        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);

        //adds the deal labels to the frame
        add(deal1);
        add(deal2);
        add(deal3);

        continueButton.addActionListener(this);
        //sets the frame to close when the exit button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //declares variables and moves to the next frame when the continue button is pressed
        if (e.getSource() == continueButton) {
            Item tissues = new Item("Tissues", 3);
            Item eggs = new Item("Eggs", 5);
            Item milk = new Item("Milk", 4);
            Item cookies = new Item("cookies", 6);
            Item steak = new Item("steak", 10);
            Item cheese = new Item("cheese", 3);
            Item apples = new Item("apples", 2);
            Item bread = new Item("bread", 4);
            Item lettuce = new Item("lettuce", 4);
            Item iceCream = new Item("ice cream", 3);
            Item chips = new Item("chips", 2);

            Screen2 screen2 = new Screen2(tissues, eggs, milk, cookies, steak, cheese, apples, bread, lettuce, iceCream, chips);
            screen2.setVisible(true);
        }
    }
    //the main function
    public static void main(String[] args) {
        Intro intro = new Intro();
        intro.setVisible(true);
    }
}

class Screen2 extends JFrame implements ActionListener {
    //declares variables for all the possible food items
    Item tissues;
    Item eggs;
    Item milk;
    Item cookies;
    Item steak;
    Item cheese;
    Item apples;
    Item bread;
    Item lettuce;
    Item iceCream;
    Item chips;
    int amountTissues;
    int amountEggs;
    int amountMilk;
    int amountCookies;
    int amountSteak;
    int amountCheese;
    int amountApples;
    int amountBread;
    int amountLettuce;
    int amountIceCream;
    int amountChips;
    //declares the labels, textfield, and buttons
    JLabel directions1 = new JLabel ("Please enter the amount of each you would like to buy");
    JLabel directions2 = new JLabel ("If you would not like the product listed, please input the quantity 0");
    JLabel tissuesLabel = new JLabel("Tissues $3");
    JTextField tissuesTextField = new JTextField (2);
    JLabel eggsLabel = new JLabel ("Eggs $5");
    JTextField eggsTextField = new JTextField (2);
    JLabel milkLabel = new JLabel ("Milk $4");
    JTextField milkTextField = new JTextField (2);
    JLabel cookiesLabel = new JLabel("Cookies $6");
    JTextField cookiesTextField = new JTextField (2);
    JLabel steakLabel = new JLabel ("Steak $10");
    JTextField steakTextField = new JTextField (2);
    JLabel cheeseLabel = new JLabel ("Cheese $3");
    JTextField cheeseTextField = new JTextField (2);
    JLabel applesLabel = new JLabel ("Apples $2");
    JTextField applesTextField = new JTextField (2);
    JLabel breadLabel = new JLabel ("Bread $4");
    JTextField breadTextField = new JTextField (2);
    JLabel lettuceLabel = new JLabel ("Lettuce $4");
    JTextField lettuceTextField = new JTextField (2);
    JLabel iceCreamLabel = new JLabel ("Ice Cream $3");
    JTextField iceCreamTextField = new JTextField (2);
    JLabel chipsLabel = new JLabel ("Chips $2");
    JTextField chipsTextField = new JTextField (2);


    JButton continueButton = new JButton("Continue");
    //declares the size of the frame
    final int WIDTH = 500;
    final int HEIGHT = 500;

    //passes the items through the new class
    public Screen2 (Item t, Item e, Item m, Item c, Item s, Item ch, Item a, Item br, Item l, Item i, Item chi) {
        super("My Frame");
        //declares the items
        tissues = t;
        eggs = e;
        milk = m;
        cookies = c;
        steak = s;
        cheese = ch;
        apples = a;
        bread = br;
        lettuce = l;
        iceCream = i;
        chips = chi;

        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());

        //adds the labels, textfields, and buttons to the frame
        add(directions1);
        add(directions2);
        add(tissuesLabel);
        add(tissuesTextField);
        add(eggsLabel);
        add(eggsTextField);
        add(milkLabel);
        add(milkTextField);
        add(cookiesLabel);
        add(cookiesTextField);
        add(steakLabel);
        add(steakTextField);
        add(cheeseLabel);
        add(cheeseTextField);
        add(applesLabel);
        add(applesTextField);
        add(breadLabel);
        add(breadTextField);
        add(lettuceLabel);
        add(lettuceTextField);
        add(iceCreamLabel);
        add(iceCreamTextField);
        add(chipsLabel);
        add(chipsTextField);



        add(continueButton);
        continueButton.addActionListener(this);
        //closes the frame when the exit button is pushed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //sets the new price of tissues if the user gets the deal
        if (e.getSource() == continueButton) {
            if (Integer.valueOf(tissuesTextField.getText()) % 4 == 0){
                amountTissues = Integer.valueOf(tissuesTextField.getText());
                int x = amountTissues / 4;
                tissues.setItemPrice(2*x);
            }
            else{
                amountTissues = Integer.valueOf(tissuesTextField.getText());
            }
            amountEggs = Integer.valueOf(eggsTextField.getText());
            amountMilk = Integer.valueOf(milkTextField.getText());
            amountCookies = Integer.valueOf((cookiesTextField.getText()));
            amountSteak = Integer.valueOf(steakTextField.getText());
            amountCheese = Integer.valueOf(cheeseTextField.getText());
            //sets the new price of apples if the user gets the deal
            if (Integer.valueOf(applesTextField.getText()) % 3 == 0){
                amountApples = Integer.valueOf(applesTextField.getText());
                int y = amountApples / 3;
                apples.setItemPrice(y);
            }
            amountBread = Integer.valueOf((breadTextField.getText()));
            amountLettuce = Integer.valueOf((lettuceTextField.getText()));
            amountIceCream = Integer.valueOf(iceCreamTextField.getText());
            amountChips = Integer.valueOf((chipsTextField.getText()));
            ItemOrder tissue = new ItemOrder(tissues, amountTissues);
            ItemOrder egg = new ItemOrder(eggs, amountEggs);
            ItemOrder ilk = new ItemOrder(milk, amountMilk);
            ItemOrder cookie = new ItemOrder(cookies, amountCookies);
            ItemOrder teak = new ItemOrder(steak, amountSteak);
            ItemOrder heese = new ItemOrder(cheese, amountCheese);
            ItemOrder apple = new ItemOrder(apples, amountApples);
            ItemOrder read = new ItemOrder(bread, amountBread);
            ItemOrder ettuce = new ItemOrder(lettuce, amountLettuce);
            ItemOrder ceCream = new ItemOrder(iceCream, amountIceCream);
            ItemOrder chip = new ItemOrder(chips, amountChips);
            Screen3 screen3 = new Screen3(tissue, egg, ilk, cookie, teak, heese, apple, read, ettuce, ceCream, chip);
            screen3.setVisible(true);



        }
    }
}
class Screen3 extends JFrame implements ActionListener{
    //declares variables for the items
    ItemOrder tissues;
    ItemOrder eggs;
    ItemOrder milk;
    ItemOrder cookies;
    ItemOrder steak;
    ItemOrder cheese;
    ItemOrder apples;
    ItemOrder bread;
    ItemOrder lettuce;
    ItemOrder iceCream;
    ItemOrder chips;
    //declares labels and buttons for the frame
    JLabel directions1 = new JLabel("These are the items in your cart.");
    JLabel directions2 = new JLabel("If you would like to add or delete an item, please click the corresponding button below");
    JLabel directions3 = new JLabel("If you are happy with the items in your cart, please hit the Continue button");
    JButton add = new JButton("Add");
    JButton delete = new JButton("Delete");
    JButton continueButton = new JButton("Continue");
    JTextArea items;
    //sets the size of the frame
    final int WIDTH = 800;
    final int HEIGHT = 700;
    //declares the array
    public ShoppingCart S1 = new ShoppingCart();
    //passes through the Item orders of all the items
    public Screen3 (ItemOrder t, ItemOrder e, ItemOrder m, ItemOrder c, ItemOrder s, ItemOrder ch, ItemOrder a, ItemOrder br, ItemOrder l, ItemOrder i, ItemOrder chi) {
        super("My Frame");
        //adds all the items to the array
        S1.addItem(t);
        S1.addItem(e);
        S1.addItem(m);
        S1.addItem(s);
        S1.addItem(ch);
        S1.addItem(a);
        S1.addItem(br);
        S1.addItem(l);
        S1.addItem(i);
        S1.addItem(chi);
        //declares the variables
        tissues = t;
        eggs = e;
        milk = m;
        cookies = c;
        steak = s;
        cheese = ch;
        apples = a;
        bread = br;
        lettuce = l;
        iceCream = i;
        chips = chi;

        //prints the total price
        items = new JTextArea(S1.getItems() + " your total price is $" + S1.getTotalPrice());
        items.setEditable(false);
        items.setLineWrap(true);
        items.setWrapStyleWord(true);
        items.setColumns(30);
        boolean b = false;

        setLayout(new FlowLayout());
        add(items);
        setSize(WIDTH, HEIGHT);
        //adds the labels and buttons to the frame
        add(directions1);
        add(directions2);
        add(directions3);
        add(add);
        add(delete);
        add(continueButton);
        //allows an action to happen when the button is pressed
        delete.addActionListener(this);
        add.addActionListener(this);
        continueButton.addActionListener(this);
        //allows the screen to close when the exit button is pushed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //adds an item
        if (e.getSource() == add) {
                boolean b = true;
                AddOrDeleteScreen addOrDeleteScreen = new AddOrDeleteScreen(tissues, eggs, milk, cookies, steak, cheese, apples, bread, lettuce, iceCream, chips, b);
                addOrDeleteScreen.setVisible(true);
        }
        //deletes an item
        if (e.getSource() == delete){
            boolean b = false;
            AddOrDeleteScreen addOrdeleteScreen = new AddOrDeleteScreen(tissues, eggs, milk, cookies, steak, cheese, apples, bread, lettuce, iceCream, chips, b);
            addOrdeleteScreen.setVisible(true);
        }
        //adds the items to the array
        if(e.getSource() == continueButton) {
            ArrayList <ItemOrder> array = new ArrayList<ItemOrder>();
            array.add(tissues);
            array.add(milk);
            array.add(eggs);
            array.add(cookies);
            array.add(steak);
            array.add(cheese);
            array.add(apples);
            array.add(bread);
            array.add(lettuce);
            array.add(iceCream);
            array.add(chips);
            ShoppingCart SC = new ShoppingCart(array);
            //changes to the final screen
            FinalScreen finalScreen = new FinalScreen(SC);
            finalScreen.setVisible(true);
        }







}}

class AddOrDeleteScreen extends JFrame implements ActionListener{
    //declares the items
    ItemOrder tissues;
    ItemOrder eggs;
    ItemOrder milk;
    ItemOrder cookies;
    ItemOrder steak;
    ItemOrder cheese;
    ItemOrder apples;
    ItemOrder bread;
    ItemOrder lettuce;
    ItemOrder iceCream;
    ItemOrder chips;
    //declares the panel and label
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Select an item you would like to add");
    //adds a drop-down box with all the items
    String[] choices = { "Tissues", "Eggs", "Milk", "Cookies", "Steak", "Cheese", "Apples", "Bread", "Lettuce", "Ice Cream", "Chips"};
    final JComboBox<String> cb = new JComboBox<String>(choices);
    JButton continueButton = new JButton("Continue");
    //sets the size of the frame
    final int WIDTH = 800;
    final int HEIGHT = 500;
    public boolean yes;
    //passes all the item orders through the class
    public AddOrDeleteScreen (ItemOrder t, ItemOrder e, ItemOrder m, ItemOrder c, ItemOrder s, ItemOrder ch, ItemOrder a, ItemOrder br, ItemOrder l, ItemOrder i, ItemOrder chi, Boolean b) {
        super("My Frame");
        //declares the variables
        tissues = t;
        eggs = e;
        milk = m;
        cookies = c;
        steak = s;
        cheese = ch;
        apples = a;
        bread = br;
        lettuce = l;
        iceCream = i;
        chips = chi;
        yes = b;
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        //adds the panel, label, and button to the frame
        add(panel1);
        add(label1);
        add(cb);
        add(continueButton);
        continueButton.addActionListener(this);
        //closes the frame when the x button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //changes the amount of the item
        if (e.getSource() == continueButton) {
            try{
                String x = (String) cb.getSelectedItem();
                if (x.equals("Tissues")){
                    tissues.changeAmount(yes);
                }
                if(x.equals("Eggs")){
                    eggs.changeAmount(yes);
                }
                if (x.equals("Milk")){
                    milk.changeAmount(yes);
                }
                if (x.equals("Cookies")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Steak")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Cheese")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Apples")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Bread")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Lettuce")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Ice Cream")){
                    tissues.changeAmount(yes);
                }
                if (x.equals("Chips")){
                    tissues.changeAmount(yes);
                }
                if (tissues.getTotalPrice() < 0 || eggs.getTotalPrice() < 0 || milk.getTotalPrice() < 0 || cookies.getTotalPrice() < 0 || steak.getTotalPrice() < 0 || cheese.getTotalPrice() < 0 || apples.getTotalPrice() < 0 || bread.getTotalPrice() < 0 || lettuce.getTotalPrice() < 0 || iceCream.getTotalPrice() < 0 || chips.getTotalPrice() < 0) {
                    System.out.println(1/0);
                } // an exception if the user deletes an item that has 0 as its amount
            } catch (Exception exception){
                JOptionPane.showMessageDialog(this, "You deleted an item that did not exist in your cart. Please click x and restart");
            }
            Screen3 screen3 = new Screen3(tissues, eggs, milk, cookies, steak, cheese, apples, bread, lettuce, iceCream, chips);
            screen3.setVisible(true);
        }
    }
}


class FinalScreen extends JFrame {
    //declares variables
    JTextArea message;
    ShoppingCart shop;
    //sets size of the frame
    final int WIDTH = 1000;
    final int HEIGHT = 500;

    public FinalScreen (ShoppingCart s){
        super();
        setSize(WIDTH,HEIGHT);
        shop = s;
        //prints the ending message
        message = new JTextArea(s.getItems() + " your total price is $" + s.getTotalPrice());
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setColumns(30);
        add(message);

    }

}


