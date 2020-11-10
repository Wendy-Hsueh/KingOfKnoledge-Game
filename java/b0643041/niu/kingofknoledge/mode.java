package b0643040.niu.kingofknoledge;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mode extends AppCompatActivity {
    Button mButton1, mButton2, mButton3, mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mButton1 = (Button)findViewById(R.id.button4);
        mButton2 = (Button)findViewById(R.id.button5);
        mButton3 = (Button)findViewById(R.id.button6);
        mButton4 = (Button)findViewById(R.id.button7);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(mode.this, subject.class);
                intent4.putExtra("Mode", 0);
                startActivity(intent4);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(mode.this, subject.class);
                intent4.putExtra("Mode", 1);
                startActivity(intent4);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(mode.this, subject.class);
                intent4.putExtra("Mode", 2);
                startActivity(intent4);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(mode.this, pinenter.class);
                startActivity(intent4);
            }
        });
    }
}
