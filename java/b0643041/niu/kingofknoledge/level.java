package b0643040.niu.kingofknoledge;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class level extends AppCompatActivity {
    TextView mTextView;
    String TitSub[] = {"國語", "數學", "英文", "自然", "社會", "生活"};
    String StrMODE;
    int Mode, Sub;
    Button mButton1, mButton2, mButton3;
    int Lev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Mode = bundle.getInt("Mode");
        if(Mode == 0) StrMODE="ONE";
        else if(Mode == 1) StrMODE = "TWO";
        else if(Mode == 2) StrMODE = "THREE";
        Sub = bundle.getInt("Sub");

        mTextView = (TextView)findViewById(R.id.textView7);
        mTextView.setText("MODE " + StrMODE + " -- " + TitSub[Sub]);

        mButton1 = (Button)findViewById(R.id.button3);
        mButton2 = (Button)findViewById(R.id.button8);
        mButton3 = (Button)findViewById(R.id.button9);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lev = 0;
                startgame();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lev = 1;
                startgame();
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lev = 2;
                startgame();
            }
        });
    }
    private void startgame(){
        Bundle bundle2 = new Bundle();
        bundle2.putInt("Mode", Mode);
        bundle2.putInt("Sub", Sub);
        bundle2.putInt("Lev", Lev);
        Intent intent7 = new Intent(level.this, game.class);
        intent7.putExtras(bundle2);
        startActivity(intent7);
    }
}
