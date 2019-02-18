package com.example.leo.meowgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ImageView card1,card2,card3;
    TextView txt1;
    ArrayList mCards;

    Random random;
    Integer RamdonNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCards = new ArrayList<ImageView>();

        card1 = (ImageView)findViewById(R.id.card1);
        mCards.add(card1);
        card2 = (ImageView)findViewById(R.id.card2);
        mCards.add(card2);
        card3 = (ImageView)findViewById(R.id.card3);
        mCards.add(card3);

        button1 = (Button)findViewById(R.id.button1);
        txt1 = (TextView)findViewById(R.id.txt1);
        random = new Random();

        //button onclick
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<3;i++){
                    ImageView card = (ImageView)mCards.get(i);
                    card.setImageResource(R.drawable.card);
                }

                RamdonNum = random.nextInt(3);
                txt1.setText("" + RamdonNum);
            }
        });

        //card onclick
        ImageView card;
        for(int i=0;i<3;i++){
            card = (ImageView)mCards.get(i);
            card.setTag(i);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //卡號
                    int chosenCardNum = (int)view.getTag();

                    selectCard(chosenCardNum);
                }
            });
        }
    }

    public void selectCard(int chosenCardNum) {
        //選的那張卡                                       arraylist.get
        ImageView card = (ImageView)mCards.get(chosenCardNum);

        //只能抽一張
        if(RamdonNum!=99){
            //比對選的卡號跟ramdon改圖
            if(chosenCardNum == RamdonNum)
                card.setImageResource(R.drawable.cat);
            else
                card.setImageResource(R.drawable.dog);
        }
        RamdonNum = 99;
    }
}
