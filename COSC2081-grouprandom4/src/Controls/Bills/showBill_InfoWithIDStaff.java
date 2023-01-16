package Controls.Bills;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_bill;
import Shareds.CommonMethod;

/**
 * showInfoWithIDStaff
 */
public class showBill_InfoWithIDStaff {
    static Scanner in = new Scanner(System.in);

    public static void displayWithIdStaff() throws IOException {
        CommonMethod.clrscr();
        file_of_bill.rFileBill();
        String id;
        if (createBillList.listBill.size() > 0) {
            System.out.println("======================= Bills list by Staff ID =======================");
            while (true) {
                System.out.print("\nEnter staff ID: ");
                int index = -1;
                id = in.nextLine();
                for (int i = 0; i < createBillList.listBill.size(); i++) {
                    if (createBillList.listBill.get(i).getStaffID().equals(id)) {
                        index = i;
                    }
                }
                if (index != -1) {
                    CommonMethod.displayBillWithId(id);
                    System.out.print("Press any to go back...");
                    in.nextLine();
                    break;
                } else {
                    System.out.println("Bill id not existed : " + id + "!");
                    System.out.print("Press any to go back...");
                    in.nextLine();
                    break;
                }
            }

        } else {
            System.out.print("0 bill created!\nPress any to go back...");
            in.nextLine();
        }
    }
}