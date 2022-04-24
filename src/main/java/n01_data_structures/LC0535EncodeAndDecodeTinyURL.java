package n01_data_structures;

import java.util.HashMap;

public class LC0535EncodeAndDecodeTinyURL
{
    HashMap<String, String> urlMapping;
    static final String baseURL = "http://tinyurl.com/";
    char[] tinyURL;
    static final int lengthKey = 3;
    static final int baseLength = baseURL.length();

    public LC0535EncodeAndDecodeTinyURL()
    {
        urlMapping = new HashMap<>();
        tinyURL = new char[lengthKey];
        for (int i = 0; i < lengthKey; i++)
            tinyURL[i] = '0';
    }

    private String nextKey()
    {
        int i;
        char ch;
        for (i = lengthKey - 1; i >= 0; i--)
        {
            ch = (char)(tinyURL[i] + 1);
            if (( ch >= '0' && ch <= '9') || ( ch >= 'A' && ch <= 'Z') || ( ch >= 'a' && ch <= 'z'))
            {
                tinyURL[i] = ch;
                break;
            }
            if (ch > 'z')
            {
                tinyURL[i] = '0';
                continue;
            }
            if (ch > 'Z')
            {
                tinyURL[i] = 'a';
                break;
            }
            if (ch > '9')
            {
                tinyURL[i] = 'A';
                break;
            }
        }
        return String.valueOf(tinyURL);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl)
    {
        String key = nextKey();
        urlMapping.put(key, longUrl);
        // System.out.println(key);
        return baseURL + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl)
    {
        return urlMapping.get(shortUrl.substring(baseLength, baseLength + lengthKey));
    }

    public static void main(String[] args) {
        LC0535EncodeAndDecodeTinyURL tURL = new LC0535EncodeAndDecodeTinyURL();

        for (int i = 0; i < 10000; i++) {
            System.out.println(tURL.encode("www.google.com/" + i));
        }

        System.out.println(tURL.decode("http://tinyurl.com/2bI"));
    }
}
