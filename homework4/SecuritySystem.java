import java.util.Stack;

/** Class for Security System. */
public class SecuritySystem {
    /** The username */
    private String username;
    /** The first password */
    private String password1;
    /** The second password */
    private int password2;


    /**
     * Default constructor of class SecuritySystem.
     * Sets data fields and checks whether they are valid or not.
     * @param username The username.
     * @param password1 The first password.
     * @param password2 The second password.
     */
    public SecuritySystem(String username, String password1, int password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        checkUserValid();
    }


    /**
     * The constructor class which takes denomination numbers.
     * @param username The username.
     * @param password1 The first password.
     * @param password2 The second password.
     * @param denominations The denomination numbers.
     */
    public SecuritySystem(String username, String password1, int password2, int [] denominations){
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        checkUserValid(denominations);
    }

    /**
     * Checks whether user valid or not respect to the default denomination numbers.
     */
    private void checkUserValid(){
        // Check whether username is valid or not.
        UsernameValidation usernameValidation = new UsernameValidation();
        if (!usernameValidation.checkIfValidUsername(username)){
            return ;
        }

        // Check whether password1 is valid or not.
        Password1Validation password1Validation = new Password1Validation();
        if (!password1Validation.checkAlphaCharactersCount(password1)){
            System.out.println("The password1 is invalid. It should have letters too.");
            return;
        }
        if (password1.length() < 8){
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return ;
        }
        if (!password1Validation.containsUserNameSpirit(username, password1)){
            System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
            return;
        }
        if (!password1Validation.isBalancedPassword(password1)){
            System.out.println("The password1 is invalid. It should be balanced.");
            return;
        }
        if (!password1Validation.isPalindromePossible(password1)){
            System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
            return;
        }
        if (password1Validation.countBracketsCount(password1) < 2){
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return ;
        }


        // Check whether password1 is valid or not.
        Password2Validation password2Validation = new Password2Validation();
        if (!password2Validation.isNumberInRange(password2)){
            System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
            return ;
        }
        if (!password2Validation.isExactDivision(password2)){
            System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            return ;
        }


        // Every case satisfied successfully.
        System.out.println("The username and passwords are valid. The door is opening, please wait..");

    }


    /**
     * Checks whether user valid or not respect to the given denomination numbers.
     * @param denominations The denomination numbers.
     */
    private void checkUserValid(int [] denominations){
        // Check whether username is valid or not.
        UsernameValidation usernameValidation = new UsernameValidation();
        if (!usernameValidation.checkIfValidUsername(username)){
            return ;
        }

        // Check whether password1 is valid or not.
        Password1Validation password1Validation = new Password1Validation();
        if (!password1Validation.checkAlphaCharactersCount(password1)){
            System.out.println("The password1 is invalid. It should have letters too.");
            return;
        }
        if (password1.length() < 8){
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return ;
        }
        if (!password1Validation.containsUserNameSpirit(username, password1)){
            System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
            return;
        }
        if (!password1Validation.isBalancedPassword(password1)){
            System.out.println("The password1 is invalid. It should be balanced.");
            return;
        }
        if (!password1Validation.isPalindromePossible(password1)){
            System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
            return;
        }
        if (password1Validation.countBracketsCount(password1) < 2){
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return ;
        }


        // Check whether password1 is valid or not.
        Password2Validation password2Validation = new Password2Validation();
        if (!password2Validation.isNumberInRange(password2)){
            System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
            return ;
        }
        if (!password2Validation.isExactDivision(password2, denominations)){
            System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            return ;
        }


        // Every case satisfied successfully.
        System.out.println("The username and passwords are valid. The door is opening, please wait..");

    }







    /** Inner class for username validation system. */
    private static class UsernameValidation{
        /**
         * Checks that whether username is valid or not.
         * @param username The username to check.
         * @return true if username is valid, else false.
         */
        private boolean checkIfValidUsername(String username){
            if (username.length() < 1){
                System.out.println("The username is invalid. It should have at least 1 character.");
                return false;
            }
            if (!isOnlyAlphaChar(username)){
                System.out.println("The username is invalid. It should have letters only.");
                return false;
            }
            return true;
        }

        /**
         * Checks that whether username consists of alphacharacters or not.
         * @param username The username.
         * @return true if it is only contains alphacharacters, else false.
         */
        private static boolean isOnlyAlphaChar(String username){
            if (username.length() == 0)
                return true;
            else if (!Character.isAlphabetic(username.charAt(username.length() - 1)))
                return false;
            else
                return isOnlyAlphaChar(username.substring(0, username.length() - 1));
        }
    }

    /** Inner class to abstract password1 validation system. */
    private static class Password1Validation{
        /** Stack that holds characters of username */
        private Stack<Character> usernameChars;
        /** Stack that holds characters of password1 */
        private Stack<Character> password1Chars;

        /** The password string that consists of nonrepeated characters */
        private String nonRepeatedString;

        /** Default constructor. */
        private Password1Validation(){
            usernameChars = new Stack<>();
            password1Chars = new Stack<>();
        }

        /**
         * Checks whether password1 contains any letter that given username contains.
         * @param username The username.
         * @param password1 The password.
         * @return true if it satisfies the condition, else false.
         */
        private boolean containsUserNameSpirit(String username, String password1){
            if (usernameChars.isEmpty())
                fillStack(username, usernameChars);
            if (password1Chars.isEmpty())
                fillStack(password1, password1Chars);

            char c;
            while (!usernameChars.isEmpty()){
                c = usernameChars.peek();
                while(!password1Chars.isEmpty()){
                    if (c == password1Chars.pop()){
                        usernameChars.clear();
                        fillStack(username, usernameChars);
                        password1Chars.clear();
                        fillStack(password1, password1Chars);
                        return true;
                    }
                }
                fillStack(password1, password1Chars);
                usernameChars.pop();
            }
            // reset stack.
            fillStack(username, usernameChars);
            return false;
        }


        /**
         * Checks whether brackets in string password1 pairs each other or not.
         * @param password1 The password string
         * @return true if open and closing brackets are matching, else false.
         */
        private boolean isBalancedPassword(String password1){
            if (password1Chars.isEmpty())
                fillStack(password1, password1Chars);
            if (!checkBracketsMatching(password1)){
                return false;
            }
            return true;
        }

        /**
         * Checks that whether password1 has more than 2 brackets or not.
         * @param password1 The password string to check.
         * @return true if password has more than 2 brackets, else false.
         */
        private boolean checkBracketsCount(String password1){
            if (password1.isEmpty()){
                return false;
            }
            int count = 0;
            for (int i = 0; i < password1.length(); i++){
                char c = password1.charAt(i);
                if (c == '(' || c == '[' || c == '{' ||
                        c == ')' || c == ']' || c == '}')
                    count++;
            }
            return count >= 2;
        }

        /**
         * Checks whether password string has at least one character or not.
         * @param password1 The password string.
         * @return true if password string contains alpha characters, else false.
         */
        private boolean checkAlphaCharactersCount(String password1){
            int count = 0;
            char c;
            for (int i = 0; i < password1.length(); i++){
                c = password1.charAt(i);
                if (Character.isAlphabetic(c))
                    count++;
            }
            return count > 0;
        }

        /**
         * Checks that whether brackets pairs in given string.
         * @param string The string to check.
         * @return true if brackets are pairing each other, else false.
         */
        private boolean checkBracketsMatching(String string){
            if (string.isEmpty()){
                return false;
            }

            Stack<Character> brackets = new Stack<>();
            char c;
            for (int i = 0; i < string.length(); i++){
                c = string.charAt(i);

                if (c == '(' || c == '[' || c == '{'){
                    brackets.push(c);
                } else if (c == ')' || c == ']' || c == '}'){
                    if (brackets.isEmpty())
                        return false;
                    if ((brackets.peek() == '(' && c != ')') ||
                            (brackets.peek() == '[' && c != ']') ||
                            (brackets.peek() == '{' && c != '}') )
                        return false;
                    else
                        brackets.pop();
                }
            }
            return true;
        }


        /**
         * Fills stack with characters of given string.
         * @param string The string.
         * @param stack The stack to fill.
         */
        private void fillStack(String string, Stack<Character> stack){
            if (string.length() != 0){
                stack.push(string.charAt(string.length() - 1));
                fillStack(string.substring(0, string.length() - 1), stack);
            }
        }

        /**
         * Checks whether a palindrome can be obtained by replacing characters in
         * password string or not.
         * @param password1 The password string.
         * @return true if a palindrome is obtainable, else false.
         */
        private boolean isPalindromePossible(String password1){
            nonRepeatedString = new String();
            getNonRepeatedString(password1);
            int oddCount = getCountOfOddChars(password1, nonRepeatedString);
            return oddCount <= 1;
        }


        /**
         * Returns the number of characters which in charSet and the count of it is odd in string s.
         * @param s The target string we count on.
         * @param charSet The character set we count.
         * @return The number of odd characters.
         */
        private int getCountOfOddChars(String s, String charSet){
            if (charSet.isEmpty())
                return 0;
            int len = charSet.length();
            char c = charSet.charAt(len - 1);
            if (countChar(s, c) % 2 != 0)
                return 1 + getCountOfOddChars(s, charSet.substring(0, len - 1));
            return getCountOfOddChars(s, charSet.substring(0, len - 1));
        }


        /**
         * Initialises the string nonRepeatedString with alpha characters in string s
         * without repetition.
         * @param s The target string.
         */
        private void getNonRepeatedString(String s){
            if (s.isEmpty())
                return;
            int len = s.length();
            char c = s.charAt(len - 1);
            if (c != '(' && c != '[' && c != '{' &&
                    c != ')' && c != ']' && c != '}' &&
                    nonRepeatedString.indexOf(c) == -1)
                nonRepeatedString += c;
            getNonRepeatedString(s.substring(0, len - 1));
        }


        /**
         * Counts count of character c in string s.
         * @param s The string.
         * @param c The target character
         * @return The count of character c in string s.
         */
        private int countChar(String s, char c){
            if (s.isEmpty())
                return 0;
            int len = s.length();
            if (s.charAt(len - 1) == c)
                return 1 + countChar(s.substring(0, len - 1), c);
            else
                return countChar(s.substring(0, len - 1), c);
        }


        /**
         * Counts brackets in string password1
         * @param password1 The string
         * @return The count of brackets in string password1
         */
        private int countBracketsCount(String password1){
            if (password1.isEmpty())
                return 0;
            int len = password1.length();
            char c = password1.charAt(len - 1);
            if (c == '(' || c == '[' ||c == '{' ||
                    c == ')' || c == ']' || c == '}')
                return 1 + countBracketsCount(password1.substring(0, len - 1));
            else
                return countBracketsCount(password1.substring(0, len - 1));
        }

    }

    /** Inner class to abstract password2 validation system. */
    private static class Password2Validation{
        /** The minimum number password2 can be */
        private static final int MIN = 10;
        /** The maximum number password2 can be */
        private static final int MAX = 10000;

        /**
         * Checks whether the number n is in range or not.
         * @param n The number which is checked.
         * @return true if number n is in range, else false.
         */
        private boolean isNumberInRange(final int n){
            return MIN <= n && n <= MAX;
        }


        /**
         * Checks whether password2 is exact division of denomination numbers or not.
         * @param password2 The number.
         * @return true if it is exact division, else false.
         */
        private boolean isExactDivision(int password2){
            int [] denominations = new int[3];
            denominations[0] = 4;
            denominations[1] = 17;
            denominations[2] = 29;

            return isExactDivision(password2, denominations);
        }

        /**
         * Checks whether password2 is exact division of denomination numbers or not.
         * @param password2 The number.
         * @param denominations The denomination numbers.
         * @return true if it is exact division, else false.
         */
        private boolean isExactDivision(int password2, int [] denominations){
            return multA(0, password2, denominations);
        }


        /**
         * First recursive function that iterates second coefficient
         * @param a The first coefficient.
         * @param password2 The password
         * @param denominations The denomination numbers.
         * @return true if it is exact division, else false.
         */
        private boolean multA(int a, int password2, int [] denominations){
            if (a*denominations[0] > password2){
                return false;
            } else {
                return multB(a, 0, password2, denominations);
            }
        }

        /**
         * Second recursive function that iterates second coefficient
         * @param a The first coefficient.
         * @param b The second coefficient.
         * @param password2 The password.
         * @param denominations The denomination numbers.
         * @return true if it is exact division, else false.
         */
        private boolean multB(int a, int b, int password2, int [] denominations){
            if (b*denominations[1] > password2){
                return false;
            } else {
                return multC(a, b+1, 0, password2, denominations);
            }
        }


        /**
         * Third recursive function that iterates first and third coefficient
         * @param a The first coefficient.
         * @param b The second coefficient.
         * @param c The third coefficient.
         * @param password2 The password.
         * @param denominations The denomination numbers.
         * @return true if it is exact division, else false.
         */
        private boolean multC(int a, int b, int c, int password2, int [] denominations){
            if (c*denominations[2] > password2 ){
                if (a * denominations[0] <= password2) {
                    return multA(a+1, password2, denominations);
                }
                return false;
            } else if (a*denominations[0] + b*denominations[1] + c*denominations[2] == password2){

                return true;
            } else {
                return multC(a, b, c+1, password2, denominations);
            }
        }


    }

}
