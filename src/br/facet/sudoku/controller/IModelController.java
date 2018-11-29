package br.facet.sudoku.controller;

public interface IModelController
{
    public void fimDeJogo();
    
    public void pararTimer();
    
    public void botaoPreenchido(int i, int j, int numeroCandidato, boolean botaoPreenchido);
    
    public void novoJogoModel(int[][] matrix);
    
    public void iniciarTimer();
}
