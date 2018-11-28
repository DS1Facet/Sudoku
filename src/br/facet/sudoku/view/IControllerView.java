package br.facet.sudoku.view;
/**
 * @author: Ricardo
 * @description Interface para mediar a comunicação de métodos do View que são
 *              acessíveis pelo Controller.
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
