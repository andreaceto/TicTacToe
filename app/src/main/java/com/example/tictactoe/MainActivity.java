package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveInput(View v){
        int id = R.id.txtView;
        TextView tV = findViewById(id);
        Button b = (Button) v;

        String turn = String.valueOf(tV.getText());
        if (turn.contains("X")) {
            b.setText("X");
            b.setEnabled(false);

            tV.setText("Turno di O");
        } else {
            b.setText("O");
            b.setEnabled(false);

            tV.setText("Turno di X");
        }
    }

    public void reset(View v){
        GridLayout grid = findViewById(R.id.grid);
        for(int i=0; i<9; i++){
            Button b = (Button) grid.getChildAt(i);
            if(!b.isEnabled()) b.setEnabled(true);
            b.setText("");
        }
    }
}