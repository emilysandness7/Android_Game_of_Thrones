package com.example.emilysandness.gameofthronesfragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements HousesListFragment.HousesListFragmentListener,
                                                      CharactersListFragment.CharactersListFragmentListener {

    private boolean isTablet;

    //inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Game of Thrones");

        //if running the first time add the menu fragment
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(new MenuFragment(), "menu_fragment")
                    .commit();
        }

        //is the device a tablet?
        isTablet = findViewById(R.id.tabletLayout) != null;

        //if starting fresh set the default selected house to baratheon
        //AND if device is a tablet
        if (savedInstanceState == null && isTablet) {
            onHouseClicked(GotCharacters.getHouses()[0]);
        }
    }

    //handles when action bar item is clicked
    //only handles the action_send_raven and action_call_banners
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_send_raven:
                Toast.makeText(this, "Sending a raven.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_call_banners:
                Toast.makeText(this, "Do you remember your bannermen's numbers?", Toast.LENGTH_LONG).show();

                //calling works fine on both tablet and phone
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //handles when a house is clicked on, uses CharactersListFragment
    @Override
    public void onHouseClicked(String house) {
        if (isTablet) {
            //use factory method to create instance of list fragment
            //pass in the name of house clicked
            CharactersListFragment charactersListFragment =
                    CharactersListFragment.newInstance(house);

            //replace the current fragment with a new fragment
            //uses dynamic fragments
            this.getFragmentManager()
                .beginTransaction()
                .replace(R.id.charactersListFragmentHook, charactersListFragment)
                .commit();

            //set the character details to the first character
            onCharacterClick(GotCharacters.getCharactersByHouse(house)[0].toString());
        }
        //device is a phone
        else {
            //create intent, put the house in it, start CharacterListActivity
            Intent intent = new Intent(this, CharactersListActivity.class);
            intent.putExtra(CharactersListActivity.EXTRA_HOUSE, house);
            startActivity(intent);
        }
    }

    //handles when character is clicked on, uses CharacterDetailFragment
    @Override
    public void onCharacterClick(String name) {
        //use factory method to create instance of detail fragment
        //pass in the name of character clicked
        CharacterDetailFragment characterDetailFragment =
                new CharacterDetailFragment().newInstance(name);

        //replace the current fragment with a new fragment
        //uses dynamic fragments
        this.getFragmentManager()
            .beginTransaction()
            .replace(R.id.detailsFragmentHook, characterDetailFragment)
            .commit();
    }
}
