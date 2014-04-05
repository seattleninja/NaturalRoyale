package com.seattleninja.naturalroyale;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Facebook extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		Intent facebookIntent = getOpenFacebookIntent(this);
		startActivity(facebookIntent);		

	}

	public static Intent getOpenFacebookIntent(Context context) {

		try {
			context.getPackageManager()
					.getPackageInfo("com.facebook.katana", 0); 
			return new Intent(Intent.ACTION_VIEW,
					Uri.parse("fb://profile/198430390347748")); 
		} catch (Exception e) {
			return new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.facebook.com/naturalroyale"));
		}
	}

}
