import service.BusinessLogicReimbursement;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by npw383 on 4/19/17.
 */
public class BusinessLogicReimbursementTest {

    @Test
    public void testReimbursementAmountEntryValid(){
        BusinessLogicReimbursement blrtest = new BusinessLogicReimbursement();

        Double d1 = null;
        Double d2 = 00.00; //needs to be >0 amount
        //System.out.println(d2);
        Double d3 = 10000000000000000000000000.00;//too big!
        Double d4 = 100.00; //>=1 character, <22 characters before decimal
        Double d7 = 100.004; //must be <=2 characters after decimal
        //what happens if they enter non-decimal number or crazy character?
        //Double d5 = 0; //>2 characters, <22 characters
        //Double d6 = 10!.02; //all numbers form should resolve issue for us

        Assert.assertFalse("Amount is null", blrtest.amountValid(d1));
        Assert.assertFalse("Amount is >$0", blrtest.amountValid(d2));
        Assert.assertFalse("Amount before decimal is <22 characters", blrtest.amountValid(d3));
        Assert.assertTrue("Amount before decimal is >=1 characters and <22 characters", blrtest.amountValid(d4));
        Assert.assertFalse("Amount after decimal is <=2 characters", blrtest.amountValid(d7));
        //Assert.assertFalse("Amount is a number", blrtest.amountValid(d6));

    }
    @Test
    public void testReimbursementDescriptionValid() {
        BusinessLogicReimbursement bltest = new BusinessLogicReimbursement();

        String str1 = null;
        String str2 = "ndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdslndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdslndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdsl";
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "!!!";

        Assert.assertFalse("Description is null", bltest.descriptionValid(str1));
        Assert.assertFalse("Description is <100 characters", bltest.descriptionValid(str2));
        Assert.assertTrue("Description is >0 characters", bltest.descriptionValid(str3));
        Assert.assertFalse("Description is >0 characters", bltest.descriptionValid(str4));
        Assert.assertTrue("Description is >0 characters", bltest.descriptionValid(str5));
        Assert.assertTrue("Description is >0 characters", bltest.descriptionValid(str6));
        Assert.assertTrue("Description is >0 characters", bltest.descriptionValid(str7));

    }

    @Test
    public void testReimbursementAuthorValid() {
        BusinessLogicReimbursement bltest = new BusinessLogicReimbursement();

        String str1 = null;
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "!!!";

        Assert.assertFalse("Username is null", bltest.authorValid(str1));
        Assert.assertTrue("Username is >0 characters", bltest.authorValid(str3));
        Assert.assertFalse("Username is >0 characters", bltest.authorValid(str4));
        Assert.assertTrue("Username is >0 characters", bltest.authorValid(str5));
        Assert.assertTrue("Username is >0 characters", bltest.authorValid(str6));
        Assert.assertTrue("Username is >0 characters", bltest.authorValid(str7));

    }
}
