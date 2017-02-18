package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * method to call on order button clicked
     * @param view
     */
    public void orderItem(View view){
        //get name
        EditText name = (EditText)findViewById(R.id.name_edit_text);
        String name_text = name.getText().toString();
        //get quantity
        TextView quantity
    }
    /**
     * display method to update quantity
     * @param quantity
     */
    protected void displayQuantity(int quantity){
        TextView quantity = (TextView)findViewById(R.id.quantity_text_view);
        quantity.setText("" + quantity);
    }
}
