package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Player representation
    // 0 - X
    // 1 - O
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // State meanings:
    //    0 - X
    //    1 - O
    //    2 - Null
    // put all win positions in a 2D array
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveInput(View v){
        int id = R.id.txtView;
        TextView tV = findViewById(id);
        Button b = (Button) v;
        int tappedPos = Integer.parseInt(b.getTag().toString());

        String turn = String.valueOf(tV.getText());
        if (turn.contains("X")) {
            b.setText("X");
            b.setEnabled(false);
            gameState[tappedPos] = 0;
            tV.setText("Turno di O");
        } else {
            b.setText("O");
            b.setEnabled(false);
            gameState[tappedPos] = 1;
            tV.setText("Turno di X");
        }

        counter++;

        checkGameResult();
    }

    public void reset(){
        GridLayout grid = findViewById(R.id.grid);
        for(int i=0; i<9; i++){
            Button b = (Button) grid.getChildAt(i);
            if(!b.isEnabled()) b.setEnabled(true);
            b.setText("");
            gameState[i] = 2;
        }
        counter = 0;
    }

    public void checkGameResult(){
        int flag = 0;

        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;
                // Someone Won
                if (gameState[winPosition[0]] == 0) {
                    TextView p1 = findViewById(R.id.player1);
                    int score1 = Integer.parseInt(p1.getText().toString());
                    p1.setText(String.valueOf(++score1));
                    Toast.makeText(this, "X has Won!", Toast.LENGTH_LONG).show();
                } else {
                    TextView p2 = findViewById(R.id.player2);
                    int score2 = Integer.parseInt(p2.getText().toString());
                    p2.setText(String.valueOf(++score2));
                    Toast.makeText(this, "O has Won!", Toast.LENGTH_LONG).show();
                }
                reset();
            }
        }
        // Draw
        if (counter == 9 && flag == 0) {
            Toast.makeText(this, "It's a Draw!", Toast.LENGTH_LONG).show();
            reset();
        }
    }

    public void resetGame(View v){
        TextView p1 = findViewById(R.id.player1);
        p1.setText("0");
        TextView p2 = findViewById(R.id.player2);
        p2.setText("0");
        reset();
    }
}