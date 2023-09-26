package LimModifiedExpressionTree;

import java.util.Stack;

public class CustomExpressionTree {

    private static boolean isInputInvalid(String input){
        return input == null || input.length() == 0;
    }

/**
 *Node data must be separated by comma.
 * Ex: "1, 2, +".<br></br>
 * method for turning string with numeric input into data that
 * can be converted into an expression.
 *
 * */
    public static CustomNode converterPostfixStringIntoExpression(String userInputPostfixNotation) {

        // base case
        if ( isInputInvalid(userInputPostfixNotation) ) {
            return null;
        }

        String[] contents = userInputPostfixNotation.split(",");

        // create an empty stack to store tree pointers
        Stack<CustomNode> nodeStack = new Stack<>();

        for ( String data : contents ){

//            creating a number node
            try {
                int numericData = Integer.parseInt(data);
                CustomNode numberNode = new CustomNode( numericData);
                nodeStack.push(numberNode);
            }
//            creating operator node
            catch (NumberFormatException e){

                if(! ( data.length() == 1) ){
//                    invalid data, no code to handle invalid data yet
                }
                char operatorInput = data.toCharArray()[0];

                // pop two nodes `x` and `y` from the stack
                CustomNode rightNode = nodeStack.pop();
                CustomNode leftNode = nodeStack.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively

                CustomNode operatorNode = new CustomNode( operatorInput, leftNode, rightNode );
                nodeStack.push(operatorNode);
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return nodeStack.peek();
    }

    /**
     *
     *  Function to check if a given token is an operator
     *
     *  NEW IN CUSTOM: added a condition to accept modulo as an operator.
     * */

    public static boolean isOperator(char c) {
        return (
            c == '+' ||
            c == '-' ||
            c == '*' ||
            c == '/' ||
            c == '^' ||
            c == '%'
        );
    }

    // Print the postfix expression for an expression tree
    public void postorder(CustomNode root)
    {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);

        String dataToPrint  = getStringContentOfCustomNode(root);
        System.out.print(dataToPrint );
    }

    // Print the infix expression for an expression tree
    public void inorder(CustomNode root)
    {
        if (root == null) {
            return;
        }

        boolean isOperator = root.isNodeAnOperator();

        /**
         *added some space inside the parenthesis so that it would not suffocate
         *characters inside, for easier readability
         *if the current token is an operator, print open parenthesis
         * */
        if ( isOperator ) {
            System.out.print("( ");
        }

        inorder(root.left);
        String dataToPrint  = getStringContentOfCustomNode(root);
        System.out.print(dataToPrint );
        inorder(root.right);

        // if the current token is an operator, print close parenthesis
        if ( isOperator ) {
            System.out.print(" )");
        }
    }


    private static String getStringContentOfCustomNode(CustomNode node) {
        return ( node.isNodeAnOperator() ) ? node.operator : (node.data + "" );
    }

}
