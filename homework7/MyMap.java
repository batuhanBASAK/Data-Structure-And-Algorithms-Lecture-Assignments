import java.util.List;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Set;

public class MyMap {
    /** The underlying hash map that stores key, Info pairs. */
    private final LinkedHashMap<Character, Info> map;

    /** The preprocessed string */
    String str;
    
    
    
    /** The constructor method */
    public MyMap() {
       map = new LinkedHashMap<>();
    }
    
    

    /**
     * The constructor method that takes string.
     * @param s The string being preprocessed.
     */
    public MyMap(String s) {
        // Preprocess string s and set str.
        str = preprocessString(s);

        // Display original and preprocessed strings.
        System.out.println("Original String:      " + s + "\n"
            +              "Preprocessed String:  " + str);


        map = new LinkedHashMap<>();

        // Fill map respect to the preprocessed string str.
        fillMap();
    }
    
    
    /**
     * Info is a class to store data of class MyMap that stores information of 
     * key character in map.<br/>
     * The <em>count</em> is the count of key occurred in preprocessed string.<br/>
     * The <em>words</em> is the list of words that contain key in string.
     *
     */
    public static class Info{
    	/** The count of key character appeared in string. */
        private int count;
        /** The list of words that contains key character in string. */
        private final List<String> words;

        /**
         * The constructor that takes count.
         * @param count The count of character.
         */
        private Info( int count) {
            this.count = count;
            this.words = new ArrayList<>();
        }

        /**
         * The getter method for count.
         * @return The count.
         */
        public int getCount(){
            return count;
        }

        /**
         * The setter method for count
         * @param count The new count.
         * post: Sets the count value with given new count value.
         */
        private void setCount(int count){
            this.count = count;
        }

        /**
         * Adds new word to word list.
         * @param word The word to add it on word list.
         */
        private void push(String word){
            words.add(word);
        }

        /**
         * The toString method for Info class that returns count and word list in string.
         * @return The count and word list in string form.
         */
        public String toString(){
            return "Count: " + count + " - Words: " + words.toString() + "\n";
        }

    }
    

    /**
     * Fills map
     */
    private void fillMap(){
        for (String word : str.split(" ")){
            for (int i = 0; i < word.length(); i++){
                if (map.get(word.charAt(i)) == null){
                    map.put(word.charAt(i), new Info(0));
                }
                map.get(word.charAt(i)).setCount(map.get(word.charAt(i)).getCount()+1);
                map.get(word.charAt(i)).push(word);
            }
        }
    }



    /**
     * Preprocesses the given string and returns the result.<br/>
     * What it does that removes the punctuation characters, make the string lower case, and
     * keeps the white spaces as they are.
     * @param s The string to preprocess.
     * @return The preprocessed string.
     */
    public static String preprocessString(String s) {
        String processedString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    c == ' ') {
                processedString += Character.toLowerCase(c);
            }
        }
        return processedString;
    }


    /**
     * toString method for MyMap class.
     * @return The map in string form.
     */
    public String toString(){
        String s = "";
        Set<Character> keySet = map.keySet();
        for (char key : keySet){
            s += "Letter: " + key + " - " + map.get(key).toString();
        }
        return s;
    }
    
    public LinkedHashMap<Character, Info> getMap(){
    	return map;
    }
    
    public void put(char c, Info i) {
    	map.put(c, i);
    }
    
    public Info get(char c) {
    	return map.get(c);
    }

}
