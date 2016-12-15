package com.example.android.pizzaord;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.value;
import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.provider.Contacts.SettingsColumns.KEY;

public class starterPage extends AppCompatActivity {
    String cname,cpnumber;
    EditText consumerName,consumerPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_page);

    }



    public void next(View view) {

        consumerName = (EditText) findViewById(R.id.consumer_name);
        cname= consumerName.getText().toString();

       consumerPhoneNumber = (EditText) findViewById(R.id.consumer_phone_number);
        cpnumber= consumerPhoneNumber.getText().toString();


        if(cname.equals("")||cpnumber.equals("")){

            Context context = getApplicationContext();
            CharSequence text = "Please fill all details to proceed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast1 = Toast.makeText(context, text, duration);
            toast1.show();

        }
        else {
          onClick1(null);
        }



}


    public void onClick1(View view) {


        Intent intent = new Intent(starterPage.this,SIze.class);
        //Create a bundle object
        Bundle b = new Bundle();

        //Inserts a String value into the mapping of this Bundle
        b.putString("number",consumerPhoneNumber.getText().toString());
        b.putString("name",consumerName.getText().toString());


        //Add the bundle to the intent.
        intent.putExtras(b);
        startActivity(intent);

    }


    }