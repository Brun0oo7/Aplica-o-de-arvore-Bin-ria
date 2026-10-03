import java.util.Scanner;

class Nodo {
    char caractere;
    Nodo esquerdo, direito;
}

class ArvoreBinariaMorse {
    Nodo raiz = new Nodo();

    void inserir(String morse, char caractere) {
        Nodo atual = raiz;
        for (char s : morse.toCharArray()) {
            if (s == '.') {
                if (atual.esquerdo == null) atual.esquerdo = new Nodo();
                atual = atual.esquerdo;
            } else {
                if (atual.direito == null) atual.direito = new Nodo();
                atual = atual.direito;
            }
        }
        atual.caractere = caractere;
    }

    char buscar(String morse) {
        Nodo atual = raiz;
        for (char s : morse.toCharArray()) {
            atual = (s == '.') ? atual.esquerdo : atual.direito;
            if (atual == null) return '?';
        }
        return atual.caractere;
    }

    String buscarMorse(Nodo no, char c, String caminho) {
        if (no == null) return null;
        if (no.caractere == c) return caminho;
        String r = buscarMorse(no.esquerdo, c, caminho + ".");
        if (r != null) return r;
        return buscarMorse(no.direito, c, caminho + "-");
    }

    void exibir(Nodo no, String recuo, String ramo) {
        if (no == null) return;
        System.out.println(recuo + ramo + " " + no.caractere);
        exibir(no.esquerdo, recuo + "    ", ".");
        exibir(no.direito, recuo + "    ", "-");
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        String[] tabela = {"A .-", "B -...", "C -.-.", "D -..", "E .", "F ..-.", "G --.", "H ....",
                "I ..", "J .---", "K -.-", "L .-..", "M --", "N -.", "O ---", "P .--.", "Q --.-",
                "R .-.", "S ...", "T -", "U ..-", "V ...-", "W .--", "X -..-", "Y -.--", "Z --..",
                "0 -----", "1 .----", "2 ..---", "3 ...--", "4 ....-", "5 .....", "6 -....",
                "7 --...", "8 ---..", "9 ----."};
        for (String t : tabela) {
            String[] p = t.split(" ");
            arvore.inserir(p[1], p[0].charAt(0));
        }

        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1 - Exibir arvore");
            System.out.println("2 - Buscar letra/numero");
            System.out.println("3 - Digitar mensagem em morse");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt(sc.nextLine().trim());

            if (opcao == 1) {
                arvore.exibir(arvore.raiz.esquerdo, "", ".");
                arvore.exibir(arvore.raiz.direito, "", "-");
            } else if (opcao == 2) {
                System.out.print("Letra ou numero: ");
                char c = sc.nextLine().trim().toUpperCase().charAt(0);
                String morse = arvore.buscarMorse(arvore.raiz, c, "");
                System.out.println(morse == null ? "Nao encontrado" : morse);
            } else if (opcao == 3) {
                System.out.print("Mensagem em morse (separe as letras com espaco): ");
                String mensagem = "";
                for (String codigo : sc.nextLine().trim().split(" ")) {
                    mensagem += arvore.buscar(codigo);
                }
                System.out.println(mensagem);
            }
        } while (opcao != 0);
    }
}