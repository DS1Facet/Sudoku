package br.facet.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import br.facet.sudoku.controller.IViewController;
import br.facet.sudoku.model.IControllerModel;

import br.facet.sudoku.controller.MainController;
import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame implements IControllerView
{
    private long tempoInicial;
    private IViewController viewToControl;
    private IControllerModel controlToModel;
    //
    private JMenuBar menuBar = new JMenuBar();
    private JMenu mnJogo = new JMenu("Jogo");
    private JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
    private JMenuItem mntmRecomecar = new JMenuItem("Recome\u00E7ar");
    private JMenuItem mntmConfiguracoes = new JMenuItem("Configura\u00E7\u00F5es");
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
    private JButton btnTestetimer = new JButton("testeTimer");
    
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
        
        mntmNovoJogo.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                t = new Timer(10, acoes);
                iniciarTimer();//devere ser integrado com os botões
            }
        });
        
        
        
        /**
         * @author Ricardo A. A.
         * @description Adiciona a ação de fexar a janela e encerrar o programa.
         */
        menuSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().sair();
				
			}
		});
        
        
        /**
         * @author Ricardo A. A.
         * @description Adiciona a ação de abrir uma janela com um texto a ser exibido.
         */
        menuSobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().ajudaSobre();
				
			}
		});
        
        
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
        mnJogo.add(mntmNovoJogo);
        mnJogo.add(mntmRecomecar);
        mnJogo.add(mntmConfiguracoes);
        mnJogo.add(menuSair);
        menuBar.add(mnAjuda);
        mnAjuda.add(menuSobre);
        pnlPrincipal.add(panel_Timer_Semente, BorderLayout.SOUTH);
<<<<<<< HEAD
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px][]", "[14px][14px]"));
=======
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px]", "[14px][14px]"));   
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
        panel_Timer_Semente.add(lblTimer, "cell 0 0,alignx center");
<<<<<<< HEAD
        btnTestetimer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                iniciarTimer();
            }
        });
        panel_Timer_Semente.add(btnTestetimer, "cell 1 0");
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");
=======
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");   
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
        pnlPrincipal.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(9, 9, 3, 3));
        preencher();
        pack();
        setVisible(true);
    }
    
    private void preencher()
    {
        panel.removeAll();
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                MyJButton b = new MyJButton(i, j);
                if (((i + j) % 2) == 1)
                {
                    b.setEnabled(false);
                }
                panel.add(b);
            }
        }
    }
    
<<<<<<< HEAD
    /** Função para fechar a janela e salvar o estado atual da janela. */
    @Override
    public void dispose()
    {
        System.exit(0);
    }
    
=======
    @Override
    public void carregarJanela()
    {
        if (window == null)
        {
            window = new MainWindow();
        }
        this.setVisible(true);
    }
    

>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
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
        lblSemente.setText("Semente: " + viewToControl.exibeSemente());
    }
    
    private void atualizarLabel()
    {
        long tempoAgora = System.currentTimeMillis();
        long tempoDecorrido = tempoAgora - tempoInicial;
        lblTimer.setText("Timer: " + tempoDecorrido);
    }
    
    @Override
    public void novoJogo()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void recomecar()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void sair()
    {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
    	dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
    }
<<<<<<< HEAD
    
=======
    /**
     * @author Ricardo A. A.
     * @description Cria a janela com a mensagem a ser exibida ao acionar o botão Sobre no menu Ajuda.
     */
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
    @Override
    public void ajudaSobre()
    {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
    	JOptionPane.showMessageDialog(this, "Jogo de Sodoku \n Versão 1.0 \n Build 09-2018 "
    			+ "\n Desenvolvido em Java pela turma de BSI da Faculdade Facet como trabalho "
    			+ "\n do segundo semestre de 2018 da matéria de DS1.");
        
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
    }
    
    @Override
    public void configuracoes()
    {
        // TODO Auto-generated method stub
    }
    
    class MyJButton extends JButton implements ActionListener
    {
        public int i;
        public int j;
        
        public MyJButton(int i, int j)
        {
            this.i = i;
            this.j = j;
            setText(i + ":" + j);
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
                int n = JOptionPane.showOptionDialog(this, "Selecione o Número", "Sudoku para " + button.getText(), JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                //@formatter:on
                //COMO PEGAR O VALOR DE OPTIONS ESCOLHIDO
                /* Object opcaoEscolhida = options[n]; */
                //mandar para controller: button.i, button.j, numeroCandidato
                //mandar para model: button.i, button.j, numeroCandidato
                //finalizar a thread e começar outra
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
}
