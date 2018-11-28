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

import br.facet.sudoku.controller.MainController;
import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame implements IControllerView
{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu mnJogo = new JMenu("Jogo");
    private JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
    private JMenuItem mntmRecomecar = new JMenuItem("Recome\u00E7ar");
    private JMenuItem mntmConfiguracoes = new JMenuItem("Configura\u00E7\u00F5es");
    private JMenuItem menuSair = new JMenuItem("Sair");
    private JMenu mnAjuda = new JMenu("Ajuda");
    private JMenuItem menuSobre = new JMenuItem("Sobre");
    private MainWindow window;
    private JPanel pnlPrincipal = new JPanel();
    private int h, m, s, cs;
    private Timer t;
    private JLabel lblSemente = new JLabel("Semente:");
    private JPanel panel_Timer_Semente = new JPanel();
    private JLabel lblTimer = new JLabel("Timer:");
    
    private final JPanel panel = new JPanel();
    
    public MainWindow()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/br/facet/sudoku/resources/images/icon.png")));
        setTitle("SUDOKU - FACET BSI DS1 ");
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
        
        
        mnJogo.add(mntmNovoJogo);
        mnJogo.add(mntmRecomecar);
        mnJogo.add(mntmConfiguracoes);
        mnJogo.add(menuSair);
        menuBar.add(mnAjuda);
        mnAjuda.add(menuSobre);
        pnlPrincipal.add(panel_Timer_Semente, BorderLayout.SOUTH);
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px]", "[14px][14px]"));   
        panel_Timer_Semente.add(lblTimer, "cell 0 0,alignx center");
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");   
        pnlPrincipal.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(9, 9, 3, 3));
        preencher();
        //no action listener do botão novo jogo deve ser adicionado o codigo abaixo
        exibeSemente("**Semente teste**");//alterar depois para o retorno da semente vindo do model
        pack();
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
    
    @Override
    public void carregarJanela()
    {
        if (window == null)
        {
            window = new MainWindow();
        }
        this.setVisible(true);
    }
    

    public void iniciarTimer()
    {
        //t = new Timer(10, acoes);
        //iniciarTimer();//devere ser integrado com os botões
        t.start();
        //return para o model o tempo inicial
    }
    
    public void pararTimer()
    {
        t.stop();
        //returna para o model o tempo final
    }
    
    public void exibeSemente(String semente)
    {
        lblSemente.setText("Semente: " + semente);
    }
    private ActionListener acoes = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            ++cs;
            if (cs == 100)
            {
                cs = 0;
                ++s;
            }
            if (s == 60)
            {
                s = 0;
                ++m;
            }
            if (m == 60)
            {
                m = 0;
                ++h;
            }
            atualizarLabel();
        }
    };
    
    
    
    private void atualizarLabel()
    {
        String tempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
        lblTimer.setText("Timer: " + tempo);
    }

    @Override
    public void exibeSemente()
    {
        // TODO Auto-generated method stub
        
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
    	dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        
    }
    /**
     * @author Ricardo A. A.
     * @description Cria a janela com a mensagem a ser exibida ao acionar o botão Sobre no menu Ajuda.
     */
    @Override
    public void ajudaSobre()
    {
    	JOptionPane.showMessageDialog(this, "Jogo de Sodoku \n Versão 1.0 \n Build 09-2018 "
    			+ "\n Desenvolvido em Java pela turma de BSI da Faculdade Facet como trabalho "
    			+ "\n do segundo semestre de 2018 da matéria de DS1.");
        
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
                Object[] options = {0,1,2,3,4,5,6,7,8,9};
                int n = JOptionPane.showOptionDialog(this,
                        "Selecione o Número",
                        "Sudoku para "+button.getText(),
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                
                //@formatter:on
                //COMO PEGAR O VALOR DE OPTIONS ESCOLHIDO
                /*
                 Object opcaoEscolhida = options[n]; 
                 */
                
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
                /*
                         Thread thread = new Thread(new Runnable()
                         {
                            @Override
                            public void run()
                            {
                                //TODO CODIGO
                            }
                         });

                 */
                //TODO Como fazer uma thread sentido View
                /*
                        SwingUtilities.invokeLater(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                //TODO CODIGO
                            }
                        });
                 */
            }
        }
    }
}
