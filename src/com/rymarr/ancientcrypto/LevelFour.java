package com.rymarr.ancientcrypto;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class LevelFour extends Activity {
	
	private final String key = "swerve";
	private TextView feedback;
	private EditText answer;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_four);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		answer = (EditText) findViewById(R.id.lv4Answer);
		feedback = (TextView) findViewById(R.id.lv4Button);
	}

	public void checkLevel4(View v) {
		if(answer.getText().toString() == key)
		{
			feedback.setText("You are right. If you did that with no help you are as smart as Charles Babbage.");
		}
		else
		{
			feedback.setText("You are wrong. Don't feel bad though, it took the best mathematical minds in the world 3 centuries to crack this cipher.");
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_level_four, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
