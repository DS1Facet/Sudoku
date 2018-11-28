package br.facet.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JMenuItem mntmSair = new JMenuItem("Sair");
    private JMenu mnAjuda = new JMenu("Ajuda");
    private JMenuItem mntmSobre = new JMenuItem("Sobre");
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
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        //
        getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
        pnlPrincipal.setLayout(new BorderLayout(0, 0));
        pnlPrincipal.add(menuBar, BorderLayout.NORTH);
        menuBar.add(mnJogo);
        mnJogo.add(mntmNovoJogo);
        mnJogo.add(mntmRecomecar);
        mnJogo.add(mntmConfiguracoes);
        mnJogo.add(mntmSair);
        menuBar.add(mnAjuda);
        mnAjuda.add(mntmSobre);
        pnlPrincipal.add(panel_Timer_Semente, BorderLayout.SOUTH);
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px][]", "[14px][14px]"));
        panel_Timer_Semente.add(lblTimer, "cell 0 0,alignx center");
        btnTestetimer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                iniciarTimer();
            }
        });
        panel_Timer_Semente.add(btnTestetimer, "cell 1 0");
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");
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
    
    /** Função para fechar a janela e salvar o estado atual da janela. */
    @Override
    public void dispose()
    {
        System.exit(0);
    }
    
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
        // TODO Auto-generated method stub
    }
    
    @Override
    public void ajuda()
    {
        // TODO Auto-generated method stub
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
