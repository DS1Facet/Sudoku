
/**
 * @author: Ricardo
 * @description Interface para mediar a comunica��o de m�todos do View que s�o acess�veis pelo Controller.
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
