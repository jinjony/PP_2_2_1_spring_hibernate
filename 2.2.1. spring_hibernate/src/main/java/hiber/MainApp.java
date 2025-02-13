package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      // 4. Создайте несколько пользователей с машинами, добавьте их в базу данных, вытащите обратно.
      for (int i = 5; i < 10; i++) {
         String userName = "User_" + i;
         String lastName = "Lastname_" + i;
         String email = "user" + i + "@mail.ru";
         String model = "Car_" + i;
         User user = new User(userName, lastName, email);
         Car car = new Car(model);
         user.setCar(car);
         userService.add(user);
      }

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Car_5", 1));

      context.close();
   }
}