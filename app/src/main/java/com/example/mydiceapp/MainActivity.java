package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imageView2);
        final ImageView diceImage2 = findViewById(R.id.imageView3);

        int [] diceImages = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3, R.drawable.dice4,R.drawable.dice5, R.drawable.dice6};

        int myBox = 10;

        float myFloatBox = 4.2f;

        double myDoubleBox = 3.34578923;

        Button btnTag = findViewById(R.id.rollButton);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        btnTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyDiceApp", "Dice Rolled!");
                mp.start();
                Random rndObject = new Random();
                Random rndObject2 = new Random();

                int myRandomNumber = rndObject.nextInt(6);
                int myRandomNumber2 = rndObject2.nextInt(6);

                Log.i("MyDiceApp", "The generated random number is " + myRandomNumber + "");



                diceImage1.setImageResource(diceImages[myRandomNumber]);
                diceImage2.setImageResource(diceImages[myRandomNumber2]);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage2);
            }
        });

    }
}