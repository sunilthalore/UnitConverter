package com.sunil.unitconverter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ButtonTemp;
    Button ButtonLen;
    Button ButtonSpeed;
    Button ButtonWeight;
    Button ButtonCustom;

    EditText ett1, ett2;

    public int btnID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLen = (Button)findViewById(R.id.lenButton);
        ButtonTemp = (Button) findViewById(R.id.tempButton);
        ButtonSpeed = (Button) findViewById(R.id.speedButton);
        ButtonWeight = (Button) findViewById(R.id.weightButton);
        ButtonCustom = (Button) findViewById(R.id.customButtom);

        ButtonTemp.setOnClickListener(this);
        ButtonLen.setOnClickListener(this);
        ButtonSpeed.setOnClickListener(this);
        ButtonWeight.setOnClickListener(this);
        ButtonCustom.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                doThis(v);
                                            }
                                        });

                ett1 = (EditText) findViewById(R.id.et1);
        ett2 = (EditText) findViewById(R.id.et2);



        }
    public void doThis(View v){
        Intent cbtn = new Intent(this,CustomButton.class);
        startActivity(cbtn);
        Log.d("Dothis", "doThis ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case (R.id.tempButton):
                btnID = 1;
                break;
            case (R.id.lenButton):
                btnID = 2;
                break;
            case (R.id.speedButton):
                btnID = 3;
                break;
            case (R.id.weightButton):
                btnID = 4;
                break;



        }



        Intent nextIntent = new Intent(this, CalActivity.class);
        nextIntent.putExtra("btnID", btnID);
        startActivity(nextIntent);


        //    if (TextUtils.isEmpty(ett1.getText().toString())
    //            || TextUtils.isEmpty(ett2.getText().toString()))
    //    {
     //       return;
     //   }
/*
        double e1 = 0;
        double e2 =0;
        String output;

      //  e1 = Double.parseDouble(ett1.getText().toString());
      //  e2 = Double.parseDouble(ett2.getText().toString());

        switch (view.getId()){
           case R.id.tempButton:
                e1 = Double.parseDouble(ett1.getText().toString());
                e2 = Double.parseDouble(ett2.getText().toString());
                e2 = (e1*1.8) + 32;
                output = Double.toString(e2);
                ett1.setText("test test");
                        }

*/





    }
}
