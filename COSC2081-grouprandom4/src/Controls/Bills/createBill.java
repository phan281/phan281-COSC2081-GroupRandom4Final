package Controls.Bills;

import Controls.Customers.createCustomerList;
import Controls.Items.createItemList;
import Controls.Items.showInfoItemsInItemList;

import Models.Bill_ett;
import Models.Customer_ett;
import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;
import Views.Menu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class createBill {

    static Scanner in = new Scanner(System.in);

    public static void createBill() throws IOException {
        Controls.WorkWithFile.file_of_item.rFileItem();
        Controls.WorkWithFile.file_of_customer.rFileCustomer();
        Controls.WorkWithFile.file_of_bill.rFileBill();
        CommonMethod.clrscr();
        // check item list
        if (!createItemList.ListItem.isEmpty()) {

            Integer intdexCustomer, itemCount = 0, index_ID_Item, amount_Item_On_Bill;
            Bill_ett newBill = new Bill_ett();

            //
            System.out.println("========== Create Bill ==========");
            while (true) {
                System.out.print("Enter bill ID: ");
                newBill.set_Bill_ID(in.nextLine());
                String id = newBill.get_Bill_ID();
                if (CheckMethodAll.checkSpecialCharacter(newBill.get_Bill_ID()) == 1) {

                    if (CheckMethodAll.checkID(id, newBill) == -1)
                        break;
                    else {
                        System.out.println("Bill ID " + Constants.already_exits_report);
                    }
                }
            }
            //
            while (true) {
                System.out.print("Enter customer ID: ");
                String id = in.nextLine();
                intdexCustomer = CheckMethodAll.checkID(id, new Customer_ett());
                if (CheckMethodAll.checkSpecialCharacter(id) == 1) {
                    break;
                }
            }
            //
            while (true) {
                System.out.print("Enter staff ID: ");
                newBill.setStaffID(in.nextLine());
                if (CheckMethodAll.checkSpecialCharacter(newBill.getStaffID()) == 1)
                    break;
            }
            //
            while (true) {
                while (true) { // check item id
                    showInfoItemsInItemList.Display();
                    System.out.print("\nEnter item ID of item " + (itemCount + 1) + " : ");
                    String id_Item = in.nextLine();
                    index_ID_Item = CheckMethodAll.checkID(id_Item, new Items_ett());
                    // check if item existed
                    if (index_ID_Item != -1) {

                        if (createItemList.ListItem.get(index_ID_Item).getAmount() == 0) {
                            System.out.printf("Out of stock %s!\n",
                                    createItemList.ListItem.get(index_ID_Item).getName());
                            System.out.print("Continue adding item?(Y/N) : ");
                            if (CommonMethod.yesNo().equalsIgnoreCase("N")) {
                                // print file if not continue
                                if (itemCount == 0) {
                                    Menu.billManage();
                                } else {
                                    CommonMethod.inTien(newBill);
                                    newBill.setDateCreat(LocalDate.now());
                                    newBill.setTimeCreat(LocalTime.now());
                                    int pointReward;
                                    if (intdexCustomer != -1) {
                                        pointReward = newBill.getToTalBill() / 1000
                                                + createCustomerList.listCustomer.get(intdexCustomer).getRewardPoint();
                                        createCustomerList.listCustomer.get(intdexCustomer).setRewardPoint(pointReward);
                                        Controls.WorkWithFile.file_of_customer.wFileCustomer();
                                    }
                                    createBillList.listBill.add(newBill);
                                    Controls.WorkWithFile.file_of_bill.wFileBill();
                                    Menu.billManage();
                                }
                            }
                        } else {
                            itemCount++;
                            break;
                        }

                    } else {
                        System.out.println("ID not founded!");
                        System.out.print("Continue adding item?(Y/N) : ");
                        if (CommonMethod.yesNo().equalsIgnoreCase("N"))
                            Menu.billManage();
                    }

                }
                //
                while (true) {
                    System.out.print("Enter quantity: ");
                    amount_Item_On_Bill = CheckMethodAll.checkIntegerInput();
                    if (amount_Item_On_Bill > createItemList.ListItem.get(index_ID_Item).getAmount()) {
                        CommonMethod.outputAmountReport(index_ID_Item);
                    } else {
                        if (amount_Item_On_Bill > 0) {
                            Integer amountTotal = createItemList.ListItem.get(index_ID_Item).getAmount()
                                    - amount_Item_On_Bill;

                            createItemList.ListItem.get(index_ID_Item).setAmount(amountTotal);
                            Controls.WorkWithFile.file_of_item.wFileItem();
                            break;
                        } else
                            System.out.println("Quantity must > 0");
                    }

                }
                // calculate total
                Integer totalMoneyIteam = amount_Item_On_Bill * createItemList.ListItem.get(index_ID_Item).getCost();
                // set total cost
                newBill.setTotalBill(newBill.getToTalBill() + totalMoneyIteam);
                // set items quantity in bill.
                newBill.setAmountOfItem(itemCount);
                System.out.print("Continue adding item?(y/n) : ");
                String choice = CommonMethod.yesNo();

                if (choice.equalsIgnoreCase("N")) {
                    CommonMethod.inTien(newBill);
                    newBill.setDateCreat(LocalDate.now());
                    newBill.setTimeCreat(LocalTime.now());
                    int pointReward;
                    if (intdexCustomer != -1) {

                        pointReward = newBill.getToTalBill() / 1000
                                + createCustomerList.listCustomer.get(intdexCustomer).getRewardPoint();
                        createCustomerList.listCustomer.get(intdexCustomer).setRewardPoint(pointReward);
                        Controls.WorkWithFile.file_of_customer.wFileCustomer();
                    }
                    createBillList.listBill.add(newBill);
                    Controls.WorkWithFile.file_of_bill.wFileBill();
                    break;
                }

            }
        } else {
            System.out.print("No item yet!" + "\n" + Constants.input_randomKey);
            in.nextLine();
        }
    }

}