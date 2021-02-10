package com.alex.garminlesson1.structureexercise

//Highly inspired by Ernest's solution

private const val bankBenefitPlanBonus = 0.5

abstract class Card {
    var balance = 0

    open fun pay(amount: Int) = verifyBalance(amount).also { if (it) balance -= amount }
    fun withdraw(amount: Int) = pay(amount)
    fun deposit(amount: Int) {
        balance += amount
    }

    abstract fun verifyBalance(amount: Int): Boolean
}

class DebitCard : Card() {
    override fun verifyBalance(amount: Int): Boolean = balance > 0 &&  balance >= amount
}

class CreditCard(private val limit: Int) : Card() {
    override fun pay(amount: Int): Boolean =
        super.pay(amount).also { if (it) balance += (amount * bankBenefitPlanBonus).toInt() }

    override fun verifyBalance(amount: Int): Boolean = balance + limit >= amount
}

object Bank {
    fun issueDebitCard() = DebitCard()
    fun issueCreditCard(limit: Int) = CreditCard(limit)
}