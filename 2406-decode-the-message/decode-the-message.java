class Solution {
      public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char substitute = 'a';  // Start from 'a'

        // Build the decoding map
        for (char c : key.toCharArray()) {
            if (c != ' ' && !map.containsKey(c)) {  // Ignore spaces
                map.put(c, substitute);
                substitute++;
            }
        }

        // Decode the message
        StringBuilder str = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                str.append(' '); // Preserve spaces
            } else {
                str.append(map.get(c)); // Convert character
            }
        }

        return str.toString();
    }
}