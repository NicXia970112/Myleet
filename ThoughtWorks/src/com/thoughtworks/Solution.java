package com.thoughtworks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        String wid = scn.nextLine();
        int width = Integer.parseInt(wid);
        TextProcessor tp = new TextProcessor();
        String out = tp.process(text, width);
        System.out.println(out);
    }
}

class  TextProcessor {

    private Segment[] segments;

    public String process(String text, int width) {

        try {
            Util.checkCharacter(text);
            Util.checkRange(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Integer> l = new ArrayList<>();
        char []chars = text.toCharArray();
        l = parseInput(chars);

        segments = new Segment[l.size() + 1];

        if(l.size() == 0) {
            char []c = getChars(0, chars.length - 1, chars);
            segments[0] = new Segment(c, width, 0, chars.length - 1);
        }
        int j = 0;
        for(int i = 0; i < l.size(); i++) {
            if(i == 0) {
                char []c = getChars(0, l.get(i), chars);
                segments[j] = new Segment(c, width, 0, l.get(i) - 1);
                j++;
                continue;
            }
            if(i == l.size() - 1) {
                char []c = getChars(l.get(i - 1), l.get(i), chars);
                segments[j] = new Segment(c, width, l.get(i - 1), l.get(i) - 1);
                j++;
                c = getChars(l.get(i), chars.length, chars);
                segments[j] = new Segment(c, width, l.get(i), chars.length - 1);
                j++;
                continue;
            }
            char []c = getChars(l.get(i - 1), l.get(i), chars);
            segments[j] = new Segment(c, width, l.get(i - 1), l.get(i) - 1);
            j++;
        }

        return new String(printSeg());

    }

    private StringBuilder printSeg() {
        StringBuilder result = new StringBuilder();
        for(Segment s : segments) {
            result.append(s);
        }
        return result;
    }

    private List<Integer> parseInput(char []input) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            if(i - 1 >= 0) {
                if(isChar(input[i]) && !isChar(input[i - 1])) {
                    l.add(i);
                }
                if(isWhite(input[i]) && !isWhite(input[i - 1])) {
                    l.add(i);
                }
            }
        }
        return l;
    }

    private boolean isChar(char c) {
        if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }

    private boolean isWhite(char c) {
        if(c == 32) {
            return true;
        }
        return false;
    }

    private char[] getChars(int begin, int end, char []obj) {
        char []chars = new char[end - begin];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = obj[begin];
            begin++;
        }
        return chars;
    }

    private class Segment {

        public String value;

        public int beginH;

        public int endH;

        public Segment(char []chars, int width, int begin, int end) {
            this.value = String.valueOf(chars);
            this.beginH = begin / width + 1;
            this.endH = end / width + 1;
        }

        @Override
        public String toString() {
            if(beginH != endH) {
                return this.value + "(" + this.beginH + "," + this.endH + ")" + ";";
            } else {
                return this.value + "(" + this.beginH + ")" + ";";
            }
        }
    }
}

class Util {

    public static void checkCharacter(String in) throws Exception {
        String input = in.replaceAll("[^a-zA-Z\\s]", "");
        if(input.length() < in.length()) {
            throw new Exception("ERROR: Invalid character detected!");
        }
    }

    public static void checkRange(String in) throws Exception {
        if(in.length() < 10 || in.length() > 80) {
            throw new Exception("ERROR: Width out of range");
        }
    }

}
