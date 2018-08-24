import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PlayGround {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lhmap = new LinkedHashMap<>();
        
        lhmap.put(22, "Abey");
        lhmap.put(33, "Dawn");
        lhmap.put(1, "Sherry");
        
        Set set = lhmap.entrySet();
        
        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print("Key is: "+ me.getKey() + 
            " & Value is: "+me.getValue()+"\n");
        }

        lhmap.put(22, "KaTai");
        set = lhmap.entrySet();
        iterator = set.iterator();

        while(iterator.hasNext())
        {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print("Key is: "+ me.getKey() + 
            " & Value is: "+me.getValue()+"\n");
        }
    }
}