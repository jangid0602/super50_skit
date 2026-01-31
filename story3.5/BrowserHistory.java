import java.util.Stack;

/**
 * Filename : BrowserHistory.java
 * Description :Design a browser history system that supports:
● Visiting a new page
● Going back
● Going forward
 * Author : Nancy Jain
 */
public class BrowserHistory {
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>(); 
    String current = null;
    public void Visit(String page){
        if(current!= null){
            back.push(current);
        }
        current = page;
        forward.clear();
    }
    
    void backPage(){
        if(!back.isEmpty()){
        forward.push(current);
        current = back.pop();
        }
    }

    void forward(){
        if(!forward.isEmpty()){
            back.push(current);
            current = forward.pop();
        }
    }

    String getCurrentPage(){
        return current;
    }

}
