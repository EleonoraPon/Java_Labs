import java.util.Scanner;
import java.util.*;

class LoginCinema
{
    LoginCinema()
    {
        _cinemas = new ArrayList<>();
    }











    public void login()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("нажмите 1 чтобы войти в учётную запись администратора, или 2 если в учётную запись пользователя");
        int log = scan.nextInt();

        switch (log)
        {
            case 1:
            {
                this.loginAdmin();
                break;
            }
            case 2:
            {
                this.loginUser();
                break;
            }
        }
    }



    private List<cinema> _cinemas;
    private void addCinema(cinema cinema) {
        _cinemas.add(cinema);
    }
    private void loginAdmin()
    {
        System.out.println("вы вошли в учётную запись администратора");
        Scanner scan = new Scanner(System.in);

        int log = 1;
        while(log > 0)
        {
            System.out.println("нажмите 0 если хотите выйти ");
            System.out.println("нажмите 1 если хотите добавить новвый адрес кинотеатра");
            System.out.println("нажмите 2 если хотите добавить зал");
            System.out.println("нажмите 3 если хотите добавить сеанс");

            log = scan.nextInt();

            switch (log)
            {
                case 1:
                {
                    System.out.println("Введите новый адрес кинотеатра:");
                    String newAdress = scan.nextLine();
                    cinema cinema = new cinema(newAdress);
                    this.addCinema(cinema);
                    break;
                }
                case 2:
                {
                    System.out.println("введите адрес кинотеатра в котором будет новый зал");
                    String adress = scan.nextLine();
                    cinema cinema = new cinema(adress);
                    System.out.println("введите номер нового зала");
                    int newHall = scan.nextInt();
                    System.out.println("введите количество рядов и количество мест в ряду");
                    //for(int i = 0; i < 2; i++)
                    int lineCount = scan.nextInt();
                    int placeCount = scan.nextInt();

                    Hall hall = new Hall(newHall, lineCount, placeCount);
                    cinema.addHall(hall);
                    break;
                }
                case 3:
                {
                    System.out.println("введите адрес кинотеатра в котором зал");
                    String adress = scan.nextLine();
                    cinema cinema = new cinema(adress);

                    System.out.println("введите номер зала для добавления сеанса");
                    int Hall = scan.nextInt();

                    System.out.println("введите название фильма");
                    String name = scan.nextLine();
                    System.out.println("введите начало сеанса");
                    long start = scan.nextLong();

                    Hall hall;
                    int seats[][] = null;

                    moveSeance seance = new moveSeance(name, new Date(start),  seats);

                    break;
                }
            }

        }
    }

    private void loginUser()
    {
        System.out.println("вы вошли в учётную запись пользователя");
        Scanner scan = new Scanner(System.in);

        int log = 1;
        while(log > 0)
        {
            System.out.println("нажмите 0 если хотите выйти ");
            System.out.println("нажмите 1 если хотите выбрать билет на нужный сеанс");

            log = scan.nextInt();

            switch (log)
            {
                case 1:
                {
                    System.out.println("введите название фильма");
                    String name = scan.nextLine();
                    System.out.println("введите время сеанса");
                    long start = scan.nextLong();

                    System.out.println("введите ряд и номер места для выбора");
                    int line = scan.nextInt();
                    int place = scan.nextInt();


                    int seats[][] = new int[line][place];//элемент 2 3 будет таким же даже если матрицу сделать больше
                    moveSeance seance = new moveSeance(name, new Date(start),  seats);
                    seance.setPlaces(line, place);

                    break;
                }

            }


        }
    }
}