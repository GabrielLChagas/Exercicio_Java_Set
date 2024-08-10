package Exer2;

import java.util.*;

public class Exercicio2 {
    public static void main(String[] args){

        Set<linguagems> minhasLinguagensFavoritas = new HashSet<>(){{
            add(new linguagems("Java", 1995, "NetBeans"));
            add(new linguagems("C#", 2000, "VisualStudio"));
            add(new linguagems("Python", 1991, "Jupyter"));
        }};

        Set<linguagems> lFInsercao = new LinkedHashSet<>(minhasLinguagensFavoritas);
        System.out.println("Ordem de inserção: ");
        for (linguagems ling: lFInsercao)
            System.out.println(ling.getNome() +
                    " - " + ling.getAnoDeCriacao() +
                    " - " + ling.getIde());



        System.out.println("\nOrdem nome: ");
        Set<linguagems> lFNatural = new TreeSet<>(minhasLinguagensFavoritas);
        for (linguagems ling: lFNatural)
            System.out.println(ling.getNome() +
                    " - " + ling.getAnoDeCriacao() +
                    " - " + ling.getIde());


        System.out.println("\nOrdem ide: ");
        Set<linguagems> lF_IDE = new TreeSet<linguagems>(new comparatorIde());
        lF_IDE.addAll(minhasLinguagensFavoritas);
        for (linguagems ling: lF_IDE)
            System.out.println(ling.getNome() +
                    " _ " + ling.getAnoDeCriacao() +
                    " _ " + ling.getIde());

        System.out.println("\nOrdem ano e nome: ");
        Set<linguagems> lFAnoNome = new TreeSet<linguagems>(new comparatorAnoNome());
        lFAnoNome.addAll(minhasLinguagensFavoritas);
        for (linguagems ling: lFAnoNome)
            System.out.println(ling.getNome() +
                    " _ " + ling.getAnoDeCriacao() +
                    " _ " + ling.getIde());

        System.out.println("\nOrdem nome, ano e ide");
        Set<linguagems> lFNomeAnoIde = new TreeSet<linguagems>(new comparatorNomeAnoIde());
        lFNomeAnoIde.addAll(minhasLinguagensFavoritas);
        for (linguagems ling: lFNomeAnoIde)
            System.out.println(ling.getNome() +
                    " _ " + ling.getAnoDeCriacao() +
                    " _ " + ling.getIde());
    }
}
class linguagems implements Comparable<linguagems>{
    public String nome;
    public Integer anoDeCriacao;
    public String ide;

    public linguagems(String nome, Integer anoDeCriacao, String ide){
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(linguagems ling) {
        return this.getNome().compareTo(ling.getNome());
    }

}

class comparatorIde implements Comparator<linguagems>{

    @Override
    public int compare(linguagems lF1, linguagems lF2) {
        return lF1.ide.compareToIgnoreCase(lF2.ide);
    }
}

class comparatorAnoNome implements Comparator<linguagems>{
    @Override
    public int compare(linguagems o1, linguagems o2) {

        int ano = Integer.compare(o1.getAnoDeCriacao(), o2.anoDeCriacao);
        if (ano != 0) return ano;

        return o1.getNome().compareTo(o2.getNome());
    }
}

class comparatorNomeAnoIde implements Comparator<linguagems>{

    @Override
    public int compare(linguagems o1, linguagems o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;

        int ano = Integer.compare(o1.anoDeCriacao, o2.anoDeCriacao);
        if (ano != 0) return ano;

        return o1.getIde().compareTo(o2.getIde());
    }
}