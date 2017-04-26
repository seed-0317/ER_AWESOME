import org.junit.Assert;
import org.junit.Test;
import service.BusinessLogicUserInfo;

/**
 * Created by npw383 on 4/18/17.
 */
public class BusinessLogicUserInfoTest {


    @Test
    public void testUsernameValid() {
        BusinessLogicUserInfo bltest = new BusinessLogicUserInfo();

        String str1 = null;
        String str2 = "ndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdslndfjkgy      shdjghkjal";
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "!!!";

        Assert.assertFalse("Username is null", bltest.usernameValid(str1));
        Assert.assertFalse("Username is <100 characters", bltest.usernameValid(str2));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid(str3));
        Assert.assertFalse("Username is >0 characters", bltest.usernameValid(str4));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid(str5));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid(str6));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid(str7));

    }

    @Test
    public void testFirstNameValid() {
        BusinessLogicUserInfo bltest1 = new BusinessLogicUserInfo();

        String str1 = null;
        String str2 = "ndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdsl";
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "!!!";

        Assert.assertFalse("First name is null", bltest1.firstNameValid(str1));
        Assert.assertFalse("First name is <30 characters", bltest1.firstNameValid(str2));
        Assert.assertTrue("First name is >0 characters", bltest1.firstNameValid(str3));
        Assert.assertFalse("First name is >0 characters", bltest1.firstNameValid(str4));
        Assert.assertTrue("First name is >0 characters", bltest1.firstNameValid(str5));
        Assert.assertTrue("First name is >0 characters", bltest1.firstNameValid(str6));
        Assert.assertFalse("First name is A-Z only", bltest1.firstNameValid(str7));

    }

    @Test
    public void testLastNameValid() {
        BusinessLogicUserInfo bltest1 = new BusinessLogicUserInfo();

        String str1 = null;
        String str2 = "ndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdsl";
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "!!!";

        Assert.assertFalse("Last name is null", bltest1.lastNameValid(str1));
        Assert.assertFalse("Last name is <30 characters", bltest1.lastNameValid(str2));
        Assert.assertTrue("Last name is >0 characters", bltest1.lastNameValid(str3));
        Assert.assertFalse("Last name is >0 characters", bltest1.lastNameValid(str4));
        Assert.assertTrue("Last name is >0 characters", bltest1.lastNameValid(str5));
        Assert.assertTrue("Last name is >0 characters", bltest1.lastNameValid(str6));
        Assert.assertFalse("Last name is A-Z only", bltest1.lastNameValid(str7));

    }

    @Test
    public void testEmailValid() {
        BusinessLogicUserInfo bltest1 = new BusinessLogicUserInfo();

        String str1 = null;
        String str2 = "ndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdslndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdslndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdsl";
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "amanda@gmail.com";

        Assert.assertFalse("Username is null", bltest1.emailValid(str1));
        Assert.assertFalse("Username is <100 characters", bltest1.emailValid(str2));
        Assert.assertTrue("Username is >0 characters", bltest1.emailValid(str3));
        Assert.assertFalse("Username is >0 characters", bltest1.emailValid(str4));
        Assert.assertTrue("Username is >0 characters", bltest1.emailValid(str5));
        Assert.assertTrue("Username is >0 characters", bltest1.emailValid(str6));
        Assert.assertTrue("Username is >0 characters", bltest1.emailValid(str7));

    }
//ask taylor
    /** TEST WORKING
     *
     */
//    @Test
//    public void testUpdateEmployeeCallSuccess(){
//
//    }

    /** TEST NOT WORKING
     *
     */
//    @Test (expected = IllegalArgumentException.class)
//    public void testUpdateEmployeeCallFailure(){
//
//    }



}
