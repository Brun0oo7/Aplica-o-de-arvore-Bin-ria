# Aplica-o-de-arvore-Bin-ria

Aluno: Bruno da Costa Mattos Bonacordi

Programa em Java que monta uma arvore binaria com as letras de A a Z e os numeros de 0 a 9 do codigo Morse.

Ponto (.) vai para o filho esquerdo e traço (-) vai para o filho direito. O caminho da raiz ate um no e o codigo Morse do caractere que esta nele.

## Classes

- Nodo: guarda um caractere e os filhos esquerdo e direito.
- ArvoreBinariaMorse: tem a raiz e os metodos inserir, buscar, buscarMorse e exibir.
- Main: insere todos os caracteres automaticamente e mostra o menu.

## Metodos

- inserir(morse, caractere): percorre o codigo criando os nos que faltam e coloca o caractere no ultimo no.
- buscar(morse): segue o caminho e devolve o caractere.
- buscarMorse(no, caractere, caminho): procura o caractere na arvore e devolve o codigo Morse dele.
- exibir(no, recuo, ramo): mostra a arvore com mais recuo a cada nivel.

## Como executar

javac Main.java\
java Main

## Menu

1 - Exibir arvore\
2 - Buscar letra/numero (retorna o codigo Morse)\
3 - Digitar mensagem em morse (retorna o texto)\
0 - Sair

Na opcao 3, separe as letras com espaco. Exemplo: ... --- ... vira SOS.
