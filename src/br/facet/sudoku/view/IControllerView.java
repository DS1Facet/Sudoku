package br.facet.sudoku.view;
/** @author: Ricardo
 * @description Interface para mediar a comunica��o de m�todos do View que s�o
 *              acess�veis pelo Controller. */
public interface IControllerView
{
    public void exibeSemente();
    
    public void recomecar();
    
    public void ajudaSobre();
    
    public void salvarConfiguracoes();
    public void carregarConfiguracoes();
    
    public void sair();
    
    public void iniciarTimer();
    
    public void iniciarNovoJogo(int[][] matrix);
}
