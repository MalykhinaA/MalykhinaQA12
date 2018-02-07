package generators;

import model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
    public static void main(String[] args) throws IOException{
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<GroupData> groups = generateGroups(count);
        save(groups, file);
    }

    public static void save (List<GroupData> groups, File file) throws IOException{
            Writer writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            for(GroupData group : groups){
                bw.write(String.format("%s;%s;%s;\n", group.getHeader(), group.getGroupName(), group.getFooter()));
            }
            bw.close();

    }

    public static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for(int i = 0; i<count; i++){
            groups.add(new GroupData().withHeader(String.format("header %s",i))
                    .withGroupName(String.format("name %s",i))
                    .withFooter(String.format("footer %s",i)));
        }
        return groups;
    }

}
