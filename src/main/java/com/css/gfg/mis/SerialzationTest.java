package com.css.gfg.mis;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Problem :
 *
 * What happens when serialize the following child class ?
 * class Parent {
 * }
 *
 * class Child extends Parent implements Serializable {
 * }
 * //serialize child class
 *
 * Explanation : In this case only the properties in the child will be serialize as the child implements serialize and
 *               properties inherited from the parent won't be serialize.
 *
 * @author Kishore Routhu on 10/7/17 3:06 PM.
 */
public class SerialzationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {
        URL url = SerialzationTest.class.getClassLoader().getResource("ChildObject");
        File file = new File(url.toURI().getPath());

        Child child = new Child();
        child.setVal(44);

        //Serialize the object
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(child);
        outputStream.flush();
        outputStream.close();

        //DeSerialize the object
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Child child1 = (Child) inputStream.readObject();
        inputStream.close();

        System.out.println(child1);
    }

   static class Parent {
       int val;

       public int getVal() {
           return val;
       }

       public void setVal(int val) {
           this.val = val;
       }
    }

   static class Child extends Parent implements Serializable {


       @Override
       public String toString() {
           return "Child{" +
                   "val=" + getVal() +
                   '}';
       }
   }
}
