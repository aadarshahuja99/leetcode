/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int random = Integer.MAX_VALUE;
        do
        {
            random = (rand7() - 1)*7 + rand7();
        }while(random > 40);
        return (random-1)%10 + 1;
    }
}