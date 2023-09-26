package LimModifiedExpressionTree;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ProgramTest {
    public static void main(String[] args) {
        programStart();
    }


    public static void programStart() {

        System.out.println(
            "Input will be converted into Infix and postfix notation after input.\n" +
            "Improper input will result into error and will not show conversion\n" +
            "Use comma to separate the characters.\n\n" +
            "ENTER NUMBERS AND OPERATORS IN POSTFIX NOTATION : "
        );

        Scanner taker = new Scanner(System.in);
        String userInput = taker.nextLine();

        CustomNode headNode = CustomExpressionTree.converterPostfixStringIntoExpression( userInput );

        System.out.print("\n\nPostfix Expression" +
                ": ");

        CustomExpressionTree ExpressionTree = new CustomExpressionTree();
        ExpressionTree.postorder(headNode);

        System.out.print("\nInfix Expression: ");
        ExpressionTree.inorder(headNode);
    }
}
