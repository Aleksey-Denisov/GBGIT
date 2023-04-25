package ToyShop.model;
import java.io.*;

public class FileJob{
    private void exsistFile(String fileName){
        File file = new File(fileName);
        try{
            if(file.createNewFile())
                System.out.println("Файл создан");
        }
        catch(Exception ex){
            System.err.println(ex);
        }
    }
    public void saveInFile(Toy toy, String fileName) {
        exsistFile(fileName);
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(toy.getNameToy() + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Ошибка записи файла");
        }
    }
    public String readFile(String fileName) {
        exsistFile(fileName);
        StringBuilder sb = new StringBuilder(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла");
        }
        String contents = sb.toString();
        return contents;
    }
}
