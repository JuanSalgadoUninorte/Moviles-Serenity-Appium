package co.com.choucair.tasks;

import co.com.choucair.interaction.TakeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.logging.Logger;

public class OpenApp implements Task {

    public static OpenApp openApplication() {
        return Tasks.instrumented(OpenApp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger.getAnonymousLogger().info("The app is running");
        actor.attemptsTo(TakeScreenshot.asEvidence());
    }
}
