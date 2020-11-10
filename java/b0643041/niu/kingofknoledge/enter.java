package b0643040.niu.kingofknoledge;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class enter extends AppCompatActivity {
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        handler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000);
    }
    private static final int GOTO_MAIN_ACTIVITY = 0;
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent();
                    intent.setClass(enter.this, menu.class);
                    startActivity(intent);
                    finish();
                    break;
                default:
                    break;
            }
        }
    };
}
