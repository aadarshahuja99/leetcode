class DiningPhilosophers {
    boolean[] forkStatus;
    final Object lock;
    public DiningPhilosophers() {
        forkStatus = new boolean[5];
        Arrays.fill(forkStatus, true);
        lock = new Object();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftForkId = philosopher;
        int rightForkId = (philosopher + 1)%5;
        synchronized(lock)
        {
            while(!forkStatus[leftForkId])
            {
                lock.wait();
            }
            forkStatus[leftForkId] = false;
            pickLeftFork.run();
            lock.notify();
            while(!forkStatus[rightForkId])
            {
                lock.wait();
            }
            forkStatus[rightForkId] = false;
            pickRightFork.run();
            
            eat.run();

            forkStatus[rightForkId] = true;
            putRightFork.run();
            
            forkStatus[leftForkId] = true;
            putLeftFork.run();
            
            lock.notifyAll();
        }
    }
}