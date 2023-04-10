package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user,Car car) {
      sessionFactory.getCurrentSession().save(user);
      sessionFactory.getCurrentSession().save(car);



   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(Car car) {


      String HQL="from Car c where c = :uId";
      Query<Car> query = sessionFactory.getCurrentSession().createQuery(HQL).setParameter("uId",car);
      Car car2 = query.getSingleResult();
      User user = car2.getUser();

      return user;
   }


}
