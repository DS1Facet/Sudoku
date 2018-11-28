package br.facet.sudoku.controller;

import br.facet.sudoku.model.IControllerModel;
import br.facet.sudoku.view.IControllerView;
import br.facet.sudoku.view.MainWindow;

public class MainController implements IViewController
{
    public IControllerModel model;
    public IControllerView view;
    
    public MainController()
    {
    }
    
    private void init()
    {
        view = new MainWindow(this);
    }
    
    public static void main(String[] args)
    {
        MainController mc = new MainController();
        mc.init();
    }
    
    @Override
    public void novoJogo()
    {
    }
    
    @Override
    public void recomecar()
    {
    }
    
    @Override
    public void configuracoes()
    {
    }
    
    @Override
    public void sair()
    {
        view.sair();
    }
    
    @Override
    public void ajudaSobre()
    {
        view.ajudaSobre();
    }
    
    @Override
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato)
    {
    }
    
    @Override
    public long exibeSemente()
    {
        long semente;
        semente = model.exibeSemente();
        return semente;
    }
}
