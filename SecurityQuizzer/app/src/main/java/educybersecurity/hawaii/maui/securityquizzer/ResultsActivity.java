package educybersecurity.hawaii.maui.securityquizzer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create array of TextViews
        TextView[] questionResult = new TextView[5];
        questionResult[0] = (TextView) findViewById(R.id.textView2);
        questionResult[1] = (TextView) findViewById(R.id.textView3);
        questionResult[2] = (TextView) findViewById(R.id.textView4);
        questionResult[3] = (TextView) findViewById(R.id.textView5);
        questionResult[4] = (TextView) findViewById(R.id.textView6);

        // Necessary stuff for I/O-ing score.txt
        File file = new File(getFilesDir().getPath().toString() + "/score.txt");
        FileReader fr;
        char[] score;
        score = new char[5];

        // Reads from score.txt and sends to score char array
        try {
            fr = new FileReader(file);
            fr.read(score);
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Systematically sets the text for each TextView in the array, depending on whether it's correct or incorrect
        for (int i = 0; i < 5; i++) {
            String question = Integer.toString(i+1);
            if (score[i] == '0') {
                questionResult[i].setText("Question " + question + " was incorrect, sorry!");
            } else {
                questionResult[i].setText("Question " + question + " was correct!");
            }
        }
    }

}
