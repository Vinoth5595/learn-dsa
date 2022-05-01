package learn.coding;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PracticeJava7 {

    public static void main(String[] args) {
        String day = "SAT";
        switch (day) {   // switch on String selector
            case "MON": System.out.println("Monday"); break;
            case "TUE": System.out.println("Tuesday"); break;
            case "WED": System.out.println("Wednesday"); break;
            case "THU": System.out.println("Thursday"); break;
            case "FRI": System.out.println("Friday"); break;
            case "SAT": System.out.println("Saturday"); break;
            case "SUN": System.out.println("Sunday"); break;
            default: System.out.println("Invalid");
        }

        // Some 32-bit 'int' literal values
        int anInt1 = 0b0101_0000_1010_0010_1101_0000_1010_0010;
        int anInt2 = 0b0011_1000;

        // An 8-bit 'byte' literal value. By default, literal values are 'int'.
        // Need to cast to 'byte'
        byte aByte = (byte)0b0110_1101;

        // A 16-bit 'short' literal value
        short aShort = (short)0b0111_0101_0000_0101;

        // A 64-bit 'long' literal value. Long literals requires suffix "L".
        long aLong = 0b1000_0101_0001_0110_1000_0101_0000_1010_0010_1101_0100_0101_1010_0001_0100_0101L;

        // Formatted output: "%d" for integer in decimal, "%x" in hexadecimal, "%o" in octal.
        // Take note that "%b" prints true or false (for null), NOT binary.
        System.out.printf("%d(%x)(%o)(%b)\n", anInt1, anInt1, anInt1, anInt1);
        System.out.printf("%d(%x)(%o)(%b)\n", aByte, aByte, aByte, aByte);

        try {
            System.out.println("Exception Handling");
            exception1();
        } catch(ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        // it will throw IOException if in.txt is not available.
        try (BufferedReader src  = new BufferedReader(new FileReader("in.txt"));
             BufferedWriter dest = new BufferedWriter(new FileWriter("out.txt"))) {
            String line;
            while ((line = src.readLine()) != null) {
                System.out.println(line);
                dest.write(line);
                dest.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        List<String> lst2 = new ArrayList<>();
    }

    public static void exception1() throws ClassNotFoundException, SQLException{
        throw new ClassNotFoundException("I am throwing fake exception");
    }
}
