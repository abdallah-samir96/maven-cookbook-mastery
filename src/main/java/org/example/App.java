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
}
