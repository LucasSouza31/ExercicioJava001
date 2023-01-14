package youtube;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

        static int valorReferencia = 5;
       // static Produto produtos[]= new Produto[valorReferencia];
        static ArrayList<Produto> produtos= new ArrayList<>();
        // alterações foram feitas, declarando a variável "ler" globalmente, por conta de erros "NoSuchElementException"
        // erro acontecia porque estava fechando a variável responsável por ler dados do teclado, nesse caso o "ler.close()"
        static Scanner ler = new Scanner(System.in); 
        

        private static void menu(){
            System.out.println("BEM VINDO");
            System.out.println("1-REALIZAR COMPRA");
            System.out.println("2-ADICIONAR PRODUTOS AO ESTOQUE");
            System.out.println("3-EXIBIR RELATÓRIO DO ESTOQUE");
            System.out.println("4- SAIR");
            
            int selecionar= ler.nextInt();
            switch (selecionar) {
                case 1: comprarProduto(); break;
                case 2: abastecerOEstoque(); break;
                case 3: exibirEstoque(); break;
            
                default:
                    break;
            }
           
        }

    private static void comprarProduto() {                
        
                int codigoProduto;
                int quantidadeDesejada;
                double valorTotal;
        
        for(int i=0;i<produtos.size();i++){
            System.out.println("Nome: "+produtos.get(i).getNome()+" Código: "+i);
        }   

        System.out.println("Informar o códido do produto desejado: ");
        codigoProduto=ler.nextInt();
        System.out.println("Informar a quantidade desejada: ");
        quantidadeDesejada= ler.nextInt();

        if(quantidadeDesejada<=produtos.get(codigoProduto).getQuantidadeEmEstoque()){
            valorTotal=produtos.get(codigoProduto).getValor()*quantidadeDesejada;
            System.out.println("Valor total: "+valorTotal);
            produtos.get(codigoProduto).retirarDoEstoque(quantidadeDesejada);            
        }
        else{
            System.out.println("Não temos a quantidade solicitada!");
        }

        
        menu();
        }




    private static void abastecerOEstoque() {
                
                for(int i=0;i<produtos.size();i++){
                    System.out.println("Nome: "+produtos.get(i).getNome()+" Código: "+i);
                }              

                
                System.out.println("Informe o código do produto: ");
                int codigoProduto= ler.nextInt();
                System.out.println("Informe a quantidade que deseja adicionar: ");
                int quantidadeParaAdicionar= ler.nextInt();
                produtos.get(codigoProduto).adicionarAoEstoque(quantidadeParaAdicionar);
                
                menu();
        }

    private static void exibirEstoque() {
            for(int i=0;i<produtos.size();i++){
                System.out.println("Código do produto: "+i);
                produtos.get(i).relatorioDoEstoque();
                System.out.println("__________________");
            }
            menu();
        }
    




    public static void main(String[] args) {

        Produto p1= new Produto("Coca-Cola", 100, 9.9);
        Produto p2= new Produto("Guaraná", 100, 8.5);
        Produto p3= new Produto("Vodka", 100, 39.99);

        // produtos[0]=p1;
        // produtos[1]=p2;
        // produtos[2]=p3;

        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        menu();


    }
}
