package Controls.Bills;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_bill;
import Models.Bill_ett;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * ShowBill_InfoWithDateCrate
 */
public class ShowBill_InfoWithDateCrate {
    static Scanner in = new Scanner(System.in);

    public static void displayWithDateCreat() throws IOException {
        CommonMethod.clrscr();
        file_of_bill.rFileBill();
        if (createBillList.listBill.size() > 0) {

            System.out.println("================= Bill ==================\n");
            boolean x = false;
            Integer check = -1, check2 = 1;
            while (x == false) {
                System.out.print("- Enter date(d/M/yyyy) : ");
                LocalDate xxx;
                try {

                    xxx = LocalDate.parse(in.nextLine(), Constants.dtf);
                    x = true;
                    for (Bill_ett bill_ett : createBillList.listBill) {
                        if (bill_ett.getDateCreat().format(Constants.dtf).equals(xxx.format(Constants.dtf))) {
                            check = check2;
                            break;
                        }
                    }
                    if (check == 1) {
                        CommonMethod.displayBillWithDateCreate(xxx);
                        System.out.print("Press any to go back...");
                        in.nextLine();
                        break;
                    } else {
                        System.out.print("0 bill created !\nEnter any number to go back...");
                        in.nextLine();
                    }
                } catch (Exception e) {
                    x = false;
                    System.out.println("Wrong input!");
                }

            }
        } else {
            System.out.print("0 bill created!\nPress any to go back...");
            in.nextLine();
        }

    }
}