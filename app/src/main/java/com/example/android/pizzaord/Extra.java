package com.example.android.pizzaord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import static android.R.attr.x;
import static com.example.android.pizzaord.R.id.base;
import static com.example.android.pizzaord.R.id.crust;

public class Extra extends AppCompatActivity {
    String extra="",cname,cpnumber,crust,mt,addons,cheese,base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        Intent intent3 = getIntent();
        Bundle b4 = intent3.getExtras();
        cname  = b4.getString("name");
        cpnumber = b4.getString("number");
        base=b4.getString("base");
        crust=b4.getString("crust");
        mt= b4.getString("mt");
        addons = b4.getString("addons");
        cheese= b4.getString("cheese");

    }

    public void getdatasize1(View view)
    {

        CheckBox ex1 =(CheckBox)findViewById(R.id.cD);
        if(ex1.isChecked())
        {
            extra=extra+'\n'+"extra: cold drink";
        }
        CheckBox ex2 =(CheckBox)findViewById(R.id.dippings);
        if(ex2.isChecked())
        {
            extra=extra+'\n'+"extra: dippings";
        }
        CheckBox ex3 =(CheckBox)findViewById(R.id.ff);
        if(ex3.isChecked())
        {
            extra=extra+'\n'+"extra: French fries";
        }
        CheckBox ex4 =(CheckBox)findViewById(R.id.eva);

        if(ex4.isChecked())
        {
            extra=extra+'\n'+"extra: veggie";
        }

        onClick2(null);
    }
    public void onClick2(View view) {
        Intent intent = new Intent(this,DeliveryDetails.class);
        Bundle b5 = new Bundle();
        b5.putString("mt",mt);
        b5.putString("addons",addons);
        b5.putString("cheese",cheese);
        b5.putString("name",cname);
        b5.putString("number",cpnumber);
        b5.putString("base",base);
        b5.putString("crust",crust);
        b5.putString("extra",extra);

        intent.putExtras(b5);
        startActivity(intent);
    }





    }
