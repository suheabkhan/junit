package com.example.demo3;

public class PallindromeCheck {

    public boolean isPallindrome(String str){
        String reverse="";
        int length=str.length();
        for(int i=length-1;i>=0;i--){
            reverse+=str.charAt(i);
        }
        return str.equals(reverse);
    }
}
