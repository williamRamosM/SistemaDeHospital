/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalgregory;

/**
 *
 * @author 2023326213
 */
class Medico {
    
    private String nome, especialidade, CRM;

    public Medico()
    {

    }
    public Medico(String nome, String especialidade, String CRM)
    {
        this.nome = nome;
        this.especialidade = especialidade;
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }



    public void setCRM(String CRM) {
        this.CRM = CRM;
    }


        public String toString() {
            return "Nome: "+nome+"\n"+"Especialidade: "+especialidade+"\n"+"CRM: "+CRM+"\n";

    }
}
