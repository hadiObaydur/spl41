package com.example.iit.androidnewsappspl2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import static android.content.Context.MODE_PRIVATE;


public class ThemeFragment extends Fragment  {
     View view;
     boolean useDarkTheme;
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME="dark_theme";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,@Nullable Bundle savedInstanceState) {



        view= inflater.inflate(R.layout.theme_switch, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        useDarkTheme=this.getArguments().getBoolean("useDarkTheme");
        Switch toggle =(Switch) view.findViewById(R.id.switch1);
        if(useDarkTheme)toggle.setText("use Light Theme");
        else toggle.setText("use Dark Theme");
        toggle.setChecked(useDarkTheme);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(CompoundButton view, boolean isChecked) {

                toggleTheme(isChecked);
            }
        });


    }
    private void toggleTheme(boolean darkTheme) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(PREF_DARK_THEME, darkTheme);
        editor.apply();

        Intent intent = getActivity().getIntent();
        getActivity().finish();

        startActivity(intent);
    }


}
