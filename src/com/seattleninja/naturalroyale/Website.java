package com.seattleninja.naturalroyale;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class Website extends BaseActivity {


	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
	
		String url = "http://www.naturalroyale.com";
		WebView myWebsite = (WebView) findViewById(R.id.webBrowser);
		myWebsite.getSettings().setJavaScriptEnabled(true);
		myWebsite.loadUrl(url);
	}

	
	
}
