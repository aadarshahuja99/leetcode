class FooBar {
    private int n;
    volatile String lastWord = "";
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i=0; i<n; i++)
        {
            synchronized(this)
            {
                while(!(lastWord.equals("") || lastWord.equals("bar")))
                {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lastWord = "foo";
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for(int i=0; i<n; i++)
        {
            synchronized(this)
            {
                while(!(lastWord.equals("foo")))
                {
                    // releases the lock for another thread goes into WAITING state
                    wait();
                }
                printBar.run();
                lastWord = "bar";
                notifyAll();
            }
        }
    }
}