//单引号字符串
/*
println 'haha'

println 'haha' + 'groovy'

println '''asd
asve
dee'''

println 'my name is \'nemo\' \\'

println 'The Euro currency symbol: \u20AC'
*/

//双引号字符串
/*
println "a double quoted string"

def name = 'some one'
println "hello, ${name}"

println "2 + 3 = ${2 + 3}"

def person = [name:'nemo',age:1024]
println "name is $person.name, age is $person.age"
*/
//String 和 GString的区别：是否是双引号+差值


// 不要把GString作为map的key
/*
println "one: ${1}".hashCode() != "one: 1".hashCode()

def key = "a"
def m = ["${key}": "letter ${key}"]
println m."a"
*/

// Slashy string 正则表达式
def f = /I am string too/
println f

println '.*\\ssd*.'
def s = /.*\ssd*./
println s

