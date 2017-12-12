println "hello"

// ÀàÓ¦ÓÃ×Ö·û´®
class Person {
	String name
	Person(String self){
		name = self;
	}
	
	String greet(String otherPerson) {
		 "hello ${otherPerson},I am ${name}"
	}
}
Person nemo = new Person("nemo");
println nemo.greet("tunes")
println nemo.name
println nemo.'name'
println nemo."name"
def aMultilineString = '''line one
line two
line three'''
print aMultilineString

aMultilineString = '''line one
line two
line three
'''
print aMultilineString

println 'The Euro currency symbol: \u20AC'

def sum = "The sum of 2 and 3 equals ${2 + 3}"
println sum



def person = [name: 'Guillaume', age: 36]
println "$person.name is $person.age years old"

println "\$person.age"

def number = 1 
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"
println eagerGString
println lazyGString

number = 2 
println eagerGString
println lazyGString



