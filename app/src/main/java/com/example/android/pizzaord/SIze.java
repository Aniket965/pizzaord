package com.example.android.pizzaord;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import static android.R.attr.name;
        import static com.example.android.pizzaord.R.drawable.w;

public class SIze extends AppCompatActivity {
    String base,crust,cname,cpnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);
        Intent intent2 = getIntent();
        Bundle b = intent2.getExtras();
        cname  = b.getString("name");
        cpnumber = b.getString("number");


    }






    public void getdatasize(View view)
    {
        RadioButton base1 = (RadioButton) findViewById(R.id.bsmall);
        RadioButton base2 = (RadioButton) findViewById(R.id.bmedium);
        RadioButton base3 = (RadioButton) findViewById(R.id.blarge);
        RadioButton crust1 = (RadioButton) findViewById(R.id.cthin);
        RadioButton crust2 = (RadioButton) findViewById(R.id.cthick);

        if (base1.isChecked())
        {
            base="small";
        }
        else  if (base2.isChecked())
        {
            base="medium";
        }
        else  if (base3.isChecked())
        {
            base="large";
        }
        if(crust1.isChecked())
        {
            crust="thin";
        }
        else  if(crust2.isChecked())
        {
            crust="thick";
        }
        onClick2(null);

    }
    public void onClick2(View view) {
        Intent intent = new Intent(this,Toppings.class);
        Bundle b1 = new Bundle();
        b1.putString("name",cname);
        b1.putString("number",cpnumber);
        b1.putString("base",base);
        b1.putString("crust",crust);
        intent.putExtras(b1);
        startActivity(intent);
    }
}


