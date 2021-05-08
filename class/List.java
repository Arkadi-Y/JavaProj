import java.util.ArrayList;

import java.util.ArrayList;
public class List<T> {
   protected ArrayList<T> list;
   public List(){
        list = new ArrayList<T>();
   }
   public ArrayList<T> getList() {
       return list;
   }
   public void setList(ArrayList<T> list) {
       this.list = list;
   }
}
