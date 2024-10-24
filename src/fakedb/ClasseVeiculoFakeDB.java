package fakedb;

import dominio.ClasseVeiculo;
import java.util.ArrayList;

public class ClasseVeiculoFakeDB extends BaseFakeDB<ClasseVeiculo>{

    @Override
    protected void preencherDados() {
        // this.tabela = new ArrayList<ClasseVeiculo>();
        this.tabela = new ArrayList<>();
        this.tabela.add(new ClasseVeiculo(1, "Fiat", "UNO", 2011, 21000));
        this.tabela.add(new ClasseVeiculo(2, "Chevrolet", "Corsa", 2002, 20000));
        this.tabela.add(new ClasseVeiculo(3, "Honda", "Civic", 2020, 80000));
    }
    
    public ClasseVeiculoFakeDB(){
        super();
    }
}
