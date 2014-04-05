package com.seattleninja.naturalroyale;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItem extends BaseActivity {

	ImageView singleImage;
	TextView nameOfItem, descriptionOfItem;
	String passTheName, passTheDescription;
	ImageView imageOfItem;
	Drawable clickedImage;	
	int passTheImage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleview);
		showEverything();

	}

	public void onBackPressed() {
		Intent intentGoBack = new Intent(this, TheGrid.class);
		startActivity(intentGoBack);
		setResult(RESULT_OK, intentGoBack);
		finish();
	}
	

	private void showEverything() {
		Bundle getPassedInfo = getIntent().getExtras();
		
		passTheName = getPassedInfo.getString("name");
		passTheDescription = getPassedInfo.getString("description");
		passTheImage = getPassedInfo.getInt("photo");

		nameOfItem = (TextView) findViewById(R.id.tvName);
		descriptionOfItem = (TextView) findViewById(R.id.tvDescription);
	    imageOfItem = (ImageView) findViewById(R.id.ivImage);
		
	    nameOfItem.setText(passTheName);
		descriptionOfItem.setText(passTheDescription);
		
		// extra process when transferring image data
		clickedImage = getResources().getDrawable(passTheImage);	
		imageOfItem.setImageDrawable(clickedImage);

	}
	

}