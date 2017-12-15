package queralt_lluis.attendanceapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    // Duration of splash screen (ms)
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Start next activity
                Intent list_activity_intent = new Intent().setClass(
                        SplashScreenActivity.this, ListActivity.class);
                startActivity(list_activity_intent);

                // Close the activity
                finish();
            }
        };

        // Simulate loading process on startup
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
