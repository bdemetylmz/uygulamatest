package com.test.uygulama;

import com.test.LoginPage;
import org.junit.Test;

public class LoginPageTest extends TestUygulama{


    @Test
    private void Login() {  new LoginPage(driver).Login("dmtbtl.19@gmail.com","ersel6.35");
    }


}
