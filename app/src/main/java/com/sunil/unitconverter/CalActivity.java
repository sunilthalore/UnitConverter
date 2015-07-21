package com.sunil.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by User on 7/3/2015.
 */
public class CalActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    EditText editText1;
    EditText editText2;
    int btID;
    int list1ID, list2ID;
  //  Button bw, bl, bt, bs, calb;
    Button clrButton;

    private Boolean machine_changed_edittext = false;

     Spinner mSpinner1, mSpinner2;
   // String list11= "   ", list12= "    ", list13= "   ", list21 = "   ", list22= "   ", list23= "   ";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        editText1 = (EditText) findViewById(R.id.et1);
        editText2 = (EditText) findViewById(R.id.et2);


        clrButton = (Button) findViewById(R.id.clrbtn);
        clrButton.setOnClickListener(this);
    //    bl = (Button) findViewById(R.id.lenButton);
    //    bw = (Button) findViewById(R.id.weightButton);
    //    bs = (Button) findViewById(R.id.speedButton);
    //    bt = (Button) findViewById(R.id.tempButton);

        /////////////////////////////////////////////////////////
        // Text Changed listener

        editText1.addTextChangedListener(new TextWatcher() {

            double c, f ;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(! machine_changed_edittext){
                    machine_changed_edittext = true;
                    if ((!s.toString().equals(""))){
                        c = Double.parseDouble(s.toString());
                        if (btID == 1) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = (((9 / 5) * c) + 32);
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c + 274.15;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = (c - 32) / 1.8;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c + 255.928;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c - 272.15;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c - 457.87;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                            editText2.setText(String.valueOf(f));

                        }else if (btID == 2) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = c/1000;
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c*39.3701;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = c*1000;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c*39370.1;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c/39.3701;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c/39370.1;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                            editText2.setText(String.valueOf(f));

                        }else if (btID == 3) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = c*1.60934;
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c*0.44704;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = c*0.621371;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c*0.277778;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c*2.23694;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c*3.6;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                            editText2.setText(String.valueOf(f));

                        }else if (btID == 4) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = c*0.453592;
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c*453.592;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = c*2.20462;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c*1000;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c*0.00220462;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c/1000;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                        }
                        editText2.setText(String.valueOf(f));

                    }
                    else {
                        editText2.setText("");
                    }
                    machine_changed_edittext = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            double c, f ;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(! machine_changed_edittext){
                    machine_changed_edittext = true;
                    if ((!s.toString().equals(""))){
                        c = Double.parseDouble(s.toString());
                        if (btID == 1) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = (((9 / 5) * c) + 32);
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c + 274.15;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = (c - 32) / 1.8;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c + 255.928;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c - 272.15;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c - 457.87;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                            editText1.setText(String.valueOf(f));

                        }else if (btID == 2) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = c/1000;
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c*39.3701;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = c*1000;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c*39370.1;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c/39.3701;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c/39370.1;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                            editText1.setText(String.valueOf(f));

                        }else if (btID == 3) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = c*1.60934;
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c*0.44704;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = c*0.621371;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c*0.277778;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c*2.23694;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c*3.6;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                            editText1.setText(String.valueOf(f));

                        }else if (btID == 4) {
                            if (list1ID == 11 && list2ID == 21) {
                                f = c;
                            } else if (list1ID == 11 && list2ID == 22) {
                                f = c*0.453592;
                            } else if (list1ID == 11 && list2ID == 23) {
                                f = c*453.592;
                            } else if (list1ID == 12 && list2ID == 21) {
                                f = c*2.20462;
                            } else if (list1ID == 12 && list2ID == 22) {
                                f = c;
                            } else if (list1ID == 12 && list2ID == 23) {
                                f = c*1000;
                            } else if (list1ID == 13 && list2ID == 21) {
                                f = c*0.00220462;
                            } else if (list1ID == 13 && list2ID == 22) {
                                f = c/1000;
                            } else if (list1ID == 13 && list2ID == 23) {
                                f = c;
                            }
                        }
                        editText1.setText(String.valueOf(f));
                    }
                    else {
                        editText1.setText("");
                    }
                    machine_changed_edittext = false;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ///////////////////////////////////////////////////

        ///////////////////////////////////////////////////
        /////////////////////////////////////////////////////

        Intent nextIntent = getIntent();
        btID = nextIntent.getIntExtra("btnID" , 1);

        String list11= "   ", list12= "    ", list13= "   ", list21 = "   ", list22= "   ", list23= "   ";
        if( btID == 1) {


        //    editText1.setHint("Temperature in Celsius");
        //    editText2.setHint("Temperature in fahrenheit ");

             list11 = list21 = "Celsius";
              list12 = list22 =  "Fahrenheit";
              list13 = list23 = "Kelvin";



        }


        else if( btID == 2){
         //   editText1.setHint("Length in Meter");
         //   editText2.setHint("Length in km");

            list11 = list21 = "Meter";
            list12 = list22 =  "Km";
            list13 = list23 = "Inch";

        }

        else if( btID == 3){
         //   editText1.setHint("Speed in mile/hour");
          //  editText2.setHint("Speed in km/hour");

            list11 = list21 = "mile/hour";
            list12 = list22 =  "km/hour";
            list13 = list23 = "m/s";

        }
        else if( btID == 4){
         //   editText1.setHint("Weight in Pounds");
          //  editText2.setHint("Weight in Kg");

            list11 = list21 = "Pound";
            list12 = list22 =  "Kg";
            list13 = list23 = "gram";

        }

        Log.d("Array value:" , String.valueOf(btID));
        Log.d("Array value:" , String.valueOf(list1ID));
        Log.d("Array value:" , String.valueOf(list2ID));
        String[] paths1 = {list11, list12, list13};
        String[] paths2 = {list21 , list22 , list23};
        mSpinner1 = (Spinner) findViewById(R.id.spinner1);
        mSpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(CalActivity.this, android.R.layout.simple_spinner_item, paths1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner1.setAdapter(adapter1);
        mSpinner1.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(CalActivity.this, android.R.layout.simple_spinner_item, paths2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner2.setAdapter(adapter2);
        mSpinner2.setOnItemSelectedListener(this);

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////




      //  calb = (Button)findViewById(R.id.calButton);
      //  calb.setOnClickListener(this);


     //   editText1.setText("");
     //   editText2.setText("");

        ///////////////////

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case (R.id.clrbtn):
                editText1.setText("");
                editText2.setText("");
        }

 //      if (TextUtils.isEmpty(editText1.getText().toString())
//            /*    || TextUtils.isEmpty(editText2.getText().toString() */) {
 //           return;
 //       }
/*        double e1 = 0;
        double e2 = 0;
        String output;



            //  e1 = Double.parseDouble(ett1.getText().toString());
            //  e2 = Double.parseDouble(ett2.getText().toString());


            e1 = Double.parseDouble(editText1.getText().toString());
            //  e2 = Double.parseDouble(editText2.getText().toString());
            output = Double.toString(e2);
            // editText2.setText(output);




        if( btID == 1) {

            e2 = (e1 * 1.8) + 32;
            output = Double.toString(e2);
            editText1.append(" C");
            editText2.setText(output+" F");
        }


       else if( btID == 2){
            e2 = e1/1000;
            output = Double.toString(e2);
            editText1.append(" m");

            editText2.setText(output+" km");

        }

        else if( btID == 3){
            e2 = e1*1.60934;
            output = Double.toString(e2);
            editText1.append(" mile/hour");

            editText2.setText(output+" km/hour");
        }
        else if( btID == 4){
            e2 = e1*0.453592;
            output = Double.toString(e2);
            editText1.append(" Pound");

            editText2.setText(output+ " kg");


        }

*/



    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        editText1.setText("");
        editText2.setText("");
        switch (parent.getId()) {
            case (R.id.spinner1):
                switch (position) {
                    case (0):
                        list1ID = 11;
                        break;
                    case (1):
                       // editText2.setText("brrrrrrrrrrrrr!!!!");
                        list1ID = 12;
                        break;
                    case (2):
                        list1ID = 13;
                        break;

                }
                break;

            case (R.id.spinner2):
                switch (position){

                    case  (0):
                        list2ID = 21;
                    break;
                    case (1):
                        list2ID = 22;
                        break;
                    case (2):
                        list2ID = 23;
                     //   editText2.setText("BREAKKKKKKK!!");
                        break;
            }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}








