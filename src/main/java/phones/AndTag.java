package phones;
public class AndTag extends Tag {
    private Tag left, right;

    public AndTag(Tag left, Tag right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean find(Phone ph) {
        return left.find(ph) && right.find(ph);
    }
}
