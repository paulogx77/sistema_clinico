# Sistema de Gestão de Clínica de Saúde - Documento de Visão

## 1. Objetivo
O propósito deste documento é coletar, analisar e definir as necessidades e características do Sistema de Gestão de Clínica de Saúde, focando nas potencialidades requeridas pelos desenvolvedores e usuários-alvo, e como estes requisitos serão abordados no sistema.

A visão do sistema documenta o ambiente geral de processos desenvolvidos para a gestão clínica, fornecendo a todos os envolvidos uma descrição compreensível deste e suas macro-funcionalidades.

## 2. Descrição do Produto
O **Sistema de Gestão de Clínica de Saúde** é um projeto direcionado para clínicas de saúde de pequeno e médio porte, consultórios médicos e profissionais de saúde autônomos que necessitam de uma solução digital para modernizar a gestão de pacientes, agendamentos e prontuários eletrônicos.

### Minimundo:
O sistema visa centralizar as informações dos pacientes, agilizar o fluxo de trabalho de médicos e recepcionistas, e fornecer uma plataforma robusta e segura para o gerenciamento clínico. As funcionalidades chave incluem:

- **Cadastro e Gestão de Pacientes**: Inclusão, edição, consulta e busca rápida de fichas de pacientes.
- **Agendamento de Consultas**: Agenda visual por profissional, com funcionalidades para agendar, reagendar, cancelar e visualizar o status das consultas.
- **Atendimento (Prontuário Eletrônico)**: Registro de anamnese, evolução, exames, diagnósticos, histórico cronológico de atendimentos, e prescrição digital de medicamentos e exames.
- **Segurança**: Sistema de autenticação e autorização por perfis para garantir controle de acesso e confidencialidade dos dados.
- **Gestão de Usuários**: O Administrador(a) da Clínica supervisiona operações e gerencia o acesso dos usuários do sistema.

O sistema proporciona uma plataforma integrada para digitalizar e automatizar os fluxos de trabalho, minimizando erros manuais, otimizando o tempo da equipe e melhorando a qualidade do atendimento ao paciente.

## 3. Envolvimento

### 3.1. Abrangência
O sistema foi concebido como uma aplicação web de gerenciamento, para uso inicial em clínicas de saúde de pequeno e médio porte.

### 3.2. Papel dos Atores
Atores são pessoas, equipamentos ou outros sistemas que interagem com o sistema em questão, enviando ou recebendo mensagens. Abaixo estão descritos de forma resumida o papel dos atores do sistema.

| **Ator**                     | **Descrição**                                                        | **Papel**                                                         | **Insumos ao sistema**                                         | **Representante** |
|------------------------------|---------------------------------------------------------------------|------------------------------------------------------------------|---------------------------------------------------------------|--------------------|
| **Recepcionista / Secretário(a)** | O usuário que irá utilizar diariamente o sistema para gerenciar o fluxo de atendimento. | Gerenciar a agenda, o cadastro de pacientes e o status das consultas diariamente. | - Dados dos Pacientes (Cadastro) <br> - Dados dos Agendamentos (Agendar, Reagendar, Cancelar) <br> - Status das Consultas | A definir           |
| **Médico(a)**                 | Responsável pelo atendimento clínico do paciente.                   | Utilizar o Prontuário Eletrônico para registrar todo o atendimento, garantindo a completude do histórico clínico. | - Dados da Anamnese/Evolução <br> - Diagnósticos <br> - Prescrições de medicamentos e exames <br> - Evolução do paciente | A definir           |
| **Administrador(a) da Clínica** | Responsável por supervisionar e gerenciar a plataforma como um todo. | Gerenciar os usuários, perfis de acesso e ter uma visão geral das operações da clínica. | - Cadastro e gestão de usuários/perfis. | A definir           |
| **Sistema de Gestão de Clínica de Saúde** | É o próprio sistema e suas funcionalidades.                           | Realiza cálculos ou gera dados para utilização, como o histórico do paciente ou a agenda. | - Cálculo de horários disponíveis <br> - Geração de histórico cronológico <br> - Segurança e controle de acesso | A definir           |
| **Paciente**                  | Beneficiário indireto do sistema.                                    | Não interage diretamente nesta versão inicial, mas se beneficia do atendimento mais ágil e seguro. | Não se aplica (na versão atual) | A definir           |

## 4. Necessidades e Funcionalidades

Esta seção descreve as principais necessidades e funcionalidades requeridas pelas partes interessadas, relacionando-as a cada ator.

| **Necessidade**               | **Benefício**      | **Id Func.** | **Descrição das Funcionalidades / Atores Envolvidos** |
|-------------------------------|--------------------|--------------|------------------------------------------------------|
| **1. Gestão de Pacientes**     | Crítico           | F 1.1        | Inclusão de Novos Pacientes <br> **Ator**: Recepcionista |
|                               |                    | F 1.2        | Pesquisa / Listagem de Pacientes <br> **Ator**: Recepcionista / Médico |
|                               |                    | F 1.3        | Alteração de dados do paciente <br> **Ator**: Recepcionista |
|                               |                    | F 1.4        | Visualização da Ficha Completa <br> **Ator**: Recepcionista / Médico |
| **2. Controle de Agendamento** | Crítico           | F 2.1        | Agendar Consulta <br> **Ator**: Recepcionista |
|                               |                    | F 2.2        | Visualização de Agenda <br> **Ator**: Recepcionista / Médico |
|                               |                    | F 2.3        | Reagendar / Cancelar Consulta <br> **Ator**: Recepcionista |
|                               |                    | F 2.4        | Alteração de Status da Consulta <br> **Ator**: Recepcionista |
| **3. Prontuário Eletrônico**   | Crítico           | F 3.1        | Abertura/Início de Atendimento <br> **Ator**: Médico |
|                               |                    | F 3.2        | Registro de Anamnese, Evolução e Diagnóstico <br> **Ator**: Médico |
|                               |                    | F 3.3        | Histórico Cronológico de Atendimentos <br> **Ator**: Médico |
|                               |                    | F 3.4        | Prescrição Digital de Medicamentos/Exames <br> **Ator**: Médico |
| **4. Segurança do Sistema**    | Crítico           | F 4.1        | Autenticação do Usuário <br> **Ator**: Todos os Atores |
|                               |                    | F 4.2        | Controle de Acesso por Perfil <br> **Ator**: Sistema |
| **5. Gestão de Usuários e Perfis** | Importante      | F 5.1        | Inclusão de Novos Usuários/Perfis <br> **Ator**: Administrador |
|                               |                    | F 5.2        | Alteração / Bloqueio de Usuários <br> **Ator**: Administrador |

## 5. Tecnologias Propostas

O sistema será desenvolvido em linguagem de programação com capacidade de gerar páginas web para uso do sistema dentro de um navegador web e realizar conexão com banco de dados.

- **Arquitetura**: Moderna e desacoplada, com API REST no back-end e Single Page Application (SPA) no front-end.
- **Front-end**: React, TypeScript.
- **Back-end**: Spring Boot, Java, API RESTful.
- **Banco de Dados**: PostgreSQL.
- **Controle de Versão**: Git e GitHub.

## 6. Escopo Futuro (Possíveis Melhorias)

- Integração com faturamento e controle financeiro.
- Portal do paciente para agendamento online e visualização de resultados de exames.
- Geração de relatórios gerenciais e estatísticos.
- Envio de lembretes de consulta por e-mail ou SMS.

## 7. Requisitos Não-Funcionais

- **Segurança**: Os dados dos pacientes devem ser armazenados de forma segura e o acesso ao sistema deve ser protegido por autenticação.
- **Usabilidade**: A interface deve ser intuitiva e de fácil utilização, minimizando a necessidade de treinamento extensivo.
- **Desempenho**: As operações críticas, como busca de pacientes e carregamento de prontuários, devem ter um tempo de resposta rápido.
- **Confiabilidade**: O sistema deve ser estável e garantir a integridade dos dados registrados.

## 8. Termo de Aceitação

Eu, **[Nome do Proprietário/Administrador da Clínica]**, certifico que estou ciente e de acordo com a visão do sistema acima apresentada, no que se refere às funcionalidades e aos requisitos descritos neste documento.

**Assinatura**:
