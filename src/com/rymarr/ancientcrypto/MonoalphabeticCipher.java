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

public class MonoalphabeticCipher extends Activity {

	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private Button encrypt, decrypt;
	private EditText plaintext;
	private TextView key;
	private final String newKey = "tgbyhnujmikolprfvedcwsxqaz";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monoalphabetic_cipher);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		encrypt = (Button) findViewById(R.id.encrypt);
		decrypt = (Button) findViewById(R.id.decrypt);
		plaintext = (EditText) findViewById(R.id.plaintext);
		key = (TextView) findViewById(R.id.keyText);
		key.setText("The key is: " + newKey);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_monoalphabetic_cipher, menu);
		return true;
	}
	
	public void encryptClick(View v)
	{
		plaintext.setText(encrypt(plaintext.getText().toString()));
	}
	
	public void decryptClick(View v)
	{
		plaintext.setText(decrypt(plaintext.getText().toString()));
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


	public String encrypt(String plainText) {
		String cipherText = "";
		plainText = removeSpaces(plainText);
		for (int i = 0; i < plainText.length(); i++) {
			char replaceVal = newKey.charAt(ALPHABET.indexOf(plainText.charAt(i)));
			cipherText += replaceVal;
		}
		return cipherText;
	}

	public String decrypt(String cipherText) {
		String plainText = "";
		cipherText = removeSpaces(cipherText);
		for (int i = 0; i < cipherText.length(); i++) {
			char replaceVal = ALPHABET.charAt(newKey
					.indexOf(cipherText.charAt(i)));
			plainText += replaceVal;
		}
		return plainText;
	}
	
	public String removeSpaces(String input) {
   	 String plainText = input;
   	 while(plainText.indexOf(" ")!= -1)
     	   plainText = plainText.substring(0, plainText.indexOf(" ")) + plainText.substring(plainText.indexOf(" ") + 1);
   	 
   	 return plainText;
    }

}
