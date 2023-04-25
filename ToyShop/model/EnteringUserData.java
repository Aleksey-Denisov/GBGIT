package ToyShop.model;
import java.util.*;

public class EnteringUserData {
    private Scanner in = new Scanner(System.in);
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(int val, String message){
        int valueInt;
        while(true){
            System.out.print(message);
            if(in.hasNextInt()){
                valueInt = in.nextInt();
                in.nextLine();
                if(valueInt > 0 && valueInt <= val)
                    break;
                else
                    System.out.println("Вы указали неверные данные, попробуйте снова");
            }else{
                System.out.println("Вы указали неверные данные, попробуйте снова");
                in.nextLine();
            }
        }
        return valueInt;
    }
    public String consoleEnter(String message){
        String userData;
        while(true){
            System.out.print(message);
            userData = in.nextLine();
            if(userData != ""){
                break;
            }else{
                System.out.println("Вы указали неверные данные, попробуйте снова");
            }
        }
        return userData;
    }
    public char consoleEnterConfirm(String message){
        char choiceUser;
        while(true){
            System.out.print(message);
            choiceUser = in.next().charAt(0);
            if(choiceUser == 'y' || choiceUser == 'n'){
                in.nextLine();
                break;
            }else{
                System.out.println("Вы указали неверные данные, попробуйте снова");
                in.nextLine();
            }
        }
        return choiceUser;
    }
    public void scannerClose(){
        in.close();
    }
}
