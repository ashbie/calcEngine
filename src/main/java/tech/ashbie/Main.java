package tech.ashbie;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n\tThis is going to be a Calculator Engine");

        double[] leftVal = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVal = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

        // version switch
        for(int i = 0; i < opCode.length; i++) {
            result[i] = executeMathOperation(opCode[i], leftVal[i], rightVal[i]);
        }

        for(double res : result) {
            System.out.println("\tResult = " + res + "\n");
        }

    }

    static double executeMathOperation(char opCode, double leftVal, double rightVal) {
        double result;
        switch(opCode) { // <-- opCode sub i
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = (rightVal != 0) ? (leftVal / rightVal) : 0.0d;
                break;
            default:
                System.out.println("\tInvalid opCode(operation code): " + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }
}