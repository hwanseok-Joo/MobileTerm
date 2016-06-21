package helloworld.example.com.payback;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class messaging extends AppCompatActivity {
    int cyear, cmonth, cday;
    Context mContext;
    EditText smsTextContext;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
        mContext = this;
        Calendar c = Calendar.getInstance();

        cyear = c.get(Calendar.YEAR);
        cmonth = c.get(Calendar.MONTH);
        cday = c.get(Calendar.DAY_OF_MONTH);

        smsTextContext = (EditText) findViewById(R.id.smsText);

        findViewById(R.id.day).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(messaging.this, dateSetListener, cyear, cmonth, cday).show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            //Change the D-day change.
            TextView text = (TextView) findViewById(R.id.dday);
            String msg = String.format("%d / %d / %d", year, monthOfYear + 1, dayOfMonth);
            text.setText(msg);

        }
    };
    public void sendSMS(View v){
        String smsText = smsTextContext.getText().toString();

        if ( smsText.length()>0){
            sendSMS(smsText);
        }else{
            Toast.makeText(this, "input the message!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void sendSMS(String smsText) {
        PendingIntent sentIntent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_SENT_ACTION"), 0);
        PendingIntent deliveredIntent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_DELIVERED_ACTION"), 0);

        /**
         * SMS가 발송될때 실행
         * When the SMS massage has been sent
         */
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        // 전송 성공
                        Toast.makeText(mContext, "전송 완료", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        // 전송 실패
                        Toast.makeText(mContext, "전송 실패", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        // 서비스 지역 아님
                        Toast.makeText(mContext, "서비스 지역이 아닙니다", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        // 무선 꺼짐
                        Toast.makeText(mContext, "무선(Radio)가 꺼져있습니다", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        // PDU 실패
                        Toast.makeText(mContext, "PDU Null", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter("SMS_SENT_ACTION"));
        SmsManager mSmsManager = SmsManager.getDefault();
        mSmsManager.sendTextMessage("01032691599", null, smsText, sentIntent, deliveredIntent);
    }
}
