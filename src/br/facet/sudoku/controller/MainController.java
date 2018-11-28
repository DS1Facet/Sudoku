package br.facet.sudoku.controller;

import br.facet.sudoku.model.IControllerModel;
import br.facet.sudoku.view.*;

public class MainController implements IViewController
{
    private static IControllerModel controlToModel;
    private static IControllerView controlToView;
    
    private static final IViewController controller = new MainController();
    
    public static IViewController getInstance() {
    	return controller;
    }
    
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
        
    	controlToView.sair();
    }

    @Override
    public void ajudaSobre()
    {
        controlToView.ajudaSobre();
        
    }

    @Override
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato)
    {
        // TODO Auto-generated method stub
        
    }
}
