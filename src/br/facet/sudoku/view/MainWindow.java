package br.facet.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import br.facet.sudoku.view.util.ViewUtils;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements IControlView
{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu mnJogo = new JMenu("Jogo");
    private JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
    private JMenuItem mntmRecomecar = new JMenuItem("Recome\u00E7ar");
    private JMenuItem mntmConfiguracoes = new JMenuItem("Configura\u00E7\u00F5es");
    private JMenuItem mntmSair = new JMenuItem("Sair");
    private JMenu mnAjuda = new JMenu("Ajuda");
    private JMenuItem mntmSobre = new JMenuItem("Sobre");
    private MainWindow window;
    private JPanel pnlPrincipal = new JPanel();
    private int h, m, s, cs;
    private Timer t;
    private JLabel lblSemente = new JLabel("Semente:");
    private JPanel panel_Timer_Semente = new JPanel();
    private JLabel lblTimer = new JLabel("Timer:");
    
    public MainWindow()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/br/facet/sudoku/resources/images/icon.png")));
        setTitle("SUDOKU - FACET BSI DS1 ");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        //
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
        mnJogo.add(mntmNovoJogo);
        mnJogo.add(mntmRecomecar);
        mnJogo.add(mntmConfiguracoes);
        mnJogo.add(mntmSair);
        menuBar.add(mnAjuda);
        mnAjuda.add(mntmSobre);
        pnlPrincipal.add(panel_Timer_Semente, BorderLayout.SOUTH);
        panel_Timer_Semente.setLayout(new MigLayout("", "[400px]", "[14px][14px]"));
        
        panel_Timer_Semente.add(lblTimer, "cell 0 0,alignx center");
        panel_Timer_Semente.add(lblSemente, "cell 0 1,alignx center,aligny top");
        //no action listener do botão novo jogo deve ser adicionado o codigo abaixo
        exibeSemente("**Semente teste**");//alterar depois para o retorno da semente vindo do model
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
    
    /** Função para fechar a janela e salvar o estado atual da janela. */
    @Override
    public void dispose()
    {
        System.exit(0);
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
}
