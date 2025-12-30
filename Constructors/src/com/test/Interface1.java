
package com.test;

interface Inf1 {
    void cat();
    void dog();
}

abstract class Abs {
    public abstract void disp();

    public void show() {
        System.out.println("Implemented Method");
    }
}

class Impl1 extends Abs implements Inf1 {

    @Override
    public void disp() {
        System.out.println("Abs method overridden");
    }

    @Override
    public void cat() {
        System.out.println("Inf method overridden");
    }

    @Override
    public void dog() {
        System.out.println("Concrete class method");
    }
}

public class Interface1 {
    public static void main(Strings1[] args) {
        Impl1 obj = new Impl1();
        obj.cat();
        obj.dog();
        obj.disp();
        obj.show();
    }
}
