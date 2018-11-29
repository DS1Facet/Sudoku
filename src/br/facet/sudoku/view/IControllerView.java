package br.facet.sudoku.view;
/** @author: Ricardo
 * @description Interface para mediar a comunicação de métodos do View que são
 *              acessíveis pelo Controller. */
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
