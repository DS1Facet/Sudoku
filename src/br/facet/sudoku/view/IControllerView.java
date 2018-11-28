
/**
 * @author: Ricardo
 * @description Interface para mediar a comunicação de métodos do View que são acessíveis pelo Controller.
 * 
*/

package br.facet.sudoku.view;

public interface IControllerView
{
/**
 * @author Ricardo A. A.
 * @description Métodos para abrir o JFrame e carregar seus componentes
 */
	public void carregarJanela();
 
    public void exibeSemente();
    
    public void novoJogo();
    
    public void recomecar();
    
    public void ajudaSobre();
    
    public void configuracoes();
    
    public void sair();
}
