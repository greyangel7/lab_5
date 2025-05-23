package phones;
public class NotTag extends Tag {
    private Tag tag;

    public NotTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean find(Phone ph) {
        return !tag.find(ph);
    }
}


