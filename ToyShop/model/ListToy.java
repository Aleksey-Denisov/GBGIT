package ToyShop.model;
import java.util.*;

public class ListToy {
    private ArrayList<Toy> listToy;
    private int countToy;

    public ListToy(){
        listToy = new ArrayList<>();
    }
    public void addToy(EnteringUserData userData){
        listToy.add(countToy, new Toy(countToy + 1, userData));
        countToy++;
    }
    public void deleteToy(Toy toy){
        listToy.remove(toy);
    }
    public Toy getToy(int idToy){
        return listToy.get(idToy);
    }
    public void printToys(){
        for(Toy toy : listToy){
            System.out.println(toy.getId() + " " + toy.getNameToy());
        }
    }
    public int countList(){
        return listToy.size();
    }
    public ArrayList<Toy> getToys(){
        return listToy;
    }
    public void print(){
        for(Toy toy : listToy){
            System.out.println(toy);
        }
    }
}
