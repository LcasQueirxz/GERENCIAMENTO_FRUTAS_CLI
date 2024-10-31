package frutas;

import java.util.ArrayList; // Importando a classe ArrayList para criar listas dinâmicas
import java.util.InputMismatchException; // Importando a classe para tratar exceções de entrada inválida
import java.util.Scanner; // Importando a classe Scanner para ler entradas do usuário

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Instanciando a classe Scanner para ler entradas do usuário
        ArrayList<String> frutas = new ArrayList<>(); // Instanciando a classe ArrayList para armazenar frutas

        while (true) {
            try {
                // Exibindo o menu de opções
                System.out.println("\nEscolha uma opcao:");
                System.out.println("1. Adicionar uma fruta");
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Modificar uma fruta");
                System.out.println("4. Remover uma fruta");
                System.out.println("5. Sair");
                System.out.print("Opção: ");
                
                int opcao = scanner.nextInt(); // Lendo a opção escolhida pelo usuário
                scanner.nextLine(); // Limpando o buffer

                switch (opcao) {
                    case 1:
                        // Adicionando uma nova fruta
                        System.out.print("Digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine();
                        frutas.add(novaFruta);
                        System.out.println(novaFruta + " foi adicionada.");
                        break;
                    case 2:
                        // Listando todas as frutas
                        System.out.println("Frutas:");
                        for (String fruta : frutas) {
                            System.out.println(fruta);
                        }
                        break;
                    case 3:
                        // Modificando uma fruta existente
                        System.out.print("Digite o indice da fruta que deseja modificar: ");
                        int indiceModificar = scanner.nextInt();
                        scanner.nextLine(); // Limpando o buffer
                        if (indiceModificar >= 0 && indiceModificar < frutas.size()) {
                            System.out.print("Digite o novo nome da fruta: ");
                            String frutaModificada = scanner.nextLine();
                            frutas.set(indiceModificar, frutaModificada);
                            System.out.println("Fruta no indice " + indiceModificar + " foi modificada para " + frutaModificada);
                        } else {
                            System.out.println("indice inválido.");
                        }
                        break;
                    case 4:
                        // Removendo uma fruta
                        System.out.print("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine();
                        if (frutas.remove(frutaRemover)) {
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " não foi encontrada.");
                        }
                        break;
                    case 5:
                        // Saindo do programa
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        // Tratando opção inválida
                        System.out.println("Opção invalida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Tratando entrada inválida
                System.out.println("Entrada invalida. Por favor, digite um numero.");
                scanner.nextLine(); // Limpando o buffer
            }
        }
    }
}
