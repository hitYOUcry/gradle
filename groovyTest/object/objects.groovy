//Types Class Interface

//Constructors
/* java style
class PersonConstructor {
    String name
    Integer age

    PersonConstructor(name, age) {          
        this.name = name
        this.age = age
    }
}
def person1 = new PersonConstructor('Marie', 1)
*/

class PersonWOConstructor {                                  
    String name
    Integer age
}

def person4 = new PersonWOConstructor()                      
def person5 = new PersonWOConstructor(name: 'Marie')         
def person6 = new PersonWOConstructor(age: 1)                
def person7 = new PersonWOConstructor(name: 'Marie', age: 2) 

//Method 
//A method is defined with a return type or with the def keyword, to make the return type untyped.
//Java modifiers can be used normally, and if no visibility modifier is provided, the method is public.

//trait  They can be seen as interfaces carrying both default implementations and state. 
trait A {
	String name = 'A'
    String exec() { 'A' }               
}
trait B implements A {
	String name = 'B'
    String exec() { 'B' }               
}
interface E {
	String name = 'E';
}
/*
class C implements A,B {} 
def c = new C()
assert c.exec() == 'B'
*/
//In this case, the default behavior is that the method from the last declared trait in the implements clause wins.


class C implements A,B,E {
   // String exec() { A.super.exec() }    
}
def c = new C()
assert c.exec() == 'B'  
assert c.name == 'B'
assert ((C)c).name == 'B'

trait D {
	//abstract void mm()
	void p() {
		println 'asdw'
	}
}
//trait can only be implemented by class,but a trait can extends/implements another trait

// deference with java8 interface default 
// the implementation from the trait is always 
//used if the class declares the trait in its interface list and 
//that it doesn’t provide an implementation
trait AA {
	String p(){
		println "I am AA"
	}
}

class BB {
	String p(){
		println "I am BB"
	}
}

class CC extends BB implements AA {}
def cc = new CC();
cc.p()

// trait filed ++ -- not allowed
/*
trait Counting {
    int x
    void inc() {
        x++                             
    }
    void dec() {
        x--                             
    }
}

class Counter implements Counting {}
def counting = new Counter()
c.inc()
*/

String name(String a, String b){
	println "a = $a, b = $b"
}
name("1","2")
name '1','2'