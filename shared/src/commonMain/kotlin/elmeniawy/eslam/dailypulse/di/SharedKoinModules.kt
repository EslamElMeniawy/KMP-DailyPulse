package elmeniawy.eslam.dailypulse.di

import elmeniawy.eslam.dailypulse.articles.di.articlesModule
import elmeniawy.eslam.dailypulse.sources.di.sourcesModule

/**
 * SharedKoinModules
 *
 * Created by Eslam El-Meniawy on 21-Jul-2025 at 3:12 PM.
 */

val sharedKoinModules = listOf(
    networkModule,
    articlesModule,
    sourcesModule
)