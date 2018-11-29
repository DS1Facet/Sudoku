package br.facet.sudoku.controller;

import javax.swing.SwingUtilities;
import br.facet.sudoku.model.IControllerModel;
import br.facet.sudoku.model.SudokuModel;
import br.facet.sudoku.view.IControllerView;
import br.facet.sudoku.view.MainWindow;

public class MainController implements IViewController, IModelController
{
    public IControllerModel model;
    public IControllerView view;
    
    public MainController()
    {
    }
    
    private void init()
    {
        view = new MainWindow(this);
        model = new SudokuModel(this);
    }
    
    public static void main(String[] args)
    {
        MainController mc = new MainController();
        mc.init();
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
    
    @Override
    public void fimDeJogo()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void pararTimer()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void botaoPreenchido(int i, int j, int numeroCandidato, boolean botaoPreenchido)
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void novoJogoModel(int[][] matrix)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                view.iniciarNovoJogo(matrix);
            }
        });
    }
    
    @Override
    public void iniciaNovoJogoBotaoView(int semente, int dificuldade)
    {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                model.novoJogo(semente, dificuldade);
            }
        });
        t.start();
    }

    @Override
    public void iniciarTimer()
    {
        view.iniciarTimer();
    }
}
