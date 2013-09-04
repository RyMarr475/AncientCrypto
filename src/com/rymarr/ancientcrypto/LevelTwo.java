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

public class LevelTwo extends Activity {

	final private String KEY = "yloeivmajfndsuczxkbwrtgqph";
	final private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	Button check;
	EditText[] letters;
	TextView feedback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_two);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		check = (Button) findViewById(R.id.lv2Button);
		feedback = (TextView) findViewById(R.id.feedbackLv2);
		letters = new EditText[26];
		letters[0] = (EditText) findViewById(R.id.a);
		letters[1] = (EditText) findViewById(R.id.b);
		letters[2] = (EditText) findViewById(R.id.c);
		letters[3] = (EditText) findViewById(R.id.d);
		letters[4] = (EditText) findViewById(R.id.e);
		letters[5] = (EditText) findViewById(R.id.f);
		letters[6] = (EditText) findViewById(R.id.g);
		letters[7] = (EditText) findViewById(R.id.h);
		letters[8] = (EditText) findViewById(R.id.i);
		letters[9] = (EditText) findViewById(R.id.j);
		letters[10] = (EditText) findViewById(R.id.k);
		letters[11] = (EditText) findViewById(R.id.l);
		letters[12] = (EditText) findViewById(R.id.m);
		letters[13] = (EditText) findViewById(R.id.n);
		letters[14] = (EditText) findViewById(R.id.o);
		letters[15] = (EditText) findViewById(R.id.p);
		letters[16] = (EditText) findViewById(R.id.q);
		letters[17] = (EditText) findViewById(R.id.r);
		letters[18] = (EditText) findViewById(R.id.s);
		letters[19] = (EditText) findViewById(R.id.t);
		letters[20] = (EditText) findViewById(R.id.u);
		letters[21] = (EditText) findViewById(R.id.v);
		letters[22] = (EditText) findViewById(R.id.w);
		letters[23] = (EditText) findViewById(R.id.x);
		letters[24] = (EditText) findViewById(R.id.y);
		letters[25] = (EditText) findViewById(R.id.z);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_level_two, menu);
		return true;
	}

	public void lv2Check(View v) {
		boolean correct = true;
		for (int i = 0; i < 26; i++) {
			if (!letters[i].getText().toString().equalsIgnoreCase(KEY.substring(i, i + 1))) {
				correct = false;
			}
		}
		
		if(correct) {
			feedback.setText("CORRECT. Move on to the next challenge!");
		} else {
 			feedback.setText("That was wrong. Please try again! Make sure there are no duplicate letters!");
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
