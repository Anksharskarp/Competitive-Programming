package intermediate.homework.Homework1;

class SubstitutionCipher {
    public static char[] normalChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static char[] codedChar
            = {'X', 'N', 'Y', 'A', 'H', 'P', 'O', 'G', 'Z', 'Q', 'W', 'B', 'T', 'S',
            'F', 'L', 'R', 'C', 'V', 'M', 'U', 'E', 'K',
            'J', 'D', 'I'};

    public static String encrypt(String s)
    {
        String encryptedString = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {

                if (s.charAt(i) == normalChar[j])
                {
                    encryptedString += codedChar[j];
                    break;
                }

                if (s.charAt(i) < 'a' || s.charAt(i) > 'z')
                {
                    encryptedString += s.charAt(i);
                    break;
                }
            }
        }

        return encryptedString;
    }

    public static String decrypt(String s)
    {

        String decryptedString = "";

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++) {

                if (s.charAt(i) == codedChar[j])
                {
                    decryptedString += normalChar[j];
                    break;
                }

                if (s.charAt(i) < 'A' || s.charAt(i) > 'Z')
                {
                    decryptedString += s.charAt(i);
                    break;
                }
            }
        }

        return decryptedString;
    }

    public static void main(String[] args) {
        String test1 = "cryptography";
        String test2 = "MGZVYZLGHCMHJMYXSSFMNHAHYCDLMHA";

        System.out.println("Plain text: " + test1);
        String encryptedTest1 = encrypt(test1.toLowerCase());
        System.out.println("Encrypted message: " + encryptedTest1);

        System.out.println("Ciphertext: " + test2);
        String decryptedTest2 = decrypt(test2.toLowerCase());
        System.out.println("Decrypted message: " + decryptedTest2);
    }
}
