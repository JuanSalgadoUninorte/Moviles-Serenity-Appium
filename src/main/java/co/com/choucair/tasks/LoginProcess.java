package co.com.choucair.tasks;

import co.com.choucair.model.DataModel;
import co.com.choucair.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class LoginProcess implements Task {

    private DataModel dataModel;

    public LoginProcess(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public static LoginProcess appLoginProcess(DataModel dataModel) {
        return Tasks.instrumented(LoginProcess.class, dataModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(dataModel.getData()).into(LoginPage.TXT_USERNAME),
                SendKeys.of(dataModel.getData()).into(LoginPage.TXT_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN)
        );
    }
}
