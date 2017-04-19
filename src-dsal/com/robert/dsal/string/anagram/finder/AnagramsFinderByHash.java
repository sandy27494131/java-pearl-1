package com.robert.dsal.string.anagram.finder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 把输入的字符串按照字母顺序排序，然后，放入hash表，hash表的key是按字母顺序排序的字符串，值则是一个列表，列表中每个元素是一个源单词。
 * 
 * @author Robert
 *
 */
public class AnagramsFinderByHash implements AnagramsFinder {
    public String[] findAnagrams(String[] src, String target) {
        HashMap<String, List<String>> hm = constructHash(src);

        char[] targetWord = target.toCharArray();
        Arrays.sort(targetWord);
        String sTargetWord = new String(targetWord);

        if (hm.containsKey(sTargetWord)) {
            // 如果包含此同位词，则返回同位词列表
            return hm.get(sTargetWord).toArray(new String[0]);
        }

        // 如果不包含，则返回空
        return null;
    }

    private HashMap<String, List<String>> constructHash(String[] src) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

        // 构造同位词hash表
        for (int i = 0; i < src.length; i++) {
            char[] word = src[i].toCharArray();
            Arrays.sort(word);
            String sWord = new String(word);

            if (hm.containsKey(sWord)) {
                List<String> anagrams = hm.get(sWord);
                anagrams.add(src[i]);
            } else {
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(sWord);
                hm.put(sWord, anagrams);
            }
        }

        return hm;
    }
}
