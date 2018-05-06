# Testowanie aplikacji JAVA 2017-2018
## Projekt 2 (Maven, JUnit oraz atrapy)

| Travis CI Status | Maintainability |
:--:|:--:
[![Build Status](https://travis-ci.com/TestowanieJAVA2017-2018Gr2/projekt2-JakubBalcerowicz.svg?token=qXd72fwPxWfza7KMHCDM&branch=master)](https://travis-ci.com/TestowanieJAVA2017-2018Gr2/projekt2-JakubBalcerowicz) | [![Maintainability](https://api.codeclimate.com/v1/badges/ec7759a9d5401cdcd24e/maintainability)](https://codeclimate.com/repos/5aeca74adacac35f5c00b6a6/maintainability)
-----------------------
### REGUŁY GRY

1. Wybieramy **jedno** z poniższych zadań. Zadania różnią się poziomem trudności i są inaczej punkto-
wane.

2. Każdy projekt ma być wykonany przy użyciu narzędzia Maven! Projekt **nie powinien zawierać pliku jar oraz folderu
target**.

3. Przesyłanie projektu będzie odbywało się przy pomocy utworzenia Issue w swoim repozytorium. Utworzenie Issue wiąże się z oddanym projektem. Wszelkie zmiany po Issue będą obcinane.

**TERMIN: 07.05.2018**

- **Spóźnienia** z terminem będą wiązały się z **mniejszą ilością punktów**.
- **Maksymalny deadline** to **11.05.2018** i wtedy obowiązuje **50%** punktów z projektu. A więc dzień zwłoki oznacza obniżenie progu o **10%**. Po tym terminie projekty liczone są na **0%**!
- Projekt, w którym nie będzie wykonywało się polecenie **mvn test** będzie liczony na **0%**!
- Ponadto pod ocenę będzie brany styl projektu: jak zapisane są testy i jak sprawdzane są asercje.
- Testy powinny wykorzystywać wiele różnych asercji (a nie tylko assertEquals)!
- Ponadto po sprawdzeniu projektu należy go obronić: będą to krótkie pytania i ewentualne drobne
zmiany w kodzie podane przez prowadzącego!

-----------------------

**Projekt 6** (25 pkt)

Rozważmy bardzo uproszczoną aplikacje w sklepie internetowym, która jest opisana danym diagramem związków encji:
![Diagram ERD](https://inf.ug.edu.pl/~mmiotk/Dydaktyka/2016-2017/TAJAVA2016-2017/ERD.png)

Dane do bazy mają być przechowywane w jakimś systemie bazodanowym. Zaimplementuj odpowiednie metody tej aplikacji i przetestuj ją uwzględniając wymagania zawarte w diagramie używając atrap.

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (4 pkt) Uwzględnienie powyższych wymagań.
- (6 pkt) Przypadki testowe (uwzględniające wyjątki).
- (5 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 10 testów, różnych od pozostałych)
- (4 pkt) Przetestowanie przy użyciu Mockito (co najmniej 10 testów, różnych od pozostałych).
- (4 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 10 testów, różnych od pozostałych).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy:
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.
