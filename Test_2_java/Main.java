package Test_2_java;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String choiceInput;
        int choice;
        Array arrayObject = new Array();
        do{
            System.out.println("1.) The Time Traveller's Array");
            System.out.println("2.) The Shifting Cipher");
            System.out.println("0.) Exit\n");

            System.out.println("Enter your Choice: ");
            choiceInput = scanner.nextLine();

            if(choiceInput.matches("\\d+")){
                choice = Integer.parseInt(choiceInput);
            }
            else{
                choice = -1;
            }

            switch(choice){
                case 1:
                    System.out.println("Enter the Size of the Array: ");
                    int size = scanner.nextInt();
                    int[] array = new int[size];
                    System.out.println("Enter elements: ");
                    for(int i=0;i<size;i++){
                        array[i] = scanner.nextInt();
                    }
                    arrayObject.setArray(array);
                    System.out.println("Enter target : ");
                    int target = scanner.nextInt();
                    arrayObject.getTargetSumArray(target);
                    break;
                
                case 2:
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");

            }

        } while(choice != 0);

        scanner.close();
    }
}


class Array{
    private int[] array;

    public Array(){
        //
    }

    // Constructor
    public Array(int[] array) {
        this.array = array;
    }

    // Setter
    public void setArray(int[] array) {
        this.array = array;
    }

    public void getTargetSumArray(int target){
        int size = array.length;
        int pointer1 = 0, pointer2 = 0;
        int currentSum=0;
        currentSum += array[pointer2];
        while(pointer2 < size){
            if(currentSum == target){
                for(int i=pointer1;i<=pointer2;i++){
                    System.out.print(array[i]+" ");
                }
                System.out.println();
                currentSum -= pointer1;
                pointer1++;
            }
            else if(currentSum > target){
                while(pointer1 < pointer2 && currentSum > target){
                    currentSum -= array[pointer1];
                    pointer1++;
                }
            }
            else{
                pointer2++;
                currentSum += array[pointer2];
            }
        }
    }
}