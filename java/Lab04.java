// Write a program to create interface A in this interface we have two method meth1 and meth2.
// Implement this interface in anoother class named MyClass.

interface A
{
    void meth1();
    void meth2();
}

class MyClass implements A
{
    public void meth1()
    {
        System.out.println("This is meth1");
    }
    public void meth2()
    {
        System.out.println("This is meth2");
    }
}

public class Lab04
{
    public static void main(String[] args)
    {
        MyClass obj = new MyClass();
        obj.meth1();
        obj.meth2();
    }
}