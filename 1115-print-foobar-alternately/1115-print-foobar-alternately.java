class FooBar {
    private int n;
    String lastWord = "";
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
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lastWord = "bar";
                notifyAll();
            }
        }
    }
}