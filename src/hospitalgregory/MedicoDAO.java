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
class MedicoDAO {
    
    private Medico objMedico = new Medico();
    private ArrayList<Medico> arrayObjMedico = new ArrayList<>();

    //CADASTRA O MEDICO
    public void cadastrarMedico(Medico medico){
        arrayObjMedico.add(medico);
    }

    //VERIFICAR SE TEM CADASTRO
    public boolean existirMedico(){
        return !arrayObjMedico.isEmpty();

        /*

        isEmpty retornará true se tiver vazio, nosso
        método pergunta se existe paciente, por isso
        negação na frente.

         */
    }

    //Buscar Medico
    public Medico buscarMedico(String CRM){
        for (int i = 0; i < arrayObjMedico.size(); i++) {
            objMedico = arrayObjMedico.get(i);
            if (objMedico.getCRM().equalsIgnoreCase(CRM)) {
                return objMedico;
            }
        }
        return  null;
    }
    //Buscar posição
    public int buscarPosicao(String CRM){
        for (int i = 0; i < arrayObjMedico.size(); i++) {
            objMedico = arrayObjMedico.get(i);
            if (objMedico.getCRM().equalsIgnoreCase(CRM)) {
                return i;
            }
        }
        return -2;
    }

    //Imprimir Medico
    public String imprimirMedico(String CRM){
        String texto;

        if (existirMedico()){
            objMedico = buscarMedico(CRM);
            if (objMedico != null){
                texto = objMedico.toString();
            }
            else {
                texto = """
                        \n------------------
                        MÉDICO NÃO ENCONTRADO!
                        ------------------------
                        """;
            }
        }
        else {
            texto = """
                    \n------------------------
                    NÃO HÁ MÉDICOS CADASTRADOS
                    ----------------------------
                    """;
        }

        return texto;
    }

    //ALTERAR CADASTRO DA CONSULTA
    public void alterarMedico(int posicao, Medico medico) {
        arrayObjMedico.set(posicao,medico);

    }

    // LISTAR MEDICOS
    public String listarMedico()
    {
        String texto = "";

        for (int i = 0; i < arrayObjMedico.size(); i++){
            objMedico = arrayObjMedico.get(i);

            texto = texto + objMedico.toString()+"\n";
        }
        return texto;
    }

    //EXCLUIR MEDICO
    public boolean excluirMedico(String CRM){
        for (int i = 0; i < arrayObjMedico.size(); i ++){
            objMedico = arrayObjMedico.get(i);
            if (objMedico.getCRM().equalsIgnoreCase(CRM)){
                arrayObjMedico.remove(i);
                return true;
            }
        }
        return false;
    }
}
