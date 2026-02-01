

/**
 * @Filename- MinimalTechStackSwap.java
 * @Description- In this we can perform three operations: Insert a tech, Delete a tech, or Upgrade (Replace)
a tech. Each operation has a specific cost C_i, C_d, C_u.
 * @Author- Arman Agrawal
 */




class MinimalTechStackSwap {

    static String sourceStack;
    static String targetStack;

    static int insertCost;
    static int deleteCost;
    static int upgradeCost;

    static int[][] memoCost;

    static int computeMinCost(int sourceLength, int targetLength) {

        if (sourceLength == 0)
            return targetLength * insertCost;

        if (targetLength == 0)
            return sourceLength * deleteCost;

        if (memoCost[sourceLength][targetLength] != -1)
            return memoCost[sourceLength][targetLength];

        if (sourceStack.charAt(sourceLength - 1) ==
            targetStack.charAt(targetLength - 1)) {

            memoCost[sourceLength][targetLength] =
                    computeMinCost(sourceLength - 1, targetLength - 1);
            return memoCost[sourceLength][targetLength];
        }

        int costInsert =
                computeMinCost(sourceLength, targetLength - 1) + insertCost;

        int costDelete =
                computeMinCost(sourceLength - 1, targetLength) + deleteCost;

        int costUpgrade =
                computeMinCost(sourceLength - 1, targetLength - 1) + upgradeCost;

        memoCost[sourceLength][targetLength] =
                Math.min(costInsert, Math.min(costDelete, costUpgrade));

        return memoCost[sourceLength][targetLength];
    }

    public static void main(String[] args) {

        sourceStack = InputUtil.readString();
        targetStack = InputUtil.readString();

        insertCost  = InputUtil.readInt();
        deleteCost  = InputUtil.readInt();
        upgradeCost = InputUtil.readInt();

        int sourceLength = sourceStack.length();
        int targetLength = targetStack.length();

        memoCost = new int[sourceLength + 1][targetLength + 1];

        for (int i = 0; i <= sourceLength; i++) {
            for (int j = 0; j <= targetLength; j++) {
                memoCost[i][j] = -1;
            }
        }

        System.out.println(
                computeMinCost(sourceLength, targetLength)
        );
    }
}
