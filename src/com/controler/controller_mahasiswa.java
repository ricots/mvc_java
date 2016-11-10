/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controler;
import com.view.form_dosen;
import com.view.form_mahasiswa;   // fungsi ini memanggil Form_Mahasiswa yang di dalam package com.view
import java.sql.SQLException;
/**
 *
 * @author ACER
 */
public interface controller_mahasiswa {
            //Jika kita menggunakan perintah sql
    public void Ubah(form_mahasiswa mhs) throws SQLException;
    public void Hapus(form_mahasiswa mhs) throws SQLException;
    public void Tampil(form_mahasiswa mhs) throws SQLException;
    public void Tampil_dosen(form_dosen dosen) throws SQLException;
    public void Baru(form_mahasiswa mhs);                               // kita melakukan perintah dasar saja
    public void KlikTabel(form_mahasiswa mhs) throws SQLException;
}
