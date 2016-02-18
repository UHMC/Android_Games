package educybersecurity.hawaii.maui.securityquizzer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
//import java.lang.Thread;

/**
 * A full-screen splash activity
 */
public class SplashActivity extends AppCompatActivity {
    /**
     * Some older devices need a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */

    private static final int UI_ANIMATION_DELAY = 300;
    private static final int SPLASH_DELAY=1000;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Trigger the initial hide()
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postAtFrontOfQueue(mHideRunnable);
        //CHECK IF FIRST TIME RUNNING
        //SPLASH DELAY

        /*try{Thread.sleep(SPLASH_DELAY);} //bad idea -- no sleeping the UI thread
        catch(InterruptedException e){e.printStackTrace();}*/

        SharedPreferences config = getPreferences(MODE_PRIVATE);
        boolean hasRun = config.getBoolean("hasRun",false);

        // First time run shows preference file as false, running this block
        if(hasRun == false) {
            Context context = getApplicationContext();
            CharSequence text = "First time running this application!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            // Stage changes to preference file to true
            SharedPreferences.Editor editor = config.edit();
            editor.putBoolean("hasRun", true);
            // Commit them
            editor.commit();
        }

        // If preference file shows true, runs this block instead
        if(hasRun == true) {
            Context context = getApplicationContext();
            CharSequence text = "Application already ran!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        /*mHideHandler.postDelayed(new Runnable(){

            @Override
            public void run(){
                //IF FIRST TIME, OPEN TUTORIAL-START ACTIVITY
                //ELSE OPEN ENTRY ACTIVITY
                Intent activity=new Intent(SplashActivity.this,hasRun?MainEntryActivity.class:TutorialEntryActivity.class);
                SplashActivity.this.startActivity(activity);
                //FINISH
                finish();
            }
        },SPLASH_DELAY);


        try{Thread.sleep(2000);}
        catch(InterruptedException e){}
        finish(); */

        mHideHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000);
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }
}
