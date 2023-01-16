package Views;

import Controls.Bills.ShowBill_InfoWithDateCrate;
import Controls.Bills.createBill;
import Controls.Bills.showBill_InfoWithIDStaff;
import Controls.Customers.*;
import Controls.Items.*;

import java.io.IOException;
import java.util.Scanner;

import Shareds.CommonMethod;

/**
 * Untils
 */
public class Menu {

    static Scanner in = new Scanner(System.in);

    public static Boolean isEmpty = createItemList.ListItem.isEmpty();
    public static Boolean isEmpty2 = createCustomerList.listCustomer.isEmpty();

    public static void MainMenu() throws IOException {
        String Choose;
        CommonMethod.clrscr();
        while (true) {
            System.out.println("==================================");
            System.out.println("COSC2081 GROUP ASSIGNMENT ");
            System.out.println("STORE ORDER MANAGEMENT SYSTEM\n");
            System.out.println("Instructor: Mr. Tom Huynh & Dr. Phong Ngo");
            System.out.println("Group: Group Random 4 ");
            System.out.println("s3926005 - Vu Phan Anh ");
            System.out.println("s3613692 - Phi Nguyen Anh Duy");
            System.out.println("s3963613 - Nguyen Duy Khang");
            System.out.println("==================================");
            System.out.println("----- Welcome to the store ------");
            System.out.println("==================================");
            System.out.println("| 1. Manage items                 |");
            System.out.println("| 2. Manage customers             |");
            System.out.println("| 3. Manage bills                 |");
            System.out.println("| 0. Exit                         |");
            System.out.println("==================================");
            System.out.print("#Choose: ");
            while (true) {
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        itemManage();
                        break;
                    case "2":
                        customManage();
                        break;
                    case "3":
                        billManage();
                        break;
                    case "0":
                        in.close();
                        System.out.println("...\nSee you again.");
                        System.exit(0);
                        break;
                    default:
                        System.out.print("Wrong input " + Choose + " Enter again : ");
                        break;
                }
            }
        }

    }

    public static void customManage() throws IOException {
        String Choose;

        while (true) {
            CommonMethod.clrscr();
            System.out.println("======================================");
            System.out.println("|------ Manage customer list --------|");
            System.out.println("|====================================|");
            System.out.println("| 1. View customer list              |");
            System.out.println("| 2. Update customer info            |");
            System.out.println("| 3. Add new customer                |");
            System.out.println("| 0. Back to main menu               |");
            System.out.println("======================================");
            System.out.print(" #Choose: ");
            while (true) {
                Integer i = -1;
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        i += 1;
                        showInfoCusList.Display();
                        System.out.print("Press any to go back:");
                        in.nextLine();
                        break;
                    case "2":
                        i += 1;
                        editCusInList.editInfo();
                        break;

                    case "3":
                        i += 1;
                        addCusToList.addCustomer();
                        break;
                    case "0":
                        MainMenu();
                    default:
                        System.out.print("Wrong input! Enter again: ");
                        break;
                }
                if (i != -1)
                    break;
            }
        }
    }

    public static void itemManage() throws IOException {

        String Choose;
        while (true) {
            CommonMethod.clrscr();
            System.out.println("==================================");
            System.out.println("-------- Manage Item List --------");
            System.out.println("==================================");
            System.out.println("| 1. View item list              |");
            System.out.println("| 2. Update item info            |");
            System.out.println("| 3. Add new item                |");
            System.out.println("| 0. Back to main menu           |");
            System.out.println("==================================");
            System.out.print("#Choose: ");
            while (true) {
                Integer check = -1;
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        check += 1;
                        showInfoItemsInItemList.Display();
                        System.out.print("\nPress any to go back:");
                        in.nextLine();
                        break;
                    case "2":
                        check += 1;
                        editItemInList.editInfo();
                        break;
                    case "3":
                        check += 1;
                        addItemToList.addItem();
                        break;
                    case "0":
                        MainMenu();
                        break;
                    default:
                        System.out.print("Wrong input " + Choose + " Enter Again : ");
                        break;
                }
                if (check != -1)
                    break;

            }
        }
    }

    public static void billManage() throws IOException {
        String Choose;

        while (true) {
            CommonMethod.clrscr();
            System.out.println("======================================================");
            System.out.println("|----------------- Manage Bills ---------------------|");
            System.out.println("|====================================================|");
            System.out.println("| 1. Create bill                                     |");
            System.out.println("| 2. View bill with staff ID                         |");
            System.out.println("| 3. View created date                               |");
            System.out.println("| 0. Back to main menu                               |");
            System.out.println("======================================================");
            System.out.print(" #Choose: ");
            while (true) {
                Integer i = -1;
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        i += 1;
                        createBill.createBill();
                        break;
                    case "2":
                        showBill_InfoWithIDStaff.displayWithIdStaff();
                        i += 1;
                        break;

                    case "3":
                        ShowBill_InfoWithDateCrate.displayWithDateCreat();
                        i += 1;
                        break;
                    case "0":
                        MainMenu();
                    default:
                        System.out.print("Wrong input! Enter again: ");
                        break;
                }
                if (i != -1)
                    break;
            }
        }
    }

}