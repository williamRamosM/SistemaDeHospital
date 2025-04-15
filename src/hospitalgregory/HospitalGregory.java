/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalgregory;

import java.util.Scanner;

/**
 *
 * @author 2023326213
 */
public class HospitalGregory {

   public static void saida() throws InterruptedException {
        Thread.sleep(800);
        System.out.print("[ ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        Thread.sleep(800);
        System.out.print(" - ");
        System.out.println(" ]");
    }
    public static void main(String[] args) throws InterruptedException {
        
        Scanner teclado = new Scanner(System.in, "latin1");

        PacienteDAO pacienteDAO = new PacienteDAO();

        MedicoDAO medicoDAO = new MedicoDAO();

        ConsultaDAO consultaDAO = new ConsultaDAO();

        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        Consulta consulta = new Consulta();
        //----------------------------------------------------------------------------------------------
        Paciente paciente1 = new Paciente("José Bernardo", "José Faustino Nunes", "AACL", "027.826.100-07");
        pacienteDAO.cadastrarPaciente(paciente1);

        Medico medico1 = new Medico("Saulo Filhão", "Patologia", "10.987.876.000-11");
        medicoDAO.cadastrarMedico(medico1);

        Consulta consulta1 = new Consulta("1234567", "21/06/2007", "Diarréia", medico1.getCRM(), paciente1.getCPF());
        consultaDAO.cadastrarConsulta(consulta1);
        //----------------------------------------------------------------------------------------------
        Paciente paciente2 = new Paciente("Arthur Silva", "Silva Faustino Nunes", "Safe life", "213.546.980-13");
        pacienteDAO.cadastrarPaciente(paciente2);

        Medico medico2 = new Medico("Terrimar Fisk", "Reanimação", "100.873.910-98");
        medicoDAO.cadastrarMedico(medico2);

        Consulta consulta2 = new Consulta("234556", "12/08/1899", "Teníase", medico2.getCRM(), paciente2.getCPF());
        consultaDAO.cadastrarConsulta(consulta2);
        //----------------------------------------------------------------------------------------------

        System.out.println("""
                                                    --------AVISO--------
                System > Ao digitar algo que necesita de espaço digite ( _ ) para não aver erros futuros! <
                """);
        int op;
        String aux, aux2, aux3;
        do {
            System.out.println("""
                [0] Sair
                [1] Cadastrar paciente
                [2] Pesquisar paciente
                [3] Excluir paciente
                [4] Alterar cadastro paciente
                [5] Cadastrar medico
                [6] Pesquisar medico
                [7] Excluir medico
                [8] Alterar cadastro medico
                [9] Cadastrar consulta
                [10] Pesquisar consulta
                [11] Excluir consulta
                [12] Alterar cadastro consulta
                [13] Listar consultas por medico
                """);
            System.out.print("Digite: ");
            op = teclado.nextInt();


            switch (op) {
                case 0:

                    System.out.println("Saindo");
                    saida();
                    System.out.println("Obrigado por usar o nosso programa!");
                    break;
                case 1:
                    paciente = new Paciente();
                    System.out.println("[ CADASTRAR PACIENTE ]");
                    System.out.println();
                    System.out.print("Digite o CPF do paciente: ");
                    aux = teclado.next();
                    if (pacienteDAO.buscarPaciente(aux) != null) {
                        System.out.println("System > Foi encontrado um paciente que  possui esse plano de saude: <");
                        System.out.println();
                        System.out.println(pacienteDAO.imprimirPaciente(aux));
                    } else {
                        paciente.setCPF(aux);
                        System.out.println();
                        System.out.print("Digite o nome: ");
                        paciente.setNome(teclado.next());
                        System.out.println();
                        System.out.print("Digite o endereço: ");
                        paciente.setEndereco(teclado.next());
                        System.out.println();
                        System.out.print("Digite o plano de saude: ");
                        paciente.setPlanoDeSaude(teclado.next());

                        pacienteDAO.cadastrarPaciente(paciente);

                        System.out.println("System > Cadastro feito com sucesso! <");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("[ PESQUISAR PACIENTE ]");
                    System.out.println();
                    System.out.println("Digite o CPF: ");
                    aux = teclado.next();

                    System.out.println(pacienteDAO.imprimirPaciente(aux));

                    System.out.println();
                    break;
                case 3:
                    System.out.println("[ EXCLUIR PACIENTE ]");
                    System.out.println();
                    System.out.print("Digite o CPF do paciente: ");
                    aux = teclado.next();
                    System.out.println();

                    if (pacienteDAO.buscarPaciente(aux) != null) {
                        System.out.println(pacienteDAO.imprimirPaciente(aux));
                        System.out.println("Quer mesmo excluir? S/N");
                        System.out.print("Digite: ");
                        aux2 = teclado.next();

                        if (aux2.equalsIgnoreCase("S")) {

                            if (pacienteDAO.excluirPaciente(aux)) {
                                System.out.println("System > Exclusao feita com sucesso! <");
                            }

                        } else if (aux2.equalsIgnoreCase("N")) {
                            System.out.println("System > Nada foi excluido! <");
                        } else {
                            System.out.println("System > opção inválida! <");
                        }
                    } else {
                        System.out.println("System > PACIENTE NÃO ENCONTRADO <");
                    }

                    break;
                case 4:
                    System.out.println("[ ALTERAR PACIENTE ]");
                    System.out.println();
                    System.out.print("Digite o CPF do paciente: ");
                    aux = teclado.next();
                    if (pacienteDAO.buscarPaciente(aux) != null) {
                        System.out.print("Quer alterar informaçoes do paciente? s/n: ");
                        aux2 = teclado.next();

                        if (aux2.equalsIgnoreCase("s")) {
                            int escolha;
                            do {
                                System.out.println("""
                                        [0] Sair e salvar
                                        [1] Alterar nome
                                        [2] Alterar endereço
                                        [3] Alterar plano de saude
                                        """);
                                System.out.println("Digite: ");
                                escolha = teclado.nextInt();
                                paciente = pacienteDAO.buscarPaciente(aux);

                                switch (escolha) {
                                    case 0:
                                            pacienteDAO.alterarPaciente(pacienteDAO.buscarPosicao(aux), paciente);
                                            System.out.println("System > Modificação salva com sucesso! <");
                                            break;
                                    case 1:
                                        System.out.print("Digite o novo nome: ");
                                        paciente.setNome(teclado.next());
                                        break;
                                    case 2:
                                        System.out.print("Digite o novo endereço: ");
                                        paciente.setEndereco(teclado.next());
                                        break;
                                    case 3:
                                        System.out.print("Digite o novo plano de saude: ");
                                        paciente.setPlanoDeSaude(teclado.next());
                                        break;

                                    default:
                                        System.out.println("System > Opcão inválida! <");

                                }
                            } while (escolha != 0);
                        } else if (aux2.equalsIgnoreCase("n")) {
                            System.out.println("System > Ok, nada foi modificado! <");
                        } else {
                            System.out.println("System > Opção desconhecida! < ");
                        }
                    } else {
                        System.out.println("System > PACIENTE NÃO ENCONTRADO <");
                    }
                    break;
                case 5:
                    medico = new Medico();

                    System.out.println("[ CADASTRAR MEDICO ]");
                    System.out.println();
                    System.out.print("Digite o CRM do medico: ");
                    aux = teclado.next();
                    if (medicoDAO.buscarMedico(aux) != null) {
                        System.out.println("System > Foi encontrado um medico com o mesmo CRM: <");
                        System.out.println();
                        System.out.println(medicoDAO.imprimirMedico(aux));

                    } else {
                        medico.setCRM(aux);
                        System.out.println();
                        System.out.print("Digite o nome: ");
                        medico.setNome(teclado.next());
                        System.out.println();
                        System.out.print("Digite a especialidade: ");
                        medico.setEspecialidade(teclado.next());
                        System.out.println();

                        medicoDAO.cadastrarMedico(medico);

                    }
                    break;
                case 6:
                    System.out.println("[ PESQUISAR MEDICO ]");
                    System.out.println();
                    System.out.print("Digite o CRM: ");
                    aux = teclado.next();

                    System.out.println(medicoDAO.imprimirMedico(aux));

                    System.out.println();
                    break;
                case 7:
                    System.out.println("[ EXCLUIR MEDICO ]");
                    System.out.println();
                    System.out.print("Digite o CRM do medico: ");
                    aux = teclado.next();
                    System.out.println();

                    if (medicoDAO.buscarMedico(aux) != null) {
                        System.out.println(medicoDAO.imprimirMedico(aux));
                        System.out.println("Quer mesmo excluir? S/N");
                        System.out.print("Digite: ");
                        aux2 = teclado.next();

                        if (aux2.equalsIgnoreCase("S")) {

                            if (medicoDAO.excluirMedico(aux)) {
                                System.out.println("System > Exclusão feita com sucesso! <");
                            }

                        } else if (aux2.equalsIgnoreCase("N")) {
                            System.out.println("System > Nada foi excluido! <");
                        } else {
                            System.out.println("System > opção inválida! <");
                        }
                    } else {
                        System.out.println("System > MEDICO NÃO ENCONTRADO <");
                    }
                    break;
                case 8:
                    System.out.println("[ ALTERAR MEDICO ]");
                    System.out.println();
                    System.out.print("Digite o CRM do medico: ");
                    aux = teclado.next();
                    if (medicoDAO.buscarMedico(aux) != null) {

                        System.out.print("Quer alterar informaçoes do medico? s/n: ");
                        aux2 = teclado.next();

                        medico = medicoDAO.buscarMedico(aux);

                        if(aux2.equalsIgnoreCase("S")) {
                            int escolha;
                            do {
                                System.out.println("""
                                        [0] Sair e salvar
                                        [1] Alterar nome
                                        [2] Alterar especialidade""");
                                System.out.print("Digite: ");
                                escolha = teclado.nextInt();

                                switch (escolha) {
                                    case 0:
                                        medicoDAO.alterarMedico(medicoDAO.buscarPosicao(aux), medico);
                                            System.out.println("System > Modificação salva com sucesso! <");

                                        break;
                                    case 1:
                                        System.out.print("Digite o novo nome: ");
                                        medico.setNome(teclado.next());
                                        break;
                                    case 2:
                                        System.out.print("Digite o novo especialidade: ");
                                        medico.setEspecialidade(teclado.next());
                                        break;

                                    default:
                                        System.out.println("System > Opcão inválida! <");

                                }
                            } while (escolha != 0);

                        }
                        else if (aux2.equalsIgnoreCase("N"))
                        {
                            System.out.println("System > Nada foi alterado! <");
                        }
                        else
                        {
                            System.out.println("System > Opaçao invalida <");
                        }
                    }
                    else
                    {
                        System.out.println("System > MEDICO NÃO ENCONTRADO <");
                    }

                    break;
                case 9:
                    consulta = new Consulta();

                    System.out.println("[ CADASTRAR CONSULTA ]");
                    System.out.println();
                    System.out.println("System > Lista de medico(s) <"); // medico
                    System.out.println();
                    System.out.println(medicoDAO.listarMedico());
                    System.out.println();
                    System.out.print("Digite o CRM do medico responsável: ");
                    aux = teclado.next();
                    if (medicoDAO.buscarMedico(aux) != null) // medico
                    {
                        System.out.println("System > Lista de paciente(s) <"); // paciente
                        System.out.println();
                        System.out.println(pacienteDAO.listarPaciente());
                        System.out.println();
                        System.out.print("Digite o cpf: ");
                        aux2 = teclado.next();
                        if (pacienteDAO.buscarPaciente(aux2) != null) // paciente
                        {
                            System.out.println();
                            System.out.print("Digite o codigo para a consulta: ");
                            aux3 = teclado.next();
                            if (consultaDAO.buscarConsulta(aux3) != null) {

                                System.out.println("System > Foi encontrado uma consulta com o mesmo codigo < ");
                                System.out.println();
                                System.out.println(consultaDAO.imprimirConsulta(aux));
                            } else {

                                consulta.setCRM(aux);
                                consulta.setPacienteCPF(aux2);
                                consulta.setCodigo(aux3);
                                System.out.println();
                                System.out.print("Digite a data: ");
                                consulta.setData(teclado.next());
                                System.out.println();
                                System.out.print("Digite o problema: ");
                                consulta.setProblema(teclado.next());
                                System.out.println();
                                System.out.println("System > CONSULTA CADASTRADA COM SUCESSO <");
                                consultaDAO.cadastrarConsulta(consulta);
                                System.out.println();

                            }
                        } else {
                            System.out.println("System > Não a nenhum paciente com esse CPF! <");
                        }
                    } else {
                        System.out.println("System > Não a nenhum medico com esse CRM! <");
                    }
                    break;
                case 10:
                    System.out.println("[ PESQUISAR CONSULTA ]");
                    System.out.println();
                    System.out.print("Digite o codigo da consulta: ");
                    aux = teclado.next();

                    System.out.println(consultaDAO.imprimirConsulta(aux));

                    System.out.println();
                    break;
                case 11:
                    System.out.println("[ EXCLUIR CONSULTA ]");
                    System.out.println();
                    System.out.print("Digite o codigo da consulta: ");
                    aux = teclado.next();
                    System.out.println();

                    if (consultaDAO.buscarConsulta(aux) != null) {
                        System.out.println(consultaDAO.imprimirConsulta(aux));
                        System.out.println("Quer mesmo excluir? S/N");
                        System.out.print("Digite: ");
                        aux2 = teclado.next();

                        if (aux2.equalsIgnoreCase("S")) {

                            if (consultaDAO.excluirConsulta(aux)) {
                                System.out.println("System > Exclusao feita com sucesso! <");
                            }

                        } else if (aux2.equalsIgnoreCase("N")) {
                            System.out.println("System > Nada foi excluido! <");
                        } else {
                            System.out.println("System > Opção inválida! <");
                        }
                    } else {
                        System.out.println("System > CONSULTA NÃO FOI ENCONTRADA! <");
                    }
                    break;
                case 12:
                    System.out.println("[ ALTERAR CONSULTA ]");
                    System.out.println();
                    System.out.print("Digite o codigo da consulta: ");
                    aux = teclado.next();
                    if (consultaDAO.buscarConsulta(aux) != null) {

                        System.out.print("Quer alterar informaçoes da consulta? s/n: ");
                        aux2 = teclado.next();

                        consulta = consultaDAO.buscarConsulta(aux);

                        if(aux2.equalsIgnoreCase("S")) {
                            int escolha;
                            do {
                                System.out.println("""
                                        [0] Sair e salvar
                                        [1] Alterar data
                                        [2] Alterar problema
                                        [3] Alterar codigo
                                        [4] Alterar Medico
                                        [5] Alterar Paciente""");
                                System.out.print("Digite: ");
                                escolha = teclado.nextInt();

                                switch (escolha) {
                                    case 0:
                                            consultaDAO.alterarConsulta(consultaDAO.buscarPosicao(aux), consulta);
                                            System.out.println("System > Consulta alterada com sucesso! <");

                                        break;
                                    case 1:
                                        System.out.print("Digite a nova data: ");
                                        consulta.setData(teclado.next());
                                        break;
                                    case 2:
                                        System.out.print("Digite o novo problema: ");
                                        consulta.setProblema(teclado.next());
                                        break;
                                    case 3:
                                        System.out.print("Digite o novo codigo: ");
                                        consulta.setCodigo(teclado.next());
                                        break;
                                    case 4:
                                        System.out.print("Digite o CRM do medico: ");
                                        aux2 = teclado.next();
                                        if(medicoDAO.buscarMedico(aux2) != null)
                                        {
                                            consulta.setCRM(aux2);
                                        }
                                        else
                                        {
                                            System.out.println("System > Desculpe, não conseguimos encontrar esse CRM em nosso banco de dados! <");
                                        }
                                        break;
                                    case 5:
                                        System.out.print("Digite o CPF do paciente:");
                                        aux2 = teclado.next();

                                        if(pacienteDAO.buscarPaciente(aux2) != null)
                                        {
                                            consulta.setPacienteCPF(aux2);
                                        }
                                        else
                                        {
                                            System.out.println("System > Desculpe, não conseguimos encontrar esse CRM em nosso banco de dados! <");
                                        }
                                        break;
                                    default:
                                        System.out.println("System > Opcão inválida! <");

                                }
                            } while (escolha != 0);
                        }
                        else if(aux2.equalsIgnoreCase("N"))
                        {
                            System.out.println("System > Nada foi alterado! <");
                        }
                        else
                        {
                            System.out.println("System > Opção invalida! <");
                        }
                    } else {
                        System.out.println("CONSULTA NÃO FOI ENCONTRADA");
                    }
                    break;
                case 13:
                    System.out.println("[ LISTA DE CONSULTA(s) POR MEDICO(s) ]");
                    System.out.println();
                    System.out.print("Digite o CRM do medico: ");
                    aux = teclado.next();
                    System.out.println();
                    System.out.println(consultaDAO.listarConsulta(aux));
                    System.out.println();

                    break;
                default:
                    System.out.println("----------------!OPÇÃO INVÁLIDA!----------------");

            }
        } while (op != 0);

   
    }
    
    
}
    

