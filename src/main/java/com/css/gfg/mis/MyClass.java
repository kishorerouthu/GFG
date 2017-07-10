package com.css.gfg.mis;

import java.io.*;

/**
 * @author Kishore Routhu on 10/7/17 3:32 PM.
 */

class NewClass1{

    private int i;
    NewClass1(){
        i=10;
    }
    int getVal() {
        return i;
    }
    void setVal(int i) {
        this.i=i;
    }
}

class MyClass extends NewClass1 implements Serializable {

    private String s;
    private NewClass1 n;

    MyClass(String s) {
        this.s = s;
        setVal(20);
    }

    public String toString() {
        return s + " " + getVal();
    }

    public static void main(String args[]) {
        MyClass m = new MyClass("Serial");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/serial.txt"));
            oos.writeObject(m); //writing current state
            oos.flush();
            oos.close();
            System.out.println(m); // display current state object value
        } catch (IOException e) {
            System.out.print(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/serial.txt"));
            MyClass o = (MyClass) ois.readObject(); // reading saved object
            ois.close();
            System.out.println(o); // display saved object state
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
