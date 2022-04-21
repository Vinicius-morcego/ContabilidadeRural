/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import SistemaDAO.ConectaBanco;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Vinicius
 */
public class UtilVIEW {

    static DateFormat formataBackup = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static JPasswordField jpf = new JPasswordField();

    public void ImprimirClienteIndividual(String codigo, String idade) {
        try {

            int op = -1;
            op = JOptionPane.showConfirmDialog(null, "Impressora esta ligada?", "PERGUNTA",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == 0) {

                // this.dispose();
                URL arquivo = getClass().getResource("/Relatorios/Pessoa.jasper");

                //JOptionPane.showMessageDialog(this, arquivo.toString());
                if (arquivo == null) {
                    System.out.println("ARQUIVO INEXISTENTE");
                } else {

                    ConectaBanco.ConectaPostgres();
                    JasperPrint rel = null;
                    Map parametros = new HashMap();
                    parametros.put("codigo", codigo);
                    parametros.put("idade", idade);
                    JasperReport jr = (JasperReport) JRLoader.loadObject(arquivo);
                    rel = JasperFillManager.fillReport(jr, parametros, ConectaBanco.con);
                    JasperViewer.viewReport(rel, false);

                }
            } else if (op == 1) {

            }

        } catch (HeadlessException e) {
            System.out.println("Aqui " + e.getMessage());
        } catch (JRException e) {
            System.out.println("Ali " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Valor nulo foi passado " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Nulo " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Erro!", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
        } catch (JRRuntimeException e) {
            System.out.println("AQUI " + e.getMessage());
        }
    }

    public static boolean PedeSenha(String parametro) {
        try {
            String senha = "";
            char[] pegaSenha;
            JLabel label = new JLabel("Digite a senha:");
           
            
            JOptionPane.showConfirmDialog(null, new Object[]{label, jpf}, "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);

            pegaSenha = jpf.getPassword();
            senha = String.valueOf(pegaSenha);
            if (senha.equals(parametro)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Senha não confere!", "ATENÇÃO",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } catch (HeadlessException e) {
            System.out.println("" + e.getMessage());
            return false;
        }
    }

    public static void realizaRestore() throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<>();
        File arquivo;
        arquivo = new File("/SolucaoSistemas/backup/");
        int i = 0;
        i = arquivo.listFiles().length;

        comandos.add("C:\\Program Files\\PostgreSQL\\9.0\\bin\\pg_restore.exe");
        comandos.add("-h");
        comandos.add("localhost");
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-d");
        comandos.add("banco");
        comandos.add("--role");
        comandos.add("postgres");
        comandos.add("--no-password");
        comandos.add("--verbose");
        comandos.add("\\SolucaoSistemas\\backup\\" + i + "_bkp.backup");
        //comandos.add("\\Clinica\\banco.backup");
        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", "123456");

        try {
            final Process processo = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(processo.getErrorStream()));
            String linha = r.readLine();

            while (linha != null) {
                System.err.println(linha);
                linha = r.readLine();
            }
            r.close();
            processo.waitFor();
            processo.destroy();
            //  System.out.println("Restore realizado com sucesso!");
            JOptionPane.showMessageDialog(null, "Restore realizado com sucesso!");

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao realizar o restore! " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao restaurar o banco!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void realizaBackup() throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<>();
        File arquivo;
        arquivo = new File("/SolucaoSistemas/backup/");
        int i = 0;
        i = arquivo.listFiles().length;
        comandos.add("C:\\Program Files\\PostgreSQL\\9.0\\bin\\pg_dump.exe");
        // comandos.add("C:\\Windows\\System32\\pg_dump.exe");
        comandos.add("-i");
        comandos.add("-h");
        comandos.add("localhost");
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-F");
        comandos.add("c");
        comandos.add("-b");
        comandos.add("-v");
        comandos.add("-f");
        comandos.add("\\SolucaoSistemas\\backup\\" + (i + 1) + "_bkp.backup");
        comandos.add("banco");
        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", "123456");
        try {
            final Process processo = pb.start();

            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(processo.getErrorStream()));
            String linha = r.readLine();

            while (linha != null) {
                System.err.println(linha);
                linha = r.readLine();
            }
            r.close();
            processo.waitFor();
            processo.destroy();
            // System.out.println("Backup realizado com sucesso!");

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao realizar o backup! " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao fazer o backup!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void CriarBanco() {
        try {
            final List<String> comandos = new ArrayList<>();
            comandos.add("C:\\Program Files\\PostgreSQL\\9.0\\bin\\createdb.exe");
            comandos.add("-h");
            comandos.add("localhost");
            comandos.add("-p");
            comandos.add("5432");
            comandos.add("-U");
            comandos.add("postgres");
            comandos.add("banco");
            ProcessBuilder pb = new ProcessBuilder(comandos);
            pb.environment().put("PGPASSWORD", "123456");

            final Process processo = pb.start();

            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(processo.getErrorStream()));
            String linha = r.readLine();

            while (linha != null) {
                System.err.println(linha);
                linha = r.readLine();
            }
            r.close();
            processo.waitFor();
            processo.destroy();
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o banco", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("" + e.getMessage());
        }
    }

    public static Integer CalcularIdade(JLabel label, Date data) {
        Integer diferencaMes, diferencaDia = null, idade = null;
        try {
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(data);
            Calendar dataAtual = Calendar.getInstance();

            diferencaMes = (dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH));
            diferencaDia = (dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH));
            idade = (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));
            if (diferencaMes <= 0 && diferencaDia < 0) {
                idade--;
            }
            label.setText(idade + " anos, " + diferencaMes + " meses e " + diferencaDia + " dias");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CalcularIdade!");

        }
        return idade;
    }

    public static void ImagemLabel(String caminho, JLabel label) {
        try {
            File arquivo = new File(caminho);
            Image imagem;
            imagem = ImageIO.read(arquivo);
            label.setIcon(new ImageIcon(imagem.getScaledInstance(label.getWidth(),
                    label.getHeight(), Image.SCALE_DEFAULT)));
            label.setText(caminho);
        } catch (IOException e) {
            System.out.println("Imagem não encontrada " + e.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    public static void LimparCampos(JPanel painel) {
        try {
            for (Component c : painel.getComponents()) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText("");
                }
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setText("");
                }
                if (c instanceof JComboBox) {
                    ((JComboBox) c).setSelectedIndex(-1);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void DesabilitarCampos(JPanel painel) {
        try {
            for (Component c : painel.getComponents()) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setEnabled(false);
                    //((JTextField) c).setBackground(new Color(240, 240, 240));
                }
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setEnabled(false);
                }
                if (c instanceof JComboBox) {
                    ((JComboBox) c).setEnabled(false);
                }
                if (c instanceof JRadioButton) {
                    ((JRadioButton) c).setEnabled(false);
                }
                if (c instanceof JDateChooser) {
                    ((JDateChooser) c).setEnabled(false);
                }
                if (c instanceof JTable) {
                    ((JTable) c).setEnabled(false);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void HabilitarCampos(JPanel painel) {
        try {
            for (Component c : painel.getComponents()) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setEnabled(true);
                    // ((JTextField) c).setBackground(Color.white);
                }
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setEnabled(true);
                }
                if (c instanceof JComboBox) {
                    ((JComboBox) c).setEnabled(true);
                }
                if (c instanceof JRadioButton) {
                    ((JRadioButton) c).setEnabled(true);
                }
                if (c instanceof JDateChooser) {
                    ((JDateChooser) c).setEnabled(true);
                }
                if (c instanceof JTable) {
                    ((JTable) c).setEnabled(true);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void DesabilitarMenus(JMenu... menus) {
        for (Component c : menus) {
            if (c instanceof JMenu) {
                ((JMenu) c).setVisible(false);

            }
        }
    }

    public static void HabilitarMenus(JMenu... menus) {
        for (Component c : menus) {
            if (c instanceof JMenu) {
                ((JMenu) c).setVisible(true);

            }
        }
    }

    public static void MudarCursor(JMenu... menus) {
        for (Component c : menus) {
            if (c instanceof JMenu) {
                ((JMenu) c).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }
        }
    }

    public static void MudarCursorLabel(JLabel... labels) {
        for (Component c : labels) {
            if (c instanceof JLabel) {
                ((JLabel) c).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }
        }
    }

    public static void PreencheCombo(ResultSet rs, JComboBox combo, int pos) {
        try {
            combo.removeAllItems();
            while (rs.next()) {
                combo.addItem(rs.getString(pos));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao Preencher Combo " + e.getMessage());
        }
    }

    public static void LimparTabela(JTable tabela) {
        DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
        tab.setRowCount(0);
        tabela.setModel(tab);
    }

    public static void mascaraCpf(JFormattedTextField... cpf) {
        try {
            for (Component c : cpf) {
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("###.###.###-##")));
                }

            }

        } catch (ParseException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static void mascaraCnpj(JFormattedTextField... cnpj) {
        try {
            for (Component c : cnpj) {
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("##.###.###/####-##")));
                }

            }

        } catch (ParseException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static void mascaraCep(JFormattedTextField... cep) {
        try {
            for (Component c : cep) {
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("##.###-###")));
                }

            }

        } catch (ParseException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static void mascaraTelefone(JFormattedTextField... telefone) {
        try {
            for (Component c : telefone) {
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(##)####-####")));
                }

            }

        } catch (ParseException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static void mascaraData(JFormattedTextField... telefone) {
        try {
            for (Component c : telefone) {
                if (c instanceof JFormattedTextField) {
                    ((JFormattedTextField) c).setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("##/##/####")));
                }

            }

        } catch (ParseException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static boolean VerificaData(String data) {
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        formata.setLenient(false);
        try {
            formata.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static void FormatarCampo(JTextField... campo) {
        try {
            Double valor = 0.0;
            NumberFormat numero = DecimalFormat.getCurrencyInstance(
                    new Locale("pt", "BR"));
            numero.setMinimumFractionDigits(2);
            String digitos = numero.format(valor);
            for (Component c : campo) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText(digitos);
                }

            }

        } catch (NumberFormatException e) {

            System.out.println("" + e.getMessage());
        }
    }

    public static void Icone(JDialog janela) {
        try {

            janela.setIconImage(
                    Toolkit.getDefaultToolkit().
                    getImage("/SolucaoSistemas/src/Imagem/cifrao_32x32.png"));

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }

    public static void Imagem(JLabel lab) {
        UIManager.put("FileChooser.lookInLabelText", "Consulte:");
        UIManager.put("FileChooser.lookInLabelMnemonic", "o");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo:");
        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo:");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "t");
        UIManager.put("FileChooser.upFolderToolTipText", "Um Nível Acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Para Cima");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Criar uma Nova Pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nova Pasta");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonMnemonic", "A");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os Arquivos");
        JFileChooser fc = new JFileChooser("D:/Ajoia/");
        fc.setDialogTitle("SELEÇÃO DE IMAGEM");
        FileFilter ft = new FileFilter() {
            @Override
            public boolean accept(File f) {
                String file = f.getName();
                return file.endsWith(".jpg") | f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "jpg";
            }
        };

        fc.setFileFilter(ft);
        int option = 0;
        String caminho;
        option = fc.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {

            //caminho = fc.getSelectedFile().getAbsolutePath().replace("\\".toString(), "\\\\");
            caminho = fc.getSelectedFile().getAbsolutePath();

            //lab.setText(caminho.replace("\\".toString(), "\\\\"));
            lab.setText(caminho);
            File f = fc.getSelectedFile();
            Image image = null;

            try {
                image = ImageIO.read(f);
            } catch (IOException ex) {

                System.out.println("Imagem não encontrada! " + ex.getMessage());
            }
            lab.setIcon(new ImageIcon(image.getScaledInstance(lab.getWidth(),
                    lab.getHeight(), image.SCALE_DEFAULT)));

        } else if (option == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Não escolheu nenhuma imagem!",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void DataAtual(JFormattedTextField campo) {
        try {
            Date data = new Date();
            DateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            campo.setText(formata.format(data));
            campo.setEditable(true);
        } catch (Exception e) {
            System.out.println("Erro ao pegar a data atual!");
        }
    }

    public static String Leitura() {
        StringBuilder lerArquivo = new StringBuilder();

        try {
            File f = new File("/SolucaoSistemas/CaminhoBanco.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String linha = "";
                while (linha != null) {
                    lerArquivo.append(linha);
                    linha = br.readLine();

                }
                br.close();
                fr.close();

            } catch (IOException e) {
                System.out.println("Erro ao ler Arquivo! " + e.getMessage());

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado! " + ex.getMessage());
        }
        return lerArquivo.toString();
    }

    public static String Criptografar(String senha) {
        String md5 = null;
        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            md5 = new BigInteger(1, digest.digest()).toString(16);
            //System.out.println(md5);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UtilVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md5;
    }

    public static void VerificaCapsLock(JLabel verifica) {
        try {

            boolean capsLigado = Toolkit.getDefaultToolkit().
                    getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
            if (capsLigado == true) {

                verifica.setText("Caps Lock ligado!");

            } else if (capsLigado == false) {

                verifica.setText("");

            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao Verificar CapsLock " + e.getMessage());
        }
    }

    public static void EmailAnexo()
            throws javax.mail.NoSuchProviderException, javax.mail.MessagingException,
            UnsupportedEncodingException {
        String emails = "vinicius_templario@hotmail.com";

        System.out.println("Enviando email...");
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps"); //define protocolo de envio como SMTP  
        props.put("mail.smtps.starttls.enable", "true");
        props.put("mail.smtps.host", "smtp.gmail.com"); //server SMTP do GMAIL  
        props.put("mail.smtps.auth", "true"); //ativa autenticacao  
        props.put("mail.smtps.user", "vinicius.templario@gmail.com");
        //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)  
        props.put("mail.debug", "true");
        props.put("mail.smtps.port", "465"); //porta  
        props.put("mail.smtps.socketFactory.port", "465"); //mesma porta para o socket  
        props.put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtps.socketFactory.fallback", "false");

        SimpleAuth auth = null;
        auth = new SimpleAuth("vinicius.templario@gmail.com", "modefokers10");
        Session mailSession = Session.getDefaultInstance(props, auth);
        mailSession.setDebug(true);
        javax.mail.Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Backup Escritório Rural - " + formataBackup.format(new Date(System.currentTimeMillis())));
        message.setFrom(new InternetAddress("vinicius.templario@gmail.com"));

        message.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(emails));

        //email
        //  
        // Este email HTML tem 2 partes, BODY e imagem embutida  
        //  
        javax.mail.internet.MimeMultipart multipart = new javax.mail.internet.MimeMultipart("related");

        // 1a parte- html  
        BodyPart messageBodyPart1 = new javax.mail.internet.MimeBodyPart();
        // BodyPart messageBodyPart2 = new javax.mail.internet.MimeBodyPart();
        String htmlText = "<br>Backup em anexo, favor confirmar recebimento.<br><br>Att:<br>Vinicius Queiroz Souza"
                + "<br>vinicius_templario@hotmail.com<br>Desenvolvedor Java"
                + "<br><img src=\"cid:image\">";
        messageBodyPart1.setContent(htmlText, "text/html");

        // Adiciona  
        multipart.addBodyPart(messageBodyPart1);

        // Segunda parte - a imagem  
        messageBodyPart1 = new javax.mail.internet.MimeBodyPart();
        //   BodyPart messageBodyPart2 = new javax.mail.internet.MimeBodyPart();
        int j = 0;
        File arquivo;
        arquivo = new File("/SolucaoSistemas/backup/");
        j = arquivo.listFiles().length;
        DataSource fds1 = new FileDataSource("/SolucaoSistemas/backup/" + (j) + "_bkp.backup");//caminho  

        messageBodyPart1.setDisposition(Part.ATTACHMENT);

        messageBodyPart1.setDataHandler(new DataHandler(fds1));

        messageBodyPart1.setFileName(fds1.getName());//nome do arquivo

        //  messageBodyPart.setHeader("Content-ID", "<image>");
        //Adiciona  
        multipart.addBodyPart(messageBodyPart1);
      //  multipart.addBodyPart(messageBodyPart2);

        // coloca tudo junto  
        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(javax.mail.Message.RecipientType.TO));
        transport.close();
    }

    public static boolean VerificaConexao() {
        try {

            java.net.URL mandarEmail = new java.net.URL("http://www.guj.com.br");
            java.net.URLConnection conecta = mandarEmail.openConnection();

            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conecta;
            httpConn.connect();
            int x = httpConn.getResponseCode();
            System.out.println("Resposta " + x);
            if (x >= 200) {
                System.out.println("Conectado com a Internet!");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Não conectado a Internet! " + e.getMessage());
            return false;
        }
    }
}
