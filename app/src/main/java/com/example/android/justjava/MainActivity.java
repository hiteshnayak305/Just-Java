package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected int cups = 2;
    protected double price = 10.0;

    /**
     * increment button action
     * @param
     */
    public void increment(View view){
        if(cups>=100){
            makeText(this,"Maximum order reached",LENGTH_SHORT).show();
            return;
        }
        cups = cups + 1;
        displayQuantity(cups);
    }

    /**
     * decreament button acion
     * @param
     */
    public void decrement(View view){
        if(cups<=1){
            Toast.makeText(this,"Minimum order reached", LENGTH_SHORT).show();
            return;
        }
        cups = cups - 1;
        displayQuantity(cups);
    }
    public void checkPrice(View view){
        //cream object
        CheckBox cream = (CheckBox)findViewById(R.id.whipped_cream_check);
        //chocolate object
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate_check);
        price = 5* cups;
        if(cream.isChecked()){
            price = price + 1* cups;
        }
        if(chocolate.isChecked()){
            price = price + 2* cups;
        }
        //price text object
        TextView priceview = (TextView)findViewById(R.id.price_text_view);
        priceview.setText("$ "+price);
    }
    /**
     * method to call on order button clicked
     * @param
     */
    public void orderItem(View view){
        //get name object
        EditText name = (EditText)findViewById(R.id.name_edit_text);
        String name_text = name.getText().toString();
        //cream object
        CheckBox cream = (CheckBox)findViewById(R.id.whipped_cream_check);
        boolean hasCream = cream.isChecked();
        //chocolate object
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate_check);
        boolean hasChoco = chocolate.isChecked();
        price = 5* cups;
        if(cream.isChecked()){
            price = price + 1* cups;
        }
        if(chocolate.isChecked()){
            price = price + 2* cups;
        }
        String messaage = "Name: " + name_text + "\nInclude whipped cream? " + hasCream + "\nInclude chocolate? " + hasChoco + "\nTotal Price: $ " + price +"\nThank You!";
        //create intent to start email activity
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+"hiteshnayak305@gmail.com"));
        //intent.putExtra(Intent.EXTRA_EMAIL,"hiteshnayak305@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java");
        intent.putExtra(Intent.EXTRA_TEXT,messaage);
        startActivity(intent);
    }
    /**
     * display method to update quantity
     * @param q
     */
    public void displayQuantity(int q){
        //get quantity object object
        TextView quantity = (TextView)findViewById(R.id.quantity_text_view);
        String qt = "" + q;
        quantity.setText(qt);
    }
}
