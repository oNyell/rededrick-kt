# Main

- Bom, começamos pela Main, onde nela temos o enable que inicia o comando e dá a mensagem de que o plugin foi iniciado com sucesso.
o mesmo se utiliza da API do Bukkit/Paper, sendo o JavaPlugin instancionado ao inicio da class.

- No final, temos o disable, que envia a mensagem de disable quando o plugin é desativado ou quando o servidor é desligado/reiniciado, ele só manda a mensagem, mas futuramente terá alguma funcionalidade necessaria nele.

# Comandos - Base

- No CommandManager temos um manager de leitura de comandos sem precisar registrar diretamente na Main ou no plugin.yml. É utilizado nele o reflections e annotations, fazendo com que todos os plugins que tenha determinada annotation seja puxada automaticamente para ele registrar tais comando.
- No CommandInterface é o básico do que o comando deverá ter, tendo quem manda o comando e o que o mesmo escreve (args)
- No Command é a annotation para que o comando seja registrado devidamente no CommandManager, como citado acima no tópico dele.

# Comandos - Commands

- Na class FlyCommand é bastante simples, é somente um comando que estende a interface e que tem de constructor para ser uma annotation registrada no CommandManager.
- No ParticulasCommand temos um exemplo de como utilizar o ParticleManager para criar uma particula de um certo tipo em uma determinada entidade.

# Enums

- Por hora, teremos somente uma ENUM, que será os tipos de particulas que teremos, como CIRCULAR, DUPLA entre outras mais

# Particles

- Na class ParticleManager temos o manager das particulas, nele é a construção das particulas, fazendo a forma e o jeito que se movem, por hora, não está totalmente funcional, tendo em vista que determinadas particulas estejam indisponível para trabalho, como a FLAME, por exemplo, já que a mesma se apresenta como partícula explosíva, não contribuindo para o funcionamento da mesma.
- Como descrito no tópico de Enum, futuramente teremos outros tipos de particulas, então é nessa classe que a mesma ficará, usando o vector e a Redstone para poder criar determinadas particulas de melhor controle, pintando a mesma e criando novas coisas, como capas ou animações via particula.