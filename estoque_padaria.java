import java.util.InputMismatchException;
import java.util.Scanner;

public class estoque_padaria {
    public static void main(String[] args) {

        // Variáveis
        int paes = 0, bombasChoco = 0, palitosChoco = 0, coxinhas = 0, cafe = 0, leite = 0;
        int paesV = 0, bombasV = 0, palitosV = 0, coxinhasV = 0, cafeV = 0, leiteV = 0;
        int paesF, bombasF, palitosF, coxinhasF, cafeF, leiteF;

        // Se a variável tiver V no fim → vendida
        // Se tiver F → estoque final

        String resposta;
        boolean aberta, fechada;

        Scanner leitor = new Scanner(System.in);

        // Loop para garantir entrada correta
        while (true) {
            System.out.println("A padaria irá abrir hoje? (Sim/Não)");
            resposta = leitor.nextLine().trim();

            if (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("não")) {
                break;
            } else {
                System.out.println("Erro! Digite 'Sim' ou 'Não'.\n");
            }
        }

        aberta = resposta.equalsIgnoreCase("sim");
        fechada = resposta.equalsIgnoreCase("não");

        if (aberta) {

            System.out.println(
                    "Informe o estoque inicial dos itens, nesta ordem:\n" +
                            "Pães, Bombas de chocolate, Palitos de chocolate, Coxinhas, Café e Leite:"
            );

            // Tratamento para entrada inválida
            while (true) {
                try {
                    paes = leitor.nextInt();
                    bombasChoco = leitor.nextInt();
                    palitosChoco = leitor.nextInt();
                    coxinhas = leitor.nextInt();
                    cafe = leitor.nextInt();
                    leite = leitor.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Digite apenas números inteiros.\n");
                    leitor.nextLine();
                    System.out.println("Tente novamente:");
                }
            }

            System.out.println(
                    "\nAgora informe quantas unidades foram VENDIDAS, na mesma ordem:"
            );

            while (true) {
                try {
                    paesV = leitor.nextInt();
                    bombasV = leitor.nextInt();
                    palitosV = leitor.nextInt();
                    coxinhasV = leitor.nextInt();
                    cafeV = leitor.nextInt();
                    leiteV = leitor.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Digite apenas números inteiros.\n");
                    leitor.nextLine();
                    System.out.println("Tente novamente:");
                }
            }

            // Verificação se há mais vendas do que estoque
            while (paes < paesV || bombasChoco < bombasV || palitosChoco < palitosV ||
                    coxinhas < coxinhasV || cafe < cafeV || leite < leiteV) {

                System.out.println(
                        "\nErro! Quantidade vendida maior que a quantidade em estoque.\n" +
                                "Digite novamente as unidades vendidas:"
                );

                while (true) {
                    try {
                        paesV = leitor.nextInt();
                        bombasV = leitor.nextInt();
                        palitosV = leitor.nextInt();
                        coxinhasV = leitor.nextInt();
                        cafeV = leitor.nextInt();
                        leiteV = leitor.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Erro! Digite apenas números inteiros.\n");
                        leitor.nextLine();
                        System.out.println("Tente novamente:");
                    }
                }
            }

            // Cálculos finais
            paesF = paes - paesV;
            bombasF = bombasChoco - bombasV;
            palitosF = palitosChoco - palitosV;
            coxinhasF = coxinhas - coxinhasV;
            cafeF = cafe - cafeV;
            leiteF = leite - leiteV;

            System.out.printf(
                    "\nEstoque final do dia:\n" +
                            "Pães: %d\nBombas de chocolate: %d\nPalitos de chocolate: %d\n" +
                            "Coxinhas: %d\nCafé: %d\nLeite: %d\n",
                    paesF, bombasF, palitosF, coxinhasF, cafeF, leiteF
            );

        } else if (fechada) {
            System.out.println("A PãoTech não abrirá hoje.");
        }

        leitor.close();
    }
}
