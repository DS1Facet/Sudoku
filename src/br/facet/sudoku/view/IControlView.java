package br.facet.sudoku.view;

/**
 * @author: Ricardo
 * @description Interface para mediar a comunicação de métodos do View que são
 *              acessíveis pelo Controller.
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
