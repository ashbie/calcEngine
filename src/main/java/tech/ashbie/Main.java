package tech.ashbie;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n\tThis is going to be a Calculator Engine");

        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

//        double value1 = 100.0d;
//        double value2 = 0.0d;
//        double result;
//        char opCode = 'd';

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
        for(int i = 0; i < opCodes.length; i++) {
            switch(opCodes[i]) { // <-- opCode sub i
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                case 'd':
                    results[i] = (rightVals[i] != 0) ? (leftVals[i] / rightVals[i]) : 0.0d;
                    break;
                default:
                    System.out.println("\tInvalid opCode(operation code): " + opCodes[i]);
                    results[i] = 0.0d;
                    break;
            }
        }



        for(double res : results) {
            System.out.println("\tResult = " + res + "\n");
        }
    }
}