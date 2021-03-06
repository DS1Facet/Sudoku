package br.facet.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.io.FileHandler;
import br.facet.sudoku.controller.IViewController;
import br.facet.sudoku.model.IControllerModel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements IControllerView
{
    private long tempoInicial;
    private IViewController controller;
    private int numCasas = 1;
    //
    private JMenuBar menuBar = new JMenuBar();
    private JMenu mnJogo = new JMenu("Jogo");
    private JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
    private JMenuItem mntmRecomecar = new JMenuItem("Recome\u00E7ar");
    private JMenuItem mntmSalvarConfiguracoes = new JMenuItem("Salvar Configura\u00E7\u00F5es");
    private JMenuItem menuSair = new JMenuItem("Sair");
    private JMenu mnAjuda = new JMenu("Ajuda");
    private JMenuItem mntmSobre = new JMenuItem("Sobre");
    private JMenuItem menuSobre = new JMenuItem("Sobre");
    private MainWindow window;
    private JPanel pnlPrincipal = new JPanel();
    private Timer timer;
    private JLabel lblSemente = new JLabel("Semente:");
    private JPanel panel_Timer_Semente = new JPanel();
    private JLabel lblTimer = new JLabel("Timer:");
    private JPanel panel = new JPanel();
    private final JMenuItem mntmCarregarConfiguraes = new JMenuItem("Carregar Configura\u00E7\u00F5es");
    
    public MainWindow(IViewController controller)
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/br/facet/sudoku/resources/images/icon.png")));
        setTitle("SUDOKU - FACET BSI DS1 ");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(387, 400);
        setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
        pnlPrincipal.setLayout(new BorderLayout(0, 0));
        pnlPrincipal.add(menuBar, BorderLayout.NORTH);
        menuBar.add(mnJogo);
        /** @author Ricardo A. A.
         * @description Adiciona a a��o de fexar a janela e encerrar o
         *              programa. */
        menuSair.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                sair();
            }
        });
        /** @author Ricardo A. A.
         * @description Adiciona a a��o de abrir uma janela com um texto a ser
         *              exibido. */
        menuSobre.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                ajudaSobre();
            }
        });
        mntmNovoJogo.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                controller.iniciaNovoJogoBotaoView(5, numCasas);
            }
        });
        mnJogo.add(mntmNovoJogo);
        mnJogo.add(mntmRecomecar);
        mntmSalvarConfiguracoes.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                salvarConfiguracoes();
            }
        });
        mnJogo.add(mntmSalvarConfiguracoes);
        mntmCarregarConfiguraes.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                carregarConfiguracoes();
            }
        });
        mnJogo.add(mntmCarregarConfiguraes);
        mnJogo.add(menuSair);
        menuBar.add(mnAjuda);
        mnAjuda.add(menuSobre);
        pnlPrincipal.add(panel_Timer_Semente, BorderLayout.SOUTH);
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px][]", "[14px][14px]"));
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px]", "[14px][14px]"));
        panel_Timer_Semente.add(lblTimer, "cell 0 0,alignx center");
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");
        pnlPrincipal.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(9, 9, 3, 3));
        pack();
        setVisible(true);
    }
    
    /** Fun��o para fechar a janela e salvar o estado atual da janela. */
    @Override
    public void dispose()
    {
        System.exit(0);
    }
    
    @Override
    public void iniciarTimer()
    {
        if (timer != null)
        {
            timer.stop();
            timer = null;
        }
        tempoInicial = System.currentTimeMillis();
        timer = new Timer(200, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                atualizarLabel();
            }
        });
        timer.start();
    }
    
    public void pararTimer()
    {
        timer.stop();
    }
    
    public void exibeSemente()
    {
        lblSemente.setText("Semente: " + controller.exibeSemente());
    }
    
    private void atualizarLabel()
    {
        long tempoAgora = System.currentTimeMillis();
        long tempoDecorrido = tempoAgora - tempoInicial;
        lblTimer.setText("Timer: " + tempoDecorrido);
    }
    
    @Override
    public void recomecar()
    {
    }
    
    @Override
    public void sair()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    /** @author Ricardo A. A.
     * @description Cria a janela com a mensagem a ser exibida ao acionar o
     *              bot�o Sobre no menu Ajuda. */
    @Override
    public void ajudaSobre()
    {
        JOptionPane.showMessageDialog(this, "Jogo de Sodoku \n Vers�o 1.0 \n Build 09-2018 " + "\n Desenvolvido em Java pela turma de BSI da Faculdade Facet como trabalho " + "\n do segundo semestre de 2018 da mat�ria de DS1.");
    }
    
    @Override
    public void salvarConfiguracoes()
    {
        try
        {
            File file = new File("Sudoku.config.xml");
            file.createNewFile();
            XMLConfiguration config = new XMLConfiguration();
            config.addProperty("sudoku.numCasas", numCasas);
            FileHandler handler = new FileHandler(config);
            handler.save(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void carregarConfiguracoes()
    {
        try
        {
            File file = new File("Sudoku.config.xml");
            //
            //
            Configurations configs = new Configurations();
            XMLConfiguration config = configs.xml(file);
            //
            //
            int numCasasVazias = config.getInt("sudoku.numCasas");
            //
            numCasas = numCasasVazias;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    class MyJButton extends JButton implements ActionListener
    {
        public int i;
        public int j;
        private int numero;
        
        public int getNumero()
        {
            return numero;
        }
        
        public void setNumero(int numero)
        {
            this.numero = numero;
            if (numero == 0)
            {
                setText("");
            }
            else
            {
                setText("" + numero);
            }
        }
        
        public MyJButton(int i, int j)
        {
            this.i = i;
            this.j = j;
            addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() instanceof JButton)
            {
                JButton button = (JButton) e.getSource();
                //@formatter:off
                Object[] options = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                int n = JOptionPane.showOptionDialog(this, "Selecione o N�mero", "Sudoku para " + button.getText(), JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                //@formatter:on
                //COMO PEGAR O VALOR DE OPTIONS ESCOLHIDO
                /* Object opcaoEscolhida = options[n]; */
                //mandar para controller: button.i, button.j, numeroCandidato
                //mandar para model: button.i, button.j, numeroCandidato
                //finalizar a thread e come�ar outra
                //verificarNumeroCandidato
                //preencher o numero candidato
                //mandar para controller: button.i, button.j, numeroCandidato, SePodeColocar
                //mandar para view: button.i, button.j, numeroCandidato, SePodeColocar
                //verificarTerminouojogo
                //mandar para controller: Terminou
                //mandar para view: Terminou
                //TODO Como fazer uma thread sentido Model
                /* Thread thread = new Thread(new Runnable() {
                 * @Override public void run() { //TODO CODIGO } }); */
                //TODO Como fazer uma thread sentido View
                /* SwingUtilities.invokeLater(new Runnable() {
                 * @Override public void run() { //TODO CODIGO } }); */
            }
        }
    }
    
    @Override
    public void iniciarNovoJogo(int[][] matrix)
    {
        panel.removeAll();
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                MyJButton b = new MyJButton(i, j);
                if (matrix[i][j] != 0)
                {
                    b.setNumero(matrix[i][j]);
                    b.setEnabled(false);
                }
                panel.add(b);
            }
        }
        SwingUtilities.updateComponentTreeUI(panel);
    }
}
