println "hello"

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