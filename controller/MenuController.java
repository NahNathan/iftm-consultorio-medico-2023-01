/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Map;
import model.Pessoa;
import view.Menu;

/**
 *
 * @author lfeli
 */
public class MenuController {

    private final Menu viewMenu;
    private String[] loginSenha = new String[2];
    //private Pessoa pessoa;
    protected PessoaController pessoaController;
    protected MedicoController medicoController;
    private FranquiaController franquiaController;
    private UnidadeController unidadeController;
    private ConsultaController consultaController;
    private InfoConsultaController infoConsultaController;
    private ProcedimentoController procedimentoController;
    private FinanceiroAdmController financeiroAdmController;
    private FinanceiroMedicoController financeiroMedicoController;

    public MenuController() {
        this.pessoaController = new PessoaController();
        this.medicoController = new MedicoController();
        this.franquiaController = new FranquiaController();
        this.unidadeController = new UnidadeController();
        this.consultaController = new ConsultaController();
        this.infoConsultaController = new InfoConsultaController();
        this.procedimentoController = new ProcedimentoController();
        this.financeiroAdmController = new FinanceiroAdmController();
        this.financeiroMedicoController = new FinanceiroMedicoController();
        this.viewMenu = new Menu();
    }

    private boolean verificaLogin() {
        boolean verifica = false;

        do {
            loginSenha = viewMenu.login();
            if (loginSenha != null) {
                verifica = this.pessoaController.validarPessoaPorLogin(loginSenha);

                if (!verifica) {
                    viewMenu.loginNegado();
                } else {
                    return verifica;
                }
            }
        } while (!verifica);

        return false;
    }

    public void run() {
        int op;
        do {
            op = viewMenu.inicio();

            switch (op) {
                case 0: // Login 
                    if (verificaLogin()) {
                        int menuOp = -1;
                        do {
                            //int menuOp;
                            String[] dadosUsuario = new String[3]; // [0]: Id(String)  | [1]: Nome(String) | [2]: Permissao(String)
                            Map<String, String> infoPessoa = this.pessoaController.obterPessoaPorLogin(loginSenha);
                            dadosUsuario[0] = infoPessoa.get("id");
                            dadosUsuario[1] = infoPessoa.get("nome");
                            dadosUsuario[2] = infoPessoa.get("tipoUsuario");
                            //int tipoUsuario = this.pessoaController.obterPessoaPorLogin(loginSenha).getTipoUsuario();

                            if (dadosUsuario[2].equals("Paciente")) { // Paciente
                                menuOp = viewMenu.menuPaciente(dadosUsuario[1]);

                                if (menuOp == 1) { // Alterar dados cadastrais
                                    String[] dadoAlterado;
                                    dadoAlterado = viewMenu.menuAlterarDadosPaciente(dadosUsuario);

                                    try {
                                        this.pessoaController.editarPessoa(dadoAlterado);
                                    } catch (RuntimeException e) {
                                        // TRATAR EXCEÇÃO
                                    }

                                } else if (menuOp == 2) { // Ver consultas
                                    //this.viewMenu.mostrarRelatorioConsultasProcedimentosPaciente(this.consultaController.obterConsultasPorIdPaciente(Integer.parseInt(dadosUsuario[0])), dadosUsuario);
                                } else if (menuOp == 3) { // Ver procedimentos
                                    //this.viewMenu.mostrarProcedimentosPaciente(this.procedimentoController.listarProcedimentosPorIdPaciente(Integer.parseInt(dadosUsuario[0])), dadosUsuario);
                                } else if (menuOp == 4) { // Gerar relatório de consultas e procedimentos
                                    this.viewMenu.mostrarRelatorioConsultasProcedimentosPaciente(this.procedimentoController.listarProcedimentosPorIdPaciente(Integer.parseInt(dadosUsuario[0])), this.consultaController.obterConsultasPorIdPaciente(Integer.parseInt(dadosUsuario[0])), dadosUsuario);
                                } else { // menuOp == 0 | Voltar
                                    continue;
                                }

                            } else if (dadosUsuario[2].equals("Médico")) { // Médico
                                Map<String, String> infoMedico = this.medicoController.obterMedicoPorIdPessoa(Integer.parseInt(dadosUsuario[0]));
                                dadosUsuario[0] = infoMedico.get("id");
                                menuOp = this.viewMenu.menuMedico(dadosUsuario[1]);

                                if (menuOp == 1) { // Alterar dados cadastrais
                                    String[] dadoAlterado;
                                    dadoAlterado = this.viewMenu.menuAlterarDadosMedico(dadosUsuario);
                                    try {
                                        this.medicoController.editarMedico(dadoAlterado);
                                    } catch (RuntimeException e) {
                                        // TRATAR EXCEÇÃO
                                    }
                                    
                                } else if (menuOp == 2) { // Visualizar consultas, informacoes de consulta e procedimentos de um paciente
                                    int pacienteID;
                                    pacienteID = this.viewMenu.mostrarPacientes(dadosUsuario, this.consultaController.listarPacientesPorIdMedico(Integer.parseInt(dadosUsuario[0])));
                                    if (pacienteID != 0) {
                                        String informacoes = this.consultaController.obterInformacoesPacientePorIdMedicoIdPaciente(Integer.parseInt(dadosUsuario[0]), pacienteID);
                                        this.viewMenu.mostrarInformacoesPaciente(informacoes, dadosUsuario);
                                    }

                                } else if (menuOp == 3) { // Visualizar procedimentos de um paciente
                                    //int paciente;
                                    //paciente = this.viewMenu.mostrarPacientes(dadosUsuario, this.consultaController.listarPacientesPorIdMedico(Integer.parseInt(dadosUsuario[0])));
                                    //this.viewMenu.mostrarProcedimentosPaciente(this.procedimentoController.listarProcedimentosPorIdPaciente(paciente), dadosUsuario);
                                } else if (menuOp == 4) { // Visualizar agenda de consulta

                                } else if (menuOp == 5) { // Visualizar consultas realizadas
                                    //this.viewMenu.mostrarConsultasPaciente(this.consultaController.listarConsultasRealizadasPorIdMedico(Integer.parseInt(dadosUsuario[0])), dadosUsuario);
                                } else if (menuOp == 6) { // Criar consulta
                                    // [0]: data | [1]: horario | [2]: descricao (infoConsulta) | [3]: valor | [4]: idpaciente | [5]: idmedico | [6]: idunidade
                                    String[] dadosConsulta = this.viewMenu.cadastrarConsulta();
                                    dadosConsulta[4] = Integer.toString(this.viewMenu.mostrarPacientes(dadosUsuario, this.pessoaController.listarPacientes()));
                                    dadosConsulta[5] = dadosUsuario[0];
                                    dadosConsulta[6] = this.viewMenu.mostrarUnidadesFranquia(dadosUsuario, this.unidadeController.listarUnidades());
                                    this.consultaController.criarConsulta(dadosConsulta);
                                    this.infoConsultaController.criarInfoConsulta(dadosConsulta[2], this.consultaController.obterUltimaConsulta());
                                } else if (menuOp == 7) { // Gerar relatório de um paciente
                                    int paciente = this.viewMenu.mostrarPacientes(dadosUsuario, this.consultaController.listarPacientesPorIdMedico(Integer.parseInt(dadosUsuario[0])));
                                    this.viewMenu.mostrarRelatorioConsultasProcedimentosPaciente(this.procedimentoController.listarProcedimentosPorIdPaciente(paciente), this.consultaController.obterConsultasPorIdPaciente(paciente), dadosUsuario);
                                } else if (menuOp == 8) { // Gerar relatório de valores recebidos
                                    this.viewMenu.mostrarRelatorioValoresRecebidosMedico(this.financeiroMedicoController.listarFinanceiroMedicoPorIdMedico(Integer.parseInt(dadosUsuario[0])), dadosUsuario);
                                } else { // menuOp == 0 | Voltar
                                    continue;
                                }
                            } else if (dadosUsuario[2].equals("Gerente Administrativo")) { // Gerente Administrativo
                                // NÃO FOI FEITO
                            } else if (dadosUsuario[2].equals("Responsavel pela Unidade")) { // Responsavel pela Unidade de Franquia
                                menuOp = this.viewMenu.menuDonoUnidade(dadosUsuario[1]);

                                if (menuOp == 1) { // Alterar dados cadastrais
                                    String[] dadoAlterado;
                                    dadoAlterado = this.viewMenu.menuAlterarDadosDonoUnidade(dadosUsuario);
                                    this.pessoaController.editarPessoa(dadoAlterado);
                                } else if (menuOp == 2) { // Alterar dados cadastrais de um usuário
                                    dadosUsuario[0] = this.viewMenu.mostrarPessoas(dadosUsuario, this.pessoaController.listarPessoasCadastradas());
                                    String[] dadoAlterado = this.viewMenu.menuAlterarDadosDonoUnidade(dadosUsuario);
                                    this.pessoaController.editarPessoa(dadoAlterado);
                                    dadosUsuario[0] = infoPessoa.get("id");
                                } else if (menuOp == 3) { // Cadastrar médico
                                    String idPessoa = this.viewMenu.mostrarPessoas(dadosUsuario, this.pessoaController.listarPessoasCadastradas());
                                    String[] dadosMedico = this.viewMenu.cadastrarMedico();
                                    dadosMedico[2] = idPessoa;
                                    this.medicoController.adicionarMedico(dadosMedico);
                                } else if (menuOp == 4) { // Gerar relatório financeiro
                                    int idUnidade = this.unidadeController.obterIdUnidadePorResponsavelId(Integer.parseInt(dadosUsuario[0]));
                                    this.viewMenu.mostrarRelatorioFinanceiroUnidadeFranquia(this.financeiroAdmController.listarMovimentosFinanceirosPorIdUnidade(idUnidade), dadosUsuario);
                                } else { // menuOp == 0 | Voltar
                                    continue;
                                }
                            } else if (dadosUsuario[2].equals("Administrador")) { // Administrador do Sistema / Dono da Franquia
                                menuOp = viewMenu.menuAdmin(dadosUsuario[1]);

                                if (menuOp == 1) { // Alterar dados cadastrais
                                    String[] dadoAlterado = viewMenu.menuAlterarDadosAdministradorSistema(dadosUsuario);
                                    this.pessoaController.editarPessoa(dadoAlterado);
                                } else if (menuOp == 2) { // Alterar dados cadastrais de um usuário
                                    dadosUsuario[0] = this.viewMenu.mostrarPessoas(dadosUsuario, this.pessoaController.listarPessoasCadastradas());
                                    String[] dadoAlterado = this.viewMenu.menuAlterarDadosAdministradorSistema(dadosUsuario);
                                    this.pessoaController.editarPessoa(dadoAlterado);
                                    dadosUsuario[0] = infoPessoa.get("id");
                                } else if (menuOp == 3) { // Cadastrar médico
                                    String idPessoa = this.viewMenu.mostrarPessoas(dadosUsuario, this.pessoaController.listarPessoasCadastradas());
                                    String[] dadosMedico = this.viewMenu.cadastrarMedico();
                                    dadosMedico[2] = idPessoa;
                                    this.medicoController.adicionarMedico(dadosMedico);
                                } else if (menuOp == 4) { // Criar uma nova franquia
                                    String[] dadosFranquia = viewMenu.cadastrarFranquia();
                                    dadosFranquia[4] = this.viewMenu.mostrarPessoas(dadosUsuario, this.pessoaController.listarPessoasCadastradas());
                                    this.viewMenu.verificaCadastroFranquia(this.franquiaController.criarFranquia(dadosFranquia), dadosFranquia[0], this.pessoaController.obterPessoaPorId(Integer.parseInt(dadosFranquia[4])).getNome());
                                } else if (menuOp == 5) { // Criar uma nova unidade de franquia
                                    String[] dadosUnidadeFranquia = this.viewMenu.cadastrarUnidadeFranquia();
                                    String idUsuario = this.viewMenu.mostrarPessoas(dadosUsuario, this.pessoaController.listarPessoasCadastradas());
                                    String idFranquia = this.viewMenu.mostrarFranquias(dadosUsuario, this.franquiaController.listarFranquias());
                                    dadosUnidadeFranquia[2] = idUsuario;
                                    dadosUnidadeFranquia[3] = idFranquia;
                                    this.viewMenu.verificaCadastroUnidadeFranquia(this.unidadeController.criarUnidade(dadosUnidadeFranquia), this.franquiaController.buscarFranquiaPorId(Integer.parseInt(idFranquia)).getNome(), this.pessoaController.obterPessoaPorId(Integer.parseInt(idUsuario)).getNome());
                                } else if (menuOp == 6) { // Gerar relatório
                                    this.viewMenu.mostrarRelatorioFinanceiroFranquia(this.financeiroAdmController.listarMovimentosFinanceiros(), dadosUsuario);
                                } else { // menuOp == 0 | Voltar
                                    continue;
                                }
                            }
                        } while (menuOp != 0);
                    }

                    break;
                case 1: // Cadastrar Usuario
                    String[] dadosUsuario = this.viewMenu.cadastrarUsuario();
                    this.viewMenu.verificaCadastroUsuario(this.pessoaController.adicionarPessoa(dadosUsuario), dadosUsuario);
                    break;
                case 2: //Sair
                    System.exit(0);
                    break;
                case -1:
                    break;
            }

        } while (op != -1);
    }
}
