package com.hfad.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToe extends AppCompatActivity {
    //yellow=0 red=1 empty=2
    int p=0;
    int[] state={2,2,2,2,2,2,2,2,2};
    int[] [] winpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean game=true;

    public void clk(View view) {
        ImageView imgv = (ImageView) view;
        int tap = Integer.parseInt(imgv.getTag().toString());
        if (state[tap]==2 && game ) {
            state[tap] = p;
            if (p == 0) {
                imgv.setImageResource(R.drawable.yellow);
                imgv.animate().alpha(1).setDuration(2000);
                p = 1;
            } else if (p == 1) {
                imgv.setImageResource(R.drawable.red);
                imgv.animate().alpha(1).setDuration(2000);
                p = 0;
            }

            for (int[] win : winpos) {
                if (state[win[0]] == state[win[1]] && state[win[1]] == state[win[2]] && state[win[0]] != 2) {
                    String winner;
                    game=false;
                    if (state[win[0]] == 1) {
                        winner = "RED";

                    } else {
                        winner = "YELLOW";
                    }
                    Button button5=(Button) findViewById(R.id.button5);
                    TextView winner1=(TextView) findViewById(R.id.textView);
                    winner1.setText(winner +" has won!");
                    button5.setVisibility(View.VISIBLE);
                    winner1.setVisibility(View.VISIBLE);

                }

            }
        }
    }

    public void button5(View view) {

        Button button5=(Button) findViewById(R.id.button5);
        TextView winner1=(TextView) findViewById(R.id.textView);

       button5.setVisibility(View.INVISIBLE);
        winner1.setVisibility(View.INVISIBLE);

  GridLayout gri =  (GridLayout) findViewById(R.id.grid);


        for(int i = 0; i< gri.getChildCount(); i++) {

           ImageView counter = (ImageView) gri.getChildAt(i);

            counter.setImageDrawable(null);

        }
        p=0;
        for(int i=0;i<state.length;i++){
            state[i]=2;
        }
        game=true;


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }
}
