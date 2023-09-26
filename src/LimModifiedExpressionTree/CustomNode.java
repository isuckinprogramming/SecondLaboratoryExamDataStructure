package LimModifiedExpressionTree;

public class CustomNode {

    char data;
    CustomNode left, right;

    CustomNode(char data)
    {
        this.data = data;
        this.left = this.right = null;
    }

    CustomNode(char data, CustomNode left, CustomNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }


/***
 * This method returns a string representation of the object,
 * which shows what is the data inside of the CustomNode.
 *
 * I overrided the toString() because I will need to see the data
 * contained for every CustomNode that is placed inside the Stack of Nodes that
 * is used as the container of the expression tree.
 *
 *In the debug view, overriding the toString() method for filtering
 * data inside the object is crucial.
 *
 * */
    @Override
    public String toString() {
        return "Node data = " + data;
    }
}
