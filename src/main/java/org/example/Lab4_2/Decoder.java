package org.example.Lab4_2;

public class Decoder {
    public static String vowelsDecoder(String words) {
        StringBuilder sb = new StringBuilder();
        for (char ch : words.toCharArray()) {
            switch (ch) {
                case '1':
                    sb.append('a');
                    break;
                case '2':
                    sb.append('e');
                    break;
                case '3':
                    sb.append('i');
                    break;
                case '4':
                    sb.append('o');
                    break;
                case '5':
                    sb.append('u');
                    break;
                default:
                    sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String consonantsDecoder(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                char decodedChar = ch == 'a' ? 'z' : (char) (ch - 1);
                sb.append(decodedChar);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String decipher(String encryptedWord) {
        if (encryptedWord.matches(".*[a-zA-Z].*\\d.*")) {
            return vowelsDecoder(encryptedWord);
        } else if (encryptedWord.matches("\\D*")) {
            return consonantsDecoder(encryptedWord);
        } else {
            return encryptedWord;
        }
    }

    public static void main(String[] args) {
        String codedMessage = "t2st3ng uftujoh 123456789 T2ST3NG UFTUJOH";
        String[] codedWords = codedMessage.split("\\s+");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : codedWords) {
            String decodedWord = decipher(word);
            decodedMessage.append(decodedWord).append(" ");
        }

        System.out.println("Decoded Message: " + decodedMessage.toString().trim());
    }
}