/*
email {
    from 'dsl-guru@mycompany.com'
    to 'john.doe@waitaminute.com'
    subject 'The pope has resigned!'
    body {
        p 'Really, the pope has resigned!'
    }
}
*/

def email(@DelegatesTo(EmailSpec) Closure cl) {
	def email = new EmailSpec()
    def code = cl.rehydrate(email, this, this)
    code.resolveStrategy = Closure.DELEGATE_ONLY
    code()
}

class EmailSpec {
	void from(String from) {println "From : $from"}
	void to (String... to) {println "To: $to"}
	void subject(String subject) {println "Subject: $subject"}
	void body(@DelegatesTo(BodySpec) Closure body){
		def bodySpec = new BodySpec()
		def code = body.rehydrate(bodySpec,this,this)
		code.resolveStrategy = Closure.DELEGATE_ONLY
		code()
	}
}

class BodySpec {
	void p(String p) {println "p: $p"}
}

/*
email {
    from 'dsl-guru@mycompany.com'
    to 'john.doe@waitaminute.com'
    subject 'The pope has resigned!'
    body {
        p 'Really, the pope has resigned!'
    }
}
*/

def task(Closure cl){
	
}

task email {
	from "bin"
	to "trash"
}