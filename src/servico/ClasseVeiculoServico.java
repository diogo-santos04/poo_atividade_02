package servico;

import dominio.ClasseVeiculo;
import java.util.ArrayList;
import repositorio.ClasseVeiculoRepositorio;

public class ClasseVeiculoServico extends BaseServico<ClasseVeiculo> {
    private ClasseVeiculoRepositorio repositorio;
    
    public ClasseVeiculoServico(){
        this.repositorio = new ClasseVeiculoRepositorio();
    }
    @Override
    public ClasseVeiculo Criar(ClasseVeiculo obj) {
        return this.repositorio.Create(obj);
    }

    @Override
    public ArrayList<ClasseVeiculo> LerTodos() {
        return this.repositorio.ReadAll();
    }

    @Override
    public ClasseVeiculo Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public ClasseVeiculo Atualizar(ClasseVeiculo obj) {
        return this.repositorio.Update(obj);
    }

    @Override
    public ClasseVeiculo Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
