package tech.ashbie;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n\tThis is going to be a Calculator Engine");

        double[] leftVal = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVal = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

        // version switch
        if(args.length == 0) {
            for(int i = 0; i < opCode.length; i++) {
                result[i] = executeMathOperation(opCode[i], leftVal[i], rightVal[i]);
            }

            for(double res : result) {
                System.out.println("\tResult = " + res + "\n");
            }
        }
        else if(args.length == 3) {
            handleCommandLineArgs(args);
        }
        else {
            System.out.println("\tPlease provide an operation code and 2 numeric values!");
        }

    }

    private static void handleCommandLineArgs(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);

        double result = executeMathOperation(opCode, leftVal, rightVal);
        System.out.println("\tResult = " + result + "\n");
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