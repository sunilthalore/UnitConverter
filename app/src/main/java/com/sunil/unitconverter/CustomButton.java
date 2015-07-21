package com.sunil.unitconverter;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 7/14/2015.
 */
public class CustomButton extends AppCompatActivity implements DialogInterface.OnClickListener{

    EditText JET1, JET2, JET3;
    TextView textView;
    SQLiteDatabase db;
    Button JInsertButton, JDeleteAll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        JET1 = (EditText) findViewById(R.id.cet1);
        JET2 = (EditText) findViewById(R.id.cet2);
        JET3 = (EditText) findViewById(R.id.cet3);
        textView = (TextView) findViewById(R.id.textview);
        JInsertButton = (Button) findViewById(R.id.insertButton);
        JDeleteAll = (Button) findViewById(R.id.deleteButton);
        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        db.execSQL("create table if not exists mytable(sym1 varchar, sym2 varchar, relation varchar)");

        JInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sym1 = JET1.getText().toString();
                String sym2 = JET2.getText().toString();
                String relation = JET3.getText().toString();
                db.execSQL("insert into mytable values('"+sym1+"','"+sym2+"','"+relation+"')");
                Toast.makeText(CustomButton.this, "Formula successfully added", Toast.LENGTH_SHORT).show();

                Cursor c = db.rawQuery("select *from mytable",null);
                textView.setText("");
                c.moveToFirst();
                do{
                    sym1 = c.getString(c.getColumnIndex("sym1"));
                    sym2 = c.getString(1);
                    relation = c.getString(2);
                    textView.append(sym1 + "  vs  " + sym2 + "_______" + relation + "\n");
                } while (c.moveToNext());
            }
        });

        JDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("drop table mytable");
                textView.setText("");
                Toast.makeText(CustomButton.this,"Table Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
