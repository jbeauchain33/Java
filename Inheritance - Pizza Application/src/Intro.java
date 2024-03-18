import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Intro extends JFrame implements ActionListener {
    //declares labels, picture, and buttons for the intro-slide JFrame
    JLabel label1 = new JLabel("Welcome to Jenna's Pizzeria");
    //adds picture to the JFrame
    ImageIcon icon = new ImageIcon("/Users/jennabeauchain/Downloads/pizzaPhoto.jpeg");
    Image image = icon.getImage();
    Image scaledImage = image.getScaledInstance(460,340, Image.SCALE_SMOOTH);
    JLabel label = new JLabel(new ImageIcon(scaledImage));
    JLabel label2 = new JLabel("We sell pizzas with up to 10 toppings and deliver!");
    JLabel label3 = new JLabel("Each pizza is only $14!!!");
    JButton continueButton = new JButton("Continue");
    //declares the width and height for the JFrame
    final int WIDTH = 500;
    final int HEIGHT = 500;
    public Intro() {
        //sets the width and height for the JFrame
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        //adds the first label, sets the font size and type
        Font labelFont1 = label1.getFont();
        label1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 30));
        add(label1);

        //adds the second label, sets the font size and type
        Font labelFont2 = label2.getFont();
        label2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 18));
        add(label2);

        //adds the continue button, sets the font size and type
        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);

        //adds the third label, sets the font size and type
        Font labelFont3 = label3.getFont();
        label3.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 18));
        add(label3);

        add(label);

        //allows an action to be created from the button being clicked
        continueButton.addActionListener(this);

        //allows the user to click the x button to close the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //switches the screens when the continue button is pushed
        if (e.getSource() == continueButton) {
            GUIPizza guipizza = new GUIPizza();
            guipizza.setVisible(true);
        }
    }
    //main function
    public static void main(String [] args){
        Intro intro = new Intro();
        intro.setVisible(true);
    }


}
class GUIPizza extends JFrame implements ActionListener{
    //creates an array
    public static String[] arr = new String[10];
    //creates a variable for the number of toppings
    static int counterToppings = 0;
    //declares labels, textField, and buttons for the intro-slide JFrame
    JLabel directions = new JLabel("Please enter the next topping you would like on your pizza, each additional topping is $2.");
    JLabel directions2 = new JLabel("Then press 'exit' to exit this screen or 'continue' to add a new topping.");
    JTextField textField = new JTextField(20);
    JButton continueButton = new JButton("Continue");
    JButton exitButton = new JButton("Exit");
    JLabel directions4 = new JLabel("If you would like to be delievered to your address, please press the delivery button");
    JButton directions3 = new JButton("Delivery");
    //declares the width and height for the JFrame
    final int WIDTH = 650;
    final int HEIGHT = 500;

    public GUIPizza(){
        //sets the width and height for the JFrame
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        //adds the JLabels, TextFields, Buttons
        add(directions);
        add(directions2);
        add(textField);
        add(continueButton);
        add(exitButton);
        add(directions4);
        add(directions3);

        //allows the user to click the x button to close the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //allows an action to be created from the button being clicked
        continueButton.addActionListener(this);
        exitButton.addActionListener(this);
        directions3.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //switches the screens when the continue button is pushed and has an exception for if too many toppings are entered
        if (e.getSource() == continueButton){
            if (counterToppings < 10){
                arr[counterToppings] = textField.getText();
                counterToppings++;
                GUIPizza order = new GUIPizza();
                order.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "The Maximum limit has been reached");
            }
        }
        //switches the screens when the continue button is pushed
        if (e.getSource() == exitButton || counterToppings == 10){
            Pizza order = new Pizza(arr, counterToppings);
            End end = new End(order.getString());
            end.setVisible(true);
        }
        if (e.getSource() == directions3){
            PizzaDelivery order = new PizzaDelivery(arr, counterToppings);
            order.setVisible(true);
        }
    }

}

class PizzaDelivery extends JFrame implements ActionListener {
    //declares the array, counter, and adds an address variable
    public String [] arr;
    public int counter;
    public String address;
    //declares labels, textField, and buttons for the Pizza Delivery JFrame
    JLabel directions = new JLabel("Delivery is an additional $5 unless the Pizza order is over $18 then the fee is $3");
    JLabel directions1 = new JLabel("Please enter your address");
    JTextField textField = new JTextField(20);
    JButton continueButton = new JButton("Continue");
    //declares the width and height for the JFrame
    final int WIDTH = 750;
    final int HEIGHT = 500;

    public PizzaDelivery(String [] arr, int counter) {
        super();
        this.arr = arr;
        this.counter = counter;
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        //adds the JLabels, TextFields, Buttons
        add(directions);
        add(directions1);
        add(textField);
        add(continueButton);

        //allows the user to click the x button to close the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //allows an action to be created from the button being clicked
        continueButton.addActionListener( this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //switches the screens when the continue button is pushed
        if (e.getSource() == continueButton){
            address = textField.getText();
            DeliverPizza order = new DeliverPizza(address, counter, arr);
            End end = new End(order.getString());
            end.setVisible(true);
        }
    }
}
class End extends JFrame{
    //creates labels
    private JLabel endMessage;
    JLabel label1 = new JLabel("Thank you for shopping with us today!");
    JLabel label2 = new JLabel("Your order will be ready soon.");
    //declares the width and height for the JFrame
    final int WIDTH = 750;
    final int HEIGHT = 500;
    //passes through the end message into the class
    End(String s){
        super();
        endMessage = new JLabel(s);
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        //adds JLabels and sets the fonts and types
        add(endMessage);
        Font labelFont1 = label1.getFont();
        label1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 25));
        add(label1);
        Font labelFont2 = label2.getFont();
        label2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 25));
        add(label2);
    }
}
