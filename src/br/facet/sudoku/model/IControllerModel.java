/**
 * @author Ricardo A. A.
 * @description
 */

package br.facet.sudoku.model;

public interface IControllerModel
{
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato);
<<<<<<< HEAD
    public void iniciarTimer();
    public void pararTimer();
    public long exibeSemente();
=======
    
    public boolean newGame();
    
    public boolean newGame(long seed);
    
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
}

