package LimModifiedExpressionTree;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ProgramTest {
    public static void main(String[] args) {

//        developmentTestScenarioOne();
//    testingModuloOperationImplementation();
//    testingNumberAndOperatorCustomConverter();
        programStart();
    }




/**
 * Test method to figure out behaviour of the binary expression tree.
 *
 * Method is successful. I managed to understand how the postfix string is
 * converted into an expression inside the tree.
 *
 * Based from what I have understood with how the string is coverted into
 * an expression. I think this is an accurate representation of a
 * template for the binary expression tree.
 *  String template:  " {VAR A}, {VAR B}, {OPERATOR} "
 *
 *result = ( VAR-A OPERATOR VAR-B )
 *
 * */
    public static void developmentTestScenarioOne( ){
        CustomExpressionTree ExpressionTree = new CustomExpressionTree();

        String postfixExperimentEntry = "fgab+cde+****";
        String postfixOriginal = "";

        CustomNode root = ExpressionTree.construct(postfixExperimentEntry);

        System.out.print("Postfix Expression: ");
        ExpressionTree.postorder(root);

        System.out.print("\nInfix Expression: ");
        ExpressionTree.inorder(root);
    }


    public static void testingModuloOperationImplementation() {

        CustomExpressionTree ExpressionTree = new CustomExpressionTree();

        String postfixExperimentEntry = "ab%";
        CustomNode root = ExpressionTree.construct(postfixExperimentEntry);

        System.out.print("Postfix Expression" +
                ": ");
        ExpressionTree.postorder(root);

        System.out.print("\nInfix Expression: ");
        ExpressionTree.inorder(root);

    }

    public static void testingNumberAndOperatorCustomConverter() {

        CustomExpressionTree ExpressionTree = new CustomExpressionTree();

        String postfixExperimentEntry = "1,2,%";
        CustomNode rootNodeOfExpressionTree = CustomExpressionTree.converterPostfixStringIntoExpression(postfixExperimentEntry);

        System.out.print("Postfix Expression" +
                ": ");
        ExpressionTree.postorder(rootNodeOfExpressionTree);

        System.out.print("\nInfix Expression: ");
        ExpressionTree.inorder(rootNodeOfExpressionTree);


//      batch 2
        String postfixExperimentEntry2 = "1,2,%,3,%";
        CustomNode rootNodeOfExpressionTree2 =
                CustomExpressionTree.converterPostfixStringIntoExpression(postfixExperimentEntry2);

        System.out.print("\n\nPostfix Expression" +
                ": ");
        ExpressionTree.postorder(rootNodeOfExpressionTree2);

        System.out.print("\nInfix Expression: ");
        ExpressionTree.inorder(rootNodeOfExpressionTree2);
    }

    public static void programStart() {

        System.out.println(  "Input will be converted into Infix and postfix notation after input.\n" +
                "Improper input will result into error and will not show conversion\n" +
                "ENTER NUMBERS AND OPERATORS IN POSTFIX NOTATION : ");

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
