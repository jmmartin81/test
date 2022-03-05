// Java program to generate short url from integer id and
// integer id back from short url.
import java.util.*;
import java.lang.*;
import java.io.*;

class TinyUrl
{

    public static final int BASE_ENCODING = 64;

    // Function to generate a short url from integer ID
    static String idToShortURL(int n)
    {
        // Map to store 64 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        // Convert given integer id to a base BASE_ENCODING number
        while (n > 0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map[n % BASE_ENCODING]);
            n = n / BASE_ENCODING;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    // Function to get integer ID back from a short url
    static int shortURLtoID(String shortURL)
    {
        int id = 0; // initialize result 

        // A simple base conversion logic
        for (int i = 0; i < shortURL.length(); i++)
        {
            if ('a' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'z')
                id = id * BASE_ENCODING + shortURL.charAt(i) - 'a';
            else if ('A' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'Z')
                id = id * BASE_ENCODING + shortURL.charAt(i) - 'A' + 26;
            else if ('0' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= '9')
                id = id * BASE_ENCODING + shortURL.charAt(i) - '0' + 52;
            else if ('-' == shortURL.charAt(i))
                id = id * BASE_ENCODING + shortURL.charAt(i) - '-' + 62;
            else if ('_' == shortURL.charAt(i))
                id = id * BASE_ENCODING + shortURL.charAt(i) - '_' + 63;
        }
        return id;
    }

    // Driver Code
    public static void main (String[] args) throws IOException
    {
        int n = 65;
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id real: "+ n +" from url is " +
                shortURLtoID(shorturl));
    }
}
 