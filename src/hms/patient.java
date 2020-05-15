
package hms;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class patient {
    public static void insertion(char opration,String id,String name,String lname,String age,String phone,String address,String patientType,String gender)
    { 
     Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
  
        if (opration=='i') //insertion
        {
         try { 
             
             ps=con.prepareStatement("insert  into patient(id,name,lname,age,phone,address,patientType,gender)values(?,?,?,?,?,?,?,?)");
             ps.setString(1, id);
             ps.setString(2, name);
             ps.setString(3, lname);
             ps.setString(4, age);
             ps.setString(5, phone);
             ps.setString(6, address);
             ps.setString(7, patientType);
             ps.setString(8, gender);
             
              if(ps.executeUpdate()>0)
              {
               JOptionPane.showMessageDialog(null," Record  Inserted  Successfully !! ");
              }
              else
              {
              JOptionPane.showMessageDialog(null," Sorry !! Record  Not  Inserted ");
              }
        
         }
         catch (SQLException ex) {
             Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
         public void delete(char opration,String id,String name,String lname,String age,String phone,String address,String patientType){
          Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
          
          if (opration=='d')// for delete
        {
        try {
            ps=con.prepareStatement("delete from  patient where id=?");
           
            
              ps.setString(1, id);//ps.setString(8, gender);
             
             if(ps.executeUpdate()>0)
              { 
               JOptionPane.showMessageDialog(null," Record  Deleted Successfully !! ");
              }
             else
             {
              JOptionPane.showMessageDialog(null," Sorry !! Record  Not Deleted  ");
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
    }
         public void update(char opration,String id,String name,String lname,String age,String phone,String address,String patientType){
          Connection con;
         con = myconnection.getConnection();
          PreparedStatement ps;
          
          if (opration=='u') //update
        {
         try { 
             
             ps=con.prepareStatement("update patient set name=?,lname=?,age=?,phone=?,address=?,patientType=?  where id=?");
             
             ps.setString(1, name);
             ps.setString(2, lname);
             ps.setString(3, age);
             ps.setString(4, phone);
             ps.setString(5, address);
             ps.setString(6, patientType);
            // ps.setString(7, gender);
             ps.setString(7, id);
             
              if(ps.executeUpdate()>0)
              {
               JOptionPane.showMessageDialog(null," Record  Updated Successfully !! ");
              }
              else
              {
              JOptionPane.showMessageDialog(null," sorry !! Record  Not  Updated ");
              }
        
         }
         catch (SQLException ex) {
             Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
         }
          }}
     public void Report2(JTable table,String valuesearch)
     {
     Connection con = myconnection.getConnection();
     PreparedStatement ps;
         try {
             ps=con.prepareStatement("select * from patient where CONCAT('id','name','lname','age','phone','address','patientType','gender')like ?");
             ps.setString(1, "%"+valuesearch+"%");
             ResultSet rs=ps.executeQuery();
             DefaultTableModel model =(DefaultTableModel)table.getModel();
             model.setRowCount(0);
             Object [] row;
             while(rs.next())
             {
               row=new Object[8] ;
               row[0]=rs.getString(1);
               row[1]=rs.getString(2);
               row[2]=rs.getString(3);
               row[3]=rs.getString(4);
               row[4]=rs.getString(5);
               row[5]=rs.getString(6);
               row[6]=rs.getString(7);
               row[7]=rs.getString(8);
                model.addRow(row);
            }
             
         } catch (SQLException ex) {
             Logger.getLogger(doctorADD.class.getName()).log(Level.SEVERE, null, ex);
         }
}

    void insertion(char c, String name, String lname, String age, String phone, String address, String patientType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}