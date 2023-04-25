package ru.nsu.izhuravskii;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

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
    Reader input;
    String substring;


    public static int[] findPrefixArray(String substring) {
        int substringLength = substring.length();
        int[] prefixArray = new int[substringLength + 1];
        prefixArray[0] = -1;
        prefixArray[1] = 0;
        int prefixLength = 0;
        int currentSymbolId = 1;
        while (currentSymbolId < substringLength) {
            if (substring.charAt(prefixLength) == substring.charAt(currentSymbolId)) {
                prefixLength++;
                currentSymbolId++;
                prefixArray[currentSymbolId] = prefixLength;
            } else if (prefixLength > 0) {
                prefixLength = prefixArray[prefixLength];
            } else {
                currentSymbolId++;
                prefixArray[currentSymbolId] = 0;
            }
        }
        return prefixArray;
    }
    public static List<Integer> SubstringSearch(Reader file, String substring)
            throws IOException {
        int currentId = 0;
        int idInSubstring = 0;
        int substringLen = substring.length();

        List<Integer> matchesId = new ArrayList<>();
        int[] prefixLen = findPrefixArray(substring);
        int c;
        while ((c = file.read()) != -1) {
            char currentLetter = (char) c;
            if (substring.charAt(idInSubstring
            ) == currentLetter) {
                idInSubstring++;
                currentId++;
                if (idInSubstring == substringLen) {
                    matchesId.add(currentId - idInSubstring);
                    idInSubstring = prefixLen[idInSubstring];
                }
            } else {
                idInSubstring = prefixLen[idInSubstring];
                if (idInSubstring < 0) {
                    currentId++;
                    idInSubstring++;
                }
            }
        }
        return matchesId;
    }
}


