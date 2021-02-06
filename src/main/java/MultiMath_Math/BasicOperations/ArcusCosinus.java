package MultiMath_Math.BasicOperations;

public class ArcusCosinus {

    private static final String NUMBER_PATTERN = "\\d+";
    private static final String SPACE_PATTERN = "\\s*";
    private static final String PREFIX_ARCUS_COSINUS = "arccos";
    private static final String OPENING_BRACKET = "\\(";
    private static final String CLOSING_BRACKET = "\\)";
    private static final String ARCUS_COSINUS_PATTERN = PREFIX_ARCUS_COSINUS + OPENING_BRACKET + SPACE_PATTERN + NUMBER_PATTERN + SPACE_PATTERN + CLOSING_BRACKET;
    private static final String ARCUS_COSINUS_REPLACE_PATTERN = "\\D";

    public double processArcusCosinusExpression(String arcusCosinusInputString) throws Exception {
        if (matchArcusCosinusExpression(arcusCosinusInputString)) {
            return calculateArcusCosinus(arcusCosinusInputString);
        }
        throw new IllegalArgumentException("Exception Message");
    }

    private double calculateArcusCosinus(String arcusCosinusInputString) {
        return Math.acos(Double.parseDouble(arcusCosinusInputString.replaceAll(ARCUS_COSINUS_REPLACE_PATTERN, "")));
    }

    private boolean matchArcusCosinusExpression(String arcusCosinusInputString) {
        return arcusCosinusInputString.matches(ARCUS_COSINUS_PATTERN);
    }

}
