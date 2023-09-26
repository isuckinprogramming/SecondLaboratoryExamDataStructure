package LimModifiedExpressionTree;

public class CustomNode {

    int data;
    CustomNode left, right;

//    default
    String operator = "";
    private boolean isOperatorNode = false;
    public boolean isNodeAnOperator() {
        return  isOperatorNode;
    }

    CustomNode(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }

    CustomNode(int data, CustomNode left, CustomNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    CustomNode(String operator ){
        setAsOperatorNode(operator.charAt(0));
        isOperatorNode = true;
    }


    CustomNode(char operator, CustomNode left, CustomNode right)
    {
        setAsOperatorNode( operator);
        this.left = left;
        this.right = right;
    }

    public void setAsOperatorNode(char operatorInput) {

        if(!CustomExpressionTree.isOperator( operatorInput)){
            return;
        }
        this.operator += operatorInput;
        isOperatorNode= true;
    }

    public char getOperatorChar() {
        return operator.charAt(0);
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
