import dao.PersonDAO;
import model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

//        List<Person> personList = personDAO.getAll();
//        System.out.println(personList);

//        Person p = new Person();
//        p.setName("PHAM NGOC THUY");
//        p.setAdress("TN");
//        p.setPhone("789795169");
//        p.setEmail("PNT@gmail.com");
//        personDAO.insert(p);

        List<Person> personList1 = personDAO.getById(5);
        System.out.println(personList1);
//
//        Person pUpdate = new Person();
//        pUpdate.setName("PHAM NGOC THU");
//        pUpdate.setAdress("TN");
//        pUpdate.setPhone("0123456789");
//        pUpdate.setEmail("PNT@gmail.com");
//        personDAO.update(pUpdate, 1);
//        System.out.println(personList);

//        personDAO.delete(6);

    }
}
