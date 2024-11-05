## The RED: 25 백엔드 개발 필수 현업 예제를 통해 마스터하는 JAVA STREAM

## Stream?
자바 8에서 도입, 컬렉션이나 배열 등의 데이터 소스를 처리해주는 방법을 제공.
스트림은 데이터를 순차적, 혹은 병렬적으로 처리할 수 있게 해준다

### Part3. Lambda Expression
### Lambda
익명 함수를 정의하는 방법. 함수형 프로그램을 가능하게 해주는 요소.<br>
두 정수를 더하는 람다 표현식
ex) (parameters) -> expression<br>
BinaryOperator<Integer> add = (a, b) -> a + b;<br>
System.out.println(add.apply(3, 4)); // 출력: 7

### BiFunction
두 개의 인자를 받아서 결과를 반환하는 함수형 인터페이스<br>
주요메서드: apply() 두 파라미터를 받아 결과 반환<br>
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;<br>
System.out.println(add.apply(5, 3)); // 출력: 8

### TriFunction
세 개의 인자를 받아 처리하는 함수형 인터페이스.<br>
세 개의 입력 인자(T, U, V)를 받아서 결과를 반환.<br>
바에서 기본으로 제공되지 않기 때문에 사용자가 직접 구현해야함.<br>
@FunctionalInterface <br>
interface TriFunction<T, U, V, R> { <br>
R apply(T t, U u, V v); <br>
} <br>
사용 예시<br>
TriFunction<Integer, Integer, Integer, Integer> addThree = (a, b, c) -> a + b + c;<br>
System.out.println(addThree.apply(1, 2, 3)); // 출력: 6<br>


### Part4. Functional Interface
### Supplier
input 없고 output 만 있음. 값을 제공하는 역할을 함.<br>
주요 메서드: get() <br>
Supplier<String> stringSupplier = () -> "Hello, World!";<br>
System.out.println(stringSupplier.get());  // 출력: Hello, World!
<br>
 ### Consumer
input 만 존재. return 하지 않음 <br>
주요 메서드: accept() <br>
Consumer<String> printConsumer = (s) -> System.out.println(s); <br>
printConsumer.accept("Hello, World!");  // 출력: Hello, World! <br>


### BiConsumer
두개의 인자를 받아 반환값 없이 처리하는 함수형 인터페이스 <br>
주요 메서드: accept() <br>
BiConsumer<String, Integer> printFormatted = (s, i) -> System.out.println(s + " is " + i + " years old."); <br>
printFormatted.accept("Alice", 30);  // 출력: Alice is 30 years old. <br>

### Predicate
하나의 인자를 받아 boolean 을 반환하는 함수형 인터패이스 <br>
주요 메서드: test() <br>
Predicate<Integer> isEven = (n) -> n % 2 == 0; <br>
System.out.println(isEven.test(4));  // 출력: true <br>
System.out.println(isEven.test(5));  // 출력: false <br>


### Predicate
두 객체를 비교하는 함수형 인터페이스. 주로 정렬에 사용된다 <br>
주요 메서드: compare() 두 객체를 비교해 음수, 0, 양수 값을 반환한다.  <br>
Comparator<Integer> compareAsc = (a, b) -> Integer.compare(a, b);
System.out.println(compareAsc.compare(5, 10));  // 출력: -1 (5 < 10)
Comparator<String> compareLength = (a, b) -> Integer.compare(a.length(), b.length()); <br>
System.out.println(compareLength.compare("Apple", "Banana"));  // 출력: 0 ("Apple"과 "Banana"는 길이가 같음) <br>

### Part5. Method Reference
이미 존재하는 메서드를 참조해 호출하는 방법. 람다식을 간단하게 표현할 수 있게 도와준다. <br>
문법: ClassName::methodName <br>
생성자 참조 문법: ClassName::new <br>


### Part6. Stream
- 스트림은 데이터의 흐름. 
- 여러 개의 중간 처리를 연결할 수 있다 <br>
- Stream: 컬렉션 형태로 구성된 데이터를 람다를 이용해 간결하고 직관적으로 프로세스 하게 해 줌. for, while 등을 이용하던 기존 loop 를 대체<br>
- Filter: 특정 조건에 따라 걸러내는 기능을 제공한다.<br>
- Map: Stream 안에 있는 데이터를 변형하는데 사용. 데이터가 해당 함수에 적용된 결과를 제공하는 stream 을 리턴<br>
- Sort: stream 안에 있는 것을 정렬<br>
- Distinct: 중복되는 데이터가 제거된 stream 을 return <br>
- FlatMap: 다차원 배열을 1차원 배열로 만들어줌 <br>


