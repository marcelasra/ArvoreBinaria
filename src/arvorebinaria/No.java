package arvorebinaria;

public class No {
    
    private double valor;
    private No esquerda; 
    private No direita; 
    
    public No(double valor) {
        this.valor = valor; 
        this.esquerda = null; 
        this.direita = null; 
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
    
    
}
