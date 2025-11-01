class H2O {
    int currentHydrogenCount;
    int currentOxygenCount;
    Object lock;
    public H2O() {
        lock = new Object();
        currentHydrogenCount = 0;
        currentOxygenCount = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized(lock)
        {
            while(currentHydrogenCount == 2)
            {
                lock.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            currentHydrogenCount++;
            if(currentHydrogenCount == 2 && currentOxygenCount == 1)
            {
                currentHydrogenCount = 0;
                currentOxygenCount = 0;
            }
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized(lock)
        {
            while(currentOxygenCount == 1 && currentHydrogenCount != 2)
            {
                lock.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
            currentOxygenCount++;
            if(currentHydrogenCount == 2 && currentOxygenCount == 1)
            {
                currentHydrogenCount = 0;
                currentOxygenCount = 0;
            }
            lock.notifyAll();
        }
    }
}