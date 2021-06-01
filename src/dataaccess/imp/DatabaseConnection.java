package dataaccess.imp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String USERNAME="std_63_113";
    private static final String PASSWORD="pwd_63_113";
    private static final String URI="jdbc:mysql://34.126.131.128:3306/retail_db_03?zeroDateTimeBehavior=CONVERT_TO_NULL";
    
    // aa หมายถึง รหัสนักศึกษา 2 ตัวแรก
    // bbb หมายถึง รหัสนักศึกษา 3 ตัวหลัง
    // retail_db_0X  X หมายถึง เศษเหลือจากการเอา bbb หารด้วย 5 (bbb mod 5)
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn=DriverManager.getConnection(URI, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("ไม่พบ Database driver! ให้ทำดังต่อไปนี้");
            System.out.println("\nเพิ่มไฟล์ mysql-connector-java-8.0.19.jar ไว้ที่ Libraries");
            System.out.println("download ได้ที่ https://dev.mysql.com/downloads/connector/j/");
        } catch (SQLException ex) {
            System.out.println("\n---------");
            System.out.println("ตรวจสอบ");
            System.out.println("USERNAME="+USERNAME);
            System.out.println("PASSWORD="+PASSWORD);
            System.out.println("   aa หมายถึง รหัสนักศึกษา 2 ตัวแรก");
            System.out.println("   bbb หมายถึง รหัสนักศึกษา 3 ตัวหลัง");
            System.out.println("URI="+URI);
            System.out.println("   retail_db_0X  X หมายถึง เศษเหลือจากการเอา bbb หารด้วย 5 (bbb mod 5)");
            System.out.println("\nหากยังไม่สามารถเชื่อมต่อ databses ได้");
            System.out.println("ให้ทดลองเชื่อมต่อ database ให้คลิกที่หน้าต่าง Services ดูที่หัวข้อ Databases"); 
            System.out.println("\n1 คลิกขวาที่ Databases เลือก New Connection..."); 
            System.out.println("\n2 Driver File(s) เป็นไฟล์ mysql-connector-java-8.0.xx.jar "); 
            System.out.println("\n3 ทดลองต่อไปยัง Database ตามข้อมูลด้านบน"); 
            System.out.println("---------\n");
            System.out.println("หากลง MySQL ไว้ในเครื่องตนเอง (MySQL 5.7) แล้วอยากได้ข้อมูลเพื่อใช้ทดสอบสามารถ import ข้อมูลได้จาก");
            System.out.println("https://github.com/praisan/hello-world/blob/master/retail_db_mysqldump.sql");
        }
        return conn;
    }
    
}
