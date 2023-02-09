package co.com.choucair.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPage extends PageObject {

    public static final Target OK_BUTTON = Target.the("Ok button").located(By.id("android:id/button1"));

}
