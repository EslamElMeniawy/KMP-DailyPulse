import SwiftUI

struct ContentView: View {
    @State private var shouldOpenSystenInfo = false

    var body: some View {
        NavigationStack {
            ArticlesScreen(viewModel: .init())
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
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
