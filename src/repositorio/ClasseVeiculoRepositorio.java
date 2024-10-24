package repositorio;
import dominio.ClasseVeiculo;
import fakedb.ClasseVeiculoFakeDB;

public class ClasseVeiculoRepositorio extends BaseRepositorio<ClasseVeiculo>{
    private ClasseVeiculoFakeDB db;

    public ClasseVeiculoRepositorio(){
        this.db = new ClasseVeiculoFakeDB();
        this.fonteDeDados = this.db.getTabela();
    }

    @Override
    public ClasseVeiculo Create(ClasseVeiculo instancia) {
        int proxChave = this.fonteDeDados.get(this.fonteDeDados.size() - 1).getCodigo() + 1;       
        instancia.setCodigo(proxChave);
        this.fonteDeDados.add(instancia);
        return instancia;
    }

    @Override
    public ClasseVeiculo Read(int chave) {
        for (ClasseVeiculo cv : fonteDeDados) {
            if(cv.getCodigo() == chave){
                return cv;
            }
        }
        return null;
    }

    @Override
    public ClasseVeiculo Update(ClasseVeiculo instancia) {
        ClasseVeiculo cv = this.Read(instancia.getCodigo());
        if(cv != null){
            cv.setMarca(instancia.getMarca());
            cv.setModelo(instancia.getModelo());
            cv.setAnoDeFabricacao(instancia.getAnoDeFabricacao());
            cv.setPreco(instancia.getPreco());
            return cv;
        }else{
            return null;
        }
    }

    @Override
    public ClasseVeiculo Delete(int chave) {
        ClasseVeiculo cv = this.Read(chave);
        if(cv != null){
            this.fonteDeDados.remove(cv);
            return cv;
        }else{
            return null;
        }
    }
    
}
