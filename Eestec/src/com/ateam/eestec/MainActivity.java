package com.ateam.eestec;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressLint("NewApi")

public class MainActivity extends Activity {
	TextView textViewTime;
	
	int hours=5;
	int minutes=04;
	int seconds=00;
	String div=":";
	int Hours=10;
	int Minutes=50;
	String total;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textViewTime = (TextView)findViewById(R.id.textViewTime);
		textViewTime.setText((Hours-hours)+div+(Minutes-minutes)+div+seconds);
		final CounterClass timer = new CounterClass((Hours-hours)*3600000+(Minutes-minutes)*60000+seconds*1000,1000);  
		timer.start();
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
			
		return true;
	}
	
	
    public class CounterClass extends CountDownTimer {  
        public CounterClass(long millisInFuture, long countDownInterval) {  
             super(millisInFuture, countDownInterval);  
        }  
        @Override  
       public void onFinish() {  
         textViewTime.setText("Completed.");  
       }  
        

@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressLint("NewApi")
        @Override  
        public void onTick(long millisUntilFinished) {  
              long millis = millisUntilFinished;  
               String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),  
                   TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),  
                   TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));  
               System.out.println(hms);  
               textViewTime.setText(hms);  
        }  
   }  

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
