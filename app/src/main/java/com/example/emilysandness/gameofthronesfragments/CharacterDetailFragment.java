package com.example.emilysandness.gameofthronesfragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterDetailFragment extends Fragment {

    public static final String EXTRA_NAME = "extra_name";
    private String name;

    //factory method, caller must send in a name of character
    //factory method is the only way to create in instance of this fragment
    public static CharacterDetailFragment newInstance(String name) {
        CharacterDetailFragment characterDetailFragment = new CharacterDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString(CharacterDetailFragment.EXTRA_NAME, name);
        characterDetailFragment.setArguments(bundle);

        return characterDetailFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        //get the name that was passed in from  activity
        Bundle bundle = this.getArguments();

        //if the bundle has the name, set the name
        if (bundle != null) {
            name = bundle.getString(EXTRA_NAME);
        }
        //if somehow a name was not sent in, throw exception
        else {
            throw new NullPointerException
                    ("Factory method in CharacterDetailFragment was not passed in a name.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_detail, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        View v = this.getView();

        //search for character that matches name and return details on character
        GotCharacters gotCharacter = GotCharacters.getCharacterByName(name);

        //get handlers for image and text views
        TextView tvName = (TextView) v.findViewById(R.id.tvName);
        TextView tvHouse = (TextView) v.findViewById(R.id.tvHouse);
        ImageView ivCharacter = (ImageView) v.findViewById(R.id.ivCharacter);
        TextView tvDetailOne = (TextView) v.findViewById(R.id.tvDetailOne);
        TextView tvDetailTwo = (TextView) v.findViewById(R.id.tvDetailTwo);
        TextView tvDetailThree = (TextView) v.findViewById(R.id.tvDetailThree);

        //set the image and text view to data from character
        tvName.setText(gotCharacter.getName());
        tvHouse.setText(gotCharacter.getHouse());
        ivCharacter.setImageResource(gotCharacter.getImageResourceId());
        tvDetailOne.setText(gotCharacter.getDetail1());
        tvDetailTwo.setText(gotCharacter.getDetail2());
        tvDetailThree.setText(gotCharacter.getDetail3());
    }
}
