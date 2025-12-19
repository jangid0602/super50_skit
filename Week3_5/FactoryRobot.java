package Week3_5;

public class FactoryRobot {
    public static String[] labelWeights(int[] weights) {
        String[] labels = new String[weights.length];
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            if (w % 15 == 0) labels[i] = "Hazardous";
            else if (w % 3 == 0) labels[i] = "Heavy";
            else if (w % 5 == 0) labels[i] = "Fragile";
            else labels[i] = Integer.toString(w);
        }
        return labels;
    }

    public static String format(String[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
