package youtube;

public class Produto {
    private String nome;
    private int quantidadeEmEstoque;
    private double valor;


    public Produto(String nome, int quantidadeEmEstoque, double valor) {
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.valor = valor;
    }

    public void verificarQuantidade(int quantidadeDesejada) {
        if(this.quantidadeEmEstoque<=quantidadeDesejada ) 
                    
    }
    
    public void adicionarAoEstoque(int quantidadeParaAdicionar) {
        this.quantidadeEmEstoque+=quantidadeParaAdicionar;
    }

    public void retirarDoEstoque(int quantidadeRetirada) {
        this.quantidadeEmEstoque-=quantidadeRetirada;
    }

    public void relatorioDoEstoque() {
        System.out.println("Nome: "+getNome());
        System.out.println("Quantidade: "+getQuantidadeEmEstoque());
        System.out.println("Valor unitário: "+getValor());
    }

    // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }




}
