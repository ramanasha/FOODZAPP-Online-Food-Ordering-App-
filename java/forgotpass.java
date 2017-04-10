import java.util.concurrent.TimeUnit;

import android.app.ActionBar;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.widget.EditText;


public class forgotpass extends AppCompatActivity {


    EditText phone1;
    EditText key;
    TextView resend;
    Button go;
    Button verify;
    TextView _tv;
    CountDownTimer countdowntimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        phone1=(EditText)findViewById(R.id.phn1);
        key=(EditText)findViewById(R.id.key);
        go=(Button)findViewById(R.id.gobtn);
        verify=(Button)findViewById(R.id.verifybtn);
        _tv = (TextView) findViewById( R.id.textView1);



        class CountDownTimerClass extends CountDownTimer {

            public CountDownTimerClass(long millisInFuture, long countDownInterval) {

                super(millisInFuture, countDownInterval);

            }

            @Override
            public void onTick(long millisUntilFinished) {

                int progress = (int) (millisUntilFinished/1000);

                _tv.setText(Integer.toString(progress)+" seconds left to enter the key");

            }

            @Override
            public void onFinish() {

                _tv.setText("TIME UP !");
                key.setEnabled(false);

            }
        }


    // ADD THE CODE TO SEND A MESSAGE ON PHONE
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key.setEnabled(true);
                go.setEnabled(false);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("9790718874", null, "Your key to login is 4533", null, null);
                countdowntimer = new CountDownTimerClass(300000,1000);
                countdowntimer.start();

            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(forgotpass.this,Menu.class));
            }
        });




    }
}
