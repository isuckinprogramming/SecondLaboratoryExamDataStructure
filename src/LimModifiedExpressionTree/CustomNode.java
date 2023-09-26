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
}
