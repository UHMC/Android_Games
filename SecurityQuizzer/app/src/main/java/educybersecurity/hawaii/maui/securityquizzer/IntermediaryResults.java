package educybersecurity.hawaii.maui.securityquizzer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileReader;

public class IntermediaryResults extends AppCompatActivity {
    private final static Class NEXT_ACTIVITY=Question4.class;
    private final static String ACTION_FINISH_QUIZ="educybersecurity.hawaii.maui.securityquizzer.ACTION_FINISH_QUIZ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediary_results);
        float numberCorrect = 0;
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                unregisterReceiver(this);
                finish();
            }
        }, new IntentFilter(ACTION_FINISH_QUIZ));


        TextView[] questionResult = new TextView[3];
        questionResult[0] = (TextView) findViewById(R.id.textView6);
        questionResult[1] = (TextView) findViewById(R.id.textView7);
        questionResult[2] = (TextView) findViewById(R.id.textView8);
        TextView percentCorrect = new TextView(this);
        percentCorrect = (TextView) findViewById(R.id.textView9);

        File file = new File(getFilesDir().getPath().toString() + "/score.txt");
        FileReader fr;
        char[] score;
        score = new char[5];

        try {
            fr = new FileReader(file);
            fr.read(score);
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            String question = Integer.toString(i+1);
            if (score[i] == '0') {
                questionResult[i].setText("Question " + question + " was incorrect, sorry!");


            } else {
                questionResult[i].setText("Question " + question + " was correct!");
                numberCorrect++;
            }
        }
        float percentScore = (numberCorrect/3)*100;
        percentCorrect.setText(String.format("%.1f", percentScore) + "%");


    }
    public void mainMenu(View unused){
        this.startActivity(new Intent(this, NEXT_ACTIVITY));
    }
}
