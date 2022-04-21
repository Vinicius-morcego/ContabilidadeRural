/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import SistemaCTR.FisicoCTR;
import SistemaCTR.PessoaCTR;
import SistemaCTR.ProfissaoCTR;
import SistemaCTR.TipoTelefoneCTR;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicius
 */
public class ClientesVIEW extends javax.swing.JDialog {

    ResultSet navegar = null, cpf = null;
    char[] pegaSenha;
    String senha, grupo, titulo;
    ValidarCpf objvalidar = new ValidarCpf();
    PessoaCTR objpessoaCTR = new PessoaCTR();

    /**
     * Creates new form FuncionarioVIEW
     *
     * @param parent
     * @param modal
     */
    public ClientesVIEW(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("CADASTRO DE CLIENTES");
        this.setLocationRelativeTo(null);
        txtNome.setDocument(new FixedLenghtDocument(38));
        txtEndereco.setDocument(new FixedLenghtDocument(30));
        txtCidade.setDocument(new FixedLenghtDocument(16));
        txtObservacoes.setDocument(new FixedLenghtDocument(42));
        rbNovo.setSelected(true);
        UtilVIEW.mascaraCpf(txtCPF);
        UtilVIEW.mascaraCnpj(txtCNPJ);
        // UtilVIEW.mascaraTelefone(txtTel1, txtTel2);
        UtilVIEW.mascaraData(txtNascimento);
        rbSituacao.setSelected(true);
//        UtilVIEW.DesabilitarCampos(jPanel1);
//        UtilVIEW.DesabilitarMenus(btnSalvar, btnImprimir, btnPrimeiro, btnAnterior,
//                btnProximo, btnUltimo);
        UtilVIEW.DataAtual(txtData);
        UtilVIEW.Icone(this);

        UtilVIEW.MudarCursor(btnSalvar, btnImprimir, btnSair);
        tblCliente.setDefaultRenderer(Object.class, new ColorRenderer());
        ConsultarCliente();
        ConfiguraTabela();

    }

    private void ConfiguraTabela() {
        try {
            tblCliente.getColumnModel().getColumn(0).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(1).setMinWidth(200);
            tblCliente.getColumnModel().getColumn(2).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(3).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(4).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(5).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(6).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(7).setMinWidth(200);
            tblCliente.getColumnModel().getColumn(8).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(9).setMinWidth(200);
            tblCliente.getColumnModel().getColumn(10).setMinWidth(200);
            tblCliente.getColumnModel().getColumn(11).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(12).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(13).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(14).setMinWidth(200);
            tblCliente.getColumnModel().getColumn(15).setMinWidth(200);
            tblCliente.getColumnModel().getColumn(16).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(17).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(18).setMinWidth(100);
            tblCliente.getColumnModel().getColumn(19).setMinWidth(200);
            tblCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        } catch (Exception e) {
            System.out.println("Erro ao ConfigurarTabela " + e.getMessage());
        }
    }

    public void Primeiro() {
        try {

            navegar = objpessoaCTR.ConsultarClienteCTR("0", "");
            navegar.first();
            txtCodigo.setText(navegar.getString("codigo"));

        } catch (SQLException | NullPointerException e) {
            System.out.println("Primeiro");
        }
    }

    public void Anterior() {
        try {
            navegar.previous();
            txtCodigo.setText(navegar.getString("codigo"));
        } catch (SQLException | NullPointerException e) {
            System.out.println("Anterior");
        }
    }

    public void Proximo() {
        try {
            navegar.next();
            txtCodigo.setText(navegar.getString("codigo"));
        } catch (SQLException | NullPointerException e) {
            System.out.println("Próximo");
        }
    }

    public void Ultimo() {
        try {

            navegar = navegar = objpessoaCTR.ConsultarClienteCTR("0", "");
            navegar.last();
            txtCodigo.setText(navegar.getString("codigo"));
        } catch (SQLException | NullPointerException e) {
            System.out.println("Ultimo");
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

        btnOperacao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblFoto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        lblPesqFoto = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblProfissao = new javax.swing.JLabel();
        cbxFuncao = new javax.swing.JComboBox();
        lblFuncao = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMae = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTel1 = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        cbxTipo1 = new javax.swing.JComboBox();
        lblTipo1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTel2 = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        cbxTipo2 = new javax.swing.JComboBox();
        lblTipo2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblPesqEnd = new javax.swing.JLabel();
        lblCadEnd = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblPesqBairro = new javax.swing.JLabel();
        lblCadBairro = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblPesqCidade = new javax.swing.JLabel();
        lblCadCidade = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtObservacoes = new javax.swing.JTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        rbAtualizar = new javax.swing.JRadioButton();
        rbNovo = new javax.swing.JRadioButton();
        rbSituacao = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnSalvar = new javax.swing.JMenu();
        btnImprimir = new javax.swing.JMenu();
        btnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("Código:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(4, 0, 60, 14);

        txtCodigo.setForeground(new java.awt.Color(255, 0, 0));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(4, 20, 54, 20);

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(69, 0, 90, 14);

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        jPanel1.add(txtNome);
        txtNome.setBounds(69, 20, 246, 20);

        jLabel3.setText("Data:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(327, 0, 50, 14);

        txtData.setEditable(false);
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtData);
        txtData.setBounds(327, 20, 86, 20);
        jPanel1.add(lblFoto);
        lblFoto.setBounds(830, 5, 120, 100);

        jLabel6.setText("Data de nascimento:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(420, 0, 110, 14);

        txtNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNascimentoKeyPressed(evt);
            }
        });
        jPanel1.add(txtNascimento);
        txtNascimento.setBounds(420, 20, 100, 20);

        jLabel7.setText("Idade:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(530, 0, 70, 14);

        lblPesqFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/lupa_16x16.png"))); // NOI18N
        lblPesqFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesqFotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPesqFotoMouseEntered(evt);
            }
        });
        jPanel1.add(lblPesqFoto);
        lblPesqFoto.setBounds(955, 85, 20, 20);

        lblIdade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIdade.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblIdade);
        lblIdade.setBounds(530, 20, 160, 20);

        jLabel10.setText("RG:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(700, 0, 50, 14);

        txtRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRGKeyPressed(evt);
            }
        });
        jPanel1.add(txtRG);
        txtRG.setBounds(700, 20, 124, 20);

        jLabel11.setText("CPF:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(4, 45, 23, 14);

        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCPFKeyPressed(evt);
            }
        });
        jPanel1.add(txtCPF);
        txtCPF.setBounds(4, 65, 90, 20);

        lblProfissao.setText("Profissão:");
        jPanel1.add(lblProfissao);
        lblProfissao.setBounds(104, 45, 60, 14);

        cbxFuncao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxFuncaoFocusGained(evt);
            }
        });
        cbxFuncao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxFuncaoKeyPressed(evt);
            }
        });
        jPanel1.add(cbxFuncao);
        cbxFuncao.setBounds(104, 65, 176, 20);

        lblFuncao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_16x16.png"))); // NOI18N
        lblFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFuncaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFuncaoMouseEntered(evt);
            }
        });
        jPanel1.add(lblFuncao);
        lblFuncao.setBounds(285, 64, 20, 20);

        jLabel14.setText("Pai:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(310, 45, 18, 14);

        txtPai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaiKeyPressed(evt);
            }
        });
        jPanel1.add(txtPai);
        txtPai.setBounds(310, 65, 220, 20);

        jLabel15.setText("Mãe:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(540, 45, 100, 14);

        txtMae.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaeKeyPressed(evt);
            }
        });
        jPanel1.add(txtMae);
        txtMae.setBounds(540, 65, 285, 20);

        jLabel16.setText("Telefone 1:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(4, 90, 70, 14);

        txtTel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTel1KeyPressed(evt);
            }
        });
        jPanel1.add(txtTel1);
        txtTel1.setBounds(4, 110, 90, 20);

        jLabel17.setText("Tipo:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(104, 90, 70, 14);

        cbxTipo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxTipo1FocusGained(evt);
            }
        });
        cbxTipo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipo1KeyPressed(evt);
            }
        });
        jPanel1.add(cbxTipo1);
        cbxTipo1.setBounds(104, 110, 100, 20);

        lblTipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_16x16.png"))); // NOI18N
        lblTipo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTipo1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTipo1MouseEntered(evt);
            }
        });
        jPanel1.add(lblTipo1);
        lblTipo1.setBounds(210, 110, 20, 20);

        jLabel19.setText("Telefone 2:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(235, 90, 90, 14);

        txtTel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTel2KeyPressed(evt);
            }
        });
        jPanel1.add(txtTel2);
        txtTel2.setBounds(235, 110, 90, 20);

        jLabel20.setText("Tipo:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(335, 90, 80, 14);

        cbxTipo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxTipo2FocusGained(evt);
            }
        });
        cbxTipo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipo2KeyPressed(evt);
            }
        });
        jPanel1.add(cbxTipo2);
        cbxTipo2.setBounds(335, 110, 100, 20);

        lblTipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_16x16.png"))); // NOI18N
        lblTipo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTipo2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTipo2MouseEntered(evt);
            }
        });
        jPanel1.add(lblTipo2);
        lblTipo2.setBounds(440, 110, 20, 20);

        jLabel22.setText("CGC / CNPJ:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(460, 90, 130, 14);

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(620, 110, 150, 20);

        jLabel23.setText("Email / Facebook:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(620, 90, 100, 14);

        jLabel24.setText("Situação:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(1240, 140, 80, 14);

        jLabel25.setText("Endereço:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(0, 140, 60, 14);

        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyPressed(evt);
            }
        });
        jPanel1.add(txtEndereco);
        txtEndereco.setBounds(4, 160, 217, 20);

        lblPesqEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/lupa_16x16.png"))); // NOI18N
        lblPesqEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesqEndMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPesqEndMouseEntered(evt);
            }
        });
        jPanel1.add(lblPesqEnd);
        lblPesqEnd.setBounds(224, 160, 20, 20);

        lblCadEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_16x16.png"))); // NOI18N
        lblCadEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadEndMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadEndMouseEntered(evt);
            }
        });
        jPanel1.add(lblCadEnd);
        lblCadEnd.setBounds(244, 160, 20, 20);

        jLabel28.setText("Número:");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(270, 140, 80, 14);

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });
        jPanel1.add(txtNumero);
        txtNumero.setBounds(270, 160, 90, 20);

        jLabel29.setText("Bairro:");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(370, 140, 80, 14);

        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBairroKeyPressed(evt);
            }
        });
        jPanel1.add(txtBairro);
        txtBairro.setBounds(370, 160, 184, 20);

        lblPesqBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/lupa_16x16.png"))); // NOI18N
        lblPesqBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesqBairroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPesqBairroMouseEntered(evt);
            }
        });
        jPanel1.add(lblPesqBairro);
        lblPesqBairro.setBounds(550, 160, 20, 20);

        lblCadBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_16x16.png"))); // NOI18N
        lblCadBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadBairroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadBairroMouseEntered(evt);
            }
        });
        jPanel1.add(lblCadBairro);
        lblCadBairro.setBounds(570, 160, 20, 20);

        jLabel32.setText("Cidade:");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(600, 140, 100, 14);

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCidadeKeyPressed(evt);
            }
        });
        jPanel1.add(txtCidade);
        txtCidade.setBounds(600, 160, 217, 20);

        lblPesqCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/lupa_16x16.png"))); // NOI18N
        lblPesqCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesqCidadeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPesqCidadeMouseEntered(evt);
            }
        });
        jPanel1.add(lblPesqCidade);
        lblPesqCidade.setBounds(820, 160, 20, 20);

        lblCadCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_16x16.png"))); // NOI18N
        lblCadCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadCidadeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadCidadeMouseEntered(evt);
            }
        });
        jPanel1.add(lblCadCidade);
        lblCadCidade.setBounds(840, 160, 20, 20);

        jLabel35.setText("Estado:");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(860, 140, 60, 14);

        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstadoKeyPressed(evt);
            }
        });
        jPanel1.add(txtEstado);
        txtEstado.setBounds(860, 160, 34, 20);

        jLabel4.setText("Sexo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(780, 90, 28, 14);

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbxSexo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxSexoFocusGained(evt);
            }
        });
        cbxSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxSexoKeyPressed(evt);
            }
        });
        jPanel1.add(cbxSexo);
        cbxSexo.setBounds(780, 110, 100, 20);

        jLabel5.setText("Observações:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(4, 190, 80, 14);
        jPanel1.add(txtObservacoes);
        txtObservacoes.setBounds(4, 210, 900, 20);

        txtCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCNPJKeyPressed(evt);
            }
        });
        jPanel1.add(txtCNPJ);
        txtCNPJ.setBounds(460, 110, 150, 20);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operação"));
        jPanel2.setLayout(null);

        btnOperacao.add(rbAtualizar);
        rbAtualizar.setText("Atualizar");
        jPanel2.add(rbAtualizar);
        rbAtualizar.setBounds(4, 36, 70, 23);

        btnOperacao.add(rbNovo);
        rbNovo.setText("Novo");
        rbNovo.setOpaque(false);
        rbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNovoActionPerformed(evt);
            }
        });
        jPanel2.add(rbNovo);
        rbNovo.setBounds(4, 16, 60, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(900, 110, 80, 70);

        rbSituacao.setText("Ativo");
        jPanel1.add(rbSituacao);
        rbSituacao.setBounds(920, 210, 60, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(4, 0, 990, 240);

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Telefone 1", "Telefone 2", "CPF", "RG", "CGC/CNPJ", "Endereço", "Numero", "Bairro", "Cidade", "Estado", "Nascimento", "Data/Hora Cadastro", "Pai", "Mãe", "Profissão", "Email/Facebook", "Sexo", "Observações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        tblCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 970, 320);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/disquete_32x32.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnSalvar);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Imprimir_32x32.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnImprimir);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/casa_32x32.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnSair);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 1007, 644);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        int op = -1;
        op = JOptionPane.showConfirmDialog(null, "Deseja sair?", "PERGUNTA",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == 0) {

            dispose();

        } else if (op == 1) {

        }

    }//GEN-LAST:event_btnSairMouseClicked

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (txtCodigo.getText().equals("")) {

            } else {
                RestaurarClienteVIEW(txtCodigo.getText());
                rbNovo.setSelected(false);
                rbAtualizar.setSelected(true);
            }

            txtNome.requestFocusInWindow();
        } else if (evt.getKeyCode() == 40) {
            tblCliente.changeSelection(0, 0, false, false);
            tblCliente.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtNascimento.requestFocusInWindow();
        } else if (evt.getKeyCode() == 40) {
            tblCliente.changeSelection(0, 0, false, false);
            tblCliente.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtNascimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNascimentoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (txtNascimento.getText().equals("  /  /    ")) {
                txtRG.requestFocusInWindow();
            } else if (txtNascimento.getText().equals("11/11/1111")
                    || UtilVIEW.VerificaData(txtNascimento.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Data Inválida!", "ATENÇÃO",
                        JOptionPane.ERROR_MESSAGE);
                txtNascimento.requestFocusInWindow();
            } else {
                DateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    UtilVIEW.CalcularIdade(lblIdade, formata.parse(txtNascimento.getText()));
                } catch (ParseException ex) {
                    System.out.println("AQUI " + ex.getMessage());
                }
                txtRG.requestFocusInWindow();
            }

        }
    }//GEN-LAST:event_txtNascimentoKeyPressed

    private void txtRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRGKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtCPF.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtRGKeyPressed

    private void txtCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (objvalidar.validarCPF(txtCPF.getText()) == true) {

                cbxFuncao.requestFocusInWindow();
            } else {
                JOptionPane.showMessageDialog(null, "CPF Inválido!", "ATENÇÃO",
                        JOptionPane.ERROR_MESSAGE);
                cbxFuncao.requestFocusInWindow();

            }

        }
    }//GEN-LAST:event_txtCPFKeyPressed

    private void cbxFuncaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxFuncaoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtPai.requestFocusInWindow();
        }
    }//GEN-LAST:event_cbxFuncaoKeyPressed

    private void txtPaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaiKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtMae.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtPaiKeyPressed

    private void txtMaeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaeKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtTel1.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtMaeKeyPressed

    private void txtTel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTel1KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cbxTipo1.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtTel1KeyPressed

    private void cbxTipo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipo1KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtTel2.requestFocusInWindow();
        }
    }//GEN-LAST:event_cbxTipo1KeyPressed

    private void txtTel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTel2KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cbxTipo2.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtTel2KeyPressed

    private void cbxTipo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipo2KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtCNPJ.requestFocusInWindow();
        }
    }//GEN-LAST:event_cbxTipo2KeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cbxSexo.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void lblPesqEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqEndMouseClicked
        PrincipalVIEW.cliente = false;
        PrincipalVIEW.endereco = true;
        new PesquisaVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblPesqEndMouseClicked

    private void lblCadEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadEndMouseClicked
        PrincipalVIEW.cliente = false;
        PrincipalVIEW.endereco = true;
        new BairroVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblCadEndMouseClicked

    private void lblPesqBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqBairroMouseClicked
        PrincipalVIEW.cliente = false;
        PrincipalVIEW.bairro = true;
        new PesquisaVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblPesqBairroMouseClicked

    private void lblCadBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadBairroMouseClicked
        PrincipalVIEW.bairro = true;
        new BairroVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblCadBairroMouseClicked

    private void lblPesqCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqCidadeMouseClicked
        PrincipalVIEW.cliente = false;
        PrincipalVIEW.cidade = true;
        new PesquisaVIEW(null, true).setVisible(true);

    }//GEN-LAST:event_lblPesqCidadeMouseClicked

    private void lblCadCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadCidadeMouseClicked
        PrincipalVIEW.cidade = true;
        new BairroVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblCadCidadeMouseClicked

    private void cbxFuncaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxFuncaoFocusGained
        try {
            ProfissaoCTR objprofissaoCTR = new ProfissaoCTR();
            ResultSet profissao = null;
            profissao = objprofissaoCTR.ConsultarProfissaoCTR("0", "");
            UtilVIEW.PreencheCombo(profissao, cbxFuncao, 2);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxFuncaoFocusGained

    private void lblPesqFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqFotoMouseClicked
        UtilVIEW.Imagem(lblFoto);

    }//GEN-LAST:event_lblPesqFotoMouseClicked

    private void cbxTipo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxTipo1FocusGained
        try {
            TipoTelefoneCTR objtipoCTR = new TipoTelefoneCTR();
            ResultSet tipo2 = null;
            tipo2 = objtipoCTR.ConsultarTipoTelefoneCTR("", "0");
            UtilVIEW.PreencheCombo(tipo2, cbxTipo1, 1);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxTipo1FocusGained

    private void cbxTipo2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxTipo2FocusGained
        try {
            TipoTelefoneCTR objtipoCTR = new TipoTelefoneCTR();
            ResultSet tipo2 = null;
            tipo2 = objtipoCTR.ConsultarTipoTelefoneCTR("", "0");
            UtilVIEW.PreencheCombo(tipo2, cbxTipo2, 1);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxTipo2FocusGained

    private void cbxSexoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxSexoFocusGained
        cbxSexo.removeAllItems();
        cbxSexo.addItem("FEMININO");
        cbxSexo.addItem("MASCULINO");

    }//GEN-LAST:event_cbxSexoFocusGained

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        try {
            if (txtNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencher o campo nome!", "ATENÇÃO",
                        JOptionPane.WARNING_MESSAGE);
                txtNome.requestFocusInWindow();
            } else if (txtCPF.getText().equals("   .   .   -  ")) {
                JOptionPane.showMessageDialog(null, "Preencher o campo cpf!", "ATENÇÃO",
                        JOptionPane.WARNING_MESSAGE);
                txtCPF.requestFocusInWindow();
            } else {

                if (rbNovo.isSelected() == true) {
                    CadastrarClienteVIEW();
                } else if (rbAtualizar.isSelected() == true) {
                    AlterarClienteVIEW();
                }

                UtilVIEW.LimparCampos(jPanel1);
                UtilVIEW.DataAtual(txtData);
                lblIdade.setText("");
                UtilVIEW.ImagemLabel("/SolucaoSistemas/src/Imagem/semFoto.jpg", lblFoto);
                txtCodigo.requestFocusInWindow();
                rbNovo.setSelected(true);
                rbAtualizar.setSelected(true);
                ConsultarCliente();
            }

        } catch (HeadlessException e) {
            System.out.println("" + e.getMessage());
        }

    }//GEN-LAST:event_btnSalvarMouseClicked
    public static boolean profissao = false;
    private void lblFuncaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFuncaoMouseClicked
        profissao = true;
        new BairroVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblFuncaoMouseClicked
    public static boolean tipotel = false;
    private void lblTipo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipo1MouseClicked
        tipotel = true;
        new BairroVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblTipo1MouseClicked

    private void lblTipo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipo2MouseClicked
        tipotel = true;
        new BairroVIEW(null, true).setVisible(true);
    }//GEN-LAST:event_lblTipo2MouseClicked

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked
        if (txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pesquisar o cliente!", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            PrincipalVIEW.cliente = false;
            this.dispose();
            UtilVIEW objutilVIEW = new UtilVIEW();
            objutilVIEW.ImprimirClienteIndividual(txtCodigo.getText(), lblIdade.getText());
        }

    }//GEN-LAST:event_btnImprimirMouseClicked

    private void lblFuncaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFuncaoMouseEntered
        lblFuncao.setToolTipText("Cadastrar profissão");
    }//GEN-LAST:event_lblFuncaoMouseEntered

    private void lblTipo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipo1MouseEntered
        lblTipo1.setToolTipText("Cadastrar tipo telefone");
    }//GEN-LAST:event_lblTipo1MouseEntered

    private void lblTipo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipo2MouseEntered
        lblTipo2.setToolTipText("Cadastrar tipo telefone");
    }//GEN-LAST:event_lblTipo2MouseEntered

    private void lblPesqEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqEndMouseEntered
        lblPesqEnd.setToolTipText("Pesquisar endereço");
    }//GEN-LAST:event_lblPesqEndMouseEntered

    private void lblCadEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadEndMouseEntered
        lblCadEnd.setToolTipText("Cadastrar endereço");
    }//GEN-LAST:event_lblCadEndMouseEntered

    private void lblPesqBairroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqBairroMouseEntered
        lblPesqBairro.setToolTipText("Pesquisar bairro");
    }//GEN-LAST:event_lblPesqBairroMouseEntered

    private void lblCadBairroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadBairroMouseEntered
        lblCadBairro.setToolTipText("Cadastrar bairro");
    }//GEN-LAST:event_lblCadBairroMouseEntered

    private void lblPesqCidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqCidadeMouseEntered
        lblPesqCidade.setToolTipText("Pesquisar cidade");
    }//GEN-LAST:event_lblPesqCidadeMouseEntered

    private void lblCadCidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadCidadeMouseEntered
        lblCadCidade.setToolTipText("Cadastrar cidade");
    }//GEN-LAST:event_lblCadCidadeMouseEntered

    private void lblPesqFotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesqFotoMouseEntered
        lblPesqFoto.setToolTipText("Procurar foto");
    }//GEN-LAST:event_lblPesqFotoMouseEntered

    private void txtCNPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNPJKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtEmail.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtCNPJKeyPressed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        txtCodigo.setText(txtCodigo.getText().toUpperCase());
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void cbxSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSexoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtEndereco.requestFocusInWindow();
        }
    }//GEN-LAST:event_cbxSexoKeyPressed

    private void txtEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtNumero.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtEnderecoKeyPressed

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtBairro.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtCidade.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtBairroKeyPressed

    private void txtCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtEstado.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtCidadeKeyPressed

    private void txtEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtObservacoes.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtEstadoKeyPressed

    private void rbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNovoActionPerformed
        UtilVIEW.LimparCampos(jPanel1);
        UtilVIEW.DataAtual(txtData);
        lblIdade.setText("");
        UtilVIEW.HabilitarCampos(jPanel1);
        UtilVIEW.HabilitarMenus(btnSalvar, btnImprimir);
        UtilVIEW.ImagemLabel("/SolucaoSistemas/src/Imagem/semFoto.jpg", lblFoto);
        txtCodigo.requestFocusInWindow();
    }//GEN-LAST:event_rbNovoActionPerformed

    private void tblClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClienteKeyReleased
        rbAtualizar.setSelected(true);
        rbNovo.setSelected(false);
        RestaurarClienteVIEW(String.valueOf(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0)));
    }//GEN-LAST:event_tblClienteKeyReleased

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        try {
            rbAtualizar.setSelected(true);
            rbNovo.setSelected(false);
            RestaurarClienteVIEW(String.valueOf(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0)));
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecionar um cliente!", "MENSAGEM", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tblClienteMouseClicked

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        ConsultarCliente();
    }//GEN-LAST:event_txtNomeKeyReleased

    public void CadastrarClienteVIEW() {
        try {

            PessoaCTR objpessoaCTR = new PessoaCTR();
            FisicoCTR objfisicoCTR = new FisicoCTR();
            DateFormat formata = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.S");

            if (objpessoaCTR.CadastrarPessoaCTR(txtCodigo.getText().toUpperCase(),
                    txtCidade.getText().toUpperCase(), txtEstado.getText().toUpperCase(),
                    txtEndereco.getText().toUpperCase(), txtNumero.getText().toUpperCase(),
                    txtBairro.getText().toUpperCase(), txtTel1.getText(),
                    txtTel2.getText(), (String) cbxTipo1.getSelectedItem(),
                    (String) cbxTipo2.getSelectedItem(), txtEmail.getText().toLowerCase(),
                    lblFoto.getText(), txtObservacoes.getText().toUpperCase(),
                    "CLIENTE",
                    formata.format(new Date(System.currentTimeMillis())),
                    "ATIVO", txtCNPJ.getText())) {
                if (objfisicoCTR.CadastrarFisicoCTR(txtNome.getText().toUpperCase(),
                        txtCPF.getText(), txtRG.getText().toUpperCase(),
                        txtNascimento.getText(), lblIdade.getText(),
                        (String) cbxFuncao.getSelectedItem(), "",
                        (String) cbxSexo.getSelectedItem(), txtPai.getText().toUpperCase(),
                        txtMae.getText().toUpperCase(), txtCodigo.getText().toUpperCase())) {

                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "MENSAGEM",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AlterarClienteVIEW() {
        try {

            FisicoCTR objfisicoCTR = new FisicoCTR();

            String situacao = "";
            if (rbSituacao.isSelected() == true) {
                situacao = "ATIVO";
            } else if (rbSituacao.isSelected() == false) {
                situacao = "INATIVO";
            }

            if (objpessoaCTR.AlterarPessoaCTR(txtCidade.getText().toUpperCase(),
                    txtEstado.getText().toUpperCase(),
                    txtEndereco.getText().toUpperCase(), txtNumero.getText().toUpperCase(),
                    txtBairro.getText().toUpperCase(), txtTel1.getText(),
                    txtTel2.getText(), (String) cbxTipo1.getSelectedItem(),
                    (String) cbxTipo2.getSelectedItem(), txtEmail.getText().toLowerCase(),
                    lblFoto.getText(), txtObservacoes.getText().toUpperCase(),
                    situacao, txtCNPJ.getText(), txtCodigo.getText())) {
                if (objfisicoCTR.AlterarFisicoCTR(txtNome.getText().toUpperCase(),
                        txtCPF.getText(), txtRG.getText().toUpperCase(),
                        txtNascimento.getText(), lblIdade.getText(),
                        (String) cbxFuncao.getSelectedItem(), "",
                        (String) cbxSexo.getSelectedItem(), txtPai.getText().toUpperCase(),
                        txtMae.getText().toUpperCase(), txtCodigo.getText())) {

                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso!", "MENSAGEM",
                            JOptionPane.INFORMATION_MESSAGE);

                }

            }

        } catch (HeadlessException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("" + e.getMessage());
        }
    }

    public void RestaurarClienteVIEW(String parametro) {
        try {

            ResultSet funcionario = null;

            DateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            funcionario = objpessoaCTR.ConsultarClienteCTR(parametro,
                    "null");
            if (funcionario.next()) {
                txtCodigo.setText("");
                txtCodigo.setText(parametro);
                txtNome.setText(funcionario.getString("nome"));
                txtNascimento.setText(funcionario.getString("datanascimento"));
                if (funcionario.getString("datanascimento").equals("  /  /    ")) {

                } else {
                    UtilVIEW.CalcularIdade(lblIdade,
                            formata.parse(funcionario.getString("datanascimento")));
                }

                txtRG.setText(funcionario.getString("rg"));
                txtCPF.setText(funcionario.getString("cpf"));
                cbxFuncao.removeAllItems();
                cbxFuncao.addItem(funcionario.getString("profissao"));
                txtPai.setText(funcionario.getString("pai"));
                txtMae.setText(funcionario.getString("mae"));
                txtTel1.setText(funcionario.getString("telefone1"));
                cbxTipo1.removeAllItems();
                cbxTipo1.addItem(funcionario.getString("tipotel1"));
                txtTel2.setText(funcionario.getString("telefone2"));
                cbxTipo2.removeAllItems();
                cbxTipo2.addItem(funcionario.getString("tipotel2"));
                txtEmail.setText(funcionario.getString("email_face"));
                cbxSexo.removeAllItems();
                cbxSexo.addItem(funcionario.getString("sexo"));
                txtEndereco.setText(funcionario.getString("endereco"));
                txtNumero.setText(funcionario.getString("numero"));
                txtBairro.setText(funcionario.getString("bairro"));
                txtCidade.setText(funcionario.getString("cidade"));
                txtEstado.setText(funcionario.getString("estado"));
                if (funcionario.getString("situacao").equals("ATIVO")) {
                    rbSituacao.setSelected(true);
                } else if (funcionario.getString("situacao").equals("INATIVO")) {
                    rbSituacao.setSelected(false);
                }
                if (funcionario.getString("foto") == null) {
                    UtilVIEW.ImagemLabel("/SolucaoSistemas/src/Imagem/semFoto.jpg", lblFoto);
                } else {
                    UtilVIEW.ImagemLabel(funcionario.getString("foto"), lblFoto);
                }

                txtCNPJ.setText(funcionario.getString("cnpj"));
                txtObservacoes.setText(funcionario.getString("observacao"));

            } else {
                JOptionPane.showMessageDialog(null, "Código não encontrado!", "ATENÇÃO",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException | ParseException | HeadlessException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o código!", "ATENÇÃO",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("" + e.getMessage());
        }

    }

    private void ConsultarCliente() {
        try {
            ResultSet consulta = null;
            consulta = objpessoaCTR.ConsultarClienteCTR(txtCodigo.getText().toUpperCase(),
                    txtNome.getText().toUpperCase());
            RestauraPessoa(consulta);
        } catch (Exception e) {
        }
    }

    private void RestauraPessoa(ResultSet rs) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("codigo"), rs.getString("nome"), rs.getString("telefone1"),
                    rs.getString("telefone2"), rs.getString("cpf"), rs.getString("rg"), rs.getString("cnpj"),
                    rs.getString("endereco"), rs.getString("numero"), rs.getString("bairro"), rs.getString("cidade"),
                    rs.getString("estado"), rs.getString("datanascimento"), rs.getString("dia"), rs.getString("pai"), rs.getString("mae"), rs.getString("profissao"),
                    rs.getString("email_face"), rs.getString("sexo"), rs.getString("observacao")});
            }
            tblCliente.setModel(dtm);
        } catch (SQLException e) {
            System.out.println("Erro ao RestaurarPessoa " + e.getMessage());
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClientesVIEW dialog = new ClientesVIEW(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenu btnImprimir;
    private javax.swing.ButtonGroup btnOperacao;
    private javax.swing.JMenu btnSair;
    private javax.swing.JMenu btnSalvar;
    private javax.swing.JComboBox cbxFuncao;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JComboBox cbxTipo1;
    private javax.swing.JComboBox cbxTipo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCadBairro;
    private javax.swing.JLabel lblCadCidade;
    private javax.swing.JLabel lblCadEnd;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblPesqBairro;
    private javax.swing.JLabel lblPesqCidade;
    private javax.swing.JLabel lblPesqEnd;
    private javax.swing.JLabel lblPesqFoto;
    private javax.swing.JLabel lblProfissao;
    private javax.swing.JLabel lblTipo1;
    private javax.swing.JLabel lblTipo2;
    private javax.swing.JRadioButton rbAtualizar;
    private javax.swing.JRadioButton rbNovo;
    private javax.swing.JCheckBox rbSituacao;
    private javax.swing.JTable tblCliente;
    public static javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCPF;
    public static javax.swing.JTextField txtCidade;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtEndereco;
    public static javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMae;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    public static javax.swing.JTextField txtNumero;
    public static javax.swing.JTextField txtObservacoes;
    private javax.swing.JTextField txtPai;
    private javax.swing.JTextField txtRG;
    private javax.swing.JFormattedTextField txtTel1;
    private javax.swing.JFormattedTextField txtTel2;
    // End of variables declaration//GEN-END:variables
}
