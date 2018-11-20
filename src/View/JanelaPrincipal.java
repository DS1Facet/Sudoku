package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

public class JanelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JPanel panel = new JPanel();
	
	public JanelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPrincipal.class.getResource("/imagens/icon.png")));
		setTitle("SUDOKU - FACET BSI DS1 ");
		setSize(400,400);
		setMinimumSize(new Dimension(400,400));
		setLocationRelativeTo(null);
		setResizable(true);
		
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);
	}

}
