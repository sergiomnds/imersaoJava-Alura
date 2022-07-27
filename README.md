![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
<h1 align="center"> Imersão Java - 2° Aula </h1>

Na segunda aula, estamos

<h3>Desafios Propostos:</h3>

- [X] Ler a documentação da classe abstrata InputStream.

- [ ] Centralizar o texto na figurinha.

- [ ] Fazer um pacote no Whatsapp e/ou Telegram com as suas próprias figurinhas!

- [X] Criar diretório de saída das imagens, se ainda não existir.

- [X] Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.

- [ ] Colocar uma imagem de você que está fazendo esse curso sorrindo, fazendo joinha!

- [ ] Colocar contorno (outline) no texto da imagem.

- [X] Tratar as imagens retornadas pela API do IMDB para pegar uma imagem maior ao invés dos thumbnails. Opções: pegar a URL da imagem e remover o trecho mostrado durante a aula ou consumir o endpoint de posters da API do IMDB (mais trabalhoso), tratando o JSON retornado.

- [ ] Fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB.

- [ ] Desafio supremo: usar alguma biblioteca de manipulação de imagens como OpenCV pra extrair imagem principal e contorná-la.

<h2>Galeria</h2>

![image](https://user-images.githubusercontent.com/85349959/181353732-7c8281cf-a3e9-4edc-89ca-13061f971c54.png)
![image](https://user-images.githubusercontent.com/85349959/181355227-7bcf7220-9e3a-4e34-943a-fcf30fbff107.png)



<h2>Considerações</h2>

Utilizar dessa API para gerar as imagens não é um trabalho fácil, a começar pelo problema para salvar com a extensão ".png". Consegui resolver isso! Era um problema com títulos com ":". Fora isso, algumas imagens simplesmente não existem para criar as figurinhas e outra não conseguiram ser lidas, mas foram a minoria também.

O Outline com Java é uma grande gambiarra kkkk, até consegui criar porém algumas figurinhas ficavam deslocadas o texto do contorno já que são gerados separadamente, então preferi retirar.

<h2>Material Complementar:</h2>

- Primeira aula do curso [“Java Polimorfismo: entenda herança e interfaces” da Alura.](https://www.alura.com.br/conteudo/java-heranca-interfaces-polimorfismo)

- Apêndice da apostila [“Java e Orientação a Objetos”](https://www.alura.com.br/apostila-java-orientacao-objetos/apendice-pacote-java-io) da Alura sobre o pacote java.io que explica com mais detalhes a abstração InputStream.
