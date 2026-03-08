public class CartaDano {
    String nome;
    int custo;
    public CartaDano(String nome, int custo){
        this.nome = nome;
        this.custo = custo;
    }
    public void usar(Inimigo ruim){
        ruim.receberDano(custo * 3);
    }
}