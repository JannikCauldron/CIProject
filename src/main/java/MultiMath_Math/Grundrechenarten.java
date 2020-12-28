package MultiMath_Math;

public class Grundrechenarten {
    public double calcSinus(String op) {
        String sinusPattern = "^sin\\([0-9]+\\)$";
        int num;

        if (op.matches(sinusPattern)) {
            String numberOnlyStr = op.replaceAll("[^0-9]", "");
            num = Integer.parseInt(numberOnlyStr);
        } else {
            return 0;
        }
        return Math.sin(num);
    }
}
