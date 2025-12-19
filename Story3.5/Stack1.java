import java.util.Stack;

public class Stack1 {
    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();
    String currentPage = null;
    void visit(String page){
        if(currentPage != null){
            backStack.push(currentPage);
        }
        currentPage = page;
        forwardStack.clear();
    }

    String back(){
        if(backStack.isEmpty()){
            return null;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    String forward(){
        if(forwardStack.isEmpty()){
            return null;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }
}
