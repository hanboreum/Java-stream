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
System.out.println(stringSupplier.get()); // 출력: Hello, World!
<br>

### Consumer

input 만 존재. return 하지 않음 <br>
주요 메서드: accept() <br>
Consumer<String> printConsumer = (s) -> System.out.println(s); <br>
printConsumer.accept("Hello, World!"); // 출력: Hello, World! <br>

### BiConsumer

두개의 인자를 받아 반환값 없이 처리하는 함수형 인터페이스 <br>
주요 메서드: accept() <br>
BiConsumer<String, Integer> printFormatted = (s, i) -> System.out.println(s + " is " + i + " years
old."); <br>
printFormatted.accept("Alice", 30); // 출력: Alice is 30 years old. <br>

### Predicate

하나의 인자를 받아 boolean 을 반환하는 함수형 인터패이스 <br>
주요 메서드: test() <br>
Predicate<Integer> isEven = (n) -> n % 2 == 0; <br>
System.out.println(isEven.test(4)); // 출력: true <br>
System.out.println(isEven.test(5)); // 출력: false <br>

### Predicate

두 객체를 비교하는 함수형 인터페이스. 주로 정렬에 사용된다 <br>
주요 메서드: compare() 두 객체를 비교해 음수, 0, 양수 값을 반환한다.  <br>
Comparator<Integer> compareAsc = (a, b) -> Integer.compare(a, b);
System.out.println(compareAsc.compare(5, 10)); // 출력: -1 (5 < 10)
Comparator<String> compareLength = (a, b) -> Integer.compare(a.length(), b.length()); <br>
System.out.println(compareLength.compare("Apple", "Banana")); // 출력: 0 ("Apple"과 "Banana"는 길이가
같음) <br>

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

### Part7. Optional

Optional: null 일수도, 아닐 수도 있는 오브젝트를 담은 상자 <br>

- of: null 이 아닌 오브젝트를 이용해 optional 을 만들 때
- Empty: 빈 optional 을 만들 때
- ofNullable: null 인지 아닌지 알 수 없는 오브젝트로 optional 을 만들 때
- irPresent:  안의 오브젝트의 null 여부 체크. null 일 시 false
- get: optional 안의 값을 추출. null 일 시 에러
- orElse: optional 이 null 이 아니라면 안의 값을, null 이라면 other 로 공감된 값을 리턴
- ifPresent: optional 이 null 이 아니라면 action 실행
- map: optional 이 null 이 mapper 적용
- flatMap: mapper 의 리턴 값이 또 다른 optional 이라면 한 단계의 optional 이 되도록 납작하게 해 줌

### Part8. Advanced Stream

- min: Stream 안의 min 값을 반환. 없다면 Optional 반환
- max : Stream 안의 max 값을 반환.없다면 Optional 반환
- count: Stream 안의 데이터 개수 반환. 없다면 Optional 반환
- allMatch: Stream 안의 모든 데이터가 predicate 을 만족하면 true
- anyMatch: Stream 안의 데이터 중 하나라도 predicate 을 만족하면 true
- findFirst: Stream 안의 첫번째 데이터를 반환, Stream 이 비어있다면 Optional 반환
- findAny: Stream 안 아무 데이터나 리턴, 순서는 중요지 않음. Stream 이 비어있다면 Optional 반환
- reduce: 주어진 함수를 반복 적용해 Stream 안의 데이터를 하나의 값으로 합치는 작업. <br>
  max/ min/ count 도 reduce 의 일종이다.
- ToMap: Stream 안의 데이터를 map 형태로 변환해주는 collector<br>
  keyMapper: 데이터를 map 의 key 로 변환해주는 function<br>
  valueMapper: 데이터를 map 의 value 로 변환해주는 function<br>
- grouping by: Stream 안의 데이터에 classifier 를 적용했을 때 결과값이 같은 것 끼리 List 로 모아 Map 의 형태로 반환해주는 collector
  <br> 이 때 key 는 classifier 의 결과값, value 는 그 결과값을 갖는 데이터들.
  <br> 예를 들어 stream{1,2,5,7,9,12,13} 이 있을 때 classifier 가 x -> x % 3 이라면 반환되는 map 은 { 0= [9,12].
  1=[1,7,13], 2[2,5]} <br>
  두번째 매개변수로 downstream collector 를 넘기는 것도 가능 <br>
  그 경우 list 대신 collector 를 적용시킨 값으로 map 의 value가 만들어짐
  <br> 이 때 자주 쓰이는 것이 mapping/ reducing 등의 collector
- partitioning by: grouping by 와 유사하지만 function 대신 predicate 를 받아 true, false 두 key 가 존재하는 map  반환하는 collector. <br>
마찬가지로 downstream collector 를 넘겨 List 이외의 형태로 map 의 value 를 만드는 것 역시 가능. 
-for each: 제공된 action(consumer) 을 stream 의 각 데이터에 적용해주는 종결 처리 메서드. <br>
자바의 iterable 인터페이스에도 for each 가 있기 때문에 stream 의 중간 처리가 필요 없다면 iterable collection (set, list) 에서 바로 쓰는 것도 가능
- parallel stream: 여러개의 스레드를 이용헤 stream 의 처리 과정을 병렬화.
<br> 중간 과정은 병렬 처리 되지만 순서가 있는 stream 의 경우 종결 처리 했을 때의 결과물이 기존의 순차적 처리와 일치하도록 종결 처리 과정에서 조정된다. 
<br> 즉, list 로 collect 한다면 순서가 항상 올바르게 나온다는 것 <br>
장점 - 간단한 병렬 처리 가능, 속도 향상 가능<br>
단점 - 항상 속도가 향상되는 것은 아님. 공통으로 사용하는 리소스가 있을 경우 잘못된 결과가 나오거나 아예 오류가 날 수 있음(deadlock).<br>
이를 막기 위해 mutex, semaphore 등의 병렬 처리 기술을 이용하면 순차 처리보다 느려질 수 있다.<br>
순서가 필요 없을 때 사용하는것이 좋다<br>
<b>
- summary </b>
- Stream 의 다양한 종결 처리들 : max/ min/ count/ allMatch/ anyMatch/ findFirst/ findAny/ reduce/ forEach
- Collector 를 이용한 종결처리들: toList/ mapping/ reducing/ toMap/ groupingBy/ partitioningBy
- Parallel Stream 의 장점과 단점
<br>
<br> <b>
### Part9. 함수형 프로그래밍의 응용 

- Scope(유효범위): 변수에 접근할 수 있는 범위. 함수 안에 함수가 있을 때 내부 함수에서 외부 함수에 있는 변수에 접근이 가능하다 (lexical scope). 그 반대는 불가능하다.
- Closure: 내부 함수가 존재하는 한 내부 함수가 사용한 외부 함수의 변수들 역시 계속 존재한다. 이렇게 lexical scope 를 포함하는 함수를 closure 하고 한다. 이 때 내부 함수가 사용한 외부
함수의 변수들은 내부 함수 선언 당시로부터 변할 수 없기 때문에 final 로 선언되지 않더라도 암묵적으로 final 로 취급된다. 
- Curry: 여러 개의 매개변수를 받는 함수를 중첩된 여러 개의 함수로 쪼개어 매개 변수를 한 번에 받지 않고 여러 단계에 걸쳐 나눠 받을 수 있게 하는 기술. Closure 의 응용이다. 
- Lazy Evaluation: Lambda 의 계산은 그 결과값이 필요할 때가 되어서야 계산된다. 이를 이용해 불필요한 계산을 줄이거나 해당 코드의 실행 순서를 의도적으로 미뤄 최적화를 할 수 있다. 
- Function composition: 여러 개의 함수를 합쳐 하나의 새로운 함수를 만드는 것
<br>
### Part10. 디자인 패턴
- 생성 패턴 Creational Patterns: 오브젝트의 생성에 관련된 패턴
- 구조 패턴 Structural Patterns: 상속을 이용해 클래스/ 오브젝트를 조합해 더 발전된 구조로 만드는 패턴
- 행동 패턴 Behavioral Patterns: 필요한 작업을 여러 객체에 분배해 객체간 결합도를 줄이게 해주는 패턴 <br>
- Builder Pattern: 대표적인 생성 패턴. 객체 생서에 대한 로직과 표현에 대한 로직을 분리해준다. 객체의 생성 과정을 정의하고싶거나 필드가 많아 constructor 가 복잡해질 때 유용
- Decorator Pattern: 구조 패턴의 하나. 용도에 따라 객체에 기능을 계속 추가 할 수 있게 해준다. 
- Strategy Pattern: 대표적인 행동 패턴. 런타임에 어떤 전략(알고리즘) 을 사용할 지 선택 할 수 있게 해준다. 전략들을 캡슐화하여 간단하게 교체할 수 있게 해준다. 