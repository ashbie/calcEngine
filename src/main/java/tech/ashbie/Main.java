package tech.ashbie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("\n\n\tThis is going to be a Calculator Engine");
        // ## Predefined Values
        double[] leftVal = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVal = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

        // app mode: no arguments
        // >> 1. calculate [predefined values](#predefined-values)
        if(args.length == 0) {
            for(int i = 0; i < opCode.length; i++) {
                result[i] = executeMathOperation(opCode[i], leftVal[i], rightVal[i]);
            }

            for(double res : result) {
                //System.out.println("\tResult = " + res + "\n");
                displayResult(res);
            }
        }
        // app mode: user-specified arguments
        // >> 2.1. One argument :: user interactively specifies values to calculate
        // $  java FULLY.QUALIFIED.APPNAME --interactive | -i
        else if(args.length == 1 && (args[0].equals("--interactive") || args[0].equals("-i"))) {
            handleCollectionOfUserInputInteractivly();
        }
        // >> 2.1. Three arguments :: user (NON-interactively) specifies values to calculate
        // $  java FULLY.QUALIFIED.APPNAME operationCode LeftOperand RightOperand
        else if(args.length == 3) {
            handleCommandLineArgs(args);
        }
        // Display ERROR Message
        else {
            System.out.println("\n\t\t\t!!! ERROR !!!" +
                    "\n\tOperation failed!" +
                    "\n\tPlease provide an operation code and 2 numeric values!");
        }

    }

    // method that handles the details of getting the input from the user
    static void handleCollectionOfUserInputInteractivly() {
        StringBuilder sbHeader = new StringBuilder();
        sbHeader.append(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::")
        .append("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::")
        .append("\n:::::::::::::::::::::::::::                                             :::::::::::::::::::::::::::::")
        .append("\n:::::::::::::::::::::::::::          Inconvenient-Calculator App        :::::::::::::::::::::::::::::")
        .append("\n:::::::::::::::::::::::::::                                             :::::::::::::::::::::::::::::")
        .append("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::")
        .append("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\n")
        .append("Type 'help' or '-h' for help")
        .append("\nType 'exit' or 'stop' to quit the app");
        String headerText = sbHeader.toString();

        StringBuilder sbInstructions = new StringBuilder();
        sbInstructions.append("\n\n::::::::::::::::::::      About   ")
        .append("\n\nThis a Java console calculator app that performs a mathematical operation/calculation on two(2) numbers/operands")
        .append("\n\n::::::::::::::::::::      Instructions")
        .append("\nIn order to perform a mathematical operation on two numbers, you'll need to provide THREE things:")
        .append("\n\tAn operation-code           ( In words/String format. Do NOT input a math symbol!!! )                         ")
        .append("\n\tA left-operand              ( aka the 1st-number )                               ")
        .append("\n\tA right-operand             ( aka the 2nd-number )                               ")
        .append("\n\nInput the THREE requirements as shown in the format below:")
        .append("\n\t\toperation-code left-operand/1st-number right-operand/2nd-number ")
        .append("\n\nThe table below shows the operation-codes accepted by the app.")
        .append("\n ** operation-codes are listed under the 'OPERATION-CODE' column **")
        .append("\n\t\tOPERATION-CODE       LEFT-OPERAND/1st-NUMBER        RIGHT-OPERAND/2nd-NUMBER       CALCULATION-TO-PERFORM")
        .append("\n\t\tadd                  a                              b                              a + b")
        .append("\n\t\tsubtract             a                              b                              a - b")
        .append("\n\t\tmultiply             a                              b                              a x b")
        .append("\n\t\tdivide               a                              b                              a / b")
        .append("\n\nExamples showing how to input calculations")
        .append("\n(+) Addition Example: ")
        .append("\n\t\tInput>> add one one")
        .append("\n\t\tOutput>> Result = 2 ")
        .append("\n\n(-) Subtraction Example: ")
        .append("\n\t\tInput>> subtract eight five")
        .append("\n\t\tOutput>> Result = 3")
        .append("\n\n(x) Multiplication Example: ")
        .append("\n\t\tInput>> multiply six three")
        .append("\n\t\tOutput>> Result = 18 ")
        .append("\n\n(/) Division Example: ")
        .append("\n\t\tInput>> divide six two")
        .append("\n\t\tOutput>> Result = 3 ");
        String instructionsText = sbInstructions.toString();

        //        StringBuilder sbInputText = new StringBuilder();
        //        sbInputText.append("\n\n::::::::::::::::::::      Input & Output area");

        boolean repeatProcess = true;
        System.out.println(headerText);
        do {
            System.out.print("Input>> ");

            Scanner scanner = new Scanner(System.in);
            String userInputString = scanner.nextLine(); // We have the input <--here
            // Quit app
            if(userInputString.equals("exit") || userInputString.equals("stop") || userInputString.equals("end") || userInputString.equals("quit") || userInputString.equals("q")) {
                repeatProcess = false;
                continue;  // <--- will break;(instead of continue;) work too ?
            }
            // display help (instructions)
            if(userInputString.equals("help") || userInputString.equals("-h")) {
                System.out.println(instructionsText);
            }
            // Once we have input -> Break it into it's individual parts ( using .split() method of the String instance )
            String[] arrayOfOpCodeAndNumbersInWords = userInputString.split(" ");
            // Interactivity task is done.
            // Hand over to other task.
            handleUserInputToMathOperation(arrayOfOpCodeAndNumbersInWords);
        } while (repeatProcess == true);
        displayFooter();
    }

    private static void displayFooter() {
        // this text should come at the end of the program(/ when I Type exit)
        StringBuilder sbFooter = new StringBuilder();
        sbFooter.append("\n*********************************************************************************************************************************************")
                .append("\n*********************************************************************************************************************************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n***************************        Inc. Way                                                                     *****************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n***************************        Inconvenient-Calculator App (Inc. Calc TM) is a product of Inc. Way          *****************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n***************************        The Inc. Way mission:                                                        *****************************")
                .append("\n***************************        To help the world appreciate the conveniences of life :)                     *****************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n***************************        The Inc. Way slogan:                                                         *****************************")
                .append("\n***************************        Why do it the convenient way, when you can do it the Inc. Way                *****************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n***************************                                                                                     *****************************")
                .append("\n*********************************************************************************************************************************************")
                .append("\n*********************************************************************************************************************************************");
        String footerText = sbFooter.toString();
        System.out.println(footerText);
    }

    private static void handleUserInputToMathOperation(String[] arrayOfOpCodeAndNumbersInWords) {
        char opCode = opCodeFromWord(arrayOfOpCodeAndNumbersInWords[0]);
        double leftNumber = numberFromWord(arrayOfOpCodeAndNumbersInWords[1]);
        double rightNumber = numberFromWord(arrayOfOpCodeAndNumbersInWords[2]);

        double result = executeMathOperation(opCode, leftNumber, rightNumber);
        displayResult(result);

    }

    private static void displayResult(double result) {
        StringBuilder sbOutputLine = new StringBuilder(40);
        sbOutputLine.append("Output>> Result = ").append(result);
        String outputLineText = sbOutputLine.toString();
        System.out.println(outputLineText);

    }

    private static void handleCommandLineArgs(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);

        double result = executeMathOperation(opCode, leftVal, rightVal);
        displayResult(result);
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

    static char opCodeFromWord(String operationName) {
//        char opCode = operationName.charAt(0);
//        return opCode;
        return operationName.charAt(0);
    }
    
    static double numberFromWord(String word) {
        String[] numberInWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for(int index = 0; index < numberInWords.length; index++) {
            if(word.equals(numberInWords[index])) {
                value = index;
                break;
            }
        }

        return value;
    }
}