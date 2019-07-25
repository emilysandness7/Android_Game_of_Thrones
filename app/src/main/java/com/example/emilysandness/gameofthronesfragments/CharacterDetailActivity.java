package com.example.emilysandness.gameofthronesfragments;

import android.app.Activity;
import android.os.Bundle;

public class CharacterDetailActivity extends Activity {

    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        //if first time running add the fragment and menu
        if (savedInstanceState == null ) {
            //get the name passed in
            String name = this.getIntent().getStringExtra(EXTRA_NAME);

            //create instance of fragment and give it the character name
            CharacterDetailFragment characterDetailFragment = CharacterDetailFragment.newInstance(name);
            this.getFragmentManager()
                    .beginTransaction()
                    .add(R.id.detailsFragmentHook, characterDetailFragment)
                    .add(new MenuFragment(), "menu_fragment")
                    .commit();
        }
    }
}
