package Task3;
import java.sql.*;
import java.util.Scanner;


public class SMS {
    static String url="jdbc:MySQL://localhost:3306/students";
   static  String user="root";
    static String   pass="1605";
    String roll_no;
    String name;
    int grade;
    String gender;
    int age;
    String query;
    Scanner sc=new Scanner(System.in);
 

    public void addStudent(){
        try {
            Connection con= DriverManager.getConnection(url,user,pass);
              PreparedStatement s;
            boolean g=true;
            while(g)
            {
                     System.out.println("Enter the rool number of the Student");
        roll_no=sc.next();
       
       query="Select *from students where roll_no=?";
       s=con.prepareStatement(query);
       s.setString(1,roll_no);
       ResultSet r=s.executeQuery();
       if(r.next()){
        System.out.println("U entered roll no exists already in the class");
        System.out.println("please Enter some other roll number");
       }
       else{
        g=false;
       }
            }
        System.out.println("enter the name of the student");
        name=sc.next();
        
        System.out.println("Enter the grade student studying");
        grade=sc.nextInt();
        System.out.println("Enter the gender male or female");
        gender=sc.next();
        System.out.println("Enter the age of the student");
        age=sc.nextInt();
        query="insert into students(roll_no,name,grade,sex,age) values(?,?,?,?,?)";
       s=con.prepareStatement(query);
        s.setString(1, roll_no);
        s.setString(2, name);
        s.setInt(3, grade);
        s.setString(4, gender);
        s.setInt(5, age);
        s.executeUpdate();
        System.out.println("inserted");

       }
       catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteStudent()
    {
        try {
              Connection con= DriverManager.getConnection(url,user,pass);
              PreparedStatement s;
            boolean g=true;
          
            while(g)
            {
                System.out.println("Enter the rool number of the student to delete");
                roll_no=sc.next();
                 query="Select *from students where roll_no=?";
       s=con.prepareStatement(query);
       s.setString(1,roll_no);
       ResultSet r=s.executeQuery();
       if(r.next()){
        query="delete from students where roll_no=?";
        s=con.prepareStatement(query);
       s.setString(1,roll_no);
       s.executeUpdate();
       System.out.println("DELETED");

       break;
          
       }
       else{
        System.out.println("Sorry the roll number entered does't exists ");
        System.out.println("Please enter the valid roll number");

       }


            }
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    public void showstudent()
    {
        try {
             Connection con= DriverManager.getConnection(url,user,pass);
              PreparedStatement s;
              query="select *from students";
              s=con.prepareStatement(query);
              ResultSet rs=s.executeQuery();
              System.out.println("ROLL_NO\t\tNAME\t\tGRADE\t\tGENDER\t\tAGE");
              System.out.println("____\t\t____\t\t____\t\t____\t\t____");
              
              while(rs.next())
              {
                System.out.println(rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
                
              }
              
              

            
        } catch (Exception e) {
            System.out.println(e);

        }
    }
       
    public void updateStudent(){
         try {
              Connection con= DriverManager.getConnection(url,user,pass);
              PreparedStatement s;
            boolean g=true;
          
            while(g)
            {
                System.out.println("Enter the rool number of the student to update");
                roll_no=sc.next();
                 query="Select *from students where roll_no=?";
       s=con.prepareStatement(query);
       s.setString(1,roll_no);
       ResultSet r=s.executeQuery();
       if(r.next()){
        System.out.println("Information about the student you wish to update");
      
                System.out.println("ROLL_NO\t\tNAME\t\tGRADE\t\tGENDER\t\tAGE");
              System.out.println("____\t\t____\t\t____\t\t____\t\t____");
                System.out.println(r.getString(2)+"\t\t"+r.getString(3)+"\t\t"+r.getInt(4)+"\t\t"+r.getString(5)+"\t\t"+r.getInt(6));
        
        System.out.println("Select the attribute of the student you wish to update\n");
        System.out.println("1.Name \t 2.Grade \t 3.Gender \t 4.Age \n");
        System.out.println("Enter the option:");
        int option=sc.nextInt();
        if(option>4 && option<1){
            System.out.println("Sorry you entered the wrong option");
            break;
        }
        
      
    
        switch(option){
            case 1:System.out.println("Enter the new name u wish to update\n");
            name=sc.next();
            query="update students set name=? where roll_no=?";
               s=con.prepareStatement(query);
            s.setString(1, name);
               s.setString(2,roll_no);
              
            break;
            case 2:
            System.out.println("Enter the new grade of the student u wish to update");
            grade=sc.nextInt();
            query="update students set grade=? where roll_no=?";
             s=con.prepareStatement(query);
            s.setInt(1, grade);
            s.setString(2,roll_no);
            
            break;
            case 3:System.out.println("Enter the new gender  u wish to update\n");
            gender=sc.next();
             query="update students set sex=? where roll_no=?";
            s=con.prepareStatement(query);
            s.setString(1, gender);
            s.setString(2,roll_no);
                
            break;
            case 4:
            System.out.println("Enter the new age of the student u wish to update");
            age=sc.nextInt();
            s=con.prepareStatement(query);
           query="update students set age=? where roll_no=?";
            s.setInt(1, age);
             s.setString(2,roll_no);
                 
            break;
            

        }
       
       s.executeUpdate();
       System.out.println("UPDATED");

       break;
          
       }
       else{
        System.out.println("Sorry the roll number entered does't exists ");
        System.out.println("Please enter the valid roll number");

       }


            }
            
        } catch (Exception e) {
            System.out.println(e);
            
        }

    }
 
    
    public static void main(String[] args) {

         boolean loop=true;
       while(loop){
        int choice;
        SMS student=new SMS();
        Scanner s=new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("\t------STUDENT MANAGEMENT SYSTEM------");
        System.out.println("1.ADD NEW STUDENT");
        System.out.println("2.DELETE THE EXISTING STUDENT");
        System.out.println("3.UPDATE THE EXISTING STUDENT DETAIL");
        System.out.println("4.DISPLAY THE LIST OF THE STUDENTS");
        System.out.println("5.EXIT\n\n ");
        System.out.print("Enter your choice:");
        choice=s.nextInt();
        switch(choice)
        {
            case 1:
               student.addStudent();
               break;
            case 2:
               student.deleteStudent();
               break;
               case 3:
               student.updateStudent();
               break;
               case 4:
               student.showstudent();
               break;
               case 5:
                loop=false;
                break;
                default :
                System.out.println("\nPlease Enter the valid choice");

        }
        
    }
}
}
