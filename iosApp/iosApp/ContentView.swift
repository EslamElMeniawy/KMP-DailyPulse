import SwiftUI

struct ContentView: View {
    @State private var shouldOpenSystenInfo = false

    var body: some View {
        let articlesScreen = ArticlesScreen(viewModel: .init())

        NavigationStack {
            articlesScreen
                .toolbar {
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
