Feature: Testes de API - GoRest

  @list-users @all
  Scenario: Listar usuários paginados
    Given que acesso a API "<url>"
    When realizo uma request GET para "<endpoint>"
    Then eu valido a resposta da página "<page>" com a lista de usuários
    Examples:
      | tag   | url                            | endpoint         | page |
      | @get1 | https://gorest.co.in/public/v2 | /users?page=1    | 1    |
      | @get2 | https://gorest.co.in/public/v2 | /users?page=2    | 2    |
      | @get3 | https://gorest.co.in/public/v2 | /users?page=3    | 3    |

  @user-details @all
  Scenario: Obter detalhes de usuários existentes
    Given que acesso a API "<url>"
    When realizo uma request GET para "<endpoint>" e id
    Then eu valido os dados do usuário específico
    Examples:
      | tag    | url                            | endpoint   |
      | @get4  | https://gorest.co.in/public/v2 | /users/  	|

  @nonexistent-user @all
  Scenario: Obter detalhes de um usuário inexistente
    Given que acesso a API "<url>"
    When realizo uma request GET para "<endpoint>"
    Then eu valido que o erro retornado tem o status code "<status>"
    Examples:
      | tag    | url                            | endpoint     | status |
      | @get7  | https://gorest.co.in/public/v2 | /users/9999  | 404    |

  @create-valid-user @all
  Scenario Outline: Criar usuários com dados válidos
    Given que acesso a API "<url>"
    When realizo uma request POST para "<endpoint>"
    Then eu valido que a criação foi bem-sucedida
    Examples:
      | tag    | url                            | endpoint |
      | @post1 | https://gorest.co.in/public/v2 | /users   |
      | @post2 | https://gorest.co.in/public/v2 | /users   |

  @create-invalid-user @all
  Scenario Outline: Criar usuários com dados inválidos
    Given que acesso a API "<url>"
    When realizo uma request POST para "<endpoint>" com "<name>", "<email>", "<gender>" e "<status>"
    Then eu valido o erro retornado
    Examples:
      | tag    | url                            | endpoint | name | email     | gender | status |
      | @post3 | https://gorest.co.in/public/v2 | /users   |      |           |        |        |
     

  @update-user @all
  Scenario Outline: Atualizar dados de usuários
    Given que acesso a API "<url>"
    When realizo uma request PUT para "<endpoint>" com novos dados "<name>", "<status>"
    Then eu valido que os dados foram atualizados corretamente com status "<statusCode>"
    Examples:
      | tag    | url                            | endpoint  | name       | status  | statusCode |
      | @put1  | https://gorest.co.in/public/v2 | /users/1  | Novo Nome  | active  | 200        |

  @delete-user @all
  Scenario: Excluir usuário existente
    Given que acesso a API "<url>"
    When realizo uma request DELETE para "<endpoint>"
    Then eu valido o status de resposta "<statusCode>"
    Examples:
      | tag     | url                            | endpoint   | statusCode |
      | @del1   | https://gorest.co.in/public/v2 | /users/1   | 204        |
