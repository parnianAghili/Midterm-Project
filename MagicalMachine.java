
import java.util.Scanner;

public class MagicalMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        String inputString = scanner.nextLine();
        
        int[][] magicMachine = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                magicMachine[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        String outputString = "";
        int row = 0, col = 0, dir = 1;
        for (char c : inputString.toCharArray()) {
            int functionIndex = magicMachine[row][col];
            if (functionIndex == 1) {
                outputString += reverseString(Character.toString(c));
            } else if (functionIndex == 2) {
                outputString += repeatCharacters(Character.toString(c));
            } else if (functionIndex == 3) {
                outputString += repeatString(inputString);
            } else if (functionIndex == 4) {
                outputString += shiftRight(Character.toString(c));
            } else if (functionIndex == 5) {
                outputString += shiftCharacters(inputString);
            }
            
            if ((row == 0 && dir == -1) || (row == n - 1 && dir == 1)) {
                col += dir;
                dir = -dir;
            } else {
                row += dir;
            }
        }
        
        System.out.println(outputString);
    }
    
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String repeatCharacters(String input) {
        StringBuilder repeatedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            repeatedString.append(c).append(c);
        }
        return repeatedString.toString();
    }

    public static String repeatString(String input) {
        return input + input;
    }

    public static String shiftRight(String input) {
        return input.charAt(input.length() - 1) + input.substring(0, input.length() - 1);
    }

    public static String shiftCharacters(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char) ((characters[i] - 'a' + i) % 26 + 'a');
        }
        return new String(characters);
    }
}
