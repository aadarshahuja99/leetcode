class Foo {
    private static boolean isFirstCalled;
    private static boolean isSecondCalled;
    public Foo() {
        isFirstCalled = false;
        isSecondCalled = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(this)
        {
            printFirst.run();
            isFirstCalled = true;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this)
        {
            // printSecond.run() outputs "second". Do not change or remove this line.
            while(!isFirstCalled)
            {
                wait();
            }
            printSecond.run();
            isSecondCalled = true;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this)
        {
            // printThird.run() outputs "third". Do not change or remove this line.
            while(!isSecondCalled)
            {
                wait();
            }
            printThird.run();
        }
    }
}