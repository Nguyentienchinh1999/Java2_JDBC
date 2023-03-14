package dao;

import connection.MyConnection;
import model.Employees;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
    public void insert(Employees em){
        try{
            Connection conn = MyConnection.getConnection();
            String sql = String.format
                    ("INSERT INTO `employees` (`full_name`,`city`,`email`,`gender`,`salary`,`phone`) VALUES ('%s', '%s','%s','%d','%d','%s')",
                            em.getFull_name(), em.getCity(),em.getEmail(), em.getGender(), em.getSalrary(), em.getPhone());
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            // Buoc 4:
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Employees> getAll(){
        List<Employees> employeesList = new ArrayList<>();
        try{
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM employees";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
               Employees em = new Employees();
               em.setId(rs.getInt("id"));
               em.setFull_name(rs.getString("full_name"));
               em.setCity(rs.getString("city"));
               em.setEmail(rs.getString("email"));
               em.setPhone(rs.getString("phone"));
               em.setGender(rs.getInt("gender"));
               em.setSalrary(rs.getInt("salary"));
               employeesList.add(em);
            }
            rs.close();
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return employeesList;
    }

    public List<Employees> searchEmployee(String name){
        List<Employees> emList = new ArrayList<>();
        try{
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM employees WHERE `full_name` LIKE '" + name + "%'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                Employees em = new Employees();
                em.setId(rs.getInt("id"));
                em.setFull_name(rs.getString("full_name"));
                em.setCity(rs.getString("city"));
                em.setEmail(rs.getString("email"));
                em.setPhone(rs.getString("phone"));
                em.setGender(rs.getInt("gender"));
                em.setSalrary(rs.getInt("salary"));
                emList.add(em);
            }
            stm.close();
            conn.close();
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return emList;
    }

    public void update(Employees em, int id){
        try{
            Connection conn = MyConnection.getConnection();
            String sql = String.format("Update employees set full_name = '%s', city =  '%s', email = '%s', gender = '%d', salary = '%d', phone = '%d' where id = '%d'",
                    em.getFull_name(), em.getCity(), em.getEmail(),em.getGender(), em.getSalrary(), em.getPhone(), id);
            Statement stm = conn.createStatement();

            stm.executeUpdate(sql);
            stm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    };
}
