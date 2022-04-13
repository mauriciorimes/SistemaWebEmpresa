Um sistema web para gerenciar os funcionários e filiais de uma empresa.
Tecnologias usadas: Java, Jboss, JSF, JPA e Mysql.

Características e validações:

- O Retorno do método
enderecoResumido() deve ser uma String formada com no mínimo 3 dados do endereço, sendo o
Cidade obrigatório.

- A tela inicial (index) deve conter os links para as telas de Gerenciar Filial, Gerenciar Funcionário.
Esta página deve Ser configurada como tela inicial do projeto.

- Na tela de Gerenciar Filial, deve ser possível cadastrar, editar e listar. Cada filial deve possuir um
endereço cadastrado junto com os seus dados. A listagem deve conter todos os dados de uma Filial
e o seu endereço resumido e vir ordenada pelo nome da Filial.

- Em Gerenciar Funcionários, deve ser possível informar os seus dados, seu endereço e selecionar a
filial em qual trabalha. A listagem de funcionários deverá vir ordenada pelo seu nome e conter
Nome, CPF, Salário, seu endereço resumido e o nome da filial em que trabalha. Na listagem o
salário deve vir formatado como moeda (currency) Deverá ser possível editar os dados de um
funcionário exceto a Filial em que trabalha. Caso tente mudar a Filial, o sistema deve emitir um
alerta e impedir a troca.

- Ainda na tela de funcionários (gerenciar Funcionários) deverá ser possível fazer um filtro na listagem
por filial. Neste caso, deverá ter uma opção para selecionar a filial (Sem ter como digitar o nome,
somente escolher) e um botão para realizar a filtragem no banco de dados. A lista deverá vir
somente com os funcionários daquela filial e também deverá vir ordenada pelo nome do funcionário.
Deverá conter também uma opção para listar todos novamente caso seja necessário.

- Todos os dados de Filial e Funcionários são obrigatórios e caso algum fique vazio, o sistema deverá
emitir um alerta de campo obrigatório e não gravar no banco.

- É OBRIGATÓRIO O USO DO CRITERIA DO JPA PARA A RESOLUÇÃO DAS QUESTÕES DE CONSULTAS,
FILTROS, ORDENAÇÕES ENTRE OUTRAS.
