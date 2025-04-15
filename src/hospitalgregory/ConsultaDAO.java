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
class ConsultaDAO {
    
    private Consulta objConsulta = new Consulta();
    private ArrayList<Consulta> arrayObjConsulta = new ArrayList <>();

    //Cadastrar consulta
    public void cadastrarConsulta(Consulta consulta){
        arrayObjConsulta.add(consulta);
    }

    //Verificar se existe consulta
    public boolean existirConsulta(){
        return !arrayObjConsulta.isEmpty();

        /*

        isEmpty retornará true se tiver vazio, nosso
        método pergunta se existe paciente, por isso
        negação na frente.

         */
    }

    //Buscar consulta
    public Consulta buscarConsulta(String codigo){
        for (int i = 0; i < arrayObjConsulta.size(); i++){
            objConsulta = arrayObjConsulta.get(i);
            if (objConsulta.getCodigo().equalsIgnoreCase(codigo)){
                return objConsulta;
            }
        }
        return null;
    }
    //Buscar posiçao
    public int buscarPosicao(String codigo){
        for (int i = 0; i < arrayObjConsulta.size(); i++) {
            objConsulta = arrayObjConsulta.get(i);
            if (objConsulta.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -2;
    }

    //ALTERAR CADASTRO DA CONSULTA
    public void alterarConsulta(int posicao, Consulta consulta) {
        arrayObjConsulta.set(posicao, consulta);
    }

    //Listar Consultas por Médico
    public String listarConsulta(String medicoCRM){
        String texto = "";

        if (existirConsulta()){

            for (int i = 0; i < arrayObjConsulta.size(); i ++) {
                objConsulta = arrayObjConsulta.get(i);

                if (medicoCRM.equalsIgnoreCase(objConsulta.getCRM())) {
                    texto = texto + objConsulta.toString()+"\n";
                }

            }
        }
        else
        {
            texto = """
          \n------------------------
            NÃO HÁ CONSULTAS CADASTRADAS
            ----------------------------
          """;
        }

        return  texto;
    }

    //Imprimir CONSULTA
    public String imprimirConsulta(String codigo){
        String texto;

        if (existirConsulta()){
            objConsulta = buscarConsulta(codigo);
            if (objConsulta != null){
                texto = objConsulta.toString();
            }
            else {
                texto = """
                        \n------------------
                        CONSULTA NÃO ENCONTRADA!
                        ------------------------
                        """;
            }
        }
        else {
            texto = """
                    \n------------------------
                    NÃO HÁ CONSULTAS CADASTRADAS
                    ----------------------------
                    """;
        }

        return texto;
    }

    //EXCLUIR CONSULTA
    public boolean excluirConsulta(String codigo){
        for (int i = 0; i < arrayObjConsulta.size(); i ++){
            objConsulta = arrayObjConsulta.get(i);
            if (objConsulta.getCodigo().equalsIgnoreCase(codigo)){
                arrayObjConsulta.remove(i);
                return true;
            }
        }
        return false;
    }
}
