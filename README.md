<<<<<<< HEAD
# Source File Generator
## Стэк:
Java 11.
## Функциональность:
Создает файл, содержащий целые числа или строки (в зависимости от аргументов командной строки).
Каждый следующий элемент начинается с новой строки.

## Инструкция:
Доступные аргументы (в порядке их применения):
- *-h* - необязательный, используется без остальных аргументов. Выведение в консоль подсказки;


- *-a* - необязательный, сортировка значений в файле по возрастанию (установлена по умолчанию);
- *-d* - необязательный, сортировка значений в файле по убыванию;
- *-i* *<стартовое число>* *<длина интервала>* *<количество генерируемых значений>* - обязательный,
    для генерации целочисленных (integer) значений. Первое случайное число генерируется в интервале [*<стартовое число>* ; *<длина интервала>*], 
    следующие ***n*** чисел в интервалах [(n-1) * *<длина интервала>* ; n * *<длина интервала>*];
- *-s* *<минимальная длина строки>* *<максимальная длина строки>* *<количество генерируемых значений>* - обязательный, для генерации строковых значений. 
Каждая строка состоит из случайного набора строчных и заглавных символов латиницы;
- *название выходного файла* (включая абсолютный или относительный путь до него) - обязательный.

## Запуск:
Требуется установленная Java версией не ниже 11.  
В каталоге с jar-архивом открыть терминал, выполнить команду:
```
java -jar generator.jar <аргументы>
```
=======
# source-file-generator-for-test-tasks
Generates a file with strings/integers for sorting test tasks.
>>>>>>> ef59f88769ba0749e6053f1721d688601ab3b3ce
