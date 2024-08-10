package Exer1;

import java.util.*;
import java.util.stream.Collectors;

public class Exercicio1 {
    public static void main(String[] args){
        System.out.println("Cores: ");
        Set<String> cores = new HashSet<>(Arrays.asList
                ("Laranja", "Vermelho", "Azul", "Verde", "Roxo", "Amarelo", "Indigo"));
        System.out.println(cores.toString());

        System.out.println("Total de cores: " + cores.size());

        Set<String> coresOrdenadas = new TreeSet<>(cores);
        System.out.println("Cores em ordem: ");
        System.out.println(coresOrdenadas);

        System.out.println("Ordem Inversa: ");
        List<String> list = new ArrayList<>(coresOrdenadas);
        Collections.sort(list, Collections.reverseOrder());
        Set<String> resultado = new LinkedHashSet<>(list);
        System.out.println(resultado);

        System.out.println("Filtro V: ");
        String filtroV = cores.stream().filter(v -> v.startsWith("V")).
                collect(Collectors.joining(", ", "[","]"));
        System.out.println(filtroV);

        System.out.println("Removedor não V: ");
        Iterator<String> coresRemover = cores.iterator();
        while (coresRemover.hasNext()){
            String letra = coresRemover.next();
            if (letra.startsWith("V")){
            } else {coresRemover.remove();}
        }
        System.out.println(cores);

        System.out.println("Limpa tudo");
        cores.clear();

        System.out.println("Cores esta vazio: " + cores.isEmpty());
    }
}
