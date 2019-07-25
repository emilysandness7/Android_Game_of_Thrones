package com.example.emilysandness.gameofthronesfragments;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    //inflates the menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    //handles when action_hold_door, action_join_knight_watch,
    // and action_drink_wine are clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_hold_door:
                Toast.makeText(getActivity(), "Hodor will hold the door!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_join_knights_watch:
                //bring up a webbrowser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://minez-nightswatch.com"));
                startActivity(intent);
                return true;

            case R.id.action_drink_wine:
                //generate random message
                Random rand = new Random();
                int randVal = rand.nextInt(4);
                String message;

                switch (randVal) {
                    case 0:
                        message = "Arbor Gold";
                        break;
                    case 1:
                        message = "Dornish Sour Reds";
                        break;
                    case 2:
                        message = "Strongwine from Dorne";
                        break;
                    case 3:
                        message = "Sweet Reds from the Reach";
                        break;
                    default:
                        message = "you have nothing";
                }
                Toast.makeText(getActivity(), "You have a cup of " + message, Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
