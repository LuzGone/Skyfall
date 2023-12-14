# Skyfall
##  - Projeto da Disciplina de Padrões de Projeto de Software

### Grupo:
- Luiz Gonzaga
- Louise Fernandes
- Jardielen de Sousa

### Padrões Utilizados:
- State:
  - O State foi utilizando para resolver o problema de quando o Voo altera seus estados podendo variar entre: Programado, Atrasado, Cancelado, Confirmado, Finalizado e Mudança de Portão.
  - O voo só pode cadastrar novos clientes apenas enquanto se encontra no estado de Programado, após sair do mesmo nenhum cliente pode ser removido ou cadastrado. 
- Observer
  - O Observer foi utilizado para notificar os clientes quando há alguma alteração no estado do voo. No caso o Voo é a própria classe publicadora e o cliente é o assinante.
- Strategy 
  - O Strategy foi utilizado para fazer com que os clientes possam receber suas notificações em diferentes meios de comunicação e também para facilitar caso futuramente o desenvolvedor queira adicionar novos meios de notificação. Lembrando que nesse cenário o cliente só pode utilizar apenas um meio de notificação.