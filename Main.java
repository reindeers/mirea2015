import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hall[] halls = {new Hall(10, 20, 30), new Hall(20, 20, 20)};
        Seance[] seances = {new Seance(1, "фильм 1", "18:00", 1), new Seance(2, "фильм 2", "18:00", 2)};
        for (int i=0; i<seances.length; i++){
            for (int j=0; j<halls.length; j++) {
                int cnt = halls[j].getRows()-1;
                seances[i].first(cnt, halls[j].getSeats(cnt)-1);
            }
        };
        Cinema cinema = new Cinema(halls, seances);


        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1. Просмотреть сеансы");
            System.out.println("2. Бронирование");
            System.out.println("3. �����");
            int command = Integer.parseInt(in.nextLine());
            switch (command) {
            case 1:
                System.out.println("Расписание фильмов:");
                String name = in.nextLine();
                ArrayList<Seance> found = cinema.find(name);
                if (found.isEmpty()) {
                    System.out.println("Сеансов не найдено");
                } else {
                    for (Seance seance : found) {
                        System.out.println(seance);
                    }
                }
                break;
            case 2:
                System.out.println("Введите номер сеанса");
                int id = Integer.parseInt(in.nextLine());
                Seance found2 = cinema.findById(id);
                if (found2 == null) {
                    System.out.println("Сеансов не найдено");
                } else {
                    System.out.println(found2);
                }

                int hallnmb = found2.getHallNumber();
                int nmbrows = cinema.getNumberOfRows(hallnmb)-1;

                System.out.println("Введите ряд для бронирования");
                int row = Integer.parseInt(in.nextLine());
                while (row > nmbrows || row < 0) {
                    System.out.println("Введите номер ряда, от 0 до" + nmbrows);
                    row = Integer.parseInt(in.nextLine());
                }
                System.out.println("Введите место для бронирования");
                int nmbseats = cinema.getNumberOfSeats(hallnmb, row)-1;
                int seat = Integer.parseInt(in.nextLine());
                while (seat > nmbseats || seat < 0) {
                    System.out.println("Введите номер места, от 0 до" + nmbseats);
                    seat = Integer.parseInt(in.nextLine());
                }

                if (cinema.reserve(found2, row, seat)){
                    System.out.println("Успешно забронированно");
                }

                break;
            case 3:
                return;
            default:
                System.out.println("Выберите пункт от 1 до 3");
                break;
            }
        }
    }
}
