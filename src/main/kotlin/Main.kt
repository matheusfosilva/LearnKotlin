fun main(args: Array<String>) {

    val contaDoMatheus = Conta("Matheus",  4111)
    val contaDaClara = Conta("Clara",  4112)

    contaDoMatheus.deposito(250.0)
    contaDaClara.deposito(3500.0)

    println("${contaDoMatheus.titular} : saldo : R$${contaDoMatheus.saldo}")
    println("${contaDaClara.titular} : saldo : R$${contaDaClara.saldo}\n")

    println(contaDoMatheus.transfere(contaDaClara, 100.0))

    println("${contaDoMatheus.titular} : saldo : R$${contaDoMatheus.saldo}")
    println("${contaDaClara.titular} : saldo : R$${contaDaClara.saldo}\n")

    println(contaDaClara.transfere(contaDoMatheus, 1400.0))

    println("${contaDoMatheus.titular} : saldo : R$${contaDoMatheus.saldo}")
    println("${contaDaClara.titular} : saldo : R$${contaDaClara.saldo}\n")

}

class Conta(titular: String,  var conta: Int) {

    var titular: String
        private set
    var saldo = 0.0
        private set

    init{
        this.titular = titular
    }

    fun deposito(valor: Double) {
        this.saldo += valor
    }

    fun saca(valor: Double): Boolean {

        return if (this.saldo >= valor) {
            this.saldo -= valor
            return true
        } else {
            false
        }
    }

    fun transfere(conta: Conta, valor: Double): String {

        if (this.saca(valor)) {
            conta.deposito(valor)
            return "O valor de R$$valor foi transferido para ${conta.titular} com sucesso!"
        } else {
            return "saldo insuficiente, não foi possivel fazer a transação"
        }

    }

}