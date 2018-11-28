package br.facet.sudoku.model;

public interface IControllerModel
{
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato);
    public void iniciarTimer();
    public void pararTimer();
    public long exibeSemente();
}
