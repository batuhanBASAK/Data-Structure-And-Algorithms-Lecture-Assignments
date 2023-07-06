public class Main{
    public static void main(String[] args) {


        System.out.println("Test 1... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibelgulmez'  -  password1: '[rac()ecar]'  -  password2: '74'");
        // The username and passwords are valid. The door is opening, please wait..
        SecuritySystem s1 = new SecuritySystem("sibelgulmez", "[rac()ecar]", 74);
        System.out.println("\n\n");


        System.out.println("Test 2... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: ''  -  password1: '[rac()ecar]'  -  password2: '74'");
        // The username is invalid. It should have at least 1 character.
        SecuritySystem s2 = new SecuritySystem("", "[rac()ecar]", 74);
        System.out.println("\n\n");


        System.out.println("Test 3... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel1'  -  password1: '[rac()ecar]'  -  password2: '74'");
        // The username is invalid. It should have letters only.
        SecuritySystem s3 = new SecuritySystem("sibel1", "[rac()ecar]", 74);
        System.out.println("\n\n");


        System.out.println("Test 4... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: 'pass[]'  -  password2: '74'");
        // The password1 is invalid. It should have at least 8 characters.
        SecuritySystem s4 = new SecuritySystem("sibel", "pass[]", 74);
        System.out.println("\n\n");


        System.out.println("Test 5... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: 'abcdabcd'  -  password2: '74'");
        // The password1 is invalid. It should have at least 2 brackets.
        SecuritySystem s5 = new SecuritySystem("sibel", "abcdabcd", 74);
        System.out.println("\n\n");


        System.out.println("Test 6... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[[[[]]]]'  -  password2: '74'");
        // The password1 is invalid. It should have letters too.
        SecuritySystem s6 = new SecuritySystem("sibel", "[[[[]]]]", 74);
        System.out.println("\n\n");


        System.out.println("Test 7... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[no](no)'  -  password2: '74'");
        // The password1 is invalid. It should have at least 1 character from the username.
        SecuritySystem s7 = new SecuritySystem("sibel", "[no](no)", 74);
        System.out.println("\n\n");


        System.out.println("Test 8... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[rac()ecar]]'  -  password2: '74'");
        // The password1 is invalid. It should be balanced.
        SecuritySystem s8 = new SecuritySystem("sibel", "[rac()ecar]]", 74);
        System.out.println("\n\n");


        System.out.println("Test 9... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[rac()ecars]'  -  password2: '74'");
        // The password1 is invalid. It should be possible to obtain a palindrome from the password1.
        SecuritySystem s9 = new SecuritySystem("sibel", "[rac()ecars]", 74);
        System.out.println("\n\n");


        System.out.println("Test 10... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[rac()ecar]'  -  password2: '5'");
        // The password2 is invalid. It should be between 10 and 10,000.
        SecuritySystem s10 = new SecuritySystem("sibel", "[rac()ecar]", 5);
        System.out.println("\n\n");


        System.out.println("Test 11... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[rac()ecar]'  -  password2: '35'");
        // The password2 is invalid. It is not compatible with the denominations.
        SecuritySystem s11 = new SecuritySystem("sibel", "[rac()ecar]", 35);
        System.out.println("\n\n");



        System.out.println("Test 12... Inputs:");
        System.out.println("-----------------");
        System.out.println("username: 'sibel'  -  password1: '[rac()ecar]'  -  password2: '35' - denominations: [2, 4, 1]");
        System.out.println("5*2 + 6*4 + 3*1 = 37. Thus expected output is 'The username and passwords are valid. The door is opening, please wait..'");
        int [] denominations = new int [3];
        denominations[0] = 2;
        denominations[1] = 4;
        denominations[2] = 1;
        SecuritySystem s12 = new SecuritySystem("sibel", "[rac()ecar]", 37, denominations);
        System.out.println("\n\n");
    }
}