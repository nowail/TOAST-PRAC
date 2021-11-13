package com.example.toast_prac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mbutton ;
        mbutton= (Button) findViewById(R.id.button);
        Button mbutton2 ;
        mbutton2= (Button) findViewById(R.id.button2);
        Button mbutton3 ;
        mbutton3= (Button) findViewById(R.id.button3);
        Button mbutton4 ;
        mbutton4= (Button) findViewById(R.id.button4);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast toast = Toast.makeText(this, "Toast Text",Toast.LENGTH_LONG);// error
                Toast toast=Toast.makeText(MainActivity.this, "Toast Text", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showtoast();
            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialog(v);
            }
        });
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1(v);
            }
        });
    }

    public void showtoast() {
        LayoutInflater layoutInflater = getLayoutInflater();

        View myLayout=layoutInflater.inflate(R.layout.m_layout,(ViewGroup)findViewById(R.id.toast_root) );

        ImageView cameraIamge=myLayout.findViewById(R.id.imageView);

        cameraIamge.setImageResource(R.drawable.ic_toasticon);

        TextView myMessage=(TextView)myLayout.findViewById(R.id.textView);

        myMessage.setText("My Custom Toast");

        Toast myToast=new Toast(getApplicationContext());

        myToast.setDuration(Toast.LENGTH_LONG);

        myToast.setView(myLayout);

        myToast.show();
    }
    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("It is message");
        builder.setTitle("Title");
        builder.setCancelable(false);
        builder.setPositiveButton(
                "Positive Button",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int asdf)
                    {
                        finish();
                    }
                });
        builder.setNegativeButton(
                "cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void showDialog1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_toasticon)

                .setTitle("Test Dialog")

                .setMessage("Do you want to leave us")

                .setPositiveButton("Leave", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        finish();

                    }

                })

                .setNegativeButton("Stay", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }

                })

                .setNeutralButton("What up", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(), "Click Leave to close and Stay to cancel",
                                Toast.LENGTH_LONG).show();

                    }

                }).show();
    }

}

