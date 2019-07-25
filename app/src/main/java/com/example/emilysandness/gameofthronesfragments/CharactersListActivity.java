package com.example.emilysandness.gameofthronesfragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CharactersListActivity extends Activity
        implements CharactersListFragment.CharactersListFragmentListener{

    public static final String EXTRA_HOUSE = "extra_house";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_list);

        //if first time running, add fragment and menu
        if (savedInstanceState == null) {
            //get the house that was passed in
            String house = this.getIntent().getStringExtra(EXTRA_HOUSE);

            //use factory method to create fragment, pass in the house
            CharactersListFragment charactersListFragment = CharactersListFragment.newInstance(house);
            this.getFragmentManager()
                    .beginTransaction()
                    .add(R.id.charactersListFragmentHook, charactersListFragment)
                    .add(new MenuFragment(), "menu_fragment")
                    .commit();
        }
    }

    //when a character is clicked call the CharacterDetailActivity and pass character
    @Override
    public void onCharacterClick(String name) {
        Intent intent = new Intent(this, CharacterDetailActivity.class);
        intent.putExtra(CharacterDetailActivity.EXTRA_NAME, name);
        startActivity(intent);
    }
}
