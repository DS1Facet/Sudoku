package br.facet.sudoku.controller;

import br.facet.sudoku.model.IControllerModel;
import br.facet.sudoku.view.*;

public class MainController implements IViewController
{
    private static IControllerModel controlToModel;
    private static IControllerView controlToView;
    
    public static void main(String[] args)
    {
        controlToView = new MainWindow();
        controlToView.carregarJanela();
    }
    
    @Override
    public void novoJogo()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void recomecar()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void configuracoes()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void sair()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ajudaSobre()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato)
    {
        // TODO Auto-generated method stub
        
    }
}
