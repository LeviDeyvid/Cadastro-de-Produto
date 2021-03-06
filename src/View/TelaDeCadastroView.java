/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.bean.Produto;
import Model.dao.ProdutoDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author levi1
 */
public class TelaDeCadastroView extends javax.swing.JFrame {

    /**
     * Creates new form TelaDeCadastro
     */
    public TelaDeCadastroView() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        jTProdutos.setRowSorter(new TableRowSorter(modelo));
        
        readTelaDeCadastro();
        
    }
    
    public void readTelaDeCadastro(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDao pdao = new ProdutoDao();
        
        for (Produto p: pdao.read()){
            
            modelo.addRow(new Object[ ] {
                
                    p.getId(),
                    p.getDescricao(),
                    p.getQtd(),
                    p.getPreco(),
        });
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtDesc = new javax.swing.JTextField();
        TxtQuantidade = new javax.swing.JTextField();
        TxtPreco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDescActionPerformed(evt);
            }
        });
        getContentPane().add(TxtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 189, -1));
        getContentPane().add(TxtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 123, -1));
        getContentPane().add(TxtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 123, -1));

        jLabel1.setText("DESCRICAO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 81, -1));

        jLabel2.setText("UNIDADE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel3.setText("PRE??O");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jButton1.setText("CADASTRO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jButton2.setText("EXCLUIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jButton3.setText("ATUALIZAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRICAO", "QUANTIDADE", "PRECO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTProdutosMouseReleased(evt);
            }
        });
        jTProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);
        if (jTProdutos.getColumnModel().getColumnCount() > 0) {
            jTProdutos.getColumnModel().getColumn(0).setResizable(false);
            jTProdutos.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 250, 580, 290));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewImagens/wallpapers-hd-papel de parede (7).jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 570, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Produto p = new Produto();
        ProdutoDao dao = new ProdutoDao();
        
        p.setDescricao(TxtDesc.getText());
        p.setQtd(Integer.parseInt(TxtQuantidade.getText()));
        p.setPreco(Double.parseDouble(TxtPreco.getText()));    
        
        dao.create(p);
        
        TxtDesc.setText("");
        TxtQuantidade.setText("");
        TxtPreco.setText("");
        
        readTelaDeCadastro();
        
        
       // DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
       // Object[] dados = {TxtDesc.getText(),TxtQuantidade.getText(),TxtPreco.getText() };
       // dtmProdutos.addRow(dados);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
      // System.out.println("Linha selecionada: "+jTProdutos.getSelectedRow());
      
        if (jTProdutos.getSelectedRow() != -1) {
            
        Produto p = new Produto();
        ProdutoDao dao = new ProdutoDao();
      
        p.setId((int)jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));
        
        dao.delete(p);
        
        TxtDesc.setText("");
        TxtQuantidade.setText("");
        TxtPreco.setText("");
        
        readTelaDeCadastro();
              
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
        // TODO add your handling code here:
        
        if (jTProdutos.getSelectedRow() != -1) {
            
            TxtDesc.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
            TxtQuantidade.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            TxtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            
        }
        
    }//GEN-LAST:event_jTProdutosMouseClicked

    private void jTProdutosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutosMouseReleased

    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutosKeyReleased
        // TODO add your handling code here:
        
        if (jTProdutos.getSelectedRow() != -1) {
            
            TxtDesc.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
            TxtQuantidade.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            TxtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            
        }
        
    }//GEN-LAST:event_jTProdutosKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if (jTProdutos.getSelectedRow() != -1) {
            
        Produto p = new Produto();
        ProdutoDao dao = new ProdutoDao();
        
        p.setDescricao(TxtDesc.getText());
        p.setQtd(Integer.parseInt(TxtQuantidade.getText()));
        p.setPreco(Double.parseDouble(TxtPreco.getText()));
        p.setId((int)jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));
        dao.update(p);
        
        TxtDesc.setText("");
        TxtQuantidade.setText("");
        TxtPreco.setText("");
        
        readTelaDeCadastro();
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma coluna.");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TxtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDescActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCadastroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtDesc;
    private javax.swing.JTextField TxtPreco;
    private javax.swing.JTextField TxtQuantidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    // End of variables declaration//GEN-END:variables
}
