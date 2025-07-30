package elmeniawy.eslam.dailypulse.sources.di

import elmeniawy.eslam.dailypulse.sources.data.SourcesDataSource
import elmeniawy.eslam.dailypulse.sources.data.SourcesRepository
import elmeniawy.eslam.dailypulse.sources.data.SourcesService
import elmeniawy.eslam.dailypulse.sources.domain.SourcesUseCase
import elmeniawy.eslam.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

/**
 * SourcesModule
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:58 PM.
 */

val sourcesModule = module {
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesService> { SourcesService(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}