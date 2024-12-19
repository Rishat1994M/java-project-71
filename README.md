<a href="https://codeclimate.com/github/Rishat1994M/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/11cddbb14b6f702fd41c/maintainability" /></a>

<a href="https://codeclimate.com/github/Rishat1994M/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/11cddbb14b6f702fd41c/test_coverage" /></a>

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

Возможности утилиты:

Поддержка разных входных форматов: yaml и json
Генерация отчета в виде plain text, stylish и json
Пример использования:

# формат plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# формат stylish
./app filepath1.json filepath2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}

Шаг 6:
    https://asciinema.org/a/zUVH3Ye8HYEKYEHxc8OXqCRxl
Шаг 7:
    https://asciinema.org/a/CHRCXYK4AFhxsbQVI7seMbCvC
