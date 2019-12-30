package com.automationpractice.wappi.tasks.general;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.UploadToField;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.nio.file.Path;

public class UploadInputField extends UploadToField {

    private final Target uploadField;

    public UploadInputField(Path inputFile, Target uploadField) {
        super(inputFile);
        this.uploadField = uploadField;
    }

    @Override
    @Step("Upload file at #inputFile to #uploadField")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).upload(inputFile.toFile().getPath())
                .fromLocalMachine()
                .to(uploadField.resolveFor(actor));
    }
}
