import org.junit.Assert;
import org.junit.Test;
import service.BusinessLogicLogin;
/**
 * Created by npw383 on 4/18/17.
 */
public class businessLogicLoginTest {

    @Test
    public void testUsernameValid1() {
        BusinessLogicLogin bltest = new BusinessLogicLogin();

        String str1 = null;
        String str2 = "ndfjkgshdjkghdakjghrjkaghkjagnfjksahfkjdsafgkdsgkdfsajfkdslndfjkgshdjghkjal";
        String str3 = "Sara ";
        String str4 = "";
        String str5 = "a";
        String str6 = "ab";
        String str7 = "!!!";

        Assert.assertFalse("Username is null", bltest.usernameValid1(str1));
        Assert.assertFalse("Username is <40 characters", bltest.usernameValid1(str2));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid1(str3));
        Assert.assertFalse("Username is >0 characters", bltest.usernameValid1(str4));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid1(str5));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid1(str6));
        Assert.assertTrue("Username is >0 characters", bltest.usernameValid1(str7));

    }
}