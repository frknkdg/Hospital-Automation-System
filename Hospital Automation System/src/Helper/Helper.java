/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javax.swing.JOptionPane;

/**
 *
 * @author furkan
 */
public class Helper {

    public static void showMsg(String str) {
        String msg;
        switch (str) {
            case "fill":
                msg = "fill in all fields";
                break;
            case "success":
                msg = "process completed successfully";
                break;
                 case "error":
                msg = "Something went wrong";
                break;
                
            default:
                msg = str;
        }
        JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
        
    }
   
    public static boolean confirm(String str){
    String msg;
    switch(str){
        case "sure": 
            msg = "Do you want to perform this operation? ";
            break;
        default:
            msg = str;
            break;
    }
    int res= JOptionPane.showConfirmDialog(null, msg,"Pay attention", JOptionPane.YES_NO_OPTION);
    if(res==0){
    return true;
    }else{
    return false;
    }
    }
}
