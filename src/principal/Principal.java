package principal;

import arvorebinaria.ArvoreAB;


public class Principal {
    
    public static void main(String[] args) {
        
        ArvoreAB arvore = new ArvoreAB();
        
        arvore.insereNo(50);
        arvore.insereNo(25);
        arvore.insereNo(75);
        arvore.insereNo(35);
        arvore.insereNo(40);
        arvore.insereNo(30);
        
        arvore.insereNo(30);
        
        arvore.printPrecurso();
        
        
    }
}
