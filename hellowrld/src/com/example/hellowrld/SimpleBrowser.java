package com.example.hellowrld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener{
WebView ourBrowser;
EditText url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		ourBrowser = (WebView)findViewById(R.id.wvBrowser);
		ourBrowser.getSettings().setJavaScriptEnabled(true);
		ourBrowser.getSettings().setLoadWithOverviewMode(true);
		ourBrowser.getSettings().setUseWideViewPort(true);
		
		
		ourBrowser.setWebViewClient(new OurViewClient());
		ourBrowser.loadUrl("http://www.google.com");
		
		Button go = (Button)findViewById(R.id.bGo);
		Button back = (Button)findViewById(R.id.bBack);
		Button forward = (Button)findViewById(R.id.bForward);
		Button refresh = (Button)findViewById(R.id.bRefresh);
		Button clearHistory = (Button)findViewById(R.id.bHistory);
		url=(EditText)findViewById(R.id.etURL);
		
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		forward.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clearHistory.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bGo:
			String theWebsite = url.getText().toString();
			ourBrowser.loadUrl(theWebsite);
			break;
		case R.id.bBack:
			if(ourBrowser.canGoBack())
				ourBrowser.goBack();
			break;
		case R.id.bForward:
			if(ourBrowser.canGoForward())
				ourBrowser.goForward();
			break;
		case R.id.bRefresh:
			ourBrowser.reload();
			break;
		case R.id.bHistory:
			ourBrowser.clearHistory();
			break;
		}
		
		
	}

}
