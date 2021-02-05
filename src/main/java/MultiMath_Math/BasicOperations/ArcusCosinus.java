package MultiMath_Math.BasicOperations;

public class ArcusCosinus {

	public double calcArcCos(String op) throws Exception {
		if (op.matches("arccos\\(\\d\\)")) {
            return Math.acos(Double.parseDouble(op.replaceAll("\\D", "")));
        }
        return -1;
	}

}
