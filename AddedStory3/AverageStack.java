public class AverageStack {
    int[] stack;
    int top;

    AverageStack(){

        top = -1;
        stack = new int[1000];
    }

    void push(int value){
        if(top + 1 == stack.length){
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = value;

    }

    int pop(){
        if(top == -1){
            System.out.println("Stack is empty!!");
            return 0;
        }
        return stack[top--];
    }

    int top(){
        if (top == -1) {
            System.out.println("Stack is empty!!");
            return 0;
        }
        return stack[top];
    }

    float getAverage(){
        if (top == -1) return 0;
        float sum = 0.0F;
        for(int i = 0; i <= top; i++){
            sum += stack[i];
        }
        return sum / (top + 1);
    }

    public static void main(String[] args) {
        AverageStack a = new AverageStack();
        a.push(10);
        a.push(20);

       a.push(30);

        int popped = a.pop();
        float ans = a.getAverage();
        System.out.println(ans);
    }
}

