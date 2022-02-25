package studentManagementApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.student.manage.Cp;
import com.student.manage.Student;

public class Start {

    public static void main(String[] args) throws IOException, SQLException {
        // TODO Auto-generated method stub
        System.out.println("Welcome to student management App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("PRESS 1 to ADD Student");
            System.out.println("PRESS 2 to Delete student");
            System.out.println("PRESS 3 to Display student");
            System.out.println("PRess 4 to Exit");
            int c = Integer.parseInt(br.readLine());
            if (c == 1) {
                // add student
                System.out.println("Enter user name:");
                String name = br.readLine();
                System.out.println("Enter user phone");

                String phone = br.readLine();
                System.out.println("Enter your city");
                String city = br.readLine();
                // create Student object to store student
                Student st = new Student(name, phone, city);
                // System.out.println(st);
                Connection con = Cp.createC();
                String q = "insert into students(sname,sphone,scity) values (?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1, st.getStudentName());
                pstmt.setString(2, st.getStudentPhone());
                pstmt.setString(3, st.getStudentCity());
                int result = pstmt.executeUpdate();
                System.out.println("Data inserted sucessfully" + result);

            } else if (c == 2) {
                System.out.println("Enter user Id:");
                int id = Integer.parseInt(br.readLine());
                // create Student object to store student
                Connection con = Cp.createC();
                String q = "delete from students where sid=?";
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setInt(1, id);
                int result = pstmt.executeUpdate();
                System.out.println("Data deleted sucessfully" + result);

            } else if (c == 3) {
                Connection con = Cp.createC();
                String q = "select * from students";
                Statement stmt = con.createStatement();
                ResultSet set = stmt.executeQuery(q);
                while (set.next()) {
                    int id = set.getInt(1);
                    String name = set.getString(2);
                    String city = set.getString(3);
                    System.out.println(id + " : " + name + " : " + city);
                }

            } else if (c == 4) {

                break;
            } else {
                System.out.println("Please enter currect number bro");
            }

        }
        System.out.println("Thanks you for using my application");
    }

}
