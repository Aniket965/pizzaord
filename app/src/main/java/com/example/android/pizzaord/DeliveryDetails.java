package com.example.android.pizzaord;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.order;
import static com.example.android.pizzaord.R.id.base;
import static com.example.android.pizzaord.R.id.crust;

public class DeliveryDetails extends AppCompatActivity {
    String ad,emailad, extra,cname,cpnumber,orderSummary,crust,mt,addons,cheese,base;
    int price=80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        Intent intent2 = getIntent();
        Bundle b4 = intent2.getExtras();
        cname  = b4.getString("name");
        cpnumber = b4.getString("number");
        crust=b4.getString("crust");
        mt= b4.getString("mt");
        addons = b4.getString("addons");
        cheese= b4.getString("cheese");
        base=b4.getString("base");
        extra=b4.getString("extra");


    }

    public void next(View view) {



        EditText address = (EditText) findViewById(R.id.consumer_Adress);
        ad = address.getText().toString();
        EditText consumeremailad = (EditText) findViewById(R.id.consumer_email);
        emailad = consumeremailad.getText().toString();



        if (ad.equals("") || emailad.equals("")) {

            Context context = getApplicationContext();
            CharSequence text = "Please fill all details to proceed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast1 = Toast.makeText(context, text, duration);
            toast1.show();

        } else {

            if(base.equals("small"))
            {
                price=price+100;
            }
           else if(base.equals("medium"))
            {
                price=price+120;
            }
             else if(base.equals("large"))
            {
                price=price+140;
            }
            if (cheese.equals("double"))
            {
                price=price+10;
            }
            else if (cheese.equals("triple"))
            {
                price=price+20;
            }
            if(addons.contains("Green Olives"))
            {
                price=price+30;
            }

            if(addons.contains("Black Olives"))
            {
                price=price+30;
            }
            if(addons.contains("extra cheese"))
            {
                price=price+30;
            }
            if(addons.contains("Extra Veggie"))
            {
                price=price+30;
            }
            if(extra.contains("cold drink"))
            {
                price=price+50;
            }
            if(extra.contains("dippings"))
            {
                price=price+50;
            }
            if(extra.contains("French fries"))
            {
                price=price+50;
            }
            if(extra.contains("veggie"))
            {
                price=price+50;
            }

            orderSummary="total price: "+price+'\n'+"name: "+cname+'\n'+"mobile number: " +cpnumber+'\n'
            +"address: " +ad+'\n'+"email: " +emailad+'\n'+"base: "+base+'\n'+"crust: " +crust+'\n'+"main topping: "+mt+'\n'+"add-ons: " +addons+'\n'
           + "extra: " +extra+'\n';

            composeEmail(orderSummary);
        }


    }





    public void composeEmail(String os) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_CC, "pizza@");
        intent.putExtra(Intent.EXTRA_SUBJECT, "order");
        intent.putExtra(Intent.EXTRA_TEXT,os);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

