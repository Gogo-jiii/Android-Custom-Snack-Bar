package com.example.customsnackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnShowCustomSnackBar;
    View customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowCustomSnackBar = findViewById(R.id.btnShowCustomSnackBar);

        customView = getLayoutInflater().inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.rootLayout));

        btnShowCustomSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE);
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

                Button button = customView.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Dismiss.", Toast.LENGTH_SHORT).show();
                        snackbar.dismiss();
                    }
                });

                snackbarLayout.addView(customView, 0);
                snackbar.show();

            }
        });


    }
}