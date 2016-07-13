package PhoneMn;

import java.util.Arrays;

/**
 * Created by PhuongThuan on 7/11/2016.
 */
public class PhoneBook {
    private int numberOfEntries =0;
    private PhoneEntry[] phoneEntries = new PhoneEntry[100];


    public PhoneBook(){

    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public PhoneEntry[] getPhoneEntries() {
        return phoneEntries;
    }

    public void setPhoneEntries(PhoneEntry[] phoneEntries) {
        this.phoneEntries = phoneEntries;
    }

    public boolean addEntry(PhoneEntry entry){
        if(!isDuplicateName(entry.getPhoneNumber())
                && numberOfEntries < phoneEntries.length){
            phoneEntries[numberOfEntries] = entry;
            numberOfEntries++;
            return true;
        }
        return  false;
    }

    public boolean deleteEntry(String entryName){
        boolean check = false;
        if(isDuplicateName(entryName)){
            for (int i = 0; i<phoneEntries.length;i++){
                if(phoneEntries[i].getName().equals(entryName)){
                    check=true;
                    break;
                }
            }
            if(check){
                for(int i = 0; i<phoneEntries.length-1;i++){
                    phoneEntries[i] = phoneEntries[i+1];

                }
                numberOfEntries--;
            }
        }
        return false;
    }

    public PhoneEntry findEntryByName(String entryName){
        for (int i = 0; i<numberOfEntries;i++){
            if(phoneEntries[i].getName().equals(entryName)){
                return phoneEntries[i];
            }
        }
        return null;
    }

    public PhoneEntry findEntryByNumber(String entryNumber){
        for(int i = 0; i<numberOfEntries;i++){
            if(phoneEntries[i].getPhoneNumber().equals(entryNumber)){
                return phoneEntries[i];
            }
        }
        return null;
    }

    public int getNumberOfEntries(){

        return numberOfEntries;
    }

    private boolean isDuplicateName(String entryName){
        if(numberOfEntries ==0){
            return false;
        }else
            for(int i = 0;i<numberOfEntries;i++) {
                if (phoneEntries[i].getName().equals(entryName)) {
                    return true;
                }
            }
        return false;
    }

    private boolean isDuplicateNumber(String entryNumber){
        if(numberOfEntries ==0){
            return false;
        }else
            for(int i = 0;i<numberOfEntries;i++) {
                if (phoneEntries[i].getPhoneNumber().equals(entryNumber)) {
                    return true;
                }
        }
        return false;
    }

    public boolean modifyEntryName(String oldName, String newName){
        if(isDuplicateName(oldName)){
            for(int i =0; i<numberOfEntries;i++){
                if(phoneEntries[i].getName().equals(oldName)){
                    phoneEntries[i].setName(newName);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean modifyEntryNumber(String entryName, String newNumber){
        if(isDuplicateName(entryName)){
            for (int i =0; i<numberOfEntries;i++){
                if(phoneEntries[i].getName().equals(entryName)){
                    phoneEntries[i].setPhoneNumber(newNumber);
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        return " NumberOfEntries: " + numberOfEntries + "\n" + phoneEntries;
    }
    public void display(){
        for (int i = 0; i < numberOfEntries; i++) {
            if (phoneEntries[i] != null) {
                System.out.println(phoneEntries[i].toString());
            }
        }
    }
}
