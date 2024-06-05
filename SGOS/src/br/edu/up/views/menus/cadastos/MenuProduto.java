package br.edu.up.views.menus.cadastos;

import java.util.List;

import br.edu.up.controllers.ControleDeProduto;
import br.edu.up.models.Produto;
import br.edu.up.util.Prompt;

public class MenuProduto {
    ControleDeProduto controleDeProduto = new ControleDeProduto();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE PRODUTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar produto");
        Prompt.imprimir("\t2 - Listar produtos");
        Prompt.imprimir("\t3 - Alterar produto");
        Prompt.imprimir("\t4 - Deletar produto");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.limparConsole();
        boolean sair = false;

        switch (opcao1) {
            case 1:
                cadastrarProduto();
                break;
            case 2:
                List<Produto> produtos = controleDeProduto.getProdutos();
                if(produtos.isEmpty()){
                    Prompt.imprimir("Não há produtos cadastrados.");
                }else{
                    for (Produto produto : produtos) {
                        Prompt.imprimir(produto.toStringBasico());
                    }
                }
                break;
            case 3:
                Integer idAlterado = getId();
                Produto produtoAlterado = alterarProduto();
                controleDeProduto.alterarProduto(idAlterado, produtoAlterado);
                break;
            case 4:
                Integer idDeletar = getId();
                controleDeProduto.deletarProduto(idDeletar);
                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if(!sair){
            Prompt.separador();
            Prompt.pressionarEnter();
            mostrar();
        }
    }

    public Produto cadastrarProduto(){

        Integer produtoId = controleDeProduto.getProximoId();
        String nomeProduto = lerNomeProduto();
        String descrição = Prompt.lerLinha("Informe a descrição do Produto: ");
        
        Produto produto = new Produto(produtoId, nomeProduto, descrição);
        controleDeProduto.adicionarProduto(produto);
        return produto;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Produto alterarProduto(){
        
        
        String nomeProduto = lerNomeProduto();
        String descricao = Prompt.lerLinha("Informe a descrição do Produto: ");

        Produto produtoAlterado = new Produto(nomeProduto,descricao);
        
        return produtoAlterado;
    }

    private String lerNomeProduto() {
        while (true) {
            String nomeProduto = Prompt.lerLinha("Informe o nome do produto: ");
            try {
                Produto produto = new Produto();
                produto.setNomeProduto(nomeProduto);
                return nomeProduto;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }
}