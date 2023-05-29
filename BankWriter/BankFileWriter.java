package BankWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankFileWriter {
    private static final String FILE_PATH = "C:\\Users\\nowoo\\First.txt";

    public static void main(String[] args) {
        // Call the writeTransaction method or perform other operations here
        writeTransaction("Savings", "Deposit", 1000.0f);
    }

    public static void writeTransaction(String accountType, String transactionType, float amount) {
        Path filePath = Paths.get(FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());

            String transactionDetails = "Timestamp: " + timestamp + "\n"
                    + "Account Type: " + accountType + "\n"
                    + "Transaction Type: " + transactionType + "\n"
                    + "Amount: " + amount + "\n\n";

            writer.write(transactionDetails);
            System.out.println("Transaction details written to the file.");
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}

