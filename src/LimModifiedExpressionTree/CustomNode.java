package LimModifiedExpressionTree;

public class CustomNode {

    int data;
    CustomNode left, right;
/**
 *   I used a string as the operator for holding
 *   operator of an operator node because, the operator
 *   node will be added to a string for concatenation.
 *
 * */
    String operator = "";
    private boolean isOperatorNode = false;
    public boolean isNodeAnOperator() {
        return  isOperatorNode;
    }

/**
 * Constructor for number node. Number nodes hold only numbers for the expression tree.<br></br>
 *
 * @param data Number inside the node.
 * */
    CustomNode(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }

/**
 *Constructor for Operator node. Operator nodes need left and <br></br>
 * right nodes, which is why during the initialization of the node, <br></br>
 * the left and right nodes must be identified first. <br></br>
 * <br></br>
 * Both Nodes must be number nodes, operator nodes cannot be passed as
 * left or right nodes.<br></br>
 * @param left This node will be the left-hand side of the expression when
 *             used with the operator node.
 * @param right This node will be the right-hand side of the expression when
 *              used with the operator node.
 * */
    CustomNode(char operator, CustomNode left, CustomNode right)
    {
        setAsOperatorNode( operator);
        this.left = left;
        this.right = right;
    }

/**
 * Set the node as an operator node.
 * */
    public void setAsOperatorNode(char operatorInput) {

        if(!CustomExpressionTree.isOperator( operatorInput)){
            return;
        }
        this.operator += operatorInput;
        isOperatorNode= true;
    }

    /**
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
