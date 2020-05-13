package com.harun.androidkonfetiefektiprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

// https://harun.xyz/
public class MainActivity extends AppCompatActivity {

    private Button buttonKonfetiPatlat;
    private KonfettiView viewKonfetti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonKonfetiPatlat = findViewById(R.id.buttonKonfetiPatlat);
        viewKonfetti = findViewById(R.id.viewKonfetti);

        buttonKonfetiPatlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Runnable olarak çalıştırıyoruz diğer işlemlere engel olmasın
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        viewKonfetti.build()
                                .addColors(getResources().getColor(R.color.konfeti_sari), getResources().getColor(R.color.konfeti_yesil), getResources().getColor(R.color.konfeti_mor)) //Renkleri belirleme
                                .setDirection(0.0, 500.0)
                                .setSpeed(1f, 5f)
                                .setFadeOutEnabled(true)
                                .setTimeToLive(4000L)
                                .addShapes(Shape.RECT, Shape.CIRCLE)
                                .addSizes(new Size(11, 11f))
                                .setPosition(500f, 500f, -200f, -200f)
                                .streamFor(300, 5000L);

                    }
                });

            }
        });

    }



}
