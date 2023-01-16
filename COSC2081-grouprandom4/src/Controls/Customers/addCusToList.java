package Controls.Customers;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_customer;
import Models.Customer_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * addCusToList
 */
public class addCusToList {
    static Scanner in = new Scanner(System.in);

    public static void addCustomer() throws IOException {

        Customer_ett newCus;
        file_of_customer.rFileCustomer();
        while (true) {// Y/y : add 1 more customer
            CommonMethod.clrscr();

            newCus = new Customer_ett();

            System.out.println("============= Add new customer =============\n");
            while (true) {// check if duplicated
                System.out.print("- Enter customer ID: ");
                newCus.setID(in.nextLine());
                if (CheckMethodAll.checkID(newCus.getID(), newCus) == -1) {
                    if (CheckMethodAll.checkSpecialCharacter(newCus.getID()) == 1)
                        break;
                } else {
                    System.out.println("ID " + Constants.already_exits_report);
                }
            }
            while (true) {// check special character
                System.out.print("- Enter customer name(a-z): ");
                newCus.setName(in.nextLine());
                if (CheckMethodAll.checkSpecialCharacterAndNumber(newCus.getName()) == 1)
                    break;
            }
            while (true) {// check input type and existed phone number
                System.out.print("- Enter phone number (0-9): ");
                newCus.setPhoneNumber(in.nextLine());
                if (CheckMethodAll.checkPhoneNumBer(newCus.getPhoneNumber()) == -1) {
                    if (CheckMethodAll.checkSpecialCharacter(newCus.getPhoneNumber()) == 1)
                        if (CheckMethodAll.checkLetterInString(newCus.getPhoneNumber()) == false)
                            break;
                        else
                            System.out.println(Constants.ex_wrong_dataType + "Number : 0-9");

                } else
                    System.out.println("Phone number " + Constants.already_exits_report);
            }
            newCus.setRewardPoint(0);
            createCustomerList.listCustomer.add(newCus);
            file_of_customer.wFileCustomer();
            System.out.println("Successfully added!");
            System.out.print(Constants.input_y_n);
            String yn = CommonMethod.yesNo();
            if (yn.equals("n") || yn.equals("N")) {
                break;
            }
        }

    }

}