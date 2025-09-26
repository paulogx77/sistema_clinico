# Sistema de Gestão de Clínica de Saúde - Documento de Visão

## 1. Objetivo

O propósito deste documento é coletar, analisar e definir as necessidades e características do **Sistema de Gestão de Clínica de Saúde**, focando nas potencialidades requeridas pelos desenvolvedores e usuários-alvo, e como estes requisitos serão abordados no sistema.

A visão do sistema documenta o ambiente geral de processos desenvolvidos para a gestão clínica, fornecendo a todos os envolvidos uma descrição compreensível deste e suas macro-funcionalidades.

---

## 2. Descrição do Produto

O **Sistema de Gestão de Clínica de Saúde** é um projeto direcionado para clínicas de saúde de pequeno e médio porte, consultórios médicos e profissionais de saúde autônomos que necessitam de uma solução digital para modernizar a gestão de pacientes, agendamentos e prontuários eletrônicos.

### Minimundo:

O sistema visa centralizar as informações dos pacientes, agilizar o fluxo de trabalho de **médicos** e **recepcionistas**, e fornecer uma plataforma robusta e segura para o gerenciamento clínico. As funcionalidades chave incluem:

- **Gestão de Filas e Fluxo de Atendimento**: Inclui a gestão de fluxo de pacientes (agendados e **consulta na hora**) através de um sistema de "senhas" e triagem, otimizando o tempo de espera e o direcionamento ao profissional.
- **Cadastro e Gestão de Pacientes**: Inclusão, edição, consulta e busca rápida de fichas de pacientes.
- **Agendamento de Consultas**: Agenda visual por profissional, com funcionalidades para agendar, reagendar, cancelar e visualizar o status das consultas.
- **Atendimento (Prontuário Eletrônico)**: O prontuário é aberto automaticamente na tela do médico quando a "senha" do paciente é chamada, facilitando o registro de anamnese, evolução, diagnósticos e prescrição digital.
- **Segurança**: Sistema de autenticação e autorização por perfis para garantir controle de acesso e confidencialidade dos dados.
- **Gestão de Usuários**: O **Administrador(a) da Clínica** supervisiona operações e gerencia o acesso dos usuários do sistema.

O sistema proporciona uma plataforma integrada para digitalizar e automatizar os fluxos de trabalho, minimizando erros manuais, otimizando o tempo da equipe e melhorando a qualidade do atendimento ao paciente.

---

## 3. Envolvimento

### 3.1. Abrangência

O sistema foi concebido como uma aplicação web de gerenciamento, para uso inicial em clínicas de saúde de pequeno e médio porte.

### 3.2. Papel dos Atores

Atores são pessoas, equipamentos ou outros sistemas que interagem com o sistema em questão, enviando ou recebendo mensagens. Abaixo estão descritos de forma resumida o papel dos atores do sistema.

| Ator                         | Descrição                                                        | Papel                                                                                                                                          | Insumos ao sistema                                                                                                  | Representante |
| ---------------------------- | ---------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------ | ------------ |
| **Recepcionista / Secretário(a)** | Usuário que gerencia o fluxo de atendimento e fila de espera     | Gerenciar agenda, cadastro e status das consultas. Vital para **emissão, priorização e encaminhamento das 'senhas' (tickets de atendimento)** | - Dados dos Pacientes (Cadastro)<br>- Dados dos Agendamentos<br>- Registro de Chegada e Geração de Senha             | A definir     |
| **Médico(a)**                | Responsável pelo atendimento clínico do paciente                 | **Chamar a próxima 'senha' pelo sistema**, abrindo automaticamente o Prontuário Eletrônico para registro completo do atendimento               | - Chamada da Senha<br>- Dados da Anamnese/Evolução<br>- Diagnósticos<br>- Prescrições                               | A definir     |
| **Administrador(a) da Clínica** | Supervisiona e gerencia a plataforma                            | Gerenciar usuários, perfis de acesso e analisar o desempenho operacional da clínica                                                             | - Cadastro e gestão de usuários/perfis.<br>- Solicitação e análise de relatórios gerenciais                         | A definir     |
| **Sistema de Gestão de Clínica de Saúde** | O próprio sistema e suas funcionalidades                      | Realiza **gestão da fila**, encaminhamento da senha ao painel do médico, abertura automática do prontuário e geração de métricas                | - Cálculo de horários disponíveis.<br>- Gestão do fluxo de "senhas".<br>- Segurança e controle de acesso            | A definir     |
| **Paciente**                 | Beneficiário indireto do sistema                                 | Não interage diretamente nesta versão inicial, mas se beneficia do atendimento mais ágil e seguro                                              | Não se aplica (na versão atual)                                                                                     | A definir     |

---

## 4. Necessidades e Funcionalidades

Esta seção descreve as principais necessidades e funcionalidades requeridas pelas partes interessadas, relacionando-as a cada ator.

| Necessidade                    | Benefício | Id Func. | Descrição das Funcionalidades / Atores Envolvidos                                                                                             |
| ----------------------------- | --------- | -------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| **1. Gestão de Pacientes**     | Crítico   | **F 1.1** | **Inclusão de Novos Pacientes**<br>Recepcionista - Fornece os dados de cadastro solicitados pelo sistema.                                      |
|                               |           | **F 1.2** | **Pesquisa / Listagem de Pacientes**<br>Recepcionista / Médico - Fornece nome, CPF ou outro identificador e o sistema retorna uma lista.      |
|                               |           | **F 1.3** | **Visualização da Ficha Completa**<br>Recepcionista / Médico - Acesso à ficha completa e dados de contato.                                    |
| **2. Controle de Agendamento e Filas** | Crítico   | **F 2.1** | **Agendar Consulta**<br>Recepcionista - Informa paciente, profissional, data, hora e motivo.                                                  |
|                               |           | **F 2.2** | **Visualização de Agenda (por Profissional)**<br>Recepcionista / Médico - Agenda visual para visualizar horários.                             |
|                               |           | **F 2.3** | **Reagendar / Cancelar Consulta**<br>Recepcionista - Altera a data/hora ou cancela o agendamento, registrando o motivo.                      |
|                               |           | **F 2.4** | **Registro de Chegada e Geração de Senha**<br>Recepcionista - Registra a chegada (agendado ou encaixe) e gera a senha de atendimento.        |
|                               |           | **F 2.5** | **Gestão da Fila e Triagem**<br>Recepcionista - Visualiza a fila de espera e prioriza/encaminha a senha para o painel do médico.              |
|                               |           | **F 2.6** | **Painel de Chamada de Senha (Público)**<br>Sistema - Exibe a senha atual chamada e o consultório para o paciente.                            |
| **3. Prontuário Eletrônico e Atendimento** | Crítico   | **F 3.1** | **Chamada de Próxima Senha e Início de Atendimento**<br>Médico - O médico aciona a chamada da próxima senha em sua tela. O sistema **automaticamente carrega a ficha do paciente** e abre o Prontuário Eletrônico para registro. |
|                               |           | **F 3.2** | **Registro de Anamnese, Evolução e Diagnóstico**<br>Médico - Registra as informações clínicas do paciente.                                    |
|                               |           | **F 3.3** | **Histórico Cronológico de Atendimentos**<br>Médico - Acessa o histórico completo de consultas do paciente.                                  |
|                               |           | **F 3.4** | **Prescrição Digital de Medicamentos/Exames**<br>Médico - Gera prescrições e solicitações de exames eletronicamente.                         |
| **4. Segurança do Sistema**    | Crítico   | **F 4.1** | **Autenticação do Usuário**<br>Todos os Atores - Informam nome de usuário e senha para acessar o sistema.                                     |
|                               |           | **F 4.2** | **Controle de Acesso por Perfil**<br>Sistema - Restringe o acesso às funcionalidades e dados de acordo com o perfil (Médico, Recepcionista, Administrador). |
| **5. Gestão de Usuários e Perfis** | Importante | **F 5.1** | **Inclusão de Novos Usuários/Perfis**<br>Administrador - Cadastra novos membros da equipe e atribui perfis de acesso.                         |
| **6. Gerenciamento de Desempenho Clínico** | Importante | **F 6.1** | **Cálculo de Tempo de Espera**<br>Sistema - Calcula o tempo que o paciente aguardou entre a geração da senha e a chamada pelo médico.        |
|                               |           | **F 6.2** | **Cálculo de Tempo de Atendimento**<br>Sistema - Calcula o tempo total gasto pelo médico no atendimento.                                      |
|                               |           | **F 6.3** | **Relatórios de Produtividade**<br>Administrador - Gera relatórios com número de consultas, cancelamentos e média de tempo de atendimento por profissional. |

---

## 6. Tecnologias Propostas

O sistema será desenvolvido em linguagem de programação com capacidade de gerar páginas web para uso do sistema dentro de um navegador web e realizar conexão com banco de dados.

- **Arquitetura**: Moderna e desacoplada, com API REST no back-end e Single Page Application (SPA) no front-end.
- **Front-end**: React, TypeScript.
- **Back-end**: Spring Boot, Java, API RESTful.
- **Banco de Dados**: PostgreSQL.
- **Controle de Versão**: Git e GitHub.

---

## 7. Escopo Futuro (Possíveis Melhorias)

- Integração com faturamento e controle financeiro.
- Portal do paciente para agendamento online e visualização de resultados de exames.
- Envio de lembretes de consulta por e-mail ou SMS.

---

## 8. Requisitos Não-Funcionais

- **Segurança**: Os dados dos pacientes devem ser armazenados de forma segura e o acesso ao sistema deve ser protegido por autenticação.
- **Usabilidade**: A interface deve ser intuitiva e de fácil utilização, minimizando a necessidade de treinamento extensivo.
- **Desempenho**: As operações críticas, como chamada de senha e carregamento de prontuários, devem ter um tempo de resposta rápido.
- **Confiabilidade**: O sistema deve ser estável e garantir a integridade dos dados registrados.

---

## Termo de Aceitação

Eu, [Nome do Proprietário/Administrador da Clínica], certifico que estou ciente e de acordo com a visão do sistema acima apresentada, no que se refere às funcionalidades e aos requisitos descritos neste documento.

---

Assinatura

---

## Histórico de Versões

| Data         | Versão | Descrição                                                                                                     | Autor      | Revisor  | Aprovado por |
| ------------ | ------ | ------------------------------------------------------------------------------------------------------------- | ---------- | -------- | ------------ |
| [Data Atual] | 1.2    | Atualização para incluir a **Gestão de Filas (Senhas)** e o fluxo de atendimento imediato, com abertura automática do prontuário na chamada da senha. | [Seu Nome] | A definir | A definir    |
