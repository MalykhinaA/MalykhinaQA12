package generators;

import model.ContactData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException{
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);

    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(ContactData contact : contacts){
            bw.write(String.format("%s;%s;%s;\n", contact.getName(), contact.getSurname(), contact.getYear()));
        }
        bw.close();

    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for(int i=0; i<count; i++){
            contacts.add(new ContactData().withName(String.format("name %s",i))
            .withSurname(String.format("LastName %s",i))
                    .withBirthYear(String.format("%s",1995-i)));
        }
        return contacts;
    }
}
