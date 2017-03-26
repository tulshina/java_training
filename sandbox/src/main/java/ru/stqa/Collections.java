package ru.stqa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 26.03.2017.
 */
public class Collections {

    public static void main (String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

//        List<String> languages = new ArrayList<String>();
//        languages.add("Java");

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }

    }

}
