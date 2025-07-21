package elmeniawy.eslam.dailypulse.di

import elmeniawy.eslam.dailypulse.articles.ArticlesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * ViewModelsModule
 *
 * Created by Eslam El-Meniawy on 21-Jul-2025 at 3:15 PM.
 */

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
}