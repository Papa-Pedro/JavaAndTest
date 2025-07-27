# JavaAndTest

Java‑проект для практики из курса, выбор уроков запуск и тестирование через TestNG и Mockito.

Глава в курсе - пункт в проге:
1) Выбор урока - `LessonSelection`  
2) Основы    - `Basis`, 
3) Операторы - `Operators`,
4) Управлябщая структура - `ManagerStruct`

Курс: Java Тренажер - https://stepik.org/course/182389/syllabus

## 🚀 Что внутри

- `src/main/java/` - основной код:
    - `LessonSelection.java` - класс запуска меню и выбора урока
    - `LessonOptions` (enum) - отвечает за `Basis`, `Operators`, `ManagerStruct`
    - `Basis.java`, `Operators.java`, `ManagerStruct.java` - логика каждой опции
- `src/test/java/` - тесты:
    - `LessonSelectionTest`, `MultiplyPositiveNumberTest` и другие
    - Используется TestNG и Mockito (включая `mockConstruction`, `mockStatic`, `mockito-inline`)

## ✅ Как собрать и запустить

Проект использует Maven:

```bash
mvn clean install
```

## 💡 Как пользоваться 
(через main() или LessonSelection)
При запуске LessonSelection, пользователь видит меню:

Choose lesson from stepic "Java Тренажер"

1) Basis 
2) Operators 
3) Manager structure 
4) Exit

Затем вводит номер - и запускается соответствующая логика. После выполнения метод возвращает управление в меню. 

0) Завершает цикл.

## 🧪 Тестирование

- Java 19
- Maven для сборки
- TestNG для написания тестов *(c анотациями)*
- Mockito для mock-объектов и мокирования вызовов конструктора и статических методов

## 👤 Автор

Проект собран и тестируется пользователем **Papa‑Pedro**

