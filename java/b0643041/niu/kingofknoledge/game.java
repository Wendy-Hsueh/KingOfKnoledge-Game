package b0643040.niu.kingofknoledge;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;


public class game extends AppCompatActivity {
    TextView mTextView1, mTextView2;
    Button mButton1;
    Timer timer = new Timer();
    ImageView miv1,miv2,miv3,miv4,miv5,miv6,miv7,miv8,miv9,miv10;
    ImageView miv11,miv12,miv13,miv14,miv15,miv16;
    int []card = {R.drawable.eng_1_3,R.drawable.eng_2_3,R.drawable.eng_3_3,R.drawable.eng_4_3,R.drawable.eng_5_3,
            R.drawable.eng_6_3,R.drawable.eng_7_3,R.drawable.eng_8_3,R.drawable.eng_1_3,R.drawable.eng_2_3,
            R.drawable.eng_3_3,R.drawable.eng_4_3,R.drawable.eng_5_3,R.drawable.eng_6_3,R.drawable.eng_7_3,R.drawable.eng_8_3};
    int []issame = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};
    boolean[] bool = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    int flop1,flop2,btncount = 0,time = 0, end = 0;
    ImageView fiv1,fiv2;
    MediaPlayer mp = new MediaPlayer();
    int Mode, Sub, Lev;
    int lastLev = 2;
    String TitSub[] = {"國語", "數學", "英文", "自然", "社會", "生活"};
    String TitMod[] = {"MODE ONE", "MODE TWO", "MODE THREE"};
    String imgSub[] = {"國語", "數學", "eng_", "自然", "社會", "生活"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Mode = bundle.getInt("Mode");
        Sub = bundle.getInt("Sub");
        Lev = bundle.getInt("Lev");
        setcard();

        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView9);
        mButton1 = (Button) findViewById(R.id.button1);
        miv1 = (ImageView) findViewById(R.id.imageView1);
        miv2 = (ImageView) findViewById(R.id.imageView2);
        miv3 = (ImageView) findViewById(R.id.imageView3);
        miv4 = (ImageView) findViewById(R.id.imageView4);
        miv5 = (ImageView) findViewById(R.id.imageView5);
        miv6 = (ImageView) findViewById(R.id.imageView6);
        miv7 = (ImageView) findViewById(R.id.imageView7);
        miv8 = (ImageView) findViewById(R.id.imageView8);
        miv9 = (ImageView) findViewById(R.id.imageView9);
        miv10 = (ImageView) findViewById(R.id.imageView10);
        miv11 = (ImageView) findViewById(R.id.imageView11);
        miv12 = (ImageView) findViewById(R.id.imageView12);
        miv13 = (ImageView) findViewById(R.id.imageView13);
        miv14 = (ImageView) findViewById(R.id.imageView14);
        miv15 = (ImageView) findViewById(R.id.imageView15);
        miv16 = (ImageView) findViewById(R.id.imageView16);

        mTextView2.setText(TitMod[Mode] + " / " + TitSub[Sub] + " / Level" + (Lev+1));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);

            }
        },0,200);
        for (int i = 0;i < 10000;i++)
        {
            int shuffle = (int)(Math.random()*16);
            int c = card[shuffle];
            int s = issame[shuffle];
            card[shuffle] = card[0];
            issame[shuffle] = issame[0];
            card[0] = c;
            issame[0] = s;
        }
        miv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv1,0); }
        });
        miv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv2,1); }
        });
        miv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv3,2);}
        });
        miv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv4,3);}
        });
        miv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv5,4);}
        });
        miv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv6,5);}
        });
        miv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv7,6);}
        });
        miv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv8,7);}
        });
        miv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv9,8);}
        });
        miv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv10,9);}
        });
        miv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv11,10);}
        });
        miv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv12,11);}
        });
        miv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv13,12);}
        });
        miv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv14,13);}
        });
        miv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv15,14);}
        });
        miv16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { animation(miv16,15);}
        });
    }
    private void animation(final ImageView img,final int ivValue)
    {
        Animation animation = AnimationUtils.loadAnimation(game.this,R.anim.back);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if (!bool[ivValue]) {
                    img.setImageResource(card[ivValue]);
                    bool[ivValue] = true;
                }
                img.startAnimation(AnimationUtils.loadAnimation(game.this,R.anim.front));
                btncount++;
                if(btncount ==1){
                    fiv1 = img;
                    flop1 = ivValue;
                    img.setEnabled(false);
                }
                else if (btncount == 2){
                    fiv2 = img;
                    flop2 = ivValue;
                    miv1.setEnabled(false);
                    miv2.setEnabled(false);
                    miv3.setEnabled(false);
                    miv4.setEnabled(false);
                    miv5.setEnabled(false);
                    miv6.setEnabled(false);
                    miv7.setEnabled(false);
                    miv8.setEnabled(false);
                    miv9.setEnabled(false);
                    miv10.setEnabled(false);
                    miv11.setEnabled(false);
                    miv12.setEnabled(false);
                    miv13.setEnabled(false);
                    miv14.setEnabled(false);
                    miv15.setEnabled(false);
                    miv16.setEnabled(false);
                }
            }
        });
        img.startAnimation(animation);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                mTextView1.setText("遊戲時間:"+(time++)/5+"s");
                if(btncount == 3){
                    if(issame[flop1] == issame[flop2]){
                        fiv1.setVisibility(View.INVISIBLE);
                        fiv2.setVisibility(View.INVISIBLE);
                        end++;
                        mp = MediaPlayer.create(game.this,R.raw.o);
                        if(card.length/2 == end){
                            timer.cancel();
                            mTextView1.setText("遊戲結束! 紀錄時間:"+time/5+"s");
                            AlertDialog.Builder altDlgBuilder = new AlertDialog.Builder(game.this);
                            altDlgBuilder.setMessage(TitMod[Mode] + " / " + TitSub[Sub] + " / Level" + (Lev+1) + "\nComplete!");
                            if(Lev != lastLev){
                                altDlgBuilder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent8 = new Intent(game.this, game.class);
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putInt("Mode", Mode);
                                        bundle2.putInt("Sub", Sub);
                                        bundle2.putInt("Lev", (Lev+1));
                                        intent8.putExtras(bundle2);
                                        startActivity(intent8);
                                    }
                                });
                            }
                            altDlgBuilder.setNegativeButton("選擇關卡", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent8 = new Intent(game.this, level.class);
                                    startActivity(intent8);
                                }
                            });
                            altDlgBuilder.setCancelable(false);
                            altDlgBuilder.show();
                        }
                    }else {
                        fiv1.setEnabled(true);
                        fiv1.setImageResource(R.drawable.back);
                        fiv2.setImageResource(R.drawable.back);
                        bool[flop1] = false;
                        bool[flop2] = false;
                        mp = MediaPlayer.create(game.this,R.raw.x);
                    }
                    mp.start();
                    btncount = 0;
                    miv1.setEnabled(true);
                    miv2.setEnabled(true);
                    miv3.setEnabled(true);
                    miv4.setEnabled(true);
                    miv5.setEnabled(true);
                    miv6.setEnabled(true);
                    miv7.setEnabled(true);
                    miv8.setEnabled(true);
                    miv9.setEnabled(true);
                    miv10.setEnabled(true);
                    miv11.setEnabled(true);
                    miv12.setEnabled(true);
                    miv13.setEnabled(true);
                    miv14.setEnabled(true);
                    miv15.setEnabled(true);
                    miv16.setEnabled(true);
                }else if (btncount >= 2)
                    btncount++;
            }
        }
    };
    private void setcard(){
        for(int i =0; i<8; i++){
            issame[i] = i;
            issame[i+8] = i;
        }
        if(Mode == 0){
            for(int i=0; i<8; i++){
                String imageName = imgSub[Sub] + (Lev*8+i+1) +"_3";
                card[i] = getResources().getIdentifier(imageName, "drawable", "b0643040.niu.kingofknoledge");
                card[i+8] = getResources().getIdentifier(imageName, "drawable", "b0643040.niu.kingofknoledge");
            }
        }else if(Mode == 1){
            for(int i=0; i<8; i++){
                String imageName = imgSub[Sub] + (Lev*8+i+1) +"_1";
                card[i] = getResources().getIdentifier(imageName, "drawable", "b0643040.niu.kingofknoledge");
                imageName = imgSub[Sub] + (Lev*8+i+1) +"_2";
                card[i+8] = getResources().getIdentifier(imageName, "drawable", "b0643040.niu.kingofknoledge");
            }
        }else if(Mode == 2){

        }
    }
}
