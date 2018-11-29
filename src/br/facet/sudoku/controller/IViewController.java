package br.facet.sudoku.controller;
public interface IViewController
{
    public void iniciaNovoJogoBotaoView(int semente, int dificuldade);
    
    public void recomecar();
    
    public void sair();
    
    public void ajudaSobre();
    
    public void configuracoes();
    
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato);
    
    public long exibeSemente();
    
    public void iniciarTimer();
}