package com.example.listpreferencedemo;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;

public class MyPreferenceFragment extends PreferenceFragment 
{
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource( R.xml.preferences );
		
		OnPreferenceChangeListener onPreferenceChangeListener = new OnPreferenceChangeListener()
		{
			@Override
			public boolean onPreferenceChange ( Preference preference, Object newValue )
			{
				OnPreferenceChangeListener listener = (OnPreferenceChangeListener) getActivity();
				listener.onPreferenceChange(preference, newValue);
				return true;
			}
		};
		
		ListPreference p = (ListPreference) getPreferenceManager().findPreference( "lp_android_choice" );
		p.setOnPreferenceChangeListener(onPreferenceChangeListener);
	}
}