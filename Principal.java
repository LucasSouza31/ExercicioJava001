package youtube;

import java.util.Scanner;

public class Principal {

        static int valorReferencia = 5;
        static Produto produtos[]= new Produto[valorReferencia];
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
        
        for(int i=0;i<3;i++){
            System.out.println("Nome: "+produtos[i].getNome()+" Código: "+i);
        }   

        System.out.println("Informar o códido do produto desejado: ");
        codigoProduto=ler.nextInt();
        System.out.println("Informar a quantidade desejada: ");
        quantidadeDesejada= ler.nextInt();

        if(quantidadeDesejada<=produtos[codigoProduto].getQuantidadeEmEstoque()){
            valorTotal=produtos[codigoProduto].getValor()*quantidadeDesejada;
            System.out.println("Valor total: "+valorTotal);
            produtos[codigoProduto].retirarDoEstoque(quantidadeDesejada);            
        }

        
        menu();
        }




    private static void abastecerOEstoque() {
                
                for(int i=0;i<3;i++){
                    System.out.println("Nome: "+produtos[i].getNome()+" Código: "+i);
                }              

                
                System.out.println("Informe o código do produto: ");
                int codigoProduto= ler.nextInt();
                System.out.println("Informe a quantidade que deseja adicionar: ");
                int quantidadeParaAdicionar= ler.nextInt();
                produtos[codigoProduto].adicionarAoEstoque(quantidadeParaAdicionar);
                
                menu();
        }

    private static void exibirEstoque() {
            for(int i=0;i<3;i++){
                System.out.println("Código do produto: "+i);
                produtos[i].relatorioDoEstoque();
                System.out.println("__________________");
            }
            menu();
        }
    




    public static void main(String[] args) {

        Produto p1= new Produto("Coca-Cola", 100, 9.9);
        Produto p2= new Produto("Guaraná", 100, 8.5);
        Produto p3= new Produto("Vokda", 100, 39.99);

        produtos[0]=p1;
        produtos[1]=p2;
        produtos[2]=p3;

        menu();


    }
}
