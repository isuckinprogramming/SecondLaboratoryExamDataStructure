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
    public static String[] converterPostfixStringIntoExpression() {
        return null;
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
        System.out.print(root.data);
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
        System.out.print(root.data);
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
