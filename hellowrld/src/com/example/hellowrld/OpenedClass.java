package com.example.hellowrld;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{
  TextView question,Test;
  Button returndata;
  RadioGroup selectionList;
  String gotBread,setData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initial();
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name","Aakash is....");
		String values = getData.getString("list","4");
		if(values.contentEquals("1")){
			question.setText(et);
		}
		
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("key");
		//question.setText(gotBread);
		
	}

	private void initial() {
		// TODO Auto-generated method stub
		question = (TextView)findViewById(R.id.tvQuestion);
		Test = (TextView)findViewById(R.id.tvTest);
		returndata = (Button)findViewById(R.id.bReturn);
        selectionList = (RadioGroup)findViewById(R.id.rgAnswers);
		returndata.setOnClickListener(this);
		selectionList.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK,person);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case R.id.rCrazy:
			setData = "Probably correct!";
			break;
case R.id.rStupid:
	setData = "Definitely correct!";
			break;
case R.id.rBoth:
	setData = "Perfectly correct!";
	break;
		}
		Test.setText(setData);
		
	}

}
