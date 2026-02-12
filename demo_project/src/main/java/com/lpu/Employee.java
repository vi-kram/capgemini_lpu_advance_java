package com.lpu;

public class Employee {
 int id;
 String name;
 int age;
 String dept;
 public Employee(int id,String name,int age,String dept) {
	 this.id=id;
	 this.name=name;
	 this.age=age;
	 this.dept=dept;
	 
 }
 public boolean isValidAge() {
	 if (age>17) {
		 return true;
	 }
	 else {
		 return false;
	 }
 }
 public static boolean isValidName(String name) {
     if (name == null) {
         return false;
     }

     name = name.trim();

     if (name.length() < 2) {
         return false;
     }

     return name.matches("[A-Za-z ]+");
 }
 
}
