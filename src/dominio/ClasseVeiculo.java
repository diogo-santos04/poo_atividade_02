package dominio;

public class ClasseVeiculo extends BaseVeiculo {
   public ClasseVeiculo(){
        super();
    }

    public ClasseVeiculo(int codigo, String marca, String modelo, int anoDeFabricacao, double preco) {
        super(codigo, marca, modelo, anoDeFabricacao, preco);
    }
}
