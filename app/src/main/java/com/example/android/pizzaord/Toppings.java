package com.example.android.pizzaord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import static com.example.android.pizzaord.R.id.base;
import static com.example.android.pizzaord.R.id.crust;
import static com.example.android.pizzaord.R.id.t;

public class Toppings extends AppCompatActivity {
    String cheese,mt,addons="",cname,cpnumber,crust,base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        Intent intent2 = getIntent();
        Bundle b2 = intent2.getExtras();
        cname  = b2.getString("name");
        cpnumber = b2.getString("number");
        base=b2.getString("base");
        crust=b2.getString("crust");

    }

    public void getdatasize(View view)
    {
        RadioButton mt1 = (RadioButton) findViewById(R.id.mtveg);
        RadioButton mt2 = (RadioButton) findViewById(R.id.mtnonveg);
        RadioButton c1 = (RadioButton) findViewById(R.id.single_cheese);
        RadioButton c2 = (RadioButton) findViewById(R.id.double_cheese);
        RadioButton c3 = (RadioButton) findViewById(R.id.triple_cheese);
        CheckBox go =(CheckBox)findViewById(R.id.golives);
        if(go.isChecked())
        {
            addons=addons+'\n'+"Green Olives";
        }
        CheckBox bo =(CheckBox)findViewById(R.id.bolives);
        if(bo.isChecked())
        {
            addons=addons+'\n'+"Black Olives";
        }
        CheckBox ex =(CheckBox)findViewById(R.id.extracheese);
        if(ex.isChecked())
        {
            addons=addons+'\n'+"extra cheese";
        }
        CheckBox ev =(CheckBox)findViewById(R.id.extravegggie);

        if(ev.isChecked())
        {
            addons=addons+'\n'+"Extra Veggie";
        }
        if (c1.isChecked())
        {
            cheese="single";
        }
        else  if (c2.isChecked())
        {
            cheese="double";
        }
        else  if (c3.isChecked())
        {
            cheese="triple";
        }
        if(mt1.isChecked())
        {
            mt="veg";
        }
        else  if(mt2.isChecked())
        {
            mt="non-veg";
        }
        onClick2(null);

    }
    public void onClick2(View view) {
        Intent intent = new Intent(this,Extra.class);

        Bundle b3 = new Bundle();

        b3.putString("mt",mt);
        b3.putString("addons",addons);
        b3.putString("cheese",cheese);
        b3.putString("name",cname);
        b3.putString("number",cpnumber);
        b3.putString("base",base);
        b3.putString("crust",crust);
        intent.putExtras(b3);
        startActivity(intent);
    }
}
