package Controls.Items;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_item;
import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * editItemInList
 */
public class editItemInList {

    static Scanner in = new Scanner(System.in);

    public static void editInfo() throws IOException {
        String Choice;
        Items_ett Item;
        Integer indexItem = -1;

        while (true) {
            Item = new Items_ett();
            CommonMethod.clrscr();
            showInfoItemsInItemList.Display();
            if (createItemList.ListItem.isEmpty()) {// check empty list

                System.out.print("\n" + Constants.input_randomKey);
                in.nextLine();
                break;
            } else {
                System.out.println("\n====== Update item info =====");

                while (true) {// check existed id
                    System.out.print("Enter item ID: ");
                    Item.setID(in.nextLine());
                    indexItem = CheckMethodAll.checkID(Item.getID(), Item);
                    if (indexItem != -1) {
                        break;
                    } else {
                        System.out.println(Constants.ex_not_find + "ID!");
                    }
                }

                while (true) { // check item name
                    System.out.print("- Edit item name : ");
                    Item.setName(in.nextLine());
                    Integer indexName = CheckMethodAll.checkName(Item.getName());
                    if (indexName == -1 || indexName == indexItem) {
                        if (CheckMethodAll.checkSpecialCharacter(Item.getName()) == 1)
                            break;
                    } else {
                        System.out.print("Item name existed!\n");
                    }

                }
                InputItemInfo.input(Item);
                System.out.print("Finish updating?(y/n): ");
                Choice = CommonMethod.yesNo();

                if (Choice.equalsIgnoreCase("Y")) {

                    createItemList.ListItem.set(indexItem, Item);

                    file_of_item.wFileItem();
                    System.out.println("Successfully updated!");
                } else
                    System.out.println("Failed to update!");
                System.out.print("Continue updating?(y/n): ");
                Choice = CommonMethod.yesNo();
                if (Choice.equalsIgnoreCase("N")) { // check case N n
                    break;
                }
            }

        }
    }

}