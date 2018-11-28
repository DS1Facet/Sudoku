package br.facet.sudoku.model;

/**
 * @author Ricardo A. A.
 * @description Interface para mediar a comunica��o de m�todos do Model que s�o acess�veis pelo Controller.
 */
public interface IControllerModel
{
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato);
    
    public void iniciarTimer();
    
    public void pararTimer();
    
    public long exibeSemente();
    
    public boolean newGame();
    
    public boolean newGame(long seed);
}
