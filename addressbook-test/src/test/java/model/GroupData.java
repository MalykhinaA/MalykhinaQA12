package model;

import java.util.Objects;

public class GroupData implements Comparable<GroupData>{
    private int id;
    private String groupName;
    private String header;
    private String footer;

    public String getGroupName() {
        return groupName;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
    public int getId() {
        return id;
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }
    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, groupName);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", groupName: " + groupName + "\n";
    }

    @Override
    public int compareTo(GroupData g) {
        return this.id - g.id;
    }
}
