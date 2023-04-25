package ToyShop.model;

public class Toy {
    private int idToy, percWin;
    private String nameToy;

    public Toy(int idToy, EnteringUserData userData){
        this.idToy = idToy;
        this.nameToy = userData.consoleEnter("Введите название игрушки: ");
        this.percWin = userData.consoleEnterInt(100, "Введите процент выпадения: ");
    }
    public int getId(){
        return idToy;
    }public int getPercWin(){
        return percWin;
    }
    public String getNameToy(){
        return nameToy;
    }
    /*public void setId(int idToy){
        this.idToy = idToy;
    }*/
    public void setPercWin(int percWin){
        this.percWin = percWin;
    }
    /*public void setNameToy(String nameToy){
        this.nameToy = nameToy;
    }*/
    @Override
    public String toString() {
        return "Идентефикатор игрушки: " + idToy + ", Имя игрушки: " + nameToy + ", Процент выигрыша игрушки: " + percWin;
    }
}
