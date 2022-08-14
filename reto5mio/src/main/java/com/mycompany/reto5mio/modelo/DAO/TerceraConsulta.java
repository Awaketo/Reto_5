/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto5mio.modelo.DAO;

import com.mycompany.reto5mio.modelo.DAO.VO.Compra;
import com.mycompany.reto5mio.modelo.DAO.VO.Conexion;
import com.mycompany.reto5mio.modelo.DAO.VO.Proyecto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanp
 */
public class TerceraConsulta {
     public void terceraconsulta(DefaultTableModel modelo){
        
        Compra compra = new Compra();
        
        
        try{
            Conexion cc=new Conexion();
            Connection cn = cc.conectar();
            
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON (c.ID_Proyecto=p.ID_Proyecto) Where Proveedor = 'Homecenter' AND p.Ciudad='Salento';);");
            
            while(rs.next()){
                compra.setId_compra(rs.getInt(1));
                compra.setConstructora(rs.getString(2));
                compra.setBanco(rs.getString(3));
                
                
              modelo.addRow(new Object[]{compra.getId_compra(),compra.getConstructora(),compra.getBanco()});
            }
            rs.close();
            cn.close();
        }catch (SQLException ex){
            Logger.getLogger(TerceraConsulta.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
}
