package ZigZagConversion;

import java.util.HashMap;
import java.util.Map;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"*/
public class ZigZagConversion {
    public static String convert(String s, int numOfRows)
    {
        Map<Integer,StringBuilder> map = new HashMap<>();
        int position = 0;
        boolean increment = true;
        for(char c : s.toCharArray())
        {
            if(position == numOfRows) increment = false;
            if(position == 1) increment = true;
            if(increment) position++;
            else position--;
            if(!map.containsKey(position))
            {
                map.put(position,new StringBuilder());
            }
            map.get(position).append(c);
        }
        StringBuilder result = new StringBuilder();
        for(int i:map.keySet())
        {
            result.append(map.get(i));
        }
        return  result.toString();
    }

    public static void main(String[] args)
    {
        String s = "PAYPALISHIRING";
        System.out.println("New string is " + convert(s,3));
    }
}
