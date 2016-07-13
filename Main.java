package PhoneMn;

import java.util.Scanner;

/**
 * Created by PhuongThuan on 7/11/2016.
 */
public class Main {

    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();
        boolean set = true;
        Scanner input = new Scanner(System.in);

        while (set){
            System.out.println("==================");
            System.out.println("==PHONE MANAGER==");
            System.out.println("1. ADD CONTACT ");
            System.out.println("2. EDIT CONTACT ");
            System.out.println("3. DELETE CONTACT ");
            System.out.println("4. SEARCH CONTACT ");
            System.out.println("5. DISPLAY CONTACT ");
            System.out.println("6. EXIT ");
            System.out.println("CHOICE: ");
            int choice = input.nextInt();

            switch (choice){

                case 1:
                    input.nextLine();
                    PhoneEntry entry = new PhoneEntry();
                    System.out.println("ADD CONTACT");
                    //Input Name:
                    System.out.println("Name: ");
                    entry.setName(input.nextLine());
                    //Input PhoneNumber:
                    System.out.println("PhoneNumber: ");
                    entry.setPhoneNumber(input.nextLine());
                    if(pb.addEntry(entry)){
                        System.out.println("Add success !!");
                    }else {
                        System.out.println("Add failed !!");
                    }
                    break;

                case 2:
                    System.out.println("EDIT CONTACT");
                    System.out.println("1.Edit contact by name");
                    System.out.println("2.Edit contact by number");
                    int choicecase2 = input.nextInt();
                    switch (choicecase2){
                        case 1:
                            input.nextLine();
                            System.out.println("Enter OldName: ");
                            String oldName = input.nextLine();
                            System.out.println("Enter NewName: ");
                            String newName = input.nextLine();
                            if(pb.modifyEntryName(oldName, newName)){
                                System.out.println("Edit success !!");
                            }else {
                                System.out.println("Edit failed !!");
                            }
                            break;
                        case 2:
                            input.nextLine();
                            System.out.println("Enter OldNumber: ");
                            String oldNumber = input.nextLine();
                            System.out.println("Enter NewNumber: ");
                            String newNumber = input.nextLine();
                            if(pb.modifyEntryNumber(oldNumber, newNumber)){
                                System.out.println("Edit success !!");
                            }else {
                                System.out.println("Edit failed !!");
                            }
                            break;
                            default:
                                System.out.println("Oc cho =))");
                                break;
                    }
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("DELETE CONTACT");
                    System.out.println("Enter NameContact: ");
                    String namedel = input.nextLine();
                    if(pb.deleteEntry(namedel)){
                        System.out.println("Delete failed !!");
                    }else {
                        System.out.println("Delete success !!");
                    }
                    break;
                case 4:
                    System.out.println("SEARCH CONTACT");
                    System.out.println("1.Search contact by name");
                    System.out.println("2.Search contact by number");
                    int choicecase4 = input.nextInt();
                    switch (choicecase4){
                        case 1:
                            input.nextLine();
                            System.out.println("Enter NameContact: ");
                            String findname = input.nextLine();
                            PhoneEntry rs1 = pb.findEntryByName(findname);
                            if (rs1 != null){
                                System.out.println(rs1);
                            }else {
                                System.out.println("Oc cho =))");
                            }
                            break;
                        case 2:
                            input.nextLine();
                            System.out.println("Enter PhoneNumber: ");
                            String findphone = input.nextLine();
                            PhoneEntry rs2 = pb.findEntryByNumber(findphone);
                            if(rs2 != null){
                                System.out.println(rs2);
                            }else {
                                System.out.println("Oc cho =))");
                            }
                            break;
                        default:
                            System.out.println("Oc cho =))");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("LIST CONTACT = " + pb.getNumberOfEntries() + " contact ");
                    pb.display();
                    break;
                case 6:
                    System.out.println("GGWP");
                    set =false;
                    break;
                default:
                    System.out.println("Oc cho =))");
                    break;
            }
        }
    }
}
