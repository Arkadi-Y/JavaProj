package ongoing;
import java.util.ArrayList;
import java.util.ListIterator;

public class List<T> {
   public int size = 0;
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
       this.size++;
   }
   public void remove(T item) {
       this.list.remove(item);
       this.size--;
   }
   public String toString(){
       String res="";
       for(T item : list){
           res+=item.toString()+"\n";
       }
       return res;
   }
//search method by id
    public T findByID(int id){
        for(T item : this.list) {
            if(item instanceof Person&&id==((Person) item).getId())
                return item;
            if (item instanceof Ticket&&id==((Ticket)item).getTicketNum())
                return item;

        }
        return null;
    }
    //get item by index
     public T getInstance(int i) {
        return this.list.get(i);
    }

}
