package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("BMW",12345);
      Car car2 = new Car("AUDI",41579);
      Car car3 = new Car("MER",838245);
      Car car4 = new Car("INFINITY",61746);

      car1.setUser(user1);
      car2.setUser(user2);
      car3.setUser(user3);
      car4.setUser(user4);

      userService.add(user1,car1);
      userService.add(user2,car2);
      userService.add(user3,car3);
      userService.add(user4,car4);




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());

         System.out.println();
      }
       System.out.println("-----------------------------------");

      System.out.println(userService.getUserByCar(car1));
      System.out.println(userService.getUserByCar(car2));
      System.out.println(userService.getUserByCar(car3));
      System.out.println(userService.getUserByCar(car4));


      context.close();

   }

}
