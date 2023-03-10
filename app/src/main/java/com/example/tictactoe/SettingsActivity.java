package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    //Pop-up views
    private EditText editTxtP1, editTxtP2;
    private Button saveBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            Button b = findViewById(R.id.themeSwitchBtn);
            b.setText("Light Theme");
        }
    }

    public void switchTheme(View v){
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    public void editPlayers(View v){

        createEditPlayersDialog();

        dialog.show();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> playerNames = new ArrayList<>();
                playerNames.add(editTxtP1.getText().toString());
                playerNames.add(editTxtP2.getText().toString());

                Intent intent = new Intent();
                intent.putStringArrayListExtra("playerNames", playerNames);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    public void createEditPlayersDialog(){

        dialogBuilder = new AlertDialog.Builder(this);
        final View editPlayersPopUp = getLayoutInflater().inflate(R.layout.edit_players_popup,null);

        editTxtP1 = editPlayersPopUp.findViewById(R.id.editTxtP1);
        editTxtP2 = editPlayersPopUp.findViewById(R.id.editTxtP2);

        saveBtn = editPlayersPopUp.findViewById(R.id.saveBtn);
        cancelBtn = editPlayersPopUp.findViewById(R.id.cancelBtn);

        dialogBuilder.setView(editPlayersPopUp);
        dialog = dialogBuilder.create();

    }
}