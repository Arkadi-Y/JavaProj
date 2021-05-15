package ongoing;
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
   public void add(T item) {
       this.list.add(item);
   }
   public void remove(T item) {
       this.list.remove(item);
   }
   public String toString(){
       String res="";
       for(T item : list){
           res+=item.toString()+"\n";
       }
       return res;
   }
}
