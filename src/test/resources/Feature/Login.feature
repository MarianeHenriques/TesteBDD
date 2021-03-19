# Author
# Date
# Description
Feature: Validar cenario de Usuario Logado com Sucesso
  Ter login e senha cadastrado
  Usuario e senha corretos

  Scenario: Validar login efetuado com sucesso
    Given Estando na Pagina Inicial
    When Inserir usuario e senha
    And Clicar no botao confirma
    Then Validar usuario logado
