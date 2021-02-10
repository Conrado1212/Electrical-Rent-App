package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.model.Vehicle;


import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(UserApp userApp){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(userApp);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public UserApp getUserByLogin(String username) {
        Session  session = this.sessionFactory.openSession();
        UserApp userApp =
                (UserApp) session.createQuery("FROM pl.edu.wszib.model.UserApp WHERE username = :username" )
                        .setParameter("username", username)
                        .uniqueResult();
        session.close();
        System.out.println(userApp);
        return userApp;

    }

    @Override
    public UserApp getUserById(int idUser) {
        Session  session = this.sessionFactory.openSession();
        UserApp userApp =
                (UserApp) session.createQuery("FROM pl.edu.wszib.model.UserApp WHERE idUser = " + idUser ).uniqueResult();
        session.close();
        System.out.println(userApp);
        return userApp;

    }


    @Override
    public List<UserApp> getAllUser() {
        Session  session = this.sessionFactory.openSession();
        List <UserApp> userApps = session.createQuery("FROM pl.edu.wszib.model.UserApp").list();
        session.close();
        return userApps;
    }

    @Override
    public Vehicle removeUserId(int idUser){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            UserApp userApp =
                    (UserApp) session.get(UserApp.class, idUser);
            session.delete(userApp);
            tx.commit();

        }catch (HibernateException e){
            if(tx != null)tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public UserApp getUpdate(int idUser, UserApp userApp){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(UserApp.class,idUser);

            session.update(userApp);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return userApp;
    }

    @Override
    public  void getUpdateUser(int idUser, UserApp userApp) {
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(UserApp.class,idUser);
            session.saveOrUpdate(userApp);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void updateUser(int idUser, UserApp userApp) {
        Session session = null;
        Transaction tx = null;
        UserApp userApp1;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            userApp1 = (UserApp)session.load(UserApp.class,idUser);

            if(!(userApp.getUsername().equals(""))){
                userApp1.setUsername(userApp.getUsername());
            }
            if(!(userApp.getPassword().equals(""))){
                userApp1.setPassword(userApp.getPassword());
            }
            if(!(userApp.getName().equals(""))){
                userApp1.setName(userApp.getName());
            }
            if(!(userApp.getSurname().equals(""))){
                userApp1.setSurname(userApp.getSurname());
            }
            if(!(userApp.getEmail().equals(""))){
                userApp1.setEmail(userApp.getEmail());
            }


            if(!(userApp.getLatitude()==0)){
                userApp1.setLatitude(userApp.getLatitude());
            }
            if(!(userApp.getLongitude()==0)){
                userApp1.setLongitude(userApp.getLongitude());
            }
            if(!(userApp.getRole().equals(""))){
                userApp1.setRole(userApp.getRole());
            }
            if(!(userApp.getLocationName().equals(""))){
                userApp1.setLocationName(userApp.getLocationName());
            }
            session.update(userApp);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }

}
