/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Interface;
import Code.DBconnect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author acer
 */
public class loantable extends javax.swing.JInternalFrame {
    String currentDirectory = System.getProperty("user.dir");
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form loantable
     */
    public loantable() {
        initComponents();
        con = DBconnect.connect();
        tableload();
    }
    
    public void print (){
        int id = Integer.parseInt(memidbox.getText());
             if(id>=1 && id<=500){
                  try {
            HashMap m =new HashMap();
            m.put("memid", memidbox.getText());
            
            JasperDesign jdesign = JRXmlLoader.load(currentDirectory + "\\src\\reports\\loan.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, m,con);
            
            //JasperViewer.viewReport(jprint);
           JasperViewer.viewReport(jprint,false);
                //JasperPrintManager.printReport(jprint, false);
        } catch (JRException ex) {
            Logger.getLogger(loantable.class.getName()).log(Level.SEVERE, null, ex);
        }
             }else{
                 JOptionPane.showMessageDialog(null, "The Member ID can only use number 1 to 500.");
             }
       
    }
    
     private void theader(){
        JTableHeader thead = borrowertable.getTableHeader();
        thead.setForeground(Color.BLUE);
        
        thead.setFont(new Font("Tahome", Font.BOLD, 12));
        
        JTableHeader thea = guarantortable.getTableHeader();
        thea.setForeground(Color.BLUE);
        
        thea.setFont(new Font("Tahome", Font.BOLD, 12));
    }
    
     public void tableload(){
        try {
            String sql = "SELECT memberid as Member_ID,loanid as Loan_ID,name as Name,address as Address,phoneno as Phone_No,nic as NIC_No,age as Age,amount as Loan_Amount,installments as Inatallments,mendaamount as Mandatory_Deposit,secamount as Securities_Deposit,date as Date,time as Time FROM loan";
            
            pst =con.prepareStatement(sql);
            rs = pst.executeQuery();
            borrowertable.setModel(DbUtils.resultSetToTableModel(rs));
            borrowertable.setBackground(Color.LIGHT_GRAY);
            borrowertable.setFont(new Font("Times New Roman", Font.BOLD, 13));
            TableColumn col1=borrowertable.getColumnModel().getColumn(0);
            col1.setPreferredWidth(50);
            TableColumn col2=borrowertable.getColumnModel().getColumn(1);
            col2.setPreferredWidth(40);
            TableColumn col3=borrowertable.getColumnModel().getColumn(6);
            col3.setPreferredWidth(20);
            TableColumn col4=borrowertable.getColumnModel().getColumn(4);
            col4.setPreferredWidth(55);
            TableColumn col5=borrowertable.getColumnModel().getColumn(2);
            col5.setPreferredWidth(150);
            TableColumn col6=borrowertable.getColumnModel().getColumn(3);
            col6.setPreferredWidth(150);
            TableColumn col7=borrowertable.getColumnModel().getColumn(11);
            col7.setPreferredWidth(50);
            TableColumn col8=borrowertable.getColumnModel().getColumn(12);
            col8.setPreferredWidth(55);
            TableColumn col9=borrowertable.getColumnModel().getColumn(10);
            col9.setPreferredWidth(55);
            TableColumn col10=borrowertable.getColumnModel().getColumn(9);
            col10.setPreferredWidth(55);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
         try {
            String sql = "SELECT memid As Member_ID,loanid as Loan_ID,fguarantorid as FirstG_ID,lguarantorid as LastG_ID,fguarantorname as FirstG_Name,lguarantorname as LastG_Name,fguarantoradd as FristG_Address,lguarantoradd as LastG_Address,fguarantornic as FristG_NIC_No,lguarantornic as LastG_NIC_No FROM guarantor";
            
            pst =con.prepareStatement(sql);
            rs = pst.executeQuery();
            guarantortable.setModel(DbUtils.resultSetToTableModel(rs));
            guarantortable.setBackground(Color.LIGHT_GRAY);
            guarantortable.setFont(new Font("Times New Roman", Font.BOLD, 13));
           TableColumn col1=guarantortable.getColumnModel().getColumn(0);
            col1.setPreferredWidth(25);
            TableColumn col2=guarantortable.getColumnModel().getColumn(1);
            col2.setPreferredWidth(20);
            TableColumn col3=guarantortable.getColumnModel().getColumn(2);
            col3.setPreferredWidth(20);
            TableColumn col4=guarantortable.getColumnModel().getColumn(3);
            col4.setPreferredWidth(20);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        theader();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        memidbox = new javax.swing.JTextField();
        reportbtn = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        borrowertable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        guarantortable = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1360, 661));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Loan Details");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sanasa2.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Please Enter Member ID"));
        jPanel4.setLayout(null);

        memidbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        memidbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memidboxKeyReleased(evt);
            }
        });
        jPanel4.add(memidbox);
        memidbox.setBounds(20, 30, 190, 30);

        reportbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reportbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportb.png"))); // NOI18N
        reportbtn.setText("Report");
        reportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportbtnActionPerformed(evt);
            }
        });
        jPanel4.add(reportbtn);
        reportbtn.setBounds(340, 30, 100, 30);

        printbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        printbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print.png"))); // NOI18N
        printbtn.setText("Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });
        jPanel4.add(printbtn);
        printbtn.setBounds(450, 30, 90, 30);

        searchbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search_icon.png"))); // NOI18N
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel4.add(searchbtn);
        searchbtn.setBounds(230, 30, 90, 30);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Borrwer details"));
        jPanel5.setLayout(null);

        borrowertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(borrowertable);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 1330, 170);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Guarantor details"));
        jPanel6.setLayout(null);

        guarantortable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(guarantortable);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(12, 20, 1340, 190);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(562, 562, 562))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(384, 384, 384))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void memidboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memidboxKeyReleased
        if(memidbox.getText().isEmpty()){
            tableload();
        }
    }//GEN-LAST:event_memidboxKeyReleased

    private void reportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportbtnActionPerformed
        if(memidbox.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter Member ID");
        }else{
            print ();
        }

    }//GEN-LAST:event_reportbtnActionPerformed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        if(memidbox.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter Member ID");
        }else{
            int id = Integer.parseInt(memidbox.getText());
            if(id>=1 && id<=500){
                try {
                    HashMap m =new HashMap();
                    m.put("memid", memidbox.getText());

                    JasperDesign jdesign = JRXmlLoader.load(currentDirectory + "\\src\\reports\\loan.jrxml");
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, m,con);

                    //JasperViewer.viewReport(jprint,false);
                    JasperPrintManager.printReport(jprint, false);
                } catch (JRException ex) {
                    Logger.getLogger(loantable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "The Member ID can only use number 1 to 500.");
            }

        }
    }//GEN-LAST:event_printbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        if(memidbox.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter Member ID");
            tableload();
        }else{

            String srch = memidbox.getText();
            try {
                String sql = "SElECT * FROM loan WHERE memberid='"+srch+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                borrowertable.setModel(DbUtils.resultSetToTableModel(rs));

                String sq = "SElECT * FROM guarantor WHERE memid='"+srch+"'";
                pst = con.prepareStatement(sq);
                rs = pst.executeQuery();
                guarantortable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_searchbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable borrowertable;
    private javax.swing.JTable guarantortable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField memidbox;
    private javax.swing.JButton printbtn;
    private javax.swing.JButton reportbtn;
    private javax.swing.JButton searchbtn;
    // End of variables declaration//GEN-END:variables
}
