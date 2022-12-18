// Write a program to create interface named test.
// In this interface the member function is square.
// Implement this interface in arithmetic class.
// Create one new class called ToTestInt in this class use the object of arithmetic class.

interface test
{
    void square(int a);
}

class arithmetic implements test
{
    public void square(int a)
    {
        System.out.println("Square of " + a + " is " + (a * a));
    }
}

class ToTestInt
{
    public static void main(String[] args)
    {
        arithmetic obj = new arithmetic();
        obj.square(5);
    }
}