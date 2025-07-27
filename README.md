# JavaAndTest

Java‑проект для практики из курса: выбор уроков, запуск `LessonSelection` и тестирование `Basis`, `Operators`, `ManagerStruct` через TestNG и Mockito.

Курс: Java Тренажер - https://stepik.org/course/182389/syllabus

## 🚀 Что внутри

- `src/main/java/` — основной код:
    - `LessonSelection.java` — класс запуска меню и выбора урока
    - `LessonOptions` (enum) — отвечает за `Basis`, `Operators`, `ManagerStruct`
    - `Basis.java`, `Operators.java`, `ManagerStruct.java` — логика каждой опции
- `src/test/java/` — тесты:
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
1 — Basis
2 — Operators
3 — Manager structure
0 — Exit
Затем вводит номер — и запускается соответствующая логика. После выполнения метод возвращает управление в меню. Пункт 0 завершает цикл.

## 🧪 Тестирование

- Java (версия указана в pom.xml, например 17)
- Maven для сборки
- TestNG для написания тестов *(c анотациями)*
- Mockito для mock-объектов и мокирования вызовов конструктора и статических методов

## 👤 Автор

Проект собран и тестируется пользователем **Papa‑Pedro**

