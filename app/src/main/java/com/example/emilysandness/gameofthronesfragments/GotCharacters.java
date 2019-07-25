package com.example.emilysandness.gameofthronesfragments;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class GotCharacters {
    private String house;
    private String name;
    private String detail1;
    private String detail2;
    private String detail3;
    private int imageResourceId;

    //array of character each character has:
    // house, name, detail1, detail2, detail3, imageResourceId
    private static final GotCharacters[] characters =
            {
                    // HOUSE BARATHEON: Renly, Robert, Shireen, Stannis

                    new GotCharacters("House Baratheon", "Renly Baratheon",
                            "Renly served as the Master of Laws om the King's small council.",
                            "Renly's Kingsguard was called the 'Rainbow Guard.'",
                            "Renly is the Lord of Storm's End.",
                            R.drawable.renly_baratheon),
                    new GotCharacters("House Baratheon", "Robert Baratheon",
                            "Robert became king when the Targargens were dethroned.",
                            "Robert's brothers are Renly and Stannis.",
                            "Robert was killed by a boar.",
                            R.drawable.robert_baratheon),
                    new GotCharacters("House Baratheon", "Shireen Baratheon",
                            "Shireen is Stannis's daughter.",
                            "The left side of her face is scarred by Greyscale.",
                            "Shireen's best friend is Davos Seaworth.",
                            R.drawable.shireen_baratheon),
                    new GotCharacters("House Baratheon", "Stannis Baratheon",
                            "Stannis was the Master of Ships on the King's small council.",
                            "Stannis is a serious and severe man, he probably has never smiled.",
                            "Stannis is the Prince of Dragonstone.",
                            R.drawable.stannis_baratheon),

                    //HOUSE LANNISTER: Cersei, Jaime, Tyrion, Tywin

                    new GotCharacters("House Lannister", "Cersei Lannister",
                            "Cersei was Robert Baratheon's wife.",
                            "Cersei has 2 sons and 1 daughter.",
                            "Cersei hates her younger brother Tyrion.",
                            R.drawable.cersei_lannister),
                    new GotCharacters("House Lannister", "Jaime Lannister",
                            "Jaime is Cersei's fraternal twin.",
                            "Jaime is known as the 'Kingslayer' since he killed King Aerys II Targaryen.",
                            "Jaime had his right hand cut off.",
                            R.drawable.jamie_lannister),
                    new GotCharacters("House Lannister", "Tyrion Lannister",
                            "Tyrion is a dwarf.",
                            "Tyrion is extremely witty and intellectual.",
                            "Tyrion fled the continent of Westeros so he wouldn't be killed.",
                            R.drawable.tyrion_lannister),
                    new GotCharacters("House Lannister", "Tywin Lannister",
                            "Tywin's children are Cersei, Jaime, and Tyrion.",
                            "He is the richest man in the seven kingdoms.",
                            "Tywin is Lord of Casterly Rock.",
                            R.drawable.tywin_lannister),

                    //HOUSE STARK: Arya, Bran, Eddard, Robb

                    new GotCharacters("House Stark",
                            "Arya Stark",
                            "Arya is the youngest daughter of Eddard.",
                            "Arya goes blind after she fails to assasinate a target.",
                            "Arya is not very lady-like, she is interested in warefare.",
                            R.drawable.arya_stark),
                    new GotCharacters("House Stark", "Bran Stark",
                            "Bran is the second youngest son of Eddard.",
                            "Bran broke his legs when he was thrown off a tower by Jaime Lannister.",
                            "Bran is a warg: he can send his consciousness into the mind of an animal.",
                            R.drawable.bran_stark),
                    new GotCharacters("House Stark", "Eddard Stark",
                            "Eddard is the Lord of Winterfell.",
                            "Eddard served as the Hand of the King in the King's small council.",
                            "Eddard was an extemely honorable man, which contributed to his death.",
                            R.drawable.eddard_stark),
                    new GotCharacters("House Stark", "Robb Stark",
                            "Robb is Eddard's oldest son.",
                            "Robb leads a war south when his father is executed.",
                            "Robb marries Talisa Maegyr instead of one of Lord Frey's daughters.",
                            R.drawable.robb_stark),

                    //HOUSE TARGARYEN: Aegon, Aemon, Daenerys, Viserys

                    new GotCharacters("House Targaryen", "Aegon I Targaryen",
                            "Aegon is known as 'Aegon the Conqueror' since he conquered all of Westeros.",
                            "Aegon had 3 dragons.",
                            "Aegon was the first king of the Targaryen dynasty.",
                            R.drawable.aegon_targargen),
                    new GotCharacters("House Targaryen", "Aemon Targaryen",
                            "Aemon is the Maester of Castle Black.",
                            "Aemon is the great-uncle of Daenerys and Viserys.",
                            "Aemon refused to become king when he was passed the crown.",
                            R.drawable.aemon_targaryen),
                    new GotCharacters("House Targaryen", "Daenerys Targaryen",
                            "Daenerys is the last surviving Targaryen.",
                            "Daenerys is the Mother of Dragons since she hatches 3 dragon eggs.",
                            "Daenerys was Khaleesi of the Great Gress Sea.",
                            R.drawable.daenerys_targaryen),
                    new GotCharacters("House Targaryen", "Viserys Targaryen",
                            "Viserys was Daenerys' older brother.",
                            "Viserys was condescending, cruel, and arrogant.",
                            "Viserys died when he had a 'crown' of molten gold poured on his head.",
                            R.drawable.viserys_targaryen)
            };

    //get the unique names of the houses
    public static String[] getHouses() {
        //use treeset so no dupes and in alphabetic order
        Set<String> houses = new TreeSet<>();

        //go through the aray and add each house to the treeset
        for (GotCharacters character : characters) {
            houses.add(character.house);
        }
        return houses.toArray(new String[houses.size()]);
    }

    //get a list of characters in a certain house
    public static GotCharacters[] getCharactersByHouse(String house) {
        ArrayList<GotCharacters> byHouse = new ArrayList<>();

        //go through each character and see if their house matches the one needed
        for (GotCharacters character : characters) {

            //if houses match, add character to arraylist
            if (character.house.equals(house)) {
                byHouse.add(character);
            }
        }

        return byHouse.toArray(new GotCharacters[byHouse.size()]);
    }

    //find a character by the name passed in
    public static GotCharacters getCharacterByName(String name) {

        //go through the characters and check name for match
        for (GotCharacters character : characters) {
            if (name.equals(character.name)) {
                return character;
            }
        }
        //something went really wrong
        throw new IllegalArgumentException();
    }

    //constructor
    private GotCharacters(String house, String name,
                          String detail1, String detail2, String detail3,
                          int imageResourceId) {
        this.house = house;
        this.name = name;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
        this.imageResourceId = imageResourceId;
    }


    // GETTERS

    public String getHouse() {
        return house;
    }

    public String getName() {
        return name;
    }

    public String getDetail1() {
        return detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public String getDetail3() {
        return detail3;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    //TOSTRING

    @Override
    public String toString() {
        return this.name; //only return name
    }
}
