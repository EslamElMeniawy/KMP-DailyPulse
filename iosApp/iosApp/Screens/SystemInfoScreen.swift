//
//  SystemInfoScreen.swift
//  iosApp
//
//  Created by Eslam El Meniawy on 13/07/2025.
//

import SwiftUI

struct SystemInfoScreen: View {
    @Environment(\.dismiss)
    private var dismiss

    var body: some View {
        NavigationStack {
            SystemInfoListView()
                .navigationTitle("System Info")
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

#Preview {
    SystemInfoScreen()
}
