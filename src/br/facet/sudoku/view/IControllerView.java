package br.facet.sudoku.view;
/**
 * @author: Ricardo
 * @description Interface para mediar a comunica��o de m�todos do View que s�o
 *              acess�veis pelo Controller.
 */
public interface IControllerView
{
    public void exibeSemente();
    
    public void novoJogo();
    
    public void recomecar();
    
    public void ajudaSobre();
    
    public void configuracoes();
    
    public void sair();
}
