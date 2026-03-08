import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Digite o nome do seu personagem");
        Scanner nome1 = new Scanner (System.in);
        String nome = nome1.nextLine();
        Heroi heroi1 = new Heroi(nome, 40, 5);
        Inimigo inimigo1 = new Inimigo("Cobrinha", 20, 5);
        CartaDano espada = new CartaDano("Espada de cobre", 2);
        CartaEscudo escudo = new CartaEscudo("Escudo de madeira", 1);
        int nCartasDano = 2, nCartasEscudo = 1, energia = 3;

        while (true) {
            energia = 3;
            System.out.println("\n=-=\nStatus:\n" + heroi1.nome + " (" + heroi1.vida + "/40 de vida) (" + heroi1.escudo + " de escudo)\nvs");
            System.out.printf("%s (%d/20 de vida) (%d de escudo)\n=-=\n\n", inimigo1.nome, inimigo1.vida, inimigo1.escudo);    /*status dos personagens */
            System.out.println("=-=\nAções:\n1 - Usar Carta de Dano\n2 - Usar Carta  de Escudo\n3 - Encerrrar turno\n=-=\n");
            
            if (heroi1.estarVivo() == false){
                System.out.println(heroi1.nome + " foi derrotado!\nVocê perdeu.");
                break;
            }else{
                if (inimigo1.estarVivo() == false){
                    System.out.println(inimigo1.nome + " foi derrotada!\nVocê venceu.");
                    break;
                }else{
                    while (energia > 0){        /*ação do heroi*/
                        System.out.println("=-=\nDeck:\nCartas de dano: " + nCartasDano + "\nCartas de escudo: " + nCartasEscudo + "\n=-=\n");
                        System.out.println("=-=\n" + energia + "/3 de Energia disponível\n=-=\n");
                        Scanner scanner = new Scanner (System.in);
                        int comando =  scanner.nextInt();
                        if (comando == 1){
                            if (energia < 2){
                                System.out.println("=-=\nSem energnia para realizar esta ação\n=-=\n");
                            }else if (nCartasDano > 0){
                                nCartasDano -= 1;
                                inimigo1.receberDano(10);
                                energia -= espada.custo;
                            }else{
                                System.out.println("=-=\nSem cartas de dano para realizar a ação\n=-=\n");
                            }
                        }else if (comando == 2){
                            if (nCartasEscudo > 0){
                                nCartasEscudo -= 1;
                                heroi1.ganharEscudo(5);
                                energia -= escudo.custo;
                            }else{
                                System.out.println("=-=\nSem cartas de escudo para realizar a ação\n=-=\n");
                            }
                        }else{
                            break;
                        }
                    }
                    heroi1.receberDano(10); /* Ataque do inimigo */
                    if (energia == 0 || energia == 1){
                        nCartasEscudo += 1;/*adicionar cartas no baralho */
                    }else{
                        nCartasDano += 1;
                    }
                }
            }
        }
    }
}