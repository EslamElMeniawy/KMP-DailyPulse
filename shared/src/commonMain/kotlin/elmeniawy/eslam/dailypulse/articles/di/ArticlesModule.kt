package elmeniawy.eslam.dailypulse.articles.di

import elmeniawy.eslam.dailypulse.articles.ArticlesDataSource
import elmeniawy.eslam.dailypulse.articles.ArticlesRepository
import elmeniawy.eslam.dailypulse.articles.ArticlesService
import elmeniawy.eslam.dailypulse.articles.ArticlesUseCase
import elmeniawy.eslam.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

/**
 * ArticlesModule
 *
 * Created by Eslam El-Meniawy on 21-Jul-2025 at 3:02 PM.
 */

val articlesModule = module {
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}