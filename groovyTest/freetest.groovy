//1.为何GString中闭包可以根据值变化
def number = 1 
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"
println eagerGString
println lazyGString

number = 2 
println eagerGString
println lazyGString


//2.gradle 参数配置风格
//2.1 classpath 'xxx'
println 'hah'
def foo(String str,int a){
	println "$str,$a"
}
//foo ('as',1)
foo 'as', 1
def cl = { String str,int a ->
	println "$str,$a"
}
cl 'as', 1

//2.2 闭包参数风格
def android(Closure cl){
	cl.call()
}
android {
	println 'I am from android'
}
