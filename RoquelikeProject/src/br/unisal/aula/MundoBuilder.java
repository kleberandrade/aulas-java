package br.unisal.aula;

import java.util.ArrayList;
import java.util.List;

public class MundoBuilder {
    
    private int largura, altura;
    private Celula[][] mapa;
    private List<Personagem> criaturas;

    public MundoBuilder(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        
    }
    
    MundoBuilder preencher(char simbolo, boolean bloqueado){
        mapa = new Celula[largura][altura];
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                Ponto2D posicao = new Ponto2D(x, y);
                mapa[x][y] = new Celula(bloqueado, posicao, simbolo);
            }
        }
        return this;
    }
    
    MundoBuilder criarCaminho(int x, int y, int passos){
        mapa[x][y].setSimbolo('.');
        mapa[x][y].setBloqueado(false);
        
        for (int i = 0; i < passos; i++) {
            int direcao = (int)(Math.random() * 1000) % 4;
            if      (direcao == 0 && (x + 1) < largura - 1) x++;
            else if (direcao == 1 && (x - 1) > 0) x--;
            else if (direcao == 2 && (y + 1) < altura - 1) y++;
            else if (direcao == 3 && (y - 1) > 0) y--;
            
           mapa[x][y].setSimbolo('.');
           mapa[x][y].setBloqueado(false);
        }
        
        return this;
    }
    
    public Mundo build(){
        return new Mundo(mapa, new ArrayList<Personagem>());
    }
}
