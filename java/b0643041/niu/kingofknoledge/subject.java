package b0643040.niu.kingofknoledge;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class subject extends AppCompatActivity {
    Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6;
    TextView mTextView;
    int Mode, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mButton1 = (Button)findViewById(R.id.button11);
        mButton2 = (Button)findViewById(R.id.button10);
        mButton3 = (Button)findViewById(R.id.button12);
        mButton4 = (Button)findViewById(R.id.button14);
        mButton5 = (Button)findViewById(R.id.button13);
        mButton6 = (Button)findViewById(R.id.button15);
        mTextView = (TextView)findViewById(R.id.textView5);

        Intent intent5 = getIntent();
        Mode = intent5.getIntExtra("Mode",0);
        if(Mode == 0){
            mTextView.setText("MODE ONE");
        }else if(Mode == 1){
            mTextView.setText("MODE TWO");
        }else if(Mode == 2){
            mTextView.setText("MODE THREE");
        }

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = 0;
                golevel();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = 1;
                golevel();
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = 2;
                golevel();
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = 3;
                golevel();
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = 4;
                golevel();
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = 5;
                golevel();
            }
        });
    }

    private void golevel(){
        Bundle bundle = new Bundle();
        bundle.putInt("Mode", Mode);
        bundle.putInt("Sub", sub);
        Intent intent6 = new Intent(subject.this, level.class);
        intent6.putExtras(bundle);
        startActivity(intent6);
    }
}
