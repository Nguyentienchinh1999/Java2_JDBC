package dao;

import connection.MyConnection;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<Person> getAll(){
        List<Person> personList = new ArrayList<>();
        try{
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM persons";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                Person p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setAdress(rs.getString("adress"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));

                personList.add(p);
            }
            rs.close();
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return personList;
    };
    public List<Person> getById(long id){
        List<Person> personList = new ArrayList<>();
        try{
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM persons WHERE id =    '" + id + "'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                Person p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setAdress(rs.getString("adress"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));

                personList.add(p);
            }
            stm.close();
            conn.close();
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return personList;
    };

    public void insert(Person p){
        try{
            Connection conn = MyConnection.getConnection();
            String sql = String.format("INSERT INTO `persons` (`name`,`adress`,`phone`,`email`) VALUES ('%s','%s','%s','%s')",
                    p.getName(), p.getAdress(), p.getPhone(), p.getEmail());
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);


            // Buoc 4:
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    };

    public void update(Person p, long id){

        try{
            Connection conn = MyConnection.getConnection();
            String sql = "UPDATE persons SET" +
                    " name = '"+p.getName()+"'," +
                    " adress = '"+p.getAdress() + "', " +
                    " phone = '"+ p.getPhone() + "'," +
                    " email = '" + p.getEmail() + "' " +
                    " WHERE id = '" + id +"' ";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    };

    public void delete(long id) {
        try{
            Connection conn = MyConnection.getConnection();
            String sql = "DELETE FROM persons WHERE id = '" + id +"'";
            Statement stm = conn.createStatement();
            long rs = stm.executeUpdate(sql);
            if(rs == 0){
                System.out.println("không có người nào có id = " + id);
            }else{
                System.out.println("xoa thanh cong");

            }
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
