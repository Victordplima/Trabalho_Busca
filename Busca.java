public class Busca {
    public static int buscaSequencial(int[] lista, int alvo) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == alvo) {
                return i; // Retorna a posição do alvo na lista
            }
        }
        return -1; // Retorna -1 se o alvo não estiver na lista
    }

    public static int buscaBinaria(int[] lista, int alvo) {
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (lista[meio] == alvo) {
                return meio; // Retorna a posição do alvo na lista
            }

            if (lista[meio] < alvo) {
                inicio = meio + 1; // Busca na metade superior da lista
            } else {
                fim = meio - 1; // Busca na metade inferior da lista
            }
        }

        return -1; // Retorna -1 se o alvo não estiver na lista
    }
}
