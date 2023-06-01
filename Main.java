public class Main {
    public static void main(String[] args) {
        int[] lista = new int[500000000];
        for (int i = 0; i < 500000000; i++) {
            lista[i] = i + 1;
        }

        int alvo1 = 1;
        int alvo2 = 499999999;
        int alvo3 = 500000000;
        int alvo4 = -10;

        int posicao;

        // Teste para busca sequencial
        System.out.println("Busca Sequencial:");
        posicao = Busca.buscaSequencial(lista, alvo1);
        System.out.println("Indice para alvo 1: " + posicao);
        posicao = Busca.buscaSequencial(lista, alvo2);
        System.out.println("Indice para alvo 500000: " + posicao);
        posicao = Busca.buscaSequencial(lista, alvo3);
        System.out.println("Indice para alvo 1000000: " + posicao);
        posicao = Busca.buscaSequencial(lista, alvo4);
        System.out.println("Indice para alvo -10: " + posicao);

        // Teste para busca binária
        System.out.println("Busca Binaria:");
        posicao = Busca.buscaBinaria(lista, alvo1);
        System.out.println("Indice para alvo 1: " + posicao);
        posicao = Busca.buscaBinaria(lista, alvo2);
        System.out.println("Indice para alvo 500000: " + posicao);
        posicao = Busca.buscaBinaria(lista, alvo3);
        System.out.println("Indice para alvo 1000000: " + posicao);
        posicao = Busca.buscaBinaria(lista, alvo4);
        System.out.println("Indice para alvo -10: " + posicao);

        long[] duracoesSequencial = new long[4];
        long[] duracoesBinaria = new long[4];

        duracoesSequencial[0] = medirDuracao(() -> Busca.buscaSequencial(lista, alvo1));
        duracoesSequencial[1] = medirDuracao(() -> Busca.buscaSequencial(lista, alvo2));
        duracoesSequencial[2] = medirDuracao(() -> Busca.buscaSequencial(lista, alvo3));
        duracoesSequencial[3] = medirDuracao(() -> Busca.buscaSequencial(lista, alvo4));

        duracoesBinaria[0] = medirDuracao(() -> Busca.buscaBinaria(lista, alvo1));
        duracoesBinaria[1] = medirDuracao(() -> Busca.buscaBinaria(lista, alvo2));
        duracoesBinaria[2] = medirDuracao(() -> Busca.buscaBinaria(lista, alvo3));
        duracoesBinaria[3] = medirDuracao(() -> Busca.buscaBinaria(lista, alvo4));

        System.out.println("Duracoes da Busca Sequencial:");
        imprimirDuracoes(duracoesSequencial);

        System.out.println("Duracoes da Busca Binaria:");
        imprimirDuracoes(duracoesBinaria);
    }

    public static long medirDuracao(Runnable busca) {
        long inicio = System.nanoTime();
        busca.run();
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static void imprimirDuracoes(long[] duracoes) {
        for (int i = 0; i < duracoes.length; i++) {
            System.out.println("Duracao " + (i + 1) + ": " + duracoes[i] + " ns");
        }
    }
}
