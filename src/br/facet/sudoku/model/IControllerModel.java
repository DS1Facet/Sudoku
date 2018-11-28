/**
 * @author Ricardo A. A.
 * @description
 */

package br.facet.sudoku.model;

public interface IControllerModel
{
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato);
    
    public boolean newGame();
    
    public boolean newGame(long seed);
    
}

