/*
Problem:
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL 
such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL 
and the tiny URL can be decoded to the original URL.

Implement the Solution class:

* Solution() Initializes the object of the system.
* String encode(String longUrl) Returns a tiny URL for the given longUrl.
* String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl 
was encoded by the same object.

Link: https://leetcode.com/problems/encode-and-decode-tinyurl/

Solution:
Using a random code of 5 digits or letters. If a long URL is already generated, the existing short URL is used and no new entry is generated.
*/

public class EncodeAndDecodeTinyURL {
    class Codec {
        HashMap<String, String> encodedURL = new HashMap<>();
        HashMap<String, String> decodedURL = new HashMap<>();
        String BASE_URL = "http://tinyurl.com/";
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String key = "";
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    int idx = (int) (Math.random() * charSet.length());
                    sb.append(charSet.charAt(idx));
                }
                key = sb.toString();
            } while (encodedURL.containsKey(key));
            encodedURL.put(longUrl, key);
            decodedURL.put(key, longUrl);
            return BASE_URL + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return decodedURL.get(shortUrl.replace(BASE_URL, ""));
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
}
