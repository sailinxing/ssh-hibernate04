package com.lixinxin.model;

import java.io.Serializable;
import java.util.Set;

public class Course implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private Integer cid;
private String name;
private Set<Student> studentSet;
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Set<Student> getStudentSet() {
	return studentSet;
}
public void setStudentSet(Set<Student> studentSet) {
	this.studentSet = studentSet;
}

@Override
public String toString() {
	return "Course [cid=" + cid + ", name=" + name + "]";
}
public Course() {
	super();
}

}
