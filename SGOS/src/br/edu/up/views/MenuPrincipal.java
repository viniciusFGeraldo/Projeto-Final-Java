package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.util.Prompt;

public class MenuPrincipal {
    MenuDeCadastro menuDeCadastro = new MenuDeCadastro();
    Scanner scanner = new Scanner(System.in);
    public void mostrarMenu(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastros");
        Prompt.imprimir("\t2 - Movimentação de Ordem de Serviço");
        Prompt.imprimir("\t3 - Relatórios");
        Prompt.imprimir("\t4 - Configuração");
        Prompt.imprimir("\t5 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                menuDeCadastro.menuCadastro();   
                break;
            case 2:
                //menuOrdemServico();
                break;
            case 3:
                //menuRelatorio();
                break;
            case 4:
                //menuConfiguração();
                break;
            case 5:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu(); 
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(5);
    }
    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        mostrarMenu();
    }
}


