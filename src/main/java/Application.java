import entities.Doctor;
import org.hibernate.Session;
import util.HibernateUtil;

public class Application {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
    public static Integer create(Doctor doctor) {
        Session session = HibernateUtil.getSessionFactory().OpenSession();
        session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();
        session.close();
            System.out.println("Успешно создан" + doctor.toString());
            return doctor.getId;

        }
    }
}
