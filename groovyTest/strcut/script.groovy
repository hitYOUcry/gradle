println 'script'
def cl = {String str ->
	println str
}
cl.call('asdw')
cl 'asdw'
/*
public class Two {                                    
    static void main(String... args) {          
        println 'Two Main!'                 
    }
    static void sb(String[] args){
    	println 'Two SBBSBSBSBS' 
    }
}
*/