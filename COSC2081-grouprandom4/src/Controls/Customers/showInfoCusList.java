package Controls.Customers;

import java.io.IOException;
import java.util.Collections;

import Controls.WorkWithFile.file_of_customer;
import Models.Customer_ett;
import Shareds.CommonMethod;

/**
 * showInfoCusList
 */
public class showInfoCusList {

    public static void Display() throws IOException {
        file_of_customer.rFileCustomer();
        CommonMethod.clrscr();
        Collections.sort(createCustomerList.listCustomer);
        System.out.print(
                "==========================================================================================");
        System.out.print(
                "\n|                               Customer list                                        |\n");

        System.out.println(
                "==========================================================================================");
        System.out.printf("| %-25s | %-25s | %-15s | %-12s |\n", "ID", "Name",
                "Phone number", "Total spend");
        System.out.println(
                "==========================================================================================");
        if (createCustomerList.listCustomer.isEmpty())
            System.out.println("Empty list!");
        for (Customer_ett x : createCustomerList.listCustomer) {
            System.out.printf("| %-25s | %-25s | %-15s | %-12s |\n", x.getID(), x.getName(),
                    x.getPhoneNumber(), x.getRewardPoint());
        }
        System.out.println(
                "==========================================================================================");
    }

}