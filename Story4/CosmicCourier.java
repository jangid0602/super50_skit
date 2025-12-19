package Story4;
class CosmicCourier {

    public static int minimumDeadline(int[] routes) {
        if (routes.length == 1) {
            return routes[0];
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int x : routes) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }

        return max2;
    }

}
