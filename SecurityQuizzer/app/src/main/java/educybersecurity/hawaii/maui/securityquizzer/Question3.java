package educybersecurity.hawaii.maui.securityquizzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Question3 extends AppCompatActivity {
    private final static short WHICH_QUESTION=3;
    private final static Class NEXT_ACTIVITY=Question4.class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void incorrect(View unused){
        //store value
        //launch activity
        this.startActivity(new Intent(this,NEXT_ACTIVITY));
    }
    public void correct(View unused){
        //store value
        //launch activity
        this.startActivity(new Intent(this,NEXT_ACTIVITY));
    }
}
