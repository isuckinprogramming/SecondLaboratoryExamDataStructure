package LimModifiedExpressionTree;

import java.util.Stack;
import java.util.function.Function;

public class CustomExpressionTree {

/**
 *Node data must be separated by comma.
 * Ex: "1, 2, +"
 *
 * method for turning string with numeric input into data that
 * can be converted into an expression.
 *
 *
 * */
    public static CustomNode converterPostfixStringIntoExpression(String userInputPostfixNotation) {

        // base case
        if (
            userInputPostfixNotation == null ||
            userInputPostfixNotation.length() == 0
        ) {
            return null;
        }

        String[] contents = userInputPostfixNotation.split(",");
        // create an empty stack to store tree pointers
        Stack<CustomNode> nodeStack = new Stack<>();

        int indexOfData = 0;
        for ( String data : contents ){

            try {
                int numericData = Integer.parseInt(data);
                CustomNode numberNode = new CustomNode( numericData);
                nodeStack.push(numberNode);
            }
            catch (NumberFormatException e){

                if(! ( data.length() == 1) ){
//                    invalid data, no code to handle invalid data yet
                }
                char operatorInput = data.toCharArray()[0];
                boolean inputIsAnOperator = isOperator( operatorInput );



                // pop two nodes `x` and `y` from the stack
                CustomNode x = nodeStack.pop();
                CustomNode y = nodeStack.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively

//                CustomNode operatorNode = CustomNode ( ( "" + operatorInput), x, y);
                CustomNode operatorNode = new CustomNode( operatorInput, y, x );
                nodeStack.push(operatorNode);
            }




            indexOfData++;
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

//        System.out.print(root.operator);

        String dataToPrint  = ( root.isNodeAnOperator() ) ? root.operator : (root.data + "" );
        System.out.print(dataToPrint );
    }

    // Print the infix expression for an expression tree
    public void inorder(CustomNode root)
    {
        if (root == null) {
            return;
        }

        // added some space inside the parenthesis so that it would not suffocate
        // characters inside, for easier readability
        // if the current token is an operator, print open parenthesis
        if (root.isNodeAnOperator()) {
            System.out.print("( ");
        }

        inorder(root.left);
        String dataToPrint  = ( root.isNodeAnOperator() ) ? root.operator : (root.data + "" );
        System.out.print(dataToPrint );
        inorder(root.right);

        // if the current token is an operator, print close parenthesis
        if (root.isNodeAnOperator()) {
            System.out.print(" )");
        }
    }

    // Function to construct an expression tree from the given postfix expression
    public CustomNode construct(String postfix)
    {
        // base case
        if (postfix == null || postfix.length() == 0) {
            return null;
        }

        // create an empty stack to store tree pointers
        Stack<CustomNode> s = new Stack<>();

        // traverse the postfix expression
        char[] allCharacters = postfix.toCharArray();
        for (char c: allCharacters)
        {
            // if the current token is an operator
            if (isOperator(c))
            {
                // pop two nodes `x` and `y` from the stack
                CustomNode x = s.pop();
                CustomNode y = s.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively
                CustomNode node = new CustomNode(c, y, x);
                // push the current node into the stack
                s.add(node);
            }

            // if the current token is an operand, create a new binary tree node
            // whose root is the operand and push it into the stack
            else {
                CustomNode toBeAddedNode = new CustomNode(c);
                s.add( toBeAddedNode );
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return s.peek();
    }
}
