package com.example.mixnativeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int OVERLAY_PERMISSION_REQ_CODE = 1;  // Choose any value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        // Set up the intent
        Intent i = new Intent(getApplicationContext(), ReactMainActivity.class);
//        // Launch It
        startActivity(i);
//        Toast.makeText(MainActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();

    }



}
