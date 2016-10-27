/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controler.controller_mahasiswa;
import com.koneksi.koneksi;
import com.view.form_mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Model_Mahasiswa implements controller_mahasiswa{
        String jk;     
    @Override
    public void Simpan(form_mahasiswa mhs) throws SQLException {
    if(mhs.rblaki.isSelected()){
            jk = "Laki-laki";
        }
        else{
            jk = "Perempuan";
        }
        
        try {
           
            
            Connection con = koneksi.getKoneksi();
            String sql = "insert tbl_mhs values(?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, mhs.txtnim.getText());
            prepare.setString(2, mhs.txtnama.getText());
            prepare.setString(3, jk);
            prepare.setString(4, (String) mhs.cbjurusan.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            mhs.setLebarKolom();
        }   
    }

    @Override
    public void Ubah(form_mahasiswa mhs) throws SQLException {
     if(mhs.rblaki.isSelected()){
            jk = "Laki-laki";
        }
        else{
            jk = "Perempuan";
        }
        
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update tbl_mhs set nama= ?, jenis_kelamin= ?, jurusan= ? where nim= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, mhs.txtnim.getText());
            prepare.setString(1, mhs.txtnama.getText());
            prepare.setString(2, jk);
            prepare.setString(3, (String) mhs.cbjurusan.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            mhs.setLebarKolom();
            Baru(mhs);
        }    
    }

    @Override
    public void Hapus(form_mahasiswa mhs) throws SQLException {
     try {
           
            
            Connection con = koneksi.getKoneksi();
            String sql = "delete from tbl_mhs where NIM= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, mhs.txtnim.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            mhs.setLebarKolom();
            Baru(mhs);
        }    
    }

    @Override
    public void Tampil(form_mahasiswa mhs) throws SQLException {
       mhs.tblmodel.getDataVector().removeAllElements();
      mhs.tblmodel.fireTableDataChanged();
      try {
          Connection con = koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from tbl_mhs order by nim asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              mhs.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Baru(form_mahasiswa mhs) {
        mhs.txtnim.setText("");
        mhs.txtnama.setText("");
        mhs.rblaki.setSelected(true);
        mhs.cbjurusan.setSelectedIndex(0);
    }

    @Override
    public void KlikTabel(form_mahasiswa mhs) throws SQLException {
        mhs.tblmodel.getDataVector().removeAllElements();
      mhs.tblmodel.fireTableDataChanged();
      try {
          Connection con = koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from tbl_mhs order by nim asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              mhs.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }
   
}
