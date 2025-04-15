/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalgregory;

/**
 *
 * @author 2023326213
 */
class Paciente {
    
    private String nome, endereco, planoDeSaude, CPF;

    public Paciente()
    {

    }
    public Paciente(String nome, String endereco, String planoDeSaude, String CPF)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.planoDeSaude = planoDeSaude;
        this.CPF = CPF;

    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    public String getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String toString() {
        return "Nome: "+ nome +"\n"+"Endereço: "+endereco+"\n"+"Plano de saude: "+planoDeSaude+"\n"+"CPF: "+CPF+"\n";
    }
}
