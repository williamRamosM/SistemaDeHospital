/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalgregory;

/**
 *
 * @author 2023326213
 */
class Consulta {
     private String codigo, data, problema;
    private String CRM;
    private String pacienteCPF;

    public Consulta()
    {

    }
     public Consulta(String codigo, String data, String problema, String CRM, String pacienteCPF)
    {
        this.codigo = codigo;
        this.data = data;
        this.problema = problema;
        this.CRM = CRM;
        this.pacienteCPF = pacienteCPF;
    }public String getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public String getProblema() {
        return problema;
    }

    public String getCRM() {
        return CRM;
    }

    public String getPacienteCPF() {
        return pacienteCPF;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public void setPacienteCPF(String pacienteCPF) {
        this.pacienteCPF = pacienteCPF;
    }

    public String toString() {
        return "\n"+"Codigo: " + codigo + "\n" + "Data: " + data + "\n" + "Problema: " + problema + "\n" + "Medico: " + CRM + "\n" + "Paciente: " + pacienteCPF;
    }
}
