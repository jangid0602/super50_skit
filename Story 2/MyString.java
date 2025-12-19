package Oneup;

public class MyString {
    
    private String data;

    // Default constructor
    public MyString() {
        this.data = "";
    }

    // Parameterized constructor
    public MyString(String string) {
        this.data = string;
    }

    // Convert object to string
    @Override
    public String toString() {
        return this.data;
    
    }
    
}
