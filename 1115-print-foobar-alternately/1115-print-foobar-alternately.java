class FooBar {
    private int n;
    volatile String lastWord = "";
    ReentrantLock lock = new ReentrantLock();
    Condition foo = lock.newCondition();
    Condition bar = lock.newCondition();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i=0; i<n; i++)
        {
            lock.lock();
            try {
                while(!(lastWord.equals("") || lastWord.equals("bar")))
                {
                    foo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lastWord = "foo";
                bar.signal();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for(int i=0; i<n; i++)
        {
            lock.lock();
            try {
                while(!(lastWord.equals("foo")))
                {
                    // releases the lock for another thread goes into WAITING state
                    bar.await();
                }
                printBar.run();
                lastWord = "bar";
                foo.signal();
            }
            finally {
                lock.unlock();
            }
        }
    }
}