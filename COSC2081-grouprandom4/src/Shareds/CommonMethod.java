package Shareds;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Controls.Bills.createBillList;
import Controls.Items.*;
import Models.Bill_ett;

/**
 * CommonMethod
 */
public class CommonMethod {

    public static void inTien(Bill_ett x) {

        System.out.println("-  Total cost: " + x.getToTalBill() + " VND");

        System.out.print("Press any to go back...");
        in.nextLine();
    }

    public static void displayBillWithDateCreate(LocalDate xxx) {
        System.out.println("\n========================================================");
        System.out.printf("| %-10s | %-20s | %-16s |\n", "Bill ID", "Created time", "Total cost");
        System.out.println("========================================================");
        for (Bill_ett bill_ett : createBillList.listBill) {
            if (bill_ett.getDateCreat().equals(xxx)) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                System.out.printf("| %-10s | %-20s | %-13s VND|\n", bill_ett.get_Bill_ID(),
                        dtf.format(bill_ett.getTimeCreat()), bill_ett.getToTalBill());
            }
        }
        System.out.println("========================================================");

    }

    public static void displayBillWithId(String id) {
        System.out.println("\n================================================================================");
        System.out.printf("| %-10s | %-15s | %-15s | %-26s |\n", "Bill ID", "Created date", "Quantity",
                "Total cost");
        System.out.println("================================================================================");
        for (int i = 0; i < createBillList.listBill.size(); i++) {

            if (createBillList.listBill.get(i).getStaffID().equals(id)) {
                System.out.printf("| %-10s | %-16s | %-15d | %-23d VND|\n",
                        createBillList.listBill.get(i).get_Bill_ID(),
                        createBillList.listBill.get(i).getDateCreat().format(Constants.dtf),
                        createBillList.listBill.get(i).getAmountOfItem(),
                        createBillList.listBill.get(i).getToTalBill());
            }
        }
        System.out.println("================================================================================");


    }

    public static void outputAmountReport(int index_ID_Item) {
        System.out.printf("Available quantity %d %s %s!\n",
                createItemList.ListItem.get(index_ID_Item).getAmount(),
                createItemList.ListItem.get(index_ID_Item).getType(),
                createItemList.ListItem.get(index_ID_Item).getName());
    }

    static Scanner in = new Scanner(System.in);

    public static void clrscr() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static String yesNo() {
        while (true) {
            String n = in.nextLine().trim();
            if (n.equalsIgnoreCase("N") || n.equalsIgnoreCase("Y")) {
                return n;
            } else {
                System.out.print("Wrong input!Enter again : ");
            }
        }

    }
}