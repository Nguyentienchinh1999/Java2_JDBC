package Main;

import dao.EmployeesDAO;
import dao.PersonDAO;
import model.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_employees {
    public static EmployeesDAO employeesDAO = new EmployeesDAO();
    public static List<Employees> employeesList = new ArrayList<>();

    public static List<Employees> emList = employeesDAO.getAll();
    private static void mainMenu(){
        System.out.println("--- QUẢN LÝ NHAN SU ---");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Danh sách nhân viên( sắp xếp theo họ tên -abc)");
        System.out.println("3. Tìm kiếm nhân viên theo tên");
        System.out.println("4. Cập nhật thông tin nhân viên");
        System.out.println("5. Xóa nhân viên theo mã");
        System.out.println("6. Lọc ra top 5 lương cao nhất, in thông tin theo bảng");
    }

    private static void option1(Scanner in){

        Employees em = new Employees();
        System.out.println("nhập vào tên nhân viên: ");
        em.setFull_name(in.nextLine());
        System.out.println("nhập vào city: ");
        em.setCity(in.nextLine());
        System.out.println("nhập vào email: ");
        String email = in.nextLine();
        boolean flag1 = false;
        for(int i  = 0; i < emList.size(); i++){
            if(emList.get(i).getEmail().equalsIgnoreCase(email)){
                flag1 = true;
                break;
            }
        }
        if(flag1){
            System.out.println("đã tồn tại email: ");
            return;
        }else {
            em.setEmail(email);
        }
        em.setEmail(email);
        System.out.println("nhập vào phone: ");
        em.setPhone(in.nextLine());
        System.out.println("nhập vào gender: ");
        int gender = in.nextInt();
        if(gender != 0 && gender != 1){
            System.out.println("vui lòng nhập 0 là nữ hoặc 1 là nam");
            return;
        }else {
            em.setGender(gender);
        }
        System.out.println("nhập vào salary:");
        em.setSalrary(in.nextInt());
        employeesDAO.insert(em);
        System.out.println("them thành công");
    }

    private static void option2(){
       emList.stream().sorted((o1, o2) -> {
         return  o1.getFull_name().compareTo(o2.getFull_name());
       }).forEach(System.out::println);
    }

    private static void option3(Scanner in){
        System.out.println("nhập vào tên cần tìm: ");
        String name = in.nextLine();
        employeesList = employeesDAO.searchEmployee(name);
        System.out.println(employeesList);
    }

    private static void option4(Scanner in){
        Employees em = new Employees();
        System.out.println("nhập vào id nhân viên cần update: ");
        int id = in.nextInt();
        boolean flag = false;
        for(int i = 0; i < emList.size(); i++){
            if(emList.get(i).getId() != id){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Không tồn tại nhân viên này");
            return;
        }else{
            System.out.println("nhập tên cần thay đổi: ");
            em.setFull_name(in.nextLine());
            System.out.println("nhập city cần thay đổi: ");
            em.setCity(in.nextLine());
            System.out.println("nhập email cần thay đổi: ");
            String email = in.nextLine();
            boolean flag1 = false;
            for(int i  = 0; i < emList.size(); i++){
                if(emList.get(i).getEmail().equalsIgnoreCase(email)){
                    flag1 = true;
                    break;
                }
            }
            if(flag1){
                System.out.println("đã tồn tại email: ");
                return;
            }else {
                em.setEmail(email);
            }
            System.out.println("nhập vào phone: ");
            em.setPhone(in.nextLine());
            System.out.println("nhập vào gender: ");
            int gender = in.nextInt();
            if(gender != 0 && gender != 1){
                System.out.println("vui lòng nhập 0 là nữ hoặc 1 là nam");
                return;
            }else {
                em.setGender(gender);
            }
            System.out.println("nhập vào salary:");
            em.setSalrary(in.nextInt());
            employeesDAO.update(em, id);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;
        do{
            mainMenu();
            System.out.print("nhập lựa chọn ");
            try{
                option = Integer.parseInt(in.next());
            }catch (Exception e){
                System.out.println("nhap sai dinh dang");
                continue;
            }
            if(option < 1 || option > 8){
                System.out.println("lua chon khong hop le");
                continue;
            }
            switch (option){
                case 1:
                    option1(in);
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    option4(in);
                    break;
            }
        }while (option != 8);
        in.close();
    }
}
