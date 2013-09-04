package com.rymarr.ancientcrypto;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class CaesarCipher extends Activity {
	
	Button encrypt, decrypt;
	EditText plaintext, key;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caesar_cipher);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		encrypt = (Button) findViewById(R.id.encrypt);
		decrypt = (Button) findViewById(R.id.decrypt);
		plaintext = (EditText) findViewById(R.id.plaintext);
		key = (EditText) findViewById(R.id.key);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_caesar_cipher, menu);
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
	
	public void encryptClick(View v)
	{
		if(key.getText().toString() == null)
			return;
		plaintext.setText(encrypt(plaintext.getText().toString(), Integer.parseInt(key.getText().toString())));
	}
	
	public void decryptClick(View v)
	{
		plaintext.setText(decrypt(plaintext.getText().toString(), Integer.parseInt(key.getText().toString())));
	}
	 private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

     public String encrypt(String plainText,int shiftKey)
     {
           plainText = plainText.toLowerCase();
           plainText = removeSpaces(plainText);
           String cipherText="";
           for(int i=0;i<plainText.length();i++)
           {
                int charPosition = ALPHABET.indexOf(plainText.charAt(i));
                int keyVal = (shiftKey+charPosition)%26;
                char replaceVal = this.ALPHABET.charAt(keyVal);
                cipherText += replaceVal;
           }
           return cipherText;
     }
     
     public String decrypt(String cipherText, int shiftKey)
     {
           cipherText = cipherText.toLowerCase();
           String plainText="";
           for(int i=0;i<cipherText.length();i++)
           {
                int charPosition = this.ALPHABET.indexOf(cipherText.charAt(i));
                int keyVal = (charPosition-shiftKey)%26;
                if(keyVal<0)
                {
                      keyVal = this.ALPHABET.length() + keyVal;
                }
                char replaceVal = this.ALPHABET.charAt(keyVal);
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


