package profiles;

/**
 * This adds a persona to the Cucumber Scenarios.
 * All the attributes to the person can be mentioned here as a static method
 */

public class John {

    private static String accountName = "John";
    private static String beneficiary1 = "tester";
    private static String userId = "Gavhane";
    private static String pwd = "prash_333";

    /**
     * Gets account name.
     *
     * @return the account name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Gets beneficiary 1.
     *
     * @return the beneficiary 1
     */
    public static String getBeneficiary1() {
        return beneficiary1;
    }
}
