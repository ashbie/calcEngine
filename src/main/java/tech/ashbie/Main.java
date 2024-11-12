package tech.ashbie;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n\tThis is going to be a Calculator Engine");

        double value1 = 100.0d;
        double value2 = 0.0d;
        double result;
        char opCode = 'd';

        // version if
        // if(opCode == 'a') {
        //     result = value1 + value2;
        // }
        // else if(opCode == 's') {
        //     result = value1 - value2;
        // }
        // else if(opCode == 'm') {
        //     result = value1 * value2;
        // }
        // else if(opCode == 'd') {
        //     if(value2 != 0) {
        //         result = value1 / value2;
        //     }
        //     else {
        //         System.out.println("Error! Can't divide by 0!!!");
        //         result = 0.0d;
        //     }
        // }
        // else {
        //     System.out.println("Invalid opCode(operation code): " + opCode);
        //     result = 0.0d;
        // }

        // version switch
        switch(opCode) {
            case 'a':
                result = value1 + value2;
                break;
            case 's':
                result = value1 - value2;
                break;
            case 'm':
                result = value1 * value2;
                break;
            case 'd':
                result = (value2 != 0) ? (value1 / value2) : 0.0d;
                break;
            default:
                System.out.println("\tInvalid opCode(operation code): " + opCode);
                result = 0.0d;
            break;
        }

        System.out.println("\tResult = " + result + "\n");
    }
}