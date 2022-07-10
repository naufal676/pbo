import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Parkir extends javax.swing.JFrame {

    /**
     * Creates new form Parkir
     */
    public Parkir() {
        initComponents();
        readable(false);
        No_polis.requestFocusInWindow();
    }

    public void readable(boolean x) {
        Tanggal.setEnabled(x);
        Jam.setEditable(x);
        Biaya.setEditable(x);
    }

    Connection conn;
    Statement stm;
    String url = "jdbc:mysql:// localhost/parkir";
    String user = "root";
    String pass = "";

    private void Tampil_Data() throws SQLException {
        DefaultTableModel tabel = new DefaultTableModel();
        // String s = jenis.getSelectedItem().toString();
        tabel.addColumn("ID");
        tabel.addColumn("NO POL");
        tabel.addColumn("TANGGAL");
        tabel.addColumn("JAM MASUK");
        tabel.addColumn("JAM KELUAR");
        tabel.addColumn("BIAYA");
        tabel.addColumn("JENIS KENDARAAN");
        tampil.setModel(tabel);

        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm.executeQuery("select *from parkiran");

        while (res.next()) {
            // tabel.addRow(new
            // Object[]{kode.getText(),merek.getText(),jenis.getSelectedItem()
            // ,jumlah.getText(),biaya.getText()
            // });
            tabel.addRow(new Object[] { res.getString("id"), res.getString("nopol"), res.getString("tanggal"),
                    res.getString("jam_masuk"), res.getString("jam_keluar"), res.getString("biaya_parkir"),
                    res.getString("tipe")
            });
        }

    }

    private void simpan_data_masuk() throws SQLException {

        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(Tanggal.getDate()));

        conn = (Connection) DriverManager.getConnection(url, user, pass);

        String sql = "insert into parkiran(nopol,tanggal,jam_masuk,tipe) values ('" + No_polis.getText() + "','"
                + tanggal + "','" + Jam.getText() + "','" + j_kendaraan.getSelectedItem() + "')";
        PreparedStatement pr = conn.prepareStatement(sql);

        if (pr.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Simpan Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            Tampil_Data();
        } else {
            JOptionPane.showMessageDialog(this, "Simpan Gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pr.close();
        }

    }

    private void simpan_data_keluar() throws SQLException {

        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(Tanggal.getDate()));

        conn = (Connection) DriverManager.getConnection(url, user, pass);

        String sql = "update parkiran set jam_keluar = '" + Jam.getText() + "' ,biaya_parkir = '" + Biaya.getText()
                + "' where nopol = '" + No_polis.getText() + "'";
        PreparedStatement pr = conn.prepareStatement(sql);

        if (pr.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Simpan Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            Tampil_Data();
        } else {
            JOptionPane.showMessageDialog(this, "Simpan Gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pr.close();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Jam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Tanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Biaya = new javax.swing.JTextField();
        No_polis = new javax.swing.JTextField();
        j_kendaraan = new javax.swing.JComboBox<>();
        Masuk = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        Cetak = new javax.swing.JButton();
        Total_Bayar = new javax.swing.JLabel();
        jtable = new javax.swing.JScrollPane();
        tampil = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("SISTEM PARKIR XYZ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap()));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("TANGGAL : ");

        jLabel3.setText("JAM :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(Jam, javax.swing.GroupLayout.PREFERRED_SIZE, 244,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(Jam, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3)))
                                .addContainerGap(29, Short.MAX_VALUE)));

        jLabel4.setText("JENIS KENDARAAN");

        jLabel5.setText("NO POLISI");

        jLabel6.setText("BIAYA :");

        jLabel7.setText("RP");

        Biaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiayaActionPerformed(evt);
            }
        });

        j_kendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motor", "Mobil", "Truk" }));
        j_kendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_kendaraanActionPerformed(evt);
            }
        });

        Masuk.setText("JAM MASUK");
        Masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasukActionPerformed(evt);
            }
        });

        keluar.setText("JAM KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        Cetak.setText("CETAK TIKET");
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(Masuk)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(keluar)
                                                                .addGap(73, 73, 73)
                                                                .addComponent(delete))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(No_polis,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                230, Short.MAX_VALUE)
                                                                        .addComponent(j_kendaraan, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(34, 34, 34)
                                                                .addComponent(Cetak))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel6))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(Biaya,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                230, Short.MAX_VALUE)
                                                                        .addComponent(Total_Bayar,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel5)
                                        .addContainerGap(646, Short.MAX_VALUE))));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(Biaya, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(No_polis, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7)
                                        .addComponent(j_kendaraan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Total_Bayar))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(139, 139, 139)
                                        .addComponent(jLabel5)
                                        .addContainerGap(140, Short.MAX_VALUE))));

        tampil.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "ID", "NO POL", "TANGGAL", "JAM MASUK", "JAM KELUAR", "BIAYA", "JENIS KENDARAAN"
                }));
        jtable.setViewportView(tampil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtable));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(36, 36, 36)
                                .addComponent(jtable, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>

    private void j_kendaraanActionPerformed(java.awt.event.ActionEvent evt) {
        if (j_kendaraan.getSelectedItem() == "Motor") {
            Biaya.setText("2000");
        } else if (j_kendaraan.getSelectedItem() == "Mobil") {
            Biaya.setText("4000");
        } else if (j_kendaraan.getSelectedItem() == "Truk") {
            Biaya.setText("5000");
        }
    }

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            // Waktu
            Date d = new Date();
            SimpleDateFormat w = new SimpleDateFormat("hh:mm:ss");
            String waktu = w.format(d);

            Jam.setText(waktu);
            simpan_data_keluar();
        } catch (SQLException ex) {
            Logger.getLogger(Parkir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MasukActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

            // Waktu
            Date d = new Date();
            SimpleDateFormat w = new SimpleDateFormat("hh:mm:ss");
            String waktu = w.format(d);
            Biaya.setText("2000");
            Tanggal.setDate(date);
            Jam.setText(waktu);
            simpan_data_masuk();
        } catch (SQLException ex) {
            Logger.getLogger(Parkir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void simpan_data_edit() throws SQLException {

        conn = (Connection) DriverManager.getConnection(url, user, pass);

        String sql = "update parkiran set nopol = '" + No_polis.getText() + "', tipe = '"
                + j_kendaraan.getSelectedItem() + "' where id in (select nopol from parkiran)";

        PreparedStatement pr = conn.prepareStatement(sql);

        if (pr.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Update Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            Tampil_Data();
        } else {
            JOptionPane.showMessageDialog(this, "Update Gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pr.close();
        }

    }

    private void simpan_data_delete() throws SQLException {

        conn = (Connection) DriverManager.getConnection(url, user, pass);

        String sql = "delete from parkiran where nopol = '" + No_polis.getText() + "'";

        PreparedStatement pr = conn.prepareStatement(sql);

        if (pr.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Update Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            Tampil_Data();
        } else {
            JOptionPane.showMessageDialog(this, "Update Gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pr.close();
        }

    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            simpan_data_delete();
        } catch (SQLException ex) {
            Logger.getLogger(Parkir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql:// localhost/parkir", "root", "");
            String reportPath = "C:\\Users\\EnVyx\\OneDrive\\Documents\\NetBeansProjects\\Sistem_Parkir_Xyz\\src\\reportDataTerakhir.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void BiayaActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            ResultSet res = stm.executeQuery("select *from parkiran");
            String jam_masuk = res.getString("jam_masuk");
            String jam_keluar = res.getString("jam_keluar");
            SimpleDateFormat format = new SimpleDateFormat("H");
            Date date1 = format.parse(jam_masuk);
            Date date2 = format.parse(jam_keluar);
            long difference = date2.getTime() - date1.getTime();

            int convert_total_waktu = (int) difference;
            int hasil = convert_total_waktu * Integer.parseInt(Biaya.getText());
            Total_Bayar.setText(String.valueOf(hasil));

        } catch (SQLException ex) {
            Logger.getLogger(Parkir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Parkir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parkir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField Biaya;
    private javax.swing.JButton Cetak;
    private javax.swing.JTextField Jam;
    private javax.swing.JButton Masuk;
    private javax.swing.JTextField No_polis;
    private com.toedter.calendar.JDateChooser Tanggal;
    private javax.swing.JLabel Total_Bayar;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> j_kendaraan;
    private javax.swing.JScrollPane jtable;
    private javax.swing.JButton keluar;
    private javax.swing.JTable tampil;
    // End of variables declaration
}
