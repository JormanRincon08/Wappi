package com.automationpractice.wappi.questions.updateprofile;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static com.automationpractice.wappi.userinterface.updateprofile.UpdateProfilePage.*;
import static com.automationpractice.wappi.utils.util.Const.*;
import static com.automationpractice.wappi.utils.util.Validations.*;

public class UpdateProfileRequiredFields implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(UpdateProfileRequiredFields.class.getName());

    private UpdateProfileRequiredFields() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean isSuccess = false;
        try {
            isSuccess = verifyMandatory(actor);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isSuccess;
    }

    private Boolean verifyMandatory(Actor actor) {
        final int SIZE_OF_VERIFICATIONS = 5;
        Boolean[] verifications = new Boolean[SIZE_OF_VERIFICATIONS];
        Arrays.fill(verifications, Boolean.FALSE);

        verifications[0] = compareDifferences(IMAGE_MANDATORY_VALUE, MANDATORY_IMAGE.resolveFor(actor).isPresent() ? MANDATORY_IMAGE.resolveFor(actor).getText().trim() : "", "Image");
        verifications[1] = compareDifferences(FIRST_NAME_MANDATORY_VALUE, MANDATORY_FIRST_NAME.resolveFor(actor).isPresent() ? MANDATORY_FIRST_NAME.resolveFor(actor).getText().trim() : "", "First Name");
        verifications[2] = compareDifferences(BORN_DATE_MANDATORY_VALUE, MANDATORY_BORN_DATE.resolveFor(actor).isPresent() ? MANDATORY_BORN_DATE.resolveFor(actor).getText().trim() : "", "Born Date");
        verifications[3] = compareDifferences(COUNTRY_MANDATORY_VALUE, MANDATORY_COUNTRY.resolveFor(actor).isPresent() ? MANDATORY_COUNTRY.resolveFor(actor).getText().trim() : "", "Country");
        verifications[4] = compareDifferences(GENDER_MANDATORY_VALUE, MANDATORY_GENDER.resolveFor(actor).isPresent() ? MANDATORY_GENDER.resolveFor(actor).getText().trim() : "", "Gender");
        generatedReport("Profile Update");
        return isFalse(verifications);
    }

    public static UpdateProfileRequiredFields theUpdateProfileMandatoryResult() {
        return new UpdateProfileRequiredFields();
    }
}