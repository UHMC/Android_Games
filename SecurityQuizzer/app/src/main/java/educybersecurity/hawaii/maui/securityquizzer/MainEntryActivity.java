package educybersecurity.hawaii.maui.securityquizzer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;

public class MainEntryActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Security Quizzer!");
    }

    public void launch(View view) {
        Intent activity = null;
        switch (view.getId()) {
            case R.id.quiz:
                // placeholder for quiz activity
                Log.e("test", "This would run the quiz activity");
                activity = new Intent(this, Question1.class);
                break;
            case R.id.study:
                // placeholder for study activity
                Log.e("test", "This would run the study activity");
                this.startActivity(new Intent(this,TutorialEntryActivity.class));
          /*      String FILENAME = "test_file";
                String string = "00000";

                try {
                    FileOutputStream fos = openFileOutput(FILENAME, MODE_PRIVATE);
                    fos.write(string.getBytes());
                    fos.close();

                    FileInputStream fis = openFileInput(FILENAME);
                    String read = fis.read();
                    Log.e("test",read);
                }
                catch (Exception e){
                e.printStackTrace();
            }*/
        }
        try {
            startActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}