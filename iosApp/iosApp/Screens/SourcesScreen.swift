//
//  SourcesScreen.swift
//  iosApp
//
//  Created by Eslam El Meniawy on 30/07/2025.
//

import Shared
import SwiftUI

extension SourcesScreen {
    @MainActor
    class SourcesViewModelWrapper: ObservableObject {
        let sourcesViewModel: SourcesViewModel

        init() {
            sourcesViewModel = SourcesInjector().sourcesViewModel
            sourcesState = sourcesViewModel.sourcesState.value
        }

        @Published var sourcesState: SourcesState

        func startObserving() {
            Task {
                for await sourcesS in sourcesViewModel.sourcesState {
                    self.sourcesState = sourcesS
                }
            }
        }
    }
}

struct SourcesScreen: View {
    @Environment(\.dismiss)
    private var dismiss

    @ObservedObject private(set) var viewModel: SourcesViewModelWrapper

    var body: some View {
        NavigationStack {
            VStack { SourcesContentView(sourcesState: viewModel.sourcesState) }
                .onAppear { self.viewModel.startObserving() }
                .navigationTitle("Sources")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done").bold()
                        }
                    }
                }
        }

    }
}

struct SourcesContentView: View {
    var sourcesState: SourcesState

    var body: some View {
        VStack {
            if let error = sourcesState.error {
                SourcesErrorMessage(message: error)
            } else {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(
                            sourcesState.sources ?? [],
                            id: \.self
                        ) {
                            source in
                            SourceItemView(source: source)
                        }
                    }
                }
            }
        }
    }
}

struct SourcesErrorMessage: View {
    var message: String

    var body: some View {
        Text(message).font(.title)
    }
}

struct SourceItemView: View {
    var source: Source_

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(source.name ?? "")
                .font(.title)
                .fontWeight(.bold)

            Text(source.description_ ?? "")

            Text(source.languageCountry ?? "")
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }.padding(16)
    }
}

#Preview {
    SourcesScreen(viewModel: .init())
}
