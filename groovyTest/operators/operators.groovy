assert 1+1 == 2
assert 1-1 == 0
assert 1*3 == 3
assert 4/3 == (1 + 1/3)
int a = 4
int b = 3
assert a.intdiv(b) == 1

assert 7 % 2 == 1
assert 7 ** 2 == 49

a += 3
assert a == 7

// Relational operators == != <  <=  > >=
// Logical operators && || !
// bit operators & | ^ ~
int c = 0b01110000
int d = 0b10100000
int mask = 0b11111111
assert ((~c) & mask) == 0b10001111
assert (c|d) == 0b11110000
assert (c&d) == 0b00100000

// ? : 

// Safe navigation operator
def person
def name = person?.name

assert name == null

// direct field access operator
class User {
    public final String name                 
    User(String name) { this.name = name}
    String getName() { "Name: $name" }       
}
def user = new User('Bob')
assert user.name == 'Name: Bob'
assert user.@name == 'Bob'

//Method pointer operator There are multiple advantages in using method pointers. First of all, the type of such a method pointer is a groovy.lang.Closure
def str = 'example of method reference'            
def fun = str.&toUpperCase                         
def upper = fun()                                  
assert upper == str.toUpperCase()

assert fun instanceof Closure

//Spread operator
// *.
class Car {
    String make
    String model
}
def cars = [
       new Car(make: 'Peugeot', model: '508'),
       new Car(make: 'Renault', model: 'Clio')]       
def makes = cars*.make                                
assert makes == ['Peugeot', 'Renault']

// *
int function(int x, int y, int z) {
    x*y+z
}
def args = [4,5,6]
assert function(*args) == 26

def m1 = [c:3, d:4]                   
def map = [a:1, b:2, *:m1]            
assert map == [a:1, b:2, c:3, d:4]

//Range operator
//you can create a range from any Comparable object that has next() 
//and previous() methods to determine the next / previous item in the range. 
def range = 0..5
assert (0..5).collect() == [0, 1, 2, 3, 4, 5]       
assert (0..<5).collect() == [0, 1, 2, 3, 4]         
assert (0..5) instanceof List                       
assert (0..5).size() == 6 

assert ('a'..'d') == ['a','b','c','d']

// Membership operator The membership operator (in) is equivalent to calling the isCase/contains method
def list = ['Grace','Rob','Emmy']
assert ('Emmy' in list)

//Identity operator In Groovy, using == to test equality is different from using the same operator in Java. In Groovy, it is calling equals
def list1 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']        
def list2 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']        
assert list1 == list2                                       
assert !list1.is(list2) 

// Coercion operator
Integer x = 123
String s = (String) x   

Integer x = 123
String s = x as String 