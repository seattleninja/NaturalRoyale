package com.seattleninja.naturalroyale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends BaseActivity implements OnClickListener {

	String name, subject, message;
	String[] natural;
	EditText etName, etMessage;
	Button sendMail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		initEmailVars();
	}

	private void initEmailVars() {
		etName = (EditText) findViewById(R.id.etName);
		etMessage = (EditText) findViewById(R.id.etMessage);
		sendMail = (Button) findViewById(R.id.btSend);
		sendMail.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
        natural = new String[]{"sales@naturalroyale.com"};	
		subject = "Natural Royale";
		name = etName.getText().toString();
		message = etMessage.getText().toString();

		Intent emailIntent = new Intent(Intent.ACTION_SEND); 
		emailIntent.setData(Uri.parse("mailto:"));
	    emailIntent.setType("message/rfc822");		
        emailIntent.putExtra(Intent.EXTRA_EMAIL, natural);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject + " - " + name);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);		
		startActivity(Intent.createChooser(emailIntent, "Send Email:"));
	}
	
}