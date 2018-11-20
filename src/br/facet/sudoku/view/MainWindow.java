package br.facet.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import br.facet.sudoku.view.util.ViewUtils;

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
    private JPanel panel = new JPanel();
    
    public MainWindow() 
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/br/facet/sudoku/resources/images/icon.png")));
        setTitle("SUDOKU - FACET BSI DS1 ");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,400);
        setMinimumSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        
        getContentPane().add(panel, BorderLayout.CENTER);
        
        setJMenuBar(menuBar);
        menuBar.add(mnJogo);
        mnJogo.add(mntmNovoJogo);
        mnJogo.add(mntmRecomecar);
        mnJogo.add(mntmConfiguracoes);
        mnJogo.add(mntmSair);
        menuBar.add(mnAjuda);
        mnAjuda.add(mntmSobre);
    }

    @Override
    public void carregarJanela()
    {
        if(window == null)
        {
            window = new MainWindow();
        }
        this.setVisible(true);
    }
    
    /**
     * Função para fechar a janela e salvar o estado atual da janela.
     */
    @Override
    public void dispose()
    {
        System.exit(0);
    }
}
