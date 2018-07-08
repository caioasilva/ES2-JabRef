# Trabalho ES2 UFSCar 2018 - Grupo 2

## Integrantes
- Ana Lucia Cardoso
- Caio Augusto Silva
- Luis Felipe Tomazini
- Mateus Nunes Barros
- Victor Augusto Tavares

## Tarefas
- Melhorar a cobertura de testes no pacote: src/main/gen/org/jabref/logic/importer/fileformat/endnote

### Manutenção Perfectiva
Na funcionalidade Inserção de item bibliográfico (BibTeX → New entry), para as categorias book e article, realizar os seguintes incrementos:

Validar os seguintes campos de acordo com as seguintes regras:
- Year: deve ser um ano válido (de acordo com o calendário da linguagem Java)
- Bibtexkey: definido pelo usuário ou automaticamente, respeitando a seguinte regra: Sobrenome do Primeiro Autor + Ano de Publicação com 4 dígitos + Primeira Palavra do Título do Artigo toda em Maiúscula.

Na funcionalidade Importação de itens bibliográficos na base corrente (File → Import into current database), realizar os seguintes incrementos:
- Oferecer a opção de importar arquivo em formato CSV, ODS, XLX ou XLSX (escolha apenas um dos formatos)
- Oferecer a opção de criação de um novo arquivo (database) quando existirem entradas duplicadas no arquivo corrente (current database) e o arquivo que está sendo importado (considerar formatos BibTeX e CSV).

Prepare testes que demostrem que as funcionalidades estão funcionando corretamente.

### Desafio – Manutenção Corretiva

Foi escolhida a Issue #4169: can't generate bibtex for Chinese author
https://github.com/JabRef/jabref/issues/4169

O bug foi devidamente corrigido e será submetido um pull request ao repositório oficial para que o problema não exista mais nas versões futuras.
