package phones;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
public class FindPhone {
    private List<Phone> data = new PhoneDB().getPhoneData();
    public List<Phone> findByTag(Tag tag) {
        List<Phone> result = new LinkedList<>();
        for (Phone ph : data) {
            if (tag.find(ph)) {
                result.add(ph);
            }
        }
        return result;
    }

    public List<Phone> byColor(Color col) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getColor()==col)   find.add(ph);
        return find;
    }
    
    public List<Phone> byModel(String mod) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getModel().equalsIgnoreCase(mod))   find.add(ph);
        return find;
    }
    
    public List<Phone> byMSize(int memSize) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getMemorySize()==memSize)   find.add(ph);
        return find;
    }
    
   public List<Phone> byModelAndPriceLowAndColor(String mod, double price, Color color) {
        Tag modelTag = new ModelTag(mod);
        Tag priceTag = new PriceLowTag(price);
        Tag colorTag = new ColorTag(color);

        Tag combinedTag = new AndTag(new AndTag(modelTag, priceTag), colorTag);

        return findByTag(combinedTag);
    }

    public List<Phone> byModelAndPriceLow(String mod, double price) {
        Tag modelTag = new ModelTag(mod);
        Tag priceTag = new PriceLowTag(price);
    //    Color color = null;
    //    Tag colorTag = new ColorTag(color);

        Tag combinedTag = new AndTag(modelTag, priceTag);

        return findByTag(combinedTag);
    }

    public List<Phone> byMSizeAndNotColor(int memSize, Color col) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getMemorySize()==memSize && !(ph.getColor()==col))   find.add(ph);
        return find;
    }    
}
