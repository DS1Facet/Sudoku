
/**
 * @author: Ricardo
 * @description Interface para mediar a comunica��o de m�todos do View que s�o acess�veis pelo Controller.
 * 
*/

package br.facet.sudoku.view;

public interface IControllerView
{
/**
 * @author Ricardo A. A.
 * @description M�todos para abrir o JFrame e carregar seus componentes
 */
	public void carregarJanela();
 
    public void exibeSemente();
    
    public void novoJogo();
    
    public void recomecar();
    
    public void ajudaSobre();
    
    public void configuracoes();
    
    public void sair();
}
