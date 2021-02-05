package MultiMath_Math.BasicOperations;

public class ArcusCosinus {

    private static final String ARCUS_COSINUS_PATTERN = "arccos\\(\\d+\\)";
    private static final String ARCUS_COSINUS_REPLACE_PATTERN = "\\D";

    public double processArcusCosinusExpression(String arcusCosinusInputString) throws Exception {
        if (matchArcusCosinusExpression(arcusCosinusInputString)) {
            return calculateArcusCosinus(arcusCosinusInputString);
        }
        return -1;
    }

    private double calculateArcusCosinus(String arcusCosinusInputString) {
        return Math.acos(Double.parseDouble(arcusCosinusInputString.replaceAll(ARCUS_COSINUS_REPLACE_PATTERN, "")));
    }

    private boolean matchArcusCosinusExpression(String arcusCosinusInputString) {
        return arcusCosinusInputString.matches(ARCUS_COSINUS_PATTERN);
    }

}
