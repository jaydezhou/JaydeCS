
package net.jayde.study.kodejava.example.lang;

public class CharacterIsLowerCase {
    public static void main(String[] args) {
        char a = 'a';

        //
        // Checks to see if a letter is a lowercase letter.
        //
        if (Character.isLowerCase(a)) {
            System.out.println(a + " is a lowercase character.");
        }

        //
        // Checks to see if a letter is a lowercase letter
        // by comparing the character type against
        // Character.LOWERCASE_LETTER constant value.
        //
        int charType = Character.getType(a);
        if (charType == Character.LOWERCASE_LETTER) {
            System.out.println(a + " is a lowercase character.");
        }
    }
}
