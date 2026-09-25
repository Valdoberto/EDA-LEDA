package testes.menor;

import java.util.*;

public class MenorDoArray {

    private List<Integer> elementos;
    private int ehMenor;
    

    public MenorDoArray() {
        this.elementos = new ArrayList<>();
        this.ehMenor = 0;
    }

    public void addElemento(int e){
        elementos.add(e);
    }

    public int mostrarMenorElemento(){
        System.out.println(ehMenor);
    }

    @Override
    public String toString() {
        return "Testando VSCode";
    }

}
