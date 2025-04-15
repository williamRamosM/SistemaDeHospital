/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalgregory;

import java.util.ArrayList;

/**
 *
 * @author 2023326213
 */
class PacienteDAO {
    
    private Paciente objPaciente = new Paciente();
    private ArrayList <Paciente> arrayObjPaciente = new ArrayList<>();

    //CADASTRA O PACIENTE
    public void cadastrarPaciente(Paciente paciente){
        arrayObjPaciente.add(paciente);
    }

    //VERIFICAR SE TEM CADASTRO
    public boolean existirPaciente(){
        return !arrayObjPaciente.isEmpty();

        /*

        isEmpty retornará true se tiver vazio, nosso
        método pergunta se existe paciente, por isso
        negação na frente.

         */
    }

    //Buscar o Paciente
    public Paciente buscarPaciente(String cpf){
        for (int i = 0; i < arrayObjPaciente.size(); i++) {
            objPaciente = arrayObjPaciente.get(i);
            if (objPaciente.getCPF().equalsIgnoreCase(cpf)) {
                return objPaciente;
            }
        }
        return null;
    }
    //Buscar posição
    public int buscarPosicao(String cpf){
        for (int i = 0; i < arrayObjPaciente.size(); i++) {
            objPaciente = arrayObjPaciente.get(i);
            if (objPaciente.getCPF().equalsIgnoreCase(cpf)) {
                return i;
            }
        }
        return -2;
    }

    //Imprimir Paciente
    public String imprimirPaciente(String cpf){
        String texto;

        if (existirPaciente()){
            objPaciente = buscarPaciente(cpf);
            if (objPaciente != null){
                texto = objPaciente.toString();
            }
            else {
                texto = """
                        \n------------------
                        PACIENTE NÃO ENCONTRADO!
                        ------------------------
                        """;
            }
        }
        else {
            texto = """
                    \n------------------------
                    NÃO HÁ PACIENTES CADASTRADOS
                    ----------------------------
                    """;
        }

        return texto;
    }
    //LISTAR PACIENTE
    public String listarPaciente()
    {
        String texto = "";
        for(int i = 0; i < arrayObjPaciente.size(); i++)
        {
            objPaciente = arrayObjPaciente.get(i);

            texto = texto + objPaciente.toString()+"\n";
        }
        return texto;
    }
    //ALTERAR CADASTRO DO PACIENTE
    public void alterarPaciente(int posicao, Paciente paciente) {
        arrayObjPaciente.set(posicao,paciente);

    }

    //EXCLUIR PACIENTE
    public boolean excluirPaciente(String CPF){
        for (int i = 0; i < arrayObjPaciente.size(); i ++){
            objPaciente = arrayObjPaciente.get(i);
            if (objPaciente.getCPF().equalsIgnoreCase(CPF)){
                arrayObjPaciente.remove(i);
                return true;
            }
        }
        return false;

    }
}
