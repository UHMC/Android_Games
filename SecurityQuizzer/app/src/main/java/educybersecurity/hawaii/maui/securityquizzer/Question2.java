package educybersecurity.hawaii.maui.securityquizzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Question2 extends AppCompatActivity {
    private final static short WHICH_QUESTION=2;
    private final static Class NEXT_ACTIVITY=Question3.class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Question 2");
    }
    public void incorrect(View unused){
        //store value
        FileWriter fw;
        FileReader fr;
        File file = new File(getFilesDir().getPath().toString()+"/score.txt");
        char[] score;
        score = new char[5];


        try{
            // Read the file and make into char array
            fr = new FileReader(file);
            fr.read(score);
            fr.close();
            // Edit the index of the character array corresponding to the current question
            fw = new FileWriter(file,false);
            score[WHICH_QUESTION-1] = '0';
            fw.write(score);
            String debug = new String(score);
            Log.e("test", debug);
            fw.flush();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //launch activity
        this.startActivity(new Intent(this,NEXT_ACTIVITY));
    }
    public void correct(View unused){
        //store value
        FileWriter fw;
        FileReader fr;
        File file = new File(getFilesDir().getPath().toString()+"/score.txt");
        char[] score;
        score = new char[5];


        try{
            // Read the file and make into char array
            fr = new FileReader(file);
            fr.read(score);
            fr.close();
            // Edit the index of the character array corresponding to the current question
            fw = new FileWriter(file,false);
            score[WHICH_QUESTION-1] = '1';
            fw.write(score);
            String debug = new String(score);
            Log.e("test",debug);
            fw.flush();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //launch activity
        this.startActivity(new Intent(this,NEXT_ACTIVITY));
    }
}
