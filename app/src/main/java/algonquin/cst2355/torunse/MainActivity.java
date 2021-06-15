package algonquin.cst2355.torunse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private static String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginBtn = findViewById(R.id.nextPageButton);
        Log.w("MainActivity", "In onCreate() - Loading Widgets");

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String emailAdd = prefs.getString("Email", "");
        EditText emailEdit = findViewById(R.id.emailText);
        emailEdit.setText(emailAdd);
        loginBtn.setOnClickListener(clk -> {

            Intent nextPage = new Intent(MainActivity.this,SecondActivity. class);
            SharedPreferences.Editor editor = prefs.edit();
            nextPage.putExtra("EmailAddress", emailEdit.getText().toString());
            editor.putString("Email", emailEdit.getText().toString());
            editor.apply();
            startActivity(nextPage);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"In onDestroy() - Any memory used by the application is freed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"In onPause() - The application no longer responds to user input");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"In onResume() - The application is now responding to user input");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"In onStart() - The application is now visible on screen");
    }
}