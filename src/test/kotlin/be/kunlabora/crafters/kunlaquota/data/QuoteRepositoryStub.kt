package be.kunlabora.crafters.kunlaquota.data

import be.kunlabora.crafters.kunlaquota.*
import be.kunlabora.crafters.kunlaquota.service.Result
import be.kunlabora.crafters.kunlaquota.service.Result.Error
import be.kunlabora.crafters.kunlaquota.service.Result.Ok
import be.kunlabora.crafters.kunlaquota.service.domain.Quote
import be.kunlabora.crafters.kunlaquota.service.domain.QuoteRepository

@Suppress("UNCHECKED_CAST")
class QuoteRepositoryStub(private val orFail: FailureStub<Failure> = FailureStub()) : QuoteRepository, CanReturnFailure<Failure> by orFail {
    private val backingList: MutableList<Quote> = mutableListOf()

    override fun store(quote: Quote): Result<AddFailure, Quote> = orFail(QuoteRepository::store.name) {
        if (quote.id in backingList.map { it.id }) Error(AddQuoteFailed("Quote already exists!"))
        else Ok(quote).also { backingList.add(quote) }
    } as Result<AddFailure, Quote>

    override fun findAll() : Result<FetchQuotesFailed, List<Quote>> = orFail(QuoteRepository::findAll.name) {
        Ok(backingList.toList())
    } as Result<FetchQuotesFailed, List<Quote>>
}