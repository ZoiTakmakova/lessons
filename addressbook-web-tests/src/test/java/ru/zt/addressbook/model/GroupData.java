package ru.zt.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
@Override
public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;

  GroupData groupData = (GroupData) o;

  if (id != groupData.id) return false;
  if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
  if (header != null ? !header.equals(groupData.header) : groupData.header != null) return false;
  return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;
}

@Override
public int hashCode() {
  int result = id;
  result = 31 * result + (name != null ? name.hashCode() : 0);
  result = 31 * result + (header != null ? header.hashCode() : 0);
  result = 31 * result + (footer != null ? footer.hashCode() : 0);
  return result;
}

@XStreamOmitField
@Id
@Column(name = "group_id")
private int id = Integer.MAX_VALUE;

@Expose
@Column(name = "group_name")
private String name;

public Set<ContactData> getContacts() {
  return new Contacts(contacts);
}

@Expose
@Column(name = "group_header")
@Type(type = "text")
private String header;

@Expose
@Column(name = "group_footer")
@Type(type = "text")
private String footer;

@ManyToMany(mappedBy = "groups")
private Set<ContactData> contacts = new HashSet<ContactData>();

public int getId() {
  return id;
}

public GroupData withId(int id) {
  this.id = id;
  return this;//позволяет вызывать каскады - вытягивать методы в цепочку
}

public GroupData withName(String name) {
  this.name = name;
  return this;//позволяет вызывать каскады - вытягивать методы в цепочку
}

@Override
public String toString() {
  return "GroupData{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", header='" + header + '\'' +
          ", footer='" + footer + '\'' +
          '}';
}

public GroupData withHeader(String header) {
  this.header = header;
  return this;//позволяет вызывать каскады - вытягивать методы в цепочку
}

public GroupData withFooter(String footer) {
  this.footer = footer;
  return this;//позволяет вызывать каскады - вытягивать методы в цепочку
}

public String getName() {
  return name;
}

public String getHeader() {
  return header;
}

public String getFooter() {
  return footer;
}


}