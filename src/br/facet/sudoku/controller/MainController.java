package br.facet.sudoku.controller;

import br.facet.sudoku.model.IControllerModel;
import br.facet.sudoku.model.SudokuModel;
import br.facet.sudoku.view.IControllerView;
import br.facet.sudoku.view.MainWindow;

public class MainController implements IViewController
{
    public IControllerModel controlToModel;
    public IControllerView controlToView;
    public SudokuModel sudokuModel;
    public IViewController viewToControl;
    
    public MainController()
    {
    }
    
    private void init()
    {
        controlToView = new MainWindow(this);
    }
    
    private static final IViewController controller = new MainController();
    
    public static IViewController getInstance() {
    	return controller;
    }
    
    public static void main(String[] args)
    {
        MainController mc = new MainController();
        mc.init();
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
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        
    	controlToView.sair();
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
    }
    
    @Override
    public void ajudaSobre()
    {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        controlToView.ajudaSobre();
        
>>>>>>> branch 'master' of https://github.com/DS1Facet/Sudoku.git
    }
    
    @Override
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato)
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public long exibeSemente()
    {
        // TODO Auto-generated method stub
        long semente;
        semente = sudokuModel.exibeSemente();
        return semente;
    }
}
