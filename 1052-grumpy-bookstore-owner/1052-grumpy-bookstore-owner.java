class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsatisfiedCustomers = 0;

        // Calculate initial number of unsatisfied customers in first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unsatisfiedCustomers += customers[i] * grumpy[i];
        }

        int maxUnsatisfiedCustomers = unsatisfiedCustomers;

        // Slide the 'minutes' window across the rest of the customers array
        for (int i = minutes; i < n; i++) {
            // Add the current minute's unsatisfied customers if the owner is grumpy
            // and remove the customers that are out of the current window
            unsatisfiedCustomers += customers[i] * grumpy[i];
            unsatisfiedCustomers -= customers[i - minutes] * grumpy[i - minutes];

            // Update the maximum unsatisfied customers
            maxUnsatisfiedCustomers = Math.max(
                maxUnsatisfiedCustomers,
                unsatisfiedCustomers
            );
        }

        // Start with maximum possible satisfied customers due to secret technique
        int satisfiedCustomers = maxUnsatisfiedCustomers;

        // Add the satisfied customers during non-grumpy minutes
        for (int i = 0; i < customers.length; i++) {
            satisfiedCustomers += customers[i] * (1 - grumpy[i]);
        }

        // Return the maximum number of satisfied customers
        return satisfiedCustomers;
    }
}