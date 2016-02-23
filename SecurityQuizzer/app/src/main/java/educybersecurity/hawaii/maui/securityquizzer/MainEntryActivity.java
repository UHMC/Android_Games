package educybersecurity.hawaii.maui.securityquizzer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainEntryActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void launch(View view) {

        switch (view.getId()) {
            case R.id.quiz:
                // placeholder for quiz activity
                Log.e("test", "This would run the quiz activity");
                break;
            case R.id.study:
                // placeholder for study activity
                Log.e("test", "This would run the study activity");
                break;
            case R.id.selectQuiz:
                // placeholder for select quiz activity
                Log.e("test", "This would run the select quiz activity");
                break;
        }
    }
}


