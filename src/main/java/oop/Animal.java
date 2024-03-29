package oop;

import lombok.Setter;

public class Animal {
    @Setter
    String name;
    public int old;

    public void setOld(int old) {

        if( old > 0){
        this.old = old;
    } else {
            System.out.println("Age cant't be negative");
        }


}

    public void sayHello() {
        System.out.println("woof");
    }


}

