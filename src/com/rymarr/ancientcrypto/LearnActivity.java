package com.rymarr.ancientcrypto;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class LearnActivity extends Activity {
	
	private String[] ciphers = {"Caesar Cipher", "Monoalphabetic Substitution Cipher", "Vigenere Cipher"};
	ArrayAdapter adapter; 
	
	ListView cipherList; 
	TextView text;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ciphers);
		cipherList = (ListView) findViewById(R.id.cipherListView);
		cipherList.setAdapter(adapter);
		text = (TextView) findViewById(R.id.textView1);
		cipherList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				if(position == 0){
					startCaesar();
				}
				else if(position == 1){
					startMono();
				}
				else if (position == 2){
					startVig();
				}
			}});
	}
	
	private void startCaesar()
	{
		Intent intent = new Intent(this, CaesarCipher.class);
		startActivity(intent);
		
	}
	
	private void startMono()
	{
		Intent intent = new Intent(this, MonoalphabeticCipher.class);
		startActivity(intent);
	}
	
	private void startVig()
	{
		Intent intent = new Intent(this, VigenereCipher.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_learn, menu);
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
