package erlan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./cars.json");


    public static void main(String[] args) {
        Car[] cars = {
                Car.makeCar("X6", 4800, Model.BMW),
                Car.makeCar("A6", 3800, Model.AUDI),
                Car.makeCar("Solaris", 4800, Model.HONDA),
                Car.makeCar("A11", 8800, Model.TESLA),
        };
        String allCars = gson.toJson(cars);
        // System.out.println(allCars);

        // writeFile(allCars);
        System.out.println(fileReader());
    }

    private static void writeFile(String Object){
        Path write = Paths.get(String.valueOf(WRITE_PATH));

        try {
            Files.writeString(write, Object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }catch (Exception e){
            e.getMessage();
        }
    }

    private static String fileReader(){
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = reader.read()) != +1){
                json += (char) a;
            }
        }catch (Exception e){
            e.getMessage();
        }
        return json;
    }


}
