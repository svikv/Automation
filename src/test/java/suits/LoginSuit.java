package suits;

import loginTests.LoginWithPageObjectTest;
import loginTests.LoginWithPageObjectWrongLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses(
            {
                    LoginWithPageObjectTest.class,
                    LoginWithPageObjectWrongLoginTest.class
            }
    )
    public class LoginSuit {

    }
