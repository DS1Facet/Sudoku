
/**
 * @author: Ricardo
 * @description Interface para mediar a comunicação de métodos do View que são acessíveis pelo Controller.
 * 
*/

package br.facet.sudoku.view;

public interface IControllerView
{

    void carregarJanela();
    void dispose();
    void exibeSemente();
    void novoJogo();
    void recomecar();
    void sair();
    void ajuda();
    void configuracoes();
}
