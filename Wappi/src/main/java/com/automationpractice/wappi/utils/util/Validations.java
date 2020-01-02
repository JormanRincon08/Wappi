package com.automationpractice.wappi.utils.util;

import net.serenitybdd.core.Serenity;

import static com.automationpractice.wappi.utils.util.Const.*;

public abstract class Validations {

    private Validations(){}

    private static String report = "";

    public static boolean isFalse(Boolean[] verificaciones) {
        boolean result = true;
        for (Boolean e : verificaciones) {
            result = result && e;
        }
        return result;
    }

    public static boolean compareDifferences(Object expected, Object founded, String titleOfField) {
        boolean result;
        String content;
        if (expected != null) {
            result = expected.equals(founded);
        } else {
            result = expected == founded;
        }

        String valueOfValidation = result ? SUCCESS_RESULT : FAILED_RESULT;
        content = titleOfField + "\n" + "Value Expected: " + expected + "\n" + "Value Found: " + founded + "\n"
                + "Validation result is: " + valueOfValidation + "\n\n";

        report += content;

        Serenity.setSessionVariable(REPORT).to(report);
        return result;
    }

    public static void generatedReport(String reportTitle) {
        Serenity.recordReportData().withTitle(reportTitle).andContents(Serenity.sessionVariableCalled(REPORT));
        report = "";
    }
}
