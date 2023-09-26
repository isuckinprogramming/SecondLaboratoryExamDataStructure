import java.util.Stack;

// Data structure to store a binary tree node
class OriginalNode
{
    char data;
    OriginalNode left, right;

    OriginalNode(char data)
    {
        this.data = data;
        this.left = this.right = null;
    }

    OriginalNode(char data, OriginalNode left, OriginalNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class OriginalExpressionTreeFromTechieDelight
{
    // Function to check if a given token is an operator
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Print the postfix expression for an expression tree
    public static void postorder(OriginalNode root)
    {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }

    // Print the infix expression for an expression tree
    public static void inorder(OriginalNode root)
    {
        if (root == null) {
            return;
        }

        // if the current token is an operator, print open parenthesis
        if (isOperator(root.data)) {
            System.out.print("(");
        }

        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);

        // if the current token is an operator, print close parenthesis
        if (isOperator(root.data)) {
            System.out.print(")");
        }
    }

    // Function to construct an expression tree from the given postfix expression
    public static OriginalNode construct(String postfix)
    {
        // base case
        if (postfix == null || postfix.length() == 0) {
            return null;
        }

        // create an empty stack to store tree pointers
        Stack<OriginalNode> s = new Stack<>();

        // traverse the postfix expression
        for (char c: postfix.toCharArray())
        {
            // if the current token is an operator
            if (isOperator(c))
            {
                // pop two nodes `x` and `y` from the stack
                OriginalNode x = s.pop();
                OriginalNode y = s.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively
                OriginalNode node = new OriginalNode(c, y, x);

                // push the current node into the stack
                s.add(node);
            }
            // if the current token is an operand, create a new binary tree node
            // whose root is the operand and push it into the stack
            else {
                s.add(new OriginalNode(c));
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return s.peek();
    }

    public static void main(String[] args)
    {
        String postfix = "ab+cde+**";
        OriginalNode root = construct(postfix);

        System.out.print("Postfix Expression: ");
        postorder(root);

        System.out.print("\nInfix Expression: ");
        inorder(root);
    }
}