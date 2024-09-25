import java.util.ArrayList;
import java.util.Scanner;


class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Car> carList = new ArrayList<>(3);

        for (int i = 1; i <= 3;i++)
        {
            String inputCar;
            int inputSpeed;

            System.out.println("Введите название автомобиля № " + i +":");
            inputCar = scanner.nextLine();

            System.out.println("Введите скорость автомобиля № " + i + ":");

            while(true)
            {
                if (scanner.hasNextInt())
                {
                    inputSpeed = scanner.nextInt();
                    scanner.nextLine();

                    if (inputSpeed > 0 && inputSpeed <= 250)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Неправильное значение скорости! Скорость должна быть в диапазоне от 0 до 250! Введите скорость автомобиля № " + i + " еще раз:");
                    }
                }
                else
                {
                    System.out.println("Неправильное значение скорости! Скорость должна быть целым числом! Введите скорость автомобиля № " + i + " еще раз:");
                    scanner.next();
                }
            }

            carList.add(new Car(inputCar, inputSpeed));
        }

        scanner.close();
        Race race = new Race(carList);
        Car winnerCar = race.getWinner();
        System.out.printf("Самая быстрая машина: %s%n", winnerCar.carmark);
    }
}

class Car
{
    String carmark;
    int speed;

    Car(String carmark, int speed)
    {
        this.carmark = carmark;
        this.speed = speed;
    }

    int distanceFor(int duration)
    {
        return speed * duration;
    }
}

class Race
{
    ArrayList<Car> cars;
    int durationInHours = 24;

    Race(ArrayList<Car> cars)
    {
        this.cars = cars;
    }

    Car getWinner()
    {
        if (cars.isEmpty())
        {
            return null;
        }

        Car winner = this.cars.get(0);
        for (Car car : cars)
        {
            if (winner.distanceFor(durationInHours) < car.distanceFor(durationInHours))
            {
                winner = car;
            }
        }
        return winner;
    }
}
