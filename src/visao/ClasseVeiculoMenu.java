package visao;

import dominio.ClasseVeiculo;
import java.util.ArrayList;
import servico.ClasseVeiculoServico;

public class ClasseVeiculoMenu extends BaseMenu {
    private ClasseVeiculoServico srv;

    public ClasseVeiculoMenu(){
        super();
        this.srv = new ClasseVeiculoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while(opcao != 9)
        {
            Util.ClearConsole();
            System.out.println("Classe Veiculo");
            System.out.println("Menu de Opções");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.ClearConsole();
        System.out.println("Listando...");

        ArrayList<ClasseVeiculo> lista = this.srv.LerTodos();
        for (ClasseVeiculo cv : lista) {
            this.ImprimirEmLinha(cv);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.ClearConsole();
        System.out.println("Localizando...");

        System.out.print("Informe o código da Classe de Veiculo: ");
        int codigo = this.scanner.nextInt();

        ClasseVeiculo cv = this.srv.Ler(codigo);
        if (cv != null){
            this.ImprimirEmLinha(cv);
        }
        else{
            System.out.println("Problema - Classe de Veiculo não foi encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.ClearConsole();
        System.out.println("Adicionando...");

        System.out.print("Informe a marca do veiculo: ");
        String marca = this.scanner.next();
        
        System.out.print("Informe o modelo do veiculo: ");
        String modelo = this.scanner.next();

        System.out.print("Informe o ano de fabricacao do veiculo: ");
        Integer anoDeFabricacao = this.scanner.nextInt();

        System.out.print("Informe o preco do veiculo: ");
        Double preco = this.scanner.nextDouble();


        ClasseVeiculo cv = new ClasseVeiculo();
        cv.setCodigo(0);
        cv.setMarca(marca);
        cv.setModelo(modelo);
        cv.setAnoDeFabricacao(anoDeFabricacao);
        cv.setPreco(preco);
        
        ClasseVeiculo cvnovo = this.srv.Criar(cv);
        if (cvnovo != null){
            System.out.println("Classe de Veiculo adicionada com sucesso");
        }
        else{
            System.out.println("Problema - Classe de Veiculo não foi adicionada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.ClearConsole();
        System.out.println("Atualizando...");

        System.out.print("Informe o código do Veiculo: ");
        int codigo = this.scanner.nextInt();

        ClasseVeiculo cv = this.srv.Ler(codigo);

        if (cv != null){
            System.out.print("Informe a nova marca do veiculo: ");
            String marca = this.scanner.next();
            
            System.out.print("Informe o novo modelo do veiculo: ");
            String modelo = this.scanner.next();

            System.out.print("Informe o novo ano de fabricacao do veiculo: ");
            Integer anoDeFabricacao = this.scanner.nextInt();

            System.out.print("Informe o novo preco do veiculo: ");
            Double preco = this.scanner.nextDouble();

            cv.setMarca(marca);
            cv.setModelo(modelo);
            cv.setAnoDeFabricacao(anoDeFabricacao);
            cv.setPreco(preco);

            if (this.srv.Atualizar(cv) != null){
                System.out.println("Classe de Veiculo autalizado com sucesso");
            }
            else{
                System.out.println("Problema - Classe de Veiculo não foi atualizado");
            }
        }
        else{
            System.out.println("Problema - Classe de Veiculo não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.ClearConsole();
        System.out.println("Removendo...");

        System.out.print("Informe o código do veiculo: ");
        int codigo = this.scanner.nextInt();

        ClasseVeiculo cv = this.srv.Ler(codigo);

        if (cv != null){
            if (this.srv.Deletar(codigo) != null){
                System.out.println("Classe de Veiculo removido com sucesso");
            }
            else{
                System.out.println("Problema - Classe de Veiculo não foi removido");
            }
        }
        else{
            System.out.println("Problema - Classe de Veiculo não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirEmLinha(ClasseVeiculo cv){
        String msg = "Classe de Veiculo - ";
        msg += "Código: " + cv.getCodigo() + " | ";
        msg += "Marca: " + cv.getMarca() + " | ";
        msg += "Modelo: " + cv.getModelo() + " | ";
        msg += "Ano de Fabricacao: " + cv.getAnoDeFabricacao() + " | ";
        msg += "Preco: " + cv.getPreco();
        
        System.out.println(msg);
    }    
    
}
