/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import SistemaCTR.CaixaCTR;
import SistemaDAO.ConectaBanco;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Vinicius
 */
public class ContaCorrenteVIEW extends javax.swing.JDialog {

    NumberFormat formata = DecimalFormat.getCurrencyInstance(
            new Locale("pt", "BR"));

    /**
     * Creates new form ContaCorrenteVIEW
     */
    public ContaCorrenteVIEW(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        UtilVIEW.Icone(this);
        setTitle("CONTA CORRENTE");
        this.setLocationRelativeTo(null);
        UtilVIEW.DataAtual(txtData);
        //  UtilVIEW.FormatarCampo(txtIndice);
        this.setLocation(600, 350);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIndice = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Data:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 27, 14);

        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtData);
        txtData.setBounds(100, 30, 70, 20);

        jLabel2.setText("Valor do Indice:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 90, 14);

        txtIndice.setForeground(new java.awt.Color(0, 0, 255));
        txtIndice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIndiceKeyPressed(evt);
            }
        });
        getContentPane().add(txtIndice);
        txtIndice.setBounds(10, 30, 70, 20);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/casa_32x32.png"))); // NOI18N
        jMenu3.setText("Sair");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 196, 139);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        int sair = -1;
        sair = JOptionPane.showConfirmDialog(null, "Deseja sair?", "PERGUNTA",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (sair == 0) {
            if(PrincipalVIEW.relCredores == true){
                PrincipalVIEW.relCredores = false;
            }else if(PrincipalVIEW.relDevedores == true){
                PrincipalVIEW.relDevedores = false;
            }else if(PrincipalVIEW.relExtrato == true){
                PrincipalVIEW.relExtrato = false;
            }else if(PrincipalVIEW.relatorioAnalitico == true){
                PrincipalVIEW.relatorioAnalitico = false;
            }
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void txtIndiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndiceKeyPressed
        try {
            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                txtIndice.setText(formata.format(Double.parseDouble(txtIndice.getText().replace(",", "."))));
                if (txtIndice.getText().equals("R$ 0,00")) {
                    JOptionPane.showMessageDialog(null, "Valor não pode ser zero!", "ATENÇÃO",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int op = -1;
                    op = JOptionPane.showConfirmDialog(null, "Valor está correto?", "PERGUNTA",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (op == 0) {
                        if (PrincipalVIEW.relExtrato == false && PrincipalVIEW.relDevedores == false
                                && PrincipalVIEW.relCredores == false && PrincipalVIEW.relatorioAnalitico == false) {
                            CaixaVIEW.pegaIndice = txtIndice.getText();
                            this.dispose();
                            new CaixaVIEW(null, true).setVisible(true);
                        } else if (PrincipalVIEW.relExtrato == true || PrincipalVIEW.relatorioAnalitico == true) {
                            RelatorioPeriodoVIEW.indiceRelatorio = txtIndice.getText();
                            this.dispose();
                            new RelatorioPeriodoVIEW(null, true).setVisible(true);
                        } else if(PrincipalVIEW.relCredores == true || PrincipalVIEW.relDevedores == true){
                            Imprimir();
                        }

                    } else if (op == 1) {

                    }
                }
                txtData.requestFocusInWindow();
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro", "MENSAGEM", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_txtIndiceKeyPressed

    public void Imprimir() {
        try {
            int op = -1;
            op = JOptionPane.showConfirmDialog(null, "Impressora esta ligada?", "PERGUNTA",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == 0) {
                this.dispose();
                URL arquivo = null;
                if (PrincipalVIEW.relDevedores == true) {
                    arquivo = getClass().getResource("/Relatorios/Devedores.jasper");
                    PrincipalVIEW.relDevedores = false;
                } else if (PrincipalVIEW.relCredores == true) {
                    arquivo = getClass().getResource("/Relatorios/Credores.jasper");
                    PrincipalVIEW.relCredores =  false;
                }

                //JOptionPane.showMessageDialog(this, arquivo.toString());
                if (arquivo == null) {
                    System.out.println("ARQUIVO INEXISTENTE");
                } else {

                    ConectaBanco.ConectaPostgres();
                    JasperPrint rel = null;
                    Map parametros = new HashMap();
                    parametros.put("saldoAtualizado", 
                            Double.parseDouble(txtIndice.getText().
                                    replace("R$", "").replace(",", ".")));
                    JasperReport jr;
                    try {
                        jr = (JasperReport) JRLoader.loadObject(arquivo);
                        rel = JasperFillManager.fillReport(jr, parametros, ConectaBanco.con);
                        JasperViewer.viewReport(rel, false);
                    } catch (JRException ex) {
                        System.out.println("" + ex.getMessage());
                    }

                }
                
            } else if (op == 1) {

            }
        } catch (HeadlessException e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContaCorrenteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContaCorrenteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContaCorrenteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContaCorrenteVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ContaCorrenteVIEW dialog = new ContaCorrenteVIEW(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtIndice;
    // End of variables declaration//GEN-END:variables
}
