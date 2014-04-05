package com.seattleninja.naturalroyale;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.about:
			Intent intentAbout = new Intent(this, About.class);
			startActivity(intentAbout);
			return true;

		case R.id.facebook:
			Intent intentFacebook = new Intent(this, Facebook.class);
			startActivity(intentFacebook);
			return true;

		case R.id.imagegrid:
			Intent intentGrid = new Intent(this, TheGrid.class);
			startActivity(intentGrid);
			return true;

		case R.id.menu_settings:
			Intent intentHome = new Intent(this, MainActivity.class);
			startActivity(intentHome);
			return true;

		case R.id.website:
			 Uri uri = Uri.parse("http://www.naturalroyale.com");
			 Intent intentWeb = new Intent(Intent.ACTION_VIEW, uri);
			 startActivity(intentWeb); 

		case R.id.contact:
			Intent intentContact= new Intent(this, Email.class);
			startActivity(intentContact);
			return true;		
			
		case R.id.exit:
			Intent intentExit = new Intent(Intent.ACTION_MAIN);
			intentExit.addCategory(Intent.CATEGORY_HOME);
			intentExit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intentExit);	
			
			
		default:
			return super.onOptionsItemSelected(item);

		}

	}

}
