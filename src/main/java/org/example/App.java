package org.example;

import org.apache.commons.text.WordUtils;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {

        showProperties();
        System.out.println("********");
        System.out.println( "Hello Apache Maven!" );
        var name = "Abdallah";
        System.out.println("Hello, " + name);
        System.out.println(WordUtils.uncapitalize("Hello Word!!"));
    }


    public static void operate(int x, int y, int z, int k, int j, int l) {
        System.out.println("Here i want to check it in sonarQube");
        int []result = new int[2];

        for (int i = 0; i < 100; i++);

        System.out.println("Hello From Java ");

        if(true) {
            System.out.println("Hello from java");
        }

        if(true) {
            System.out.println("Hello from java");
        }

        System.out.println("Hello");

    }
    private static void showProperties() {

        System.getProperties().forEach((k,v)->{
            System.out.println(k + " = " + v);
        });

    }
    int removeOccurrences(int[] arr, int k) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == k) {
                ++count;
                arr[i] = arr[i] * -1;
            }

        }
        return arr.length - count;
    }
    boolean areAnagrams(String first, String second) {
        int [] positions = new int[26];
        if(first.length() != second.length()) {
            return false;
        }
        for(int j = 0; j < first.length(); ++j) {
            positions[first.charAt(j) % 26]++;
            positions[second.charAt(j) % 26]--;

        }
        for(int i: positions) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
    boolean areAnagramsAnotherSolution(String A, String B) {
        if(A.length() != B.length()) {
            return false;
        }
        int []hashA = new int[26];
        int []hashB = new int[26];
        for(int i = 0; i < A.length(); i++) {
            hashA[A.charAt(i) - 'a']++;
            hashB[B.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(hashA[i] != hashB[i]) {
                return false;
            }
        }
        return true;
    }
}
