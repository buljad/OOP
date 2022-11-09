package ru.nsu.izhuravskii;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*public class SubstringSearch {
    public void InputHandler() throws IOException {
        String[] subString;
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Programs\\OOP\\Task_1_3_1\\src\\main\\java\\ru\\nsu\\izhuravskii\\input.txt");
        int inputSymbol;
        while((inputSymbol = fileInputStream.read()) != -1) {
            (char)inputSymbol
        }
        }
}
*/

public class SubstringSearch {

    static void search(String pat, String txt) {
        int l1 = pat.length();
        int l2 = txt.length();
        int i = 0, j = l2 - 1;

        for (i = 0, j = l2 - 1; j < l1; ) {

            if (txt.equals(pat.substring(i, j + 1))) {
                System.out.println("Pattern found at index " + i);
            }
            i++;
            j++;
        }
    }
}


