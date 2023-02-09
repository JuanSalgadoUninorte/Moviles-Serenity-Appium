package co.com.choucair.questions;

import co.com.choucair.model.DataModel;
import co.com.choucair.ui.FistPage;
import co.com.choucair.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;

public class LastResponse implements Question<Boolean> {

    private DataModel dataModel;

    public LastResponse(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public static LastResponse lastResponseConfirmation(DataModel dataModel) {
        return new LastResponse(dataModel);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String message = Text.of(FistPage.LBL_BALANCE).answeredBy(actor).toString();
        return message.equals(dataModel.getMessage());
    }
}
