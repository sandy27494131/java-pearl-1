package com.robert.dsal.string.anagram.finder;

/**
 * 
 * 在一个串数组中找到某个目标字符串的同位词，不考虑顺序含有相同字符的单词成为同位词, 也有人称为兄弟单词，例如army和mary。
 * 
 * @author Robert
 *
 */
public interface AnagramsFinder {
    public String[] findAnagrams(String[] src, String target);
}
