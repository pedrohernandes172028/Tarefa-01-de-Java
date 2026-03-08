public class CartaEscudo {
    String nome;
    int custo;
    public CartaEscudo(String nome, int custo){
        this.nome = nome;
        this.custo = custo;
    }
    public void usar(Heroi bom){
        bom.ganharEscudo(custo * 2);
    }
}