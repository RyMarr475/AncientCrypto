package com.rymarr.ancientcrypto;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	public void launchLearn(View view)
	{
		Intent intent = new Intent(this, LearnActivity.class);
		startActivity(intent);
		
	}
	
	public void launchChallenge(View view)
	{
		Intent intent = new Intent(this, ChallengeActivity.class);
		startActivity(intent);
	}
}
