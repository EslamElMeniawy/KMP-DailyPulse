import SwiftUI

struct ContentView: View {
    @State private var shouldOpenSystenInfo = false
    @State private var shouldOpenSources = false

    var body: some View {
        let articlesScreen = ArticlesScreen(viewModel: .init())
        let sourcesScreen = SourcesScreen(viewModel: .init())

        NavigationStack {
            articlesScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenSources = true
                        } label: {
                            Label(
                                "Sources",
                                systemImage: "list.bullet.rectangle"
                            )
                            .labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenSources) {
                            sourcesScreen.refreshable {
                                sourcesScreen.viewModel.sourcesViewModel
                                    .getSources(forceFetch: true)
                            }
                        }
                    }
                    ToolbarItem {
                        Button {
                            shouldOpenSystenInfo = true
                        } label: {
                            Label("System Info", systemImage: "info.circle")
                                .labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenSystenInfo) {
                            SystemInfoScreen()
                        }
                    }
                }
                .refreshable {
                    articlesScreen.viewModel.articlesViewModel.getArticles(
                        forceFetch: true
                    )
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
