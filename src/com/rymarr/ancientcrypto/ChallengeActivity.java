package com.rymarr.ancientcrypto;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;

public class ChallengeActivity extends Activity {
	
	private String[] levels = {"Level 1", "Level 2", "Level 3" , "Level 4"};
	ArrayAdapter adapter; 
	
	ListView levelList; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_challenge);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, levels);
		levelList = (ListView) findViewById(R.id.levelListView);
		levelList.setAdapter(adapter);
		levelList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				if(position == 0){
					startOne();
				}
				else if(position == 1){
					startTwo();
				}
				else if(position == 2){
					startThree();
				}
				else if(position == 3){
					startFour();
				}
			}});
	}
	
	private void startOne()
	{
		Intent intent = new Intent(this, LevelOne.class);
		startActivity(intent);
	}

	private void startTwo()
	{
		Intent intent = new Intent(this, LevelTwo.class);
		startActivity(intent);
	}
	
	private void startThree()
	{
		Intent intent = new Intent(this, LevelThree.class);
		startActivity(intent);
	}
	
	private void startFour()
	{
		Intent intent = new Intent(this, LevelFour.class);
		startActivity(intent);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_challenge, menu);
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
