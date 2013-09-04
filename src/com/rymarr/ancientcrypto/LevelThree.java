package com.rymarr.ancientcrypto;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class LevelThree extends Activity {

	final private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	Button check;
	TextView feedback;
	EditText plainText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_three);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		check = (Button) findViewById(R.id.lv3Button);
		feedback = (TextView) findViewById(R.id.feedbackLv3);
		plainText = (EditText) findViewById(R.id.plaintextlevel3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_level_two, menu);
		return true;
	}

	public void lv3Check(View v) {
		if(plainText.getText().toString().equals(ALPHABET))
		{
			feedback.setText("Correct.");
		}
		else
		{
			feedback.setText("That was wrong, try again");
		}
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
