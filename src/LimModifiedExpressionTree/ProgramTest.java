package LimModifiedExpressionTree;

public class ProgramTest {
    public static void main(String[] args) {

        developmentTestScenarioOne();
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

}
