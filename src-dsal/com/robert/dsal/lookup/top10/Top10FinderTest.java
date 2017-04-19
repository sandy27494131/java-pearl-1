package com.robert.dsal.lookup.top10;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.robert.dsal.string.anagram.Anagram;
import com.robert.dsal.string.anagram.finder.AnagramsFinder;
import com.robert.dsal.string.anagram.finder.AnagramsFinderByHash;

public class Top10FinderTest {
    public static void main(String[] args) {
        String[] src = {"army", "mary", "test1", "test2"};
        
       AnagramsFinder af = new AnagramsFinderByHash();
       
       String[] anagrams = af.findAnagrams(src, "mary");
       
       System.out.println(Arrays.asList(anagrams));
    }
}
