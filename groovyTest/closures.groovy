//1.1closures { [closureParameters -> ] statements }
//{ -> item++}
def c1 = { -> item++}
def c2 = { item++}
def c3 = { println it }
def c4 = { it -> println it }
def c5 = {name -> println name}
def c6 = {String x, int y -> println "x:${x}, y:${y}"}

//1.2 closure as an object
def listener = { e -> println "Clicked on $e.source" }      
assert listener instanceof Closure
Closure callback = { println 'Done!' }                      
Closure<Boolean> isTextFile = {
    File it -> it.name.endsWith('.txt')                     
}
//1.3 calling closure
def isOdd = {it % 2 != 0}
assert isOdd(1) == true
assert isOdd.call(1) == true

//assert () == true

//normal parameters
/*
def closureWithOneArg = { str -> str.toUpperCase() }
assert closureWithOneArg('groovy') == 'GROOVY'

def closureWithOneArgAndExplicitType = { String str -> str.toUpperCase() }
assert closureWithOneArgAndExplicitType('groovy') == 'GROOVY'

def closureWithTwoArgs = { a,b -> a+b }
assert closureWithTwoArgs(1,2) == 3

def closureWithTwoArgsAndExplicitTypes = { int a, int b -> a+b }
assert closureWithTwoArgsAndExplicitTypes(1,2) == 3

def closureWithTwoArgsAndOptionalTypes = { a, int b -> a+b }
assert closureWithTwoArgsAndOptionalTypes(1,2) == 3

def closureWithTwoArgAndDefaultValue = { int a, int b=2 -> a+b }
assert closureWithTwoArgAndDefaultValue(1) == 3
*/

//implicit parameter
def greering = {"Hello, $it!"}
assert greering('nemo') == 'Hello, nemo!'

def num = { -> 42}
assert num() == 42

// varargs
def concat1 = { String... args -> args.join('') }           
assert concat1('abc','def') == 'abcdef'                     
def concat2 = { String[] args -> args.join('') }            
assert concat2('abc', 'def') == 'abcdef'
String[] a = ["a","b","c"]
c3(a.join('_'))


//delegation strategy:The ability to change the delegate or change the delegation strategy of closures make it possible to design
//beautifui domain specific languages in Groovy

//owner delegate this
// this 离闭包最近的类
/*
class Enclosing {
	void run() {
		def whatIsThisObj = {getThisObject()}
		assert whatIsThisObj() == this
		def whatIsThis = { this }
		assert whatIsThis() == this
		println "passed"
	}
}
def en = new Enclosing()
en.run()

class EnclosedInInnerClass {
	class Inner {
		Closure foo(){
			def cl = {this}
			cl
		}
		
	}
	void run() {
		def inner = new Inner()
		assert inner.foo().call() == inner
		println "passed"
	}
}
en = new EnclosedInInnerClass()
en.run()

class NestedClosures {
	void run() {
		def nestedClosures = {
			def cl = { this }
			cl()
		}
		assert nestedClosures() == this
		println "passed"
	}
}
en = new NestedClosures()
en.run()
*/
/* static 的情况*/
/*
class Enclosing {
	static void run() {
		def whatIsThisObj = {getThisObject()}
		assert whatIsThisObj() == this
		def whatIsThis = { this }
		assert whatIsThis() == this
		
		assert this == Enclosing.class
		println "passed"

	}
}
def en = new Enclosing()
en.run()

class EnclosedInInnerClass {
	class Inner {
		static Closure foo(){
			def cl = {this}
			cl
		}
	}
	void run() {
		def inner = new Inner()
		assert inner.foo().call() == EnclosedInInnerClass.class
		println "passed"
	}
}
en = new EnclosedInInnerClass()
en.run()
*/

// owner 离闭包最近的类或者闭包
/*
class Enclosing {
    void run() {
        def whatIsOwnerMethod = { getOwner() }               
        assert whatIsOwnerMethod() == this                   
        def whatIsOwner = { owner }                          
        assert whatIsOwner() == this                         
    }
}
class EnclosedInInnerClass {
    class Inner {
        Closure cl = { owner }                               
    }
    void run() {
        def inner = new Inner()
        assert inner.cl() == inner                           
    }
}
class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { owner }                               
            cl()
        }
        assert nestedClosures() == nestedClosures            
    }
}
*/

//delegate :It is a powerful concept for building domain specific languages in Groovy.
// By default, the delegate is set to owner
/*
class Enclosing {
    void run() {
        def cl = { getDelegate() }                          
        def cl2 = { delegate }                              
        assert cl() == cl2()                                
        assert cl() == this                                 
        def enclosed = {
            { -> delegate }.call()                          
        }
        assert enclosed() == enclosed
        println "passed"
    }
}
def en = new Enclosing()
en.run()

//delegate call be changed to any object
class Person {
    String name
}
class Thing {
    String name
}

def p = new Person(name: 'Norman')
def t = new Thing(name: 'Teapot')

def upperCasedName = { delegate.name.toUpperCase() }

upperCasedName.delegate = p
assert upperCasedName() == 'NORMAN'
upperCasedName.delegate = t
assert upperCasedName() == 'TEAPOT'
*/

//delegation strategy
/*
class Person {
	String name
}
def p = new Person(name:"nemo")
def cl = {name.toUpperCase()}
cl.delegate = p
assert cl() == "NEMO"
*/

// Closure.OWNER_FIRST  Closure.DELEGATE_FIRST Closure.OWNER_ONLY Closure.DELEGATE_ONLY
/*
class Person {
    String name
    def pretty = { "My name is $name" }             
    String toString() {
        pretty()
    }
}
class Thing {
    String name                                     
}

def p = new Person(name: 'Sarah')
def t = new Thing(name: 'Teapot')

assert p.toString() == 'My name is Sarah'           
p.pretty.delegate = t                               
assert p.toString() == 'My name is Sarah' //still is Sarah

p.pretty.resolveStrategy = Closure.DELEGATE_FIRST
assert p.toString() == 'My name is Teapot' //then it become Teapot
*/

//Currying  Memoization Composition Trampoline 省略

