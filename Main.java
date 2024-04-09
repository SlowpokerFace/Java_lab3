import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Фамилия Имя Отчество");
        System.out.println("Дата рождения формата ДД-ММ-ГГГГ");

        String FIO = console.nextLine();
        String bithday = console.nextLine();

        String[] FIO_attributes = FIO.split(" ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date_birthday;
        LocalDate current = LocalDate.now();

        try{
            date_birthday = LocalDate.parse(bithday,formatter);
        }catch (DateTimeParseException e){
            throw new RuntimeException("Неправильный формат даты");
        }

        int age = current.getYear() - date_birthday.getYear();
        if (current.getDayOfYear() < date_birthday.getDayOfYear()) {age--;}

        String gender = "М";
        try{
            if (FIO_attributes[2].charAt(FIO_attributes[2].length() - 1) == 'а') {
                gender = "Ж";
            }
        }catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("Неправильный формат ФИО");
        }


        System.out.format("%s %c.%c.\n",FIO_attributes[0], FIO_attributes[1].charAt(0), FIO_attributes[2].charAt(0));
        System.out.println(gender + ' ' + age);

    }

}

