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
            wrongOperatorInput();
            return null;
        }

        String[] contents = userInputPostfixNotation.split(" ");

        // create an empty stack to store tree pointers
        Stack<CustomNode> nodeStack = new Stack<>();

        for ( String data : contents ){
//            creating a number node
            try {
                createNumberNode( nodeStack ,data);
            }
//            creating operator node
            catch (NumberFormatException e){

                char operatorInput = data.toCharArray()[0];

                if( isOperator( operatorInput )){
                    createOperatorNode( nodeStack, operatorInput );
                } else {
//                    wrong input
                    wrongOperatorInput();
                }
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return nodeStack.peek();
    }

    private static void createNumberNode(Stack<CustomNode> nodeStack, String data ) throws NumberFormatException{

//        this will throw an exception when the string cannot be converted
//        into a number which means that input is for an operator or invalid
//            Integer.parseInt(StringParam)

        int numericData = Integer.parseInt(data);
        CustomNode numberNode = new CustomNode( numericData);
        nodeStack.push(numberNode);
    }

    private static void createOperatorNode( Stack<CustomNode> nodeStack, char operatorInput){
        CustomNode rightNode = nodeStack.pop();

//                left is popped after right
        CustomNode leftNode = nodeStack.pop();

        CustomNode operatorNode = new CustomNode( operatorInput, leftNode, rightNode );
        nodeStack.push(operatorNode);
    }

    private static void wrongOperatorInput() {

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
