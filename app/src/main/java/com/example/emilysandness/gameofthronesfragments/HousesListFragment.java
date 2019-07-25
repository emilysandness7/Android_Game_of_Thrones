package com.example.emilysandness.gameofthronesfragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HousesListFragment extends Fragment {

    //this factory method is not used
    //I created it just to practice making factory methods
    public static HousesListFragment newInstance() {
        return new HousesListFragment();
    }


    private HousesListFragmentListener housesListFragmentListener;

    //hosting activity must implement this interface in order to use this fragment
    public interface HousesListFragmentListener {
        void onHouseClicked(String house);
    }

    //Checks if the class hosting this fragment is implementing HousesListFragmentListener.
    //If not then exception is thrown.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            housesListFragmentListener = (HousesListFragmentListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.getClass().getSimpleName() +
                                         " must implement HousesListFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_houses_list, container, false);

        //get the list of houses
        String[] houses = GotCharacters.getHouses();

        //create array adapter, give it the houses string array
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, houses);

        //set the listview to the string array
        ListView lvHouses = (ListView) view.findViewById(R.id.lvHouses);
        lvHouses.setAdapter(arrayAdapter);

        //set onItemClickListener
        lvHouses.setOnItemClickListener(new HouseClickHandler());

        return view;
    }

    //inner class event handler
    private class HouseClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //get the name of the house clicked
            String house = parent.getItemAtPosition(position).toString();

            //bubble up the name of house to hosting activity
            housesListFragmentListener.onHouseClicked(house);
        }
    }
}
