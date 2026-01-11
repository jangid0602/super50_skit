class Doll {
    int size;
    boolean hasKey;
    Doll innerDoll;

    Doll(int size, boolean hasKey, Doll innerDoll) {
        this.size = size;
        this.hasKey = hasKey;
        this.innerDoll = innerDoll;
    }

    void findKey(){
        Doll currentDoll=this;
        while(currentDoll!=null){
            if(currentDoll.hasKey){
                System.out.println("Key found in doll of size: "+currentDoll.size);
                return;
            }
            currentDoll=currentDoll.innerDoll;
        }
        System.out.println("No key found in any doll.");
    }
}