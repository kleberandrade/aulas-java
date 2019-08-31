/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.aula;

import java.util.List;

/**
 *
 * @author pdjkl
 */
public class Mundo {
    
    private Celula[][] mapa;
    private List<Personagem> criaturas;
    private Jogador jogador;

    public Mundo(Celula[][] mapa, List<Personagem> criaturas) {
        this.mapa = mapa;
        this.criaturas = criaturas;
    }

    public boolean bloqueado(int x, int y) {
        return mapa[x][y].isBloqueado();
    }
    
    public void atualizar(){
        jogador.atualizar(this);
        for (Personagem criatura : criaturas) {
            criatura.atualizar(this);
            if (criatura.posicao.getX() == jogador.posicao.getX() && 
                criatura.posicao.getY() == jogador.posicao.getY()){
                jogador.tomarDano(1);
            } 
        }
    }
    
    public void desenhar(){
        for (int y = 0; y < mapa[0].length; y++) {
            for (int x = 0; x < mapa.length; x++) {
                System.out.print(mapa[x][y].simbolo);
            }
            System.out.println();
        }
    }
    
}
