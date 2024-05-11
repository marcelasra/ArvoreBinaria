package arvorebinaria;

import java.util.Set;

public class ArvoreAB {

    private No raiz;

    public ArvoreAB() {
        this.raiz = null;
    }

    public boolean ehNoVazio(No aux) {
        return (aux == null);
    }

    public boolean insereNo(double valor) {
        if (ehNoVazio(raiz)) {
            No aux = new No(valor);
            this.raiz = aux;
            return true;
        } else {
            return insere(valor, this.raiz);
        }
    }

    private boolean insere(double valor, No temp) {
        if ((valor > temp.getValor()) && (temp.getDireita() == null)) {
            No aux = new No(valor);
            temp.setDireita(aux);
            return true;
        } else if ((valor > temp.getValor()) && (temp.getDireita() != null)) {
            return insere(valor, temp.getDireita());
        } else if ((valor < temp.getValor()) && (temp.getEsquerda() == null)) {
            No aux = new No(valor);
            temp.setEsquerda(aux);
            return true;
        } else if ((valor < temp.getValor()) && (temp.getEsquerda() != null)) {
            return insere(valor, temp.getEsquerda());
        } else {
            return false;
        }
    }

    public void printPrecurso() {
        precurso(this.raiz);
    }

    private void precurso(No temp) {
        System.out.println(temp.getValor());
        if (temp.getEsquerda() != null) {
            precurso(temp.getEsquerda());
        }
        if (temp.getDireita() != null) {
            precurso(temp.getDireita());
        }
    }

    public void printIncurso() {
        incurso(this.raiz);
    }

    private void incurso(No temp) {
        if (temp.getDireita() != null) {
            precurso(temp.getDireita());
        }
        System.out.println(temp.getValor());
        if (temp.getEsquerda() != null) {
            precurso(temp.getEsquerda());
        }

    }

    public void removeGrau0(double valor) {

    }

    private boolean ehFolha(No temp) { //sem ligação pela direita ou esquerda
        return ((temp.getDireita() == null) && (temp.getEsquerda() == null));
    }

    public void recRemoveGrau0(No temp, double valor) {
        if ((valor == temp.getDireita().getValor()) && (ehFolha(temp.getDireita()))) {
            No aux = temp.getDireita();
            aux = null;
            temp.setDireita(null);
        } else if ((valor == temp.getEsquerda().getValor()) && (ehFolha(temp.getEsquerda()))) {
            No aux = temp.getEsquerda();
            aux = null;
            temp.setEsquerda(null);
        }
    }

    private boolean ehGrau1(No temp) {
        return ((temp.getDireita() == null) ^ (temp.getEsquerda() == null));
    }

    private void recRemoveGrau1(No temp, double valor) {
        if ((temp.getDireita().getValor() == valor) && (ehGrau1(temp.getDireita()))) {
            if (temp.getDireita().getDireita() != null) {
                No aux = temp.getDireita();
                temp.setDireita(aux.getDireita());
                aux = null;
            } else {
                No aux = temp.getDireita();
                temp.setDireita(aux.getEsquerda());
                aux = null;
            }
        } else if ((temp.getEsquerda().getValor() == valor) && (ehGrau1(temp.getEsquerda()))) {
            if (temp.getEsquerda().getEsquerda() != null) {
                No aux = temp.getEsquerda();
                temp.setEsquerda(aux.getEsquerda());
                aux = null;
            } else {
                No aux = temp.getEsquerda();
                temp.setEsquerda(aux.getDireita());
                aux = null;
            }
        }
    }
    
    private No maior(No temp){
        if (temp.getDireita() != null){
           return maior(temp.getDireita());
        }else{
            return temp;
        }
    }
    private boolean ehGrau2 (No temp) {
        return ((temp.getDireita() != null) && (temp.getEsquerda() != null));
    }
    
    private void recRemoveGrau2(No temp, double valor){
        if((temp.getDireita().getValor() == valor) && ehGrau2(temp.getDireita())){
            No aux = maior (temp.getEsquerda());
            temp.getDireita().setValor(aux.getValor());
        }
    }else if(temp.getEsquerda().getValor() == valor && ehGrau2(temp.getEsquerda())){
        No aux = maior(temp.getEsquerda().getEsquerda());
    }
    
    
}
