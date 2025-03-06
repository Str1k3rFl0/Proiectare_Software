interface Node
{
    int getValue();
    void setValue(int value);
}

public class SimpleChainedNode implements Node
{
    private int value;
    private SimpleChainedNode next;

    public SimpleChainedNode(int value, SimpleChainedNode next)
    {
        this.value = value;
        this.next = next;
    }

    @Override
    public int getValue() { return value; }

    @Override
    public void setValue() { this.value = value; }

    public void setNext(SimpleChainedNode next) { this.next = next; }
    public SimpleChainedNode getNextNode() { return node; }
}

public class SimpleChainedList
{

}

public class NodeTest
{

}