//规则：Identifiers start with a letter, a dollar or an underscore. They cannot start with a number.

//引用标识符
def map = [:]
map.'a' = "i am a";
map."b" = "i am b";
map./c/ = "i am c";
map.$/d/$ = "i am d"
println map

map = [a:'a','b':'b']
assert map.a == 'a'
assert map.b == 'b'
assert map.'a' == 'a'
assert map.'b' == 'b'
println map