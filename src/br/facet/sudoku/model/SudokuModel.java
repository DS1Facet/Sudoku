package br.facet.sudoku.model;

import java.util.Calendar;
import java.util.Random;
import br.facet.sudoku.controller.IModelController;

/** Classe que gerencia as regras de negócio de um jogo de sudoku
 * @author MaltonX */
public class SudokuModel implements IControllerModel
{
    private IModelController controller;
    Calendar dataInicio;
    Calendar dataFim;
    //@formatter:off
    private int[][] matrix = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
    //@formatter:on
    private Random r = new Random();
    private long Semente;
    
    public SudokuModel(IModelController controller)
    {
        this.controller = controller;
    }
    
    /** Zera todos os valores da matriz sudoku da classe
     * @author MaltonX */
    private void zerar()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                matrix[i][j] = 0;
            }
        }
    }
    
    /** Mostra uma matriz 9x9 no console
     * @author MaltonX
     * @param matrix Uma matriz 9x9 para mostrar no console */
    public void showMatrix(int[][] matrix)
    {
        System.out.println("+---------+---------+---------+");
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    System.out.printf("   ");
                }
                else
                {
                    System.out.printf(" %d ", matrix[i][j]);
                }
                if ((j % 3) == 2)
                {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i % 3) == 2)
            {
                System.out.println("+---------+---------+---------+");
            }
        }
    }
    
    /** Verifica se um numero candidato pode ser utilizado na matriz sudoku
     * @author MaltonX
     * @param matrix A matriz a ser comparada
     * @param row a linha do numeroCandidato
     * @param col a coluna do numeroCandidato
     * @param numeroCandidato o valor do numeroCandidato
     * @return true se numeroCandidato for um valor válido ou false do
     *         contrário */
    private boolean verificarNumeroCandidato(int[][] matrix, int row, int col, int numeroCandidato)
    {
        // TODO verificar Linha
        for (int j = 0; j < 9; j++)
        {
            if (numeroCandidato == matrix[row][j])
            {
                return false;
            }
        }
        // TODO verificar Coluna
        for (int i = 0; i < 9; i++)
        {
            if (numeroCandidato == matrix[i][col])
            {
                return false;
            }
        }
        // TODO verificar Bloco
        for (int i = row - (row % 3); i < row - (row % 3) + 3; i++)
        {
            for (int j = col - (col % 3); j < col - (col % 3) + 3; j++)
            {
                if (numeroCandidato == matrix[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /** Preenche e retorna um Array contendo os números de 1 a 9 embaralhados
     * Adaptado de
     * https://github.com/SomeKittens/Sudoku-Project/blob/master/SudokuGenerator.java
     * @author MaltonX
     * @return um Array contendo os números de 1 a 9 embaralhados */
    private int[] getShuffledPossibleNumbersSudoku()
    {
        int[] possibleNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int aux = 0;
        int index = 0;
        int top = possibleNumbers.length;
        for (int i = top - 1; i > 0; i--)
        {
            index = r.nextInt(i);
            aux = possibleNumbers[index];
            possibleNumbers[index] = possibleNumbers[i];
            possibleNumbers[i] = aux;
        }
        return possibleNumbers;
    }
    
    /** Método recursivo que preenche cada célula da matriz de sudoku
     * @author MaltonX
     * @param row A linha atual da célula a preencher
     * @param col A coluna atual da célula a preencher
     * @return true se a célula foi preenchida, ou se todos os requesitos foram
     *         cumpridos. false caso a célula não possa ser preenchida. */
    private boolean completa_grade(int row, int col)
    {
        if (row == 9)
        {
            return true;
        }
        if (matrix[row][col] != 0)
        {
            if (col == 8)
            {
                return completa_grade(row + 1, 0);
            }
            else
            {
                return completa_grade(row, col + 1);
            }
        }
        int[] possibleNumbers = getShuffledPossibleNumbersSudoku();
        for (int i = 0; i < possibleNumbers.length; i++)
        {
            int numeroCandidato = possibleNumbers[i];
            if (verificarNumeroCandidato(matrix, row, col, numeroCandidato))
            {
                matrix[row][col] = numeroCandidato;
                if (col == 8)
                {
                    if (completa_grade(row + 1, 0))
                    {
                        return true;
                    }
                }
                else if (completa_grade(row, col + 1))
                {
                    return true;
                }
            }
        }
        matrix[row][col] = 0;
        return false;
    }
    
    /** Inicia um novo jogo com uma semente aleatória baseada no timestamp do
     * computador
     * @author MaltonX
     * @return true se o jogo pode encontrar um quadro de sudoku adequado. false
     *         do contrário. */
    @Override
    public boolean newGame()
    {
        zerar();
        return completa_grade(0, 0);
    }
    
    /** Inicia um novo jogo com uma semente aleatória determinada
     * @author MaltonX
     * @return true se o jogo pode encontrar um quadro de sudoku adequado. false
     *         do contrário.
     * @param seed a semente aleatória usada para gerar o jogo. */
    @Override
    public boolean newGame(long seed)
    {
        r = new Random(seed);
        Semente = seed;
        //TODO Escolher aleatoriamente CAMPOS NA MATRIZ PARA esconder
        return newGame();
    }
    
    @Override
    public void preencherBotaoSudoku(int i, int j, int numeroCandidato)
    {
        if (verificarNumeroCandidato(matrix, i, j, numeroCandidato))
        {
            //TODO Preencher Matriz
        }
    }
    
    @Override
    public long exibeSemente()
    {
        return Semente;
    }
    
    private void prepararAMatrizProJogo(int difficulty)
    {
        for (int i = 0; i < difficulty; i++)
        {
            int row = r.nextInt(9);
            int col = r.nextInt(9);
            if (matrix[row][col] != 0)
            {
                matrix[row][col] = 0;
            }
            else
            {
                //FIXME Aqui pode dar um looping infinito
                i--;
            }
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    //Metodos IControllerModel
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void novoJogo(long seed, int difficulty)
    {
        //        System.out.println("Teste");
        this.Semente = seed;
        if (newGame(seed))
        {
            //            System.out.println("Teste IF");
            prepararAMatrizProJogo(difficulty);
            controller.novoJogoModel(matrix);
            controller.iniciarTimer();
        }
    }
}
