//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Eslam El Meniawy on 16/07/2025.
//

import Shared
import SwiftUI

extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel

        init() {
            articlesViewModel = ArticlesInjector().articlesViewModel
            articlesState = articlesViewModel.articlesState.value
        }

        @Published var articlesState: ArticlesState

        func startObserving() {
            Task {
                for await articlesS in articlesViewModel.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}

struct ArticlesScreen: View {
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper

    var body: some View {
        VStack {
            AppBar()

            if let error = viewModel.articlesState.error {
                ArticlesErrorMessage(message: error)
            } else {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(
                            viewModel.articlesState.articles ?? [],
                            id: \.self
                        ) {
                            article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        }.onAppear {
            self.viewModel.startObserving()
        }
    }
}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticlesErrorMessage: View {
    var message: String

    var body: some View {
        Text(message).font(.title)
    }
}

struct ArticleItemView: View {
    var article: Article

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl ?? "")!) { phase in
                if phase.image != nil {
                    phase.image?.resizable().aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }

            Text(article.title ?? "")
                .font(.title)
                .fontWeight(.bold)

            Text(article.description_ ?? "")

            Text(article.date ?? "")
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }.padding(16)
    }
}

#Preview {
    ArticlesScreen(viewModel: .init())
}
