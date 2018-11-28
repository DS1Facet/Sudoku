package br.facet.sudoku.view;

/**
 * @author: Ricardo
 * @description Interface para mediar a comunica��o de m�todos do View que s�o
 *              acess�veis pelo Controller.
 */
public interface IControlView
{
    void carregarJanela();
    
    void dispose();
    
    void exibeSemente();
    
    void novoJogo();
    
    void recomecar();
    
    void sair();
    
    void ajudaSobre();
    
    void configuracoes();
}
