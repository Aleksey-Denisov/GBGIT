package ToyShop.controller;
import java.util.Random;
import ToyShop.model.*;

public class ToyController {
    private EnteringUserData userData = new EnteringUserData();
    private ListToy lt = new ListToy();
    private FileJob fileJob = new FileJob();
    private String winFile = "ToyShop/Winning_toys.txt";

    public void menu(){
        boolean start = true;
        while(start){
            System.out.println("1. Добавить игрушки\n2. Изменить вес игрушки по ИД\n3. Удалить игрушку из списка по ИД\n" +
            "4. Показать список игрушек\n5. Розыгрыш игрушки\n6. Просмотр файла выигранных игрушек\n7. Выход");
            switch(userData.consoleEnterInt(7, "Укажите пункт меню: ")){
                case 1:
                    addData();
                    break;
                case 2:
                    changePercWin();
                    break;
                case 3:
                    deleteToy();
                    break;
                case 4:
                    print();
                    break;
                case 5:
                    loteryToy();
                    break;
                case 6:
                    printWinFile();
                    break;
                case 7:
                    start = false;
                    break;
            }
        }
    }
    private void addData(){
        while(true){
            lt.addToy(userData);
            if(userData.consoleEnterConfirm("Продолжаем? y или n ") == 'n')
                break;
        }
    }
    private void changePercWin(){
        if(lt.countList() > 0){
            lt.print();
            Toy toy = lt.getToy(userData.consoleEnterInt(lt.countList(), "Введите ИД игрушки: ") - 1);
            toy.setPercWin(userData.consoleEnterInt(100, "Введите процент выпадения: "));
        }else
            System.out.println("Нет доступных записей");
        
    }
    private void deleteToy(){
        if(lt.countList() > 0){
            lt.print();
            lt.deleteToy(lt.getToy(userData.consoleEnterInt(lt.countList(), "Введите ИД игрушки: ") - 1));
        }else
            System.out.println("Нет доступных записей");
    }
    private void print(){
        if(lt.countList() > 0){
            lt.print();
        }else
            System.out.println("Нет доступных записей");
    }
    private void loteryToy(){
        if(lt.countList() > 0){
            lt.printToys();
            Toy toy = lt.getToy(userData.consoleEnterInt(lt.countList(), "Введите ИД игрушки: ") - 1);
            Random rnd = new Random();
            int num = rnd.nextInt(100);
            if (num > toy.getPercWin()) {
                System.out.println("вы проиграли, попробуйте cнова");
            } else if (num < toy.getPercWin()) {
                System.out.println("поздравляю, вы выйграли!!!");
                fileJob.saveInFile(toy, winFile);
                lt.deleteToy(toy);
            }
        }else
            System.out.println("Нет доступных записей");
    }
    private void printWinFile(){
        System.out.println(fileJob.readFile(winFile));
    }
}
