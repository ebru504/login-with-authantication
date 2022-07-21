package com.example.a11julymon_7take;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ThreadLocalRandom;

public class AuthenticationPage extends AppCompatActivity {




    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autharization_page);
        EditText the_input_otp = findViewById(R.id.otp);
        Button otp_submit_button = (Button) findViewById(R.id.otp_submit);
        Button send_otp_button = (Button) findViewById(R.id.sendOtpButton);
        Button account_button = (Button) findViewById(R.id.go_to_account_button);
        otp_submit_button.setEnabled(false);
        account_button.setEnabled(false);


        // send sms to the user's phone number
        send_otp_button.setOnClickListener(view -> {
            sendSMS();
            otp_submit_button.setEnabled(true);
        });

        otp_submit_button.setOnClickListener(view -> {
            if (the_input_otp.getText().toString().equals("1234")) {
                //correct
                Toast.makeText(AuthenticationPage.this, "OTP CORRECT", Toast.LENGTH_SHORT).show();
                account_button.setEnabled(true);
            } else {
                //incorrect
                Toast.makeText(AuthenticationPage.this, "OTP INCORRECT", Toast.LENGTH_SHORT).show();
            }
        });

        account_button.setOnClickListener(view -> {
            Intent intent_goToAccountPage = new Intent(AuthenticationPage.this, AccountPage.class);
            startActivity(intent_goToAccountPage);
        });

    }

    // method: send sms to user's phone number
    private void sendSMS() {
        String phoneNo = "+905510511969";
        // creating otp
        ThreadLocalRandom random = ThreadLocalRandom. current();
        int otp = random.nextInt(1000, 9999);
        String sms_otp = Integer.toString(otp);
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, sms_otp, null, null);
            Toast.makeText(this, "message sent", Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "failed to send message", Toast.LENGTH_SHORT).show();
        }
    }





}
