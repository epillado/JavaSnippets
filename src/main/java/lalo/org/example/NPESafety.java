package org.example;

import java.util.Objects;

/*
 Finding out when NPE may be thrown.
 Objects.equals()
 String.equals()
 String length().
*/
public class NPESafety {
    public static void main(String[] args) {

        String name;
        String surname;

        // Objects.equals() does not throw NPE, because it checks if any
        // argument is null (i.e, it is null-safe):
        name=null;
        surname = null;
        try {
            System.out.println(Objects.equals(name, surname));
        } catch (NullPointerException e){
            System.out.println("NPE");
        }

        // name.equals() Throws NPE when name is null, but not when surname
        // is null, because the method first checks the argument and if it is
        // null, returns false:
        name="Not null.";
        surname = null;
        try {
            System.out.println("equals(): " + name.equals(surname));
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }
        name=null;
        surname = null;
        try {
            System.out.println("equals(): " + name.equals(surname));
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }

        // name.length() throws NPE when name is null:
        name=null;
        try {
            System.out.println("length():" + name.length());
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }

    }
}

