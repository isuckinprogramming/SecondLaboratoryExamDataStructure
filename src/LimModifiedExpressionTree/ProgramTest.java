package LimModifiedExpressionTree;

import java.util.Scanner;

public class ProgramTest {
    public static void main(String[] args) {
        programStart();
    }
    private static Scanner taker = new Scanner(System.in);

    public static void programStart() {

        System.out.println(
            "Input will be converted into Infix and postfix notation after input.\n" +
            "Improper input will result into error and will not show conversion\n" +
            "Use spaces to separate the characters.\n\n" +
            "ENTER NUMBERS AND OPERATORS IN POSTFIX NOTATION : "
        );


        String userInput = taker.nextLine();

        try {

            CustomNode headNode = CustomExpressionTree.converterPostfixStringIntoExpression(userInput);

            System.out.print("\n\nPostfix Expression" +
                    ": ");

            CustomExpressionTree ExpressionTree = new CustomExpressionTree();
            ExpressionTree.postorder(headNode);

            System.out.print("\nInfix Expression: ");
            ExpressionTree.inorder(headNode);
        }
        catch (Exception e ) {

//            error occurred because of user input or other issues
//            response already handled in CustomExpressionTree.java
        }
        askUserToContinueProgramOrNot();
    }

    public static void askUserToContinueProgramOrNot( ){

        System.out.println(
            "\n\nInput 'y' or 'Y' to Continue program.\n" +
            "Input any key to end program \n" +
            "Do you want to run program again ?\n"
        );
        String input = taker.nextLine();

        if( input.toLowerCase().charAt(0) == 'y' ){
            programStart();
        }
        taker.close();
//        end program if user entered other keys.
    }

}
