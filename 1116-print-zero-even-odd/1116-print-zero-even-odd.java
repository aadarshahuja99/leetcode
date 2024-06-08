class ZeroEvenOdd {
    private int numberOfZeroPrints;
    private boolean isEven;
    private boolean isOdd;
    private boolean isZero;
    private Object lock;
    private boolean isLastOdd;
    public ZeroEvenOdd(int n) {
        numberOfZeroPrints = n;
        lock = new Object();
        isZero = true;
        isOdd = false;
        isEven = false;
        isLastOdd = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<numberOfZeroPrints; i++)
        {
            synchronized(lock)
            {
                while(!isZero)
                {
                    lock.wait();
                }
                isZero = false;
                if(isLastOdd)
                {
                    isOdd = false;
                    isEven = true;
                }
                else
                {
                    isOdd = true;
                    isEven = false;
                }
                // System.out.println("z");
                printNumber.accept(0);
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=numberOfZeroPrints; i+=2)
        {
            synchronized(lock)
            {
                while(!isEven)
                {
                    lock.wait();
                }
                isZero = true;
                isOdd = false;
                isEven = false;
                isLastOdd = false;
                // System.out.println("e "+i);
                printNumber.accept(i);
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=numberOfZeroPrints; i+=2)
        {
            synchronized(lock)
            {
                while(!isOdd)
                {
                    lock.wait();
                }
                isZero = true;
                isOdd = false;
                isEven = false;
                isLastOdd = true;
                // System.out.println("o "+i);
                printNumber.accept(i);
                lock.notifyAll();
            }
        }
    }
}