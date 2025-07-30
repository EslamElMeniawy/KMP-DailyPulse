package elmeniawy.eslam.dailypulse.di

import elmeniawy.eslam.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

/**
 * KoinInitializer
 *
 * Created by Eslam El-Meniawy on 21-Jul-2025 at 3:38 PM.
 */

fun initKoin() {
    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}