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

            if viewModel.articlesState.loading {
                Loader()
            }

            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }

            if let articles = viewModel.articlesState.articles {
                if !articles.isEmpty {
                    ScrollView {
                        LazyVStack(spacing: 10) {
                            ForEach(articles, id: \.self) {
                                article in
                                ArticleItemView(article: article)
                            }
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

            Text(article.des ?? "")

            Text(article.date ?? "")
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }.padding(16)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String

    var body: some View {
        Text(message).font(.title)
    }
}

#Preview {
    ArticlesScreen(viewModel: .init())
}
