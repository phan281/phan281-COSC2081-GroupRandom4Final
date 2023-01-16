package Controls.Items;

import java.io.IOException;
import java.util.Scanner;
import Controls.WorkWithFile.file_of_item;
import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * addItemToList
 */
public class addItemToList {

    static Scanner sc = new Scanner(System.in);

    public static void addItem() throws IOException {
        Items_ett Item;
        String Choice;
        file_of_item.rFileItem();

        while (true) { // Y/y : +1 item
            CommonMethod.clrscr();
            Item = new Items_ett();
            System.out.println("========== Add new item ==========");
            while (true) {
                System.out.print(Constants.input_id_item);
                Item.setID(sc.nextLine());
                if (CheckMethodAll.checkID(Item.getID(), Item) == -1) { // check existed id
                    if (CheckMethodAll.checkSpecialCharacter(Item.getID()) == 1)
                        break;
                } else {
                    System.out.println("ID " + Constants.ex_same_item);
                }
            }

            while (true) {
                System.out.print(Constants.input_name_item);
                Item.setName(sc.nextLine());
                // Check name similarity
                if (CheckMethodAll.checkName(Item.getName()) == -1) {
                    if (CheckMethodAll.checkSpecialCharacter(Item.getName()) == 1) {
                        break;
                    }
                } else {
                    System.out.println("Name " + Constants.ex_same_item);
                }
            }

            InputItemInfo.input(Item);
            createItemList.ListItem.add(Item);

            System.out.println("Successfully added!");
            file_of_item.wFileItem();
            System.out.print(Constants.input_y_n);
            Choice = CommonMethod.yesNo();
            if (Choice.equalsIgnoreCase("N")) {

                break;
            }
        }
    }
}