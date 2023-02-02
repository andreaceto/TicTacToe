package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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