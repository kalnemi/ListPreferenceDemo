package com.example.listpreferencedemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends Activity implements OnPreferenceChangeListener 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String android_choice = sp.getString( "lp_android_choice", "None Selected" );
		TextView tv = (TextView) findViewById( R.id.android_oldversion );
		tv.setText(android_choice);
	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) 
	{
		TextView tv = (TextView) findViewById( R.id.android_oldversion );
		tv.setText( newValue.toString() );
		return true;
	}
}