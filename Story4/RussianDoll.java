
/**
 * @Filename- RussianDoll.java
 * @Description- This is Russian doll finder in which we have a Doll which have details of doll and a findkey function that find the key
 * @Author- Arman Agrawal
 */




class Doll {
    private boolean hasKey;
    private Doll innerDoll;

    Doll(boolean hasKey, Doll innerDoll) {
        this.hasKey = hasKey;
        this.innerDoll = innerDoll;
    }

    boolean hasKey() {
        return hasKey;
    }

    Doll getInnerDoll() {
        return innerDoll;
    }
}

public class RussianDoll {

    public static boolean findKey(Doll doll) {
        if (doll == null) return false;
        if (doll.hasKey()) return true;
        return findKey(doll.getInnerDoll());
    }
}
