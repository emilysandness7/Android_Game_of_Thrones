package com.example.emilysandness.gameofthronesfragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CharactersListFragment extends ListFragment {

    public static final String EXTRA_HOUSE = "extra_house";
    private CharactersListFragmentListener charactersListFragmentListener;
    private String house;

    //hosting activity must implement this interface in order to use this fragment
    public interface CharactersListFragmentListener {
        void onCharacterClick(String name);
    }

    //factory method, caller must send in name of house
    //factory method is the only way to create in instance of this fragment
    public static CharactersListFragment newInstance(String house) {
        CharactersListFragment charactersListFragment = new CharactersListFragment();

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_HOUSE, house);
        charactersListFragment.setArguments(bundle);

        return charactersListFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        //get the house that was passed in from hosting activity
        Bundle bundle = this.getArguments();

        //if the bundle has the house, set the house
        if (bundle != null) {
            house = bundle.getString(EXTRA_HOUSE);
        }
        //if somehow a house was not sent in, throw exception
        else {
            throw new NullPointerException
                    ("Factory method in CharactersListFragment was not passed in a house.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //get the characters that belong to the house passed in
        GotCharacters[] gotCharacters = GotCharacters.getCharactersByHouse(house);

        //set the list adapter to the characters
        this.setListAdapter(new ArrayAdapter<GotCharacters>(
                inflater.getContext(), android.R.layout.simple_list_item_1, gotCharacters));

        //parent constrcts the view
        return super.onCreateView(inflater, container, savedInstanceState);
    }



   //Checks if the class hosting this fragment is implementing CharactersListFragmentListener.
   //If not then exception is thrown.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            charactersListFragmentListener = (CharactersListFragmentListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.getClass().getSimpleName() +
                    " must implement CharactersListFragmentListener");
        }
    }

    //handles when character on list is clicked
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //get the character clicked
        String name = l.getItemAtPosition(position).toString();

        //bubble up the item click action to hosting activity
        charactersListFragmentListener.onCharacterClick(name);
    }
}
