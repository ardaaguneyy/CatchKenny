package com.example.kennyyakala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;



public class MainActivity extends AppCompatActivity {
TextView skor;
TextView zaman;
ImageView imageView;
int a = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skor = findViewById(R.id.skor);
        zaman = findViewById(R.id.zaman);
        imageView = findViewById(R.id.imageView);
        Toast.makeText(getApplicationContext(),"BAŞLADI    Arda Guney ",Toast.LENGTH_SHORT).show();
        new CountDownTimer(30000,1000){
            @Override
            public void onTick(long millisUntilFinished) {

                zaman.setText("Kalan süre: "+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                imageView.setEnabled(false);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Tekrar denemek ister misin ");
                alert.setMessage("Tekrar dene");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                     Intent intent = getIntent();
                     finish();
                     startActivity(intent);


                    }
                });
                alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        System.exit(0);
                    }
                });alert.show();
            }
        }.start();
    }
       public void kenny(View view){
        a++;
           skor.setText("Skor:" +a);
               Random random = new Random();
               int b = random.nextInt(700) - 350;
               imageView.setTranslationX(b);
               Random random2 = new Random();
               int c = random2.nextInt(800) - 400;
               imageView.setTranslationY(c);
        }
}



